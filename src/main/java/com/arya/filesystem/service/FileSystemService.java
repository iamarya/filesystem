package com.arya.filesystem.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.arya.filesystem.dao.FileSystemDao;
import com.arya.filesystem.model.FileSystem;
import com.arya.filesystem.parse.Parser;


@Service
public class FileSystemService {
	
	@Value("${fs.bootstrap.file}")
	String fileName;
	
	@Autowired
	FileSystemDao fsDao;

	public void parseFileAndBootstrapDb() throws IOException {
		FileSystem node = Parser.parse(fileName);
		fsDao.bootstrapDb(node);
	}

	public List<String> searchName(String name) {
		return fsDao.searchName(name);
	}

}
