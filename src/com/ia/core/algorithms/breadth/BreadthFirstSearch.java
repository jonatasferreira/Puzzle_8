package com.ia.core.algorithms.breadth;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.ia.core.model.GameBoard;

/**
 * Breadth-first search
 * 
 * @author Anderson Soares, Jonatas Carneiro, Pedro Almir
 * 
 */
public class BreadthFirstSearch {
	/**
	 * Solves the set of 8 and returns a list, parameter, 
	 * with the moves made ​​to reach completion.
	 * 
	 * @param gameBoardList
	 * @param gameBoardsVerified
	 * @param solutionList
	 */
	public GameBoard findRecordingMovements(
			List<GameBoard> gameBoardList, 
			List<GameBoard> gameBoardsVerified,
			List<GameBoard> solutionList) {
		List<GameBoard> newList = new LinkedList<GameBoard>();
		
		Map<GameBoard,LinkedList<GameBoard>> hashSuccessors = new HashMap<GameBoard, LinkedList<GameBoard>>();

		Boolean checksFlag = false;

		for (GameBoard gameBoard : gameBoardList) {
			if (gameBoard.isSolution()) {
				solutionList.add(gameBoard);
				return gameBoard;
			}
			// Get the game boards successors
			hashSuccessors.put(gameBoard, (LinkedList<GameBoard>) gameBoard.getGameBoardSuccessors());
			for (GameBoard board1 : gameBoard.getGameBoardSuccessors()) {
				for (int i = gameBoardsVerified.size() - 1; i >= 0 && !checksFlag; i--) {
					if (board1.equals(gameBoardsVerified.get(i)))
						checksFlag = true;
				}
				if (!checksFlag){
					newList.add(board1);
					//System.out.println(board1.toString() + "\n");
				}

				checksFlag = false;
			}
		}
		
		gameBoardsVerified.addAll(gameBoardList);

		if (!newList.isEmpty()) {
			// calls the garbage collector
			System.gc();

			GameBoard game = findRecordingMovements(newList,gameBoardsVerified, solutionList);

			for (GameBoard board : gameBoardList) {
				for (GameBoard board1 : hashSuccessors.get(board)) {
					if (game.equals(board1)) {
						solutionList.add(board);
						return board;
					}
				}
			}
		}

		return null;
	}

	/**
	 * Solves the problem.
	 * @param gameBoardList
	 * @param gameBoardsVerified
	 * @param steps
	 */
	public GameBoard findWithOutRecordingMovements(
			List<GameBoard> gameBoardList,
			List<GameBoard> gameBoardsVerified, 
			Integer steps) {
		List<GameBoard> newList = new LinkedList<GameBoard>();

		Boolean checksFlag = false;

		for (GameBoard gameBoard : gameBoardList) {
			if (gameBoard.isSolution())
				return gameBoard;

			// Get the game boards successors
			for (GameBoard gameBoard1 : gameBoard.getGameBoardSuccessors()) {
				for (int i = gameBoardsVerified.size() - 1; i >= 0
						&& !checksFlag; i--) {
					if (gameBoard1.equals(gameBoardsVerified.get(i)))
						checksFlag = true;
				}
				if (!checksFlag)
					newList.add(gameBoard1);

				checksFlag = false;
			}
		}
		
		gameBoardsVerified.addAll(gameBoardList);

		if (!newList.isEmpty()) {
			System.gc();
			gameBoardList.clear();
			return findWithOutRecordingMovements(newList,
					gameBoardsVerified, steps + 1);
		} else
			return null;
	}
}
