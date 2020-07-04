package com.arya.filesystem;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.arya.filesystem.service.FileSystemService;

@SpringBootApplication
public class FilesystemApplication {
	
	@Autowired
	FileSystemService fsService;

	public static void main(String[] args) {
		SpringApplication.run(FilesystemApplication.class, args);
	}
	
	@PostConstruct
	public void init() throws IOException {
		fsService.parseFileAndBootstrapDb();
	}

}
