package com.resume.parser.controller.in;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;

import com.resume.parser.ResponseWrapper;
import com.resume.parser.service.in.ParserService;

import java.io.File;
import java.util.Map;


@RestController

@CrossOrigin(origins = "http://localhost:5173")
public class ParserController {
	private static final Logger logger = LoggerFactory.getLogger(ParserController.class);
	@Autowired
	private ParserService parserService;

	@PostMapping("/upload")
	public ResponseWrapper parseResume(@RequestParam MultipartFile resume) {
		ResponseWrapper responseWrapper = new ResponseWrapper();

		try {
			logger.info("Received resume file: {}", resume.getOriginalFilename());
			responseWrapper = parserService.parseResume(resume);
		} catch (Exception ex) {
			responseWrapper.setMessage("Error parsing resume: " + ex.getMessage());
			responseWrapper.setStatus(500);
			logger.error("Error parsing resume", ex);
		}
		return responseWrapper;
	}



	@ExceptionHandler(MultipartException.class)
	public ResponseWrapper handleMultipartException(Exception ex) {
		ResponseWrapper responseWrapper = new ResponseWrapper();
		responseWrapper.setData("No file uploaded");
		responseWrapper.setMessage("Please upload Resume!!");
		responseWrapper.setStatus(400);
		return responseWrapper;
	}

}
