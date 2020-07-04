package com.arya.filesystem.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.arya.filesystem.parse.Node;

@Repository
public class FileSystemDao {

	@Transactional
	public void bootstrapDb(Node node) {
		// TODO Auto-generated method stub
		
	}

}
