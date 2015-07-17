/**
 * 
 */
package com.ia.core.model;

import java.util.List;

/**
 * This class represents the of possibilities
 * 
 * @author Anderson Soares, Jonatas Carneiro, Pedro Almir
 *
 */
public class Tree {
	/**
	 * The root of the tree 
	 */
	private GameBoard root;
	/**
	 * The nodes
	 */
	private List<GameBoard> nodes;
	/**
	 * @return the root
	 */
	public GameBoard getRoot() {
		return root;
	}
	/**
	 * @param root the root to set
	 */
	public void setRoot(GameBoard root) {
		this.root = root;
	}
	/**
	 * @return the nodes
	 */
	public List<GameBoard> getNodes() {
		return nodes;
	}
	/**
	 * @param nodes the nodes to set
	 */
	public void setNodes(List<GameBoard> nodes) {
		this.nodes = nodes;
	}
	
}
