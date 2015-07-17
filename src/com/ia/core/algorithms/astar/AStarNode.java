package com.ia.core.algorithms.astar;

import com.ia.core.model.GameBoard;

/**
 * Class stores the board (state), the previous node, 
 * the number of moves made by the current state, 
 * and the cost of the heuristic.
 * 
 * @author Anderson Soares, Jonatas Carneiro, Pedro Almir
 * 
 */
public class AStarNode {
	
	/**
	 * State
	 */
	private GameBoard gameBoard;
	/**
	 * Previous Node
	 */
	private AStarNode previous;
	/**
	 * Number of movements to the current state
	 */
	private Integer numMovements;
	/**
	 * The cost
	 */
	private Integer cost;
	
	/**
	 * @param gameBoard
	 * @param previous
	 * @param numMovements
	 * @param cost
	 */
	public AStarNode(GameBoard gameBoard, AStarNode previous,
			Integer numMovements, Integer cost) {
		super();
		this.gameBoard = gameBoard;
		this.previous = previous;
		this.numMovements = numMovements;
		this.cost = cost;
	}

	/**
	 * @return the gameBoard
	 */
	public GameBoard getGameBoard() {
		return gameBoard;
	}

	/**
	 * @param gameBoard the gameBoard to set
	 */
	public void setGameBoard(GameBoard gameBoard) {
		this.gameBoard = gameBoard;
	}

	/**
	 * @return the previous
	 */
	public AStarNode getPrevious() {
		return previous;
	}

	/**
	 * @param previous the previous to set
	 */
	public void setPrevious(AStarNode previous) {
		this.previous = previous;
	}

	/**
	 * @return the numMovements
	 */
	public Integer getNumMovements() {
		return numMovements;
	}

	/**
	 * @param numMovements the numMovements to set
	 */
	public void setNumMovements(Integer numMovements) {
		this.numMovements = numMovements;
	}

	/**
	 * @return the cost
	 */
	public Integer getCost() {
		return cost;
	}

	/**
	 * @param cost the cost to set
	 */
	public void setCost(Integer cost) {
		this.cost = cost;
	}
	
	@Override
	public String toString() {
		return this.getGameBoard().toString();
	}


}
