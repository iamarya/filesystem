package com.arya.filesystem.parse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.arya.filesystem.service.FileSystemService;

public class Parser {
	
	/**
	 * This method read the given text file form classpath and create the
	 * tree data structure with reference to parent and depth of node
	 * 
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public static Node parse(String fileName) throws IOException {
		Node root = null, prev = null;
		ClassLoader classLoader = FileSystemService.class.getClassLoader();
		InputStream resource = classLoader.getResourceAsStream(fileName);
	    
		BufferedReader reader = new BufferedReader(new InputStreamReader(resource));
		
		for (String line; (line = reader.readLine()) != null; ) {
		    if (prev == null ) {
		        root = new Node(line, 0);
		        prev = root;
		    }
		    else {
		    	String trimmedLine = line.replaceAll("^\\s+", "");
		    	int depth = line.length() - trimmedLine.length();
		    	line  = trimmedLine;
		        if (depth > prev.getDepth()) {
		            Node subSection = new Node(line, depth, prev);
		            prev.addChild(subSection);
		            prev = subSection;
		        }
		        else if (depth == prev.getDepth()) {
		            Node subSection = new Node(line, depth, prev.getParent());
		            prev.getParent().addChild(subSection);
		        }
		        else {
		            while (depth < prev.getDepth()) {
		                prev = prev.getParent();
		            }
		            Node subSection = new Node(line, depth, prev.getParent());
		            prev.getParent().addChild(subSection);
		            prev = subSection;
		        }
		    }
		}
		// did not write try/catch so that if file reading failed i want application not to start
		reader.close();
		return root;
	}
}
