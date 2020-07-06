package com.arya.filesystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.arya.filesystem.model.FileSystem;
import com.arya.filesystem.parse.Parser;
import com.arya.filesystem.service.IFileSystemService;

@SpringBootTest
class FilesystemApplicationTests {
	
	@Autowired
	IFileSystemService fsService;

	@Test
	void readFile() throws IOException {
		FileSystem fs = Parser.parse("fs1.txt");
		assertNotEquals(fs, null);
	}
	
	@Test
	void readDb() {
		List<String> results = fsService.searchName("image");
		assertEquals(results.size(), 4);
	}
}
