package com.tommy.springproject.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;

@Controller
public class UploadController {
	
	
	@GetMapping("/upload")
	public String getUpload(HttpSession session) {
		if(session.getAttribute("validuser") == null) {
	    	  return "LoginForm";
	      }
		return "UploadForm";
	}
	
	
	@PostMapping("/upload")
	public String postUpload(@RequestParam MultipartFile image, Model model, HttpSession session) throws IOException{
      if(session.getAttribute("validuser") == null) {
    	  return "LoginForm";
      }
		if(!image.isEmpty()) {
			
//			Long imgSize = image.getSize() /1024;
//			if(imgSize>200) {
//				model.addAttribute("msg" ,"invalid img size max size = 200 kb");
//				return "UploadForm";
//			}
			Files.copy(image.getInputStream(), Path.of("src/main/resources/static/image/"+image.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
			model.addAttribute("msg" ,"Upload Success");
			return "UploadForm";
		}
		
		model.addAttribute("msg" ,"Upload Failed");
		return "UploadForm";
	}

}
