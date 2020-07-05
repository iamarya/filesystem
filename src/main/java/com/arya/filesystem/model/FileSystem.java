package com.arya.filesystem.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;


@Entity(name = "file_system")
public class FileSystem {

	@Id
	@GeneratedValue
	private Long id;
	
	@OneToMany(
	        cascade = {CascadeType.ALL},
	        orphanRemoval = true,
	        fetch = FetchType.LAZY
	 )
	@JoinColumn(name = "parent")
	private List<FileSystem> children;
	
	private String name;
	
	@Transient
	private int depth;
	
	@OneToOne(fetch=FetchType.EAGER, optional = true)
    @JoinColumn(name="parent", referencedColumnName="id", nullable = true) 
	private FileSystem parent;

	public FileSystem() {
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FileSystem other = (FileSystem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public FileSystem(String text) {
		this.name = text;
	}

	public FileSystem(String text, int depth) {
		this.name = text;
		this.depth = depth;
		this.children = new ArrayList<FileSystem>();
		this.setParent(null);
	}

	public FileSystem(String text, int depth, FileSystem parent) {
		this.name = text;
		this.depth = depth;
		this.children = new ArrayList<FileSystem>();
		this.setParent(parent);
	}

	public List<FileSystem> getChildren() {
		if (children == null) {
			children = new ArrayList<FileSystem>();
		}
		return children;
	}

	public void setChildren(List<FileSystem> newChildren) {
		if (newChildren == null) {
			children = newChildren;
		} else {
			if (children == null) {
				children = new ArrayList<FileSystem>();
			}
			for (FileSystem child : newChildren) {
				this.addChild(child);
			}
		}
	}

	public void addChild(FileSystem child) {
		if (children == null) {
			children = new ArrayList<FileSystem>();
		}
		if (child != null) {
			children.add(child);
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String newText) {
		name = newText;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int newDepth) {
		depth = newDepth;
	}

	public FileSystem getParent() {
		return parent;
	}

	public void setParent(FileSystem parent) {
		this.parent = parent;
	}
}
