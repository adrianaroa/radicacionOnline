package com.itindro.radicacion.models.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;

import com.itindro.radicacion.models.dao.EntidadDao;
import com.itindro.radicacion.models.dao.IRadicacionComunacionAdjuntoDao;
import com.itindro.radicacion.models.dao.IRadicacionComunicacionDao;
import com.itindro.radicacion.models.dao.UsuarioExternoDao;
import com.itindro.radicacion.models.entity.Entidad;
import com.itindro.radicacion.models.entity.RadicacionComunicacion;
import com.itindro.radicacion.models.entity.RadicacionComunicacionAdjuntos;
import com.itindro.radicacion.models.entity.UsuarioExterno;


@Service
public class RadicacionComunicacionService implements IRadicacionComunicacionService {

	@Autowired
	private IRadicacionComunicacionDao radicacionComunicacionDao;
	
	@Autowired
	private IRadicacionComunacionAdjuntoDao radicacionComunicacionAdjuntoDao;
	
	@Autowired
	private EntidadDao entidadDao;
	
	@Autowired
	private UsuarioExternoDao usuarioExternoDao;
	
	@Value("${file.upload.directory}")
	private String uploadDirectory;
	
    @Autowired
    private EmailService emailService;
	
	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)	
	public void save(RadicacionComunicacion radicacionComunicacion,  List<MultipartFile> files) throws IOException {
		RadicacionComunicacion radicacionComunicacionSave = radicacionComunicacionDao.save(radicacionComunicacion);

		for (MultipartFile file : files) {
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            RadicacionComunicacionAdjuntos radicacionComunicacionAdjunto = new RadicacionComunicacionAdjuntos();
            radicacionComunicacionAdjunto.setNombre(fileName);
            radicacionComunicacionAdjunto.setRadicacionComunicacion(radicacionComunicacionSave);
  
            byte[] byteArray = file.getBytes();
            radicacionComunicacionAdjunto.setImage(byteArray);
            
            radicacionComunicacionAdjuntoDao.save(radicacionComunicacionAdjunto);

            Path uploadPath = Paths.get(uploadDirectory);

            String extencion = fileName.substring(fileName.lastIndexOf("."), fileName.length());
            fileName = radicacionComunicacionAdjunto.getId() + extencion;
            
            try (InputStream inputStream = file.getInputStream()) {
            //  Path filePath = uploadPath.resolve(fileName);
            //  Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
            }
		}
		
		Entidad entidad = entidadDao.find().get(0);
		
		
		System.out.println("coreeo" + entidad.getCorreoradicacion());
		
		String subject = "asunto de prueba";
		String text = " Señor(a) " + "<br>";
		text += radicacionComunicacionSave.getRad_nombres() + " " + radicacionComunicacionSave.getRad_primerapellido() + "<br>";
		text += "Se ha registrado la siguiente comunicación oficial / PQRSD:" + "<br>";
		text += "Número REGISTRO:" + radicacionComunicacionSave.getRadId() + "<br>";
		text += "Asunto: " + radicacionComunicacionSave.getRad_asunto() +  "<br>";
		
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    String fechaFormateada = sdf.format(radicacionComunicacionSave.getRad_registroAud());
	    
		text += "Fecha radicación:" + fechaFormateada +  "<br>";
		text += "Atentamente;" + "<br>";
		text += "Ventanilla Única de Comunicaciones Oficiales" + "<br>";

		
		if ( !radicacionComunicacion.getRad_correo().equals("0@0.com")) {
			
			String password = Base64.getEncoder().encodeToString(radicacionComunicacion.getRad_correo().getBytes());
			UsuarioExterno usuarioExterno = usuarioExternoDao.findOrCreate(radicacionComunicacion.getRad_correo(), password);
			
			String to = radicacionComunicacion.getRad_correo();
			text += "contraseña consulta: " + password + "<br>";

	        emailService.sendEmail(to, subject, text, files );

		}
		
		//to = radicacionComunicacion.getRad_correo();
		
		
		

	}


}
