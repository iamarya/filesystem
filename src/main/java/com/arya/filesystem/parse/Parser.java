package com.arya.filesystem.parse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.arya.filesystem.CustomException;
import com.arya.filesystem.model.FileSystem;
import com.arya.filesystem.service.FileSystemService;

public class Parser {

	/**
	 * This method read the given text file and create the tree data structure with
	 * reference to parent and depth of node
	 * 
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public static FileSystem parse(String fileName) throws IOException {
		FileSystem root = null, prev = null;
		ClassLoader classLoader = FileSystemService.class.getClassLoader();
		BufferedReader reader = null;
		try {
			InputStream resource = classLoader.getResourceAsStream(fileName);

			reader = new BufferedReader(new InputStreamReader(resource));

			for (String line; (line = reader.readLine()) != null;) {
				if (prev == null) {
					root = new FileSystem(line, 0);
					prev = root;
				} else {
					String trimmedLine = line.replaceAll("^\\s+", "");
					int depth = line.length() - trimmedLine.length();
					line = trimmedLine;
					if (depth > prev.getDepth()) {
						FileSystem subSection = new FileSystem(line, depth, prev);
						prev.addChild(subSection);
						prev = subSection;
					} else if (depth == prev.getDepth()) {
						FileSystem subSection = new FileSystem(line, depth, prev.getParent());
						prev.getParent().addChild(subSection);
					} else {
						while (depth < prev.getDepth()) {
							prev = prev.getParent();
						}
						FileSystem subSection = new FileSystem(line, depth, prev.getParent());
						prev.getParent().addChild(subSection);
						prev = subSection;
					}
				}
			}
		} catch (Exception e) {
			throw new CustomException("Failed while reading file", e);
		} finally {
			reader.close();
		}
		return root;
	}
}
