package com.arya.filesystem;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import com.arya.filesystem.parse.Node;
import com.arya.filesystem.parse.Parser;
import com.arya.filesystem.service.FileSystemService;

@SpringBootTest
class FilesystemApplicationTests {
	
	@Value("${fs.bootstrap.file}")
	String fileName;
	
	@Autowired
	FileSystemService fsService;

	@Test
	void readFile() throws IOException {
		Node fs = Parser.parse(fileName);
		assertNotEquals(fs, null);
	}
}
