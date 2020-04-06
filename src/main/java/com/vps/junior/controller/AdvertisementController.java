package com.vps.junior.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.vps.junior.entity.Advertisement;
import com.vps.junior.service.AdvertisementInterface;


@CrossOrigin("*")
@RestController
@RequestMapping(path = "/advertisement")
public class AdvertisementController {
	
	@Autowired
	AdvertisementInterface adve;
	

	
	@GetMapping(path = "/listar")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Advertisement> listarUsusarios() {
		return adve.findAll();
		
	}
	
	@GetMapping(path = "/listar/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Advertisement getAdvertisementByid(@PathVariable Long id) {
		return adve.findById(id);
		
	}
	
	@PostMapping(path = "/create")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Advertisement create(@RequestBody Advertisement Advertisement, @RequestParam("file") MultipartFile[] multipartFile) {
		
		return adve.save(Advertisement);
		
	}
	
	@DeleteMapping(path = "/Advertisement/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		adve.delete(id);
		
	}
	
	@PostMapping("/saveImage")
	 public Advertisement editProperties(@RequestParam  long id,@RequestParam("file") MultipartFile multipartFile) {
		  
			
		List<String> files = new ArrayList<>(5);
      
            if (!multipartFile.isEmpty()) {
                Path directorioRecursos = Paths.get("daw.project//src//main//resources//static//image");
                String rootPath = directorioRecursos.toFile().getAbsolutePath();
                rootPath = rootPath.replaceFirst("daw.project//", "");
                System.out.println("rootpath: " + rootPath);
                try {
                    byte[] bytes = multipartFile.getBytes();
                    System.out.println("bytes: " + bytes.length);
                    
                    Path rupacompleta = Paths.get(rootPath + "//" + multipartFile.getOriginalFilename());
                    //Files.write(rupacompleta, bytes);
                    Files.copy(multipartFile.getInputStream(), rupacompleta);
                    files.add(multipartFile.getOriginalFilename());

                } catch (IOException e) {
                    //e.printStackTrace();
                    System.out.println("Error en subida de imágenes: " +e.getMessage());
                    return null;
                }
            }
        
		 Advertisement advertisement = adve.findById(id);
	        advertisement.setImages(files);
			return adve.save(advertisement);
       
	}

}
