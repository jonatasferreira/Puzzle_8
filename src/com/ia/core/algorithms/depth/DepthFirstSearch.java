package com.ia.core.algorithms.depth;

import java.util.LinkedList;
import java.util.List;

import com.ia.core.model.GameBoard;

/**
 * 	Depth-first search.
 * 
 * @author Anderson Soares, Jonatas Carneiro, Pedro Almir
 */
public class DepthFirstSearch {
	private Integer maxDepth;
	private Integer steps;
	private List<GameBoard> movements;

	public DepthFirstSearch(Integer depth) {
		maxDepth = depth;
		steps = 0;
		movements = new LinkedList<GameBoard>();
	}

	public Integer getSteps() {
		return steps;
	}
	
	public List<GameBoard> getMovements() {
		return movements;
	}
	
	public GameBoard calledRecursive(GameBoard gameBoard, Integer depth) {
		List<GameBoard> newList;

		if (gameBoard.isSolution()) {
			movements.add(gameBoard);
			return gameBoard;
		}else if (depth != maxDepth) {
			newList = new LinkedList<GameBoard>();

			newList = gameBoard.getGameBoardSuccessors();
			
			for (GameBoard board : newList) {
				GameBoard result = calledRecursive(board, depth + 1);
				if (result != null) 
					if (result.isSolution()) {
						movements.add(board);
						steps++;
						return result;
					}
			}
		}

		return null;
	}
	
	public GameBoard depthFirstSearch(GameBoard gameBoard) {
		maxDepth = 0;
		steps = 0;
		movements = new LinkedList<GameBoard>();
		GameBoard result;
		
		do {
			movements.clear();
			result = calledRecursive(gameBoard, 0);
			maxDepth++;
		} while(result == null || !result.isSolution());

		return result;
	}
}
