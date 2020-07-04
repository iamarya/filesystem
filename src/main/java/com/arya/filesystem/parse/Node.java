package com.arya.filesystem.parse;

import java.util.ArrayList;
import java.util.List;

public class Node {

	private List<Node> children;
	private String text;
	private int depth;
	private Node parent;

	public Node(String text) {
		this.text = text;
	}

	public Node(String text, int depth) {
		this.text = text;
		this.depth = depth;
		this.children = new ArrayList<Node>();
		this.setParent(null);
	}

	public Node(String text, int depth, Node parent) {
		this.text = text;
		this.depth = depth;
		this.children = new ArrayList<Node>();
		this.setParent(parent);
	}

	public List<Node> getChildren() {
		if (children == null) {
			children = new ArrayList<Node>();
		}
		return children;
	}

	public void setChildren(List<Node> newChildren) {
		if (newChildren == null) {
			children = newChildren;
		} else {
			if (children == null) {
				children = new ArrayList<Node>();
			}
			for (Node child : newChildren) {
				this.addChild(child);
			}
		}
	}

	public void addChild(Node child) {
		if (children == null) {
			children = new ArrayList<Node>();
		}
		if (child != null) {
			children.add(child);
		}
	}

	public String getText() {
		return text;
	}

	public void setText(String newText) {
		text = newText;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int newDepth) {
		depth = newDepth;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}
}
