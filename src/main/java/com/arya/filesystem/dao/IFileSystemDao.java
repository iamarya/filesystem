package com.arya.filesystem.dao;

import java.util.List;

import com.arya.filesystem.model.FileSystem;

public interface IFileSystemDao {

	void bootstrapDb(FileSystem node);

	List<String> searchName(String name);

}
