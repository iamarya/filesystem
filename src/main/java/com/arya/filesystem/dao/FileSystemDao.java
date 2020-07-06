package com.arya.filesystem.dao;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.arya.filesystem.model.FileSystem;

/**
 * File system application DAO
 * @author arya
 *
 */
@Repository
public class FileSystemDao implements IFileSystemDao {

	@Autowired
	EntityManager em;

	@Transactional
	public void bootstrapDb(FileSystem node) {
		saveFileSystem(node);
		node.getChildren().forEach(childNode -> bootstrapDb(childNode));
	}

	@Transactional
	private void saveFileSystem(FileSystem node) {
		em.persist(node);
	}

	public List<String> searchName(String name) {
		List<FileSystem> files = getNodesForName(name);
		List<String> names = files.stream().map(file->getFullPath(file)).collect(Collectors.toList());
		return names;
	}

	private List<FileSystem> getNodesForName(String name) {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<FileSystem> query = criteriaBuilder.createQuery(FileSystem.class);
		Root<FileSystem> fs = query.from(FileSystem.class);
		query.select(fs).where(criteriaBuilder.like(criteriaBuilder.lower(fs.get("name")), "%"+name+"%"));
		return em.createQuery(query).getResultList();
	}
	
	String getFullPath(FileSystem file) {
		String path = file.getName();
		if(file.getParent()==null) {
			return path;
		}
		String parentPath = getFullPath(file.getParent());
		return String.format("%s\\%s", parentPath, path);
	}
}
