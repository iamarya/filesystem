package com.arya.filesystem.service;

import java.io.IOException;
import java.util.List;

public interface IFileSystemService {

	List<String> searchName(String lowerCase);

	void parseFileAndBootstrapDb() throws IOException;

}
