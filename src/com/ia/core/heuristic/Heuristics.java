/**
 * 
 */
package com.ia.core.heuristic;

import com.ia.core.model.Element;
import com.ia.core.model.GameBoard;


/**
 * This class represents Manhattan heuristic.
 * 
 * @author Anderson Soares, Jonatas Carneiro, Pedro Almir
 *
 */
public class Heuristics {
	/**
	 * Heuristic Manhattan. 
	 * Returns the value of Manhattan heuristic for the state board. 
	 * The heuristic value of Manhattan is equal to the sum of the 
	 * differences between the current line number and column minus 
	 * the number of row and column where the piece should be (absolute value) 
	 * of all the pieces to their correct positions.
	 * 
	 * @param gameBoard
	 * @return the value of the heuristic
	 */
	public static Integer hManhattan(GameBoard gameBoard) {
		Integer manhattan = 0;

		for (Element element : gameBoard.getElements()) {
			Integer temp = 0;

			if (element.getNumber() == null) {
				temp = Math.abs(element.getLine() - 2);
				temp += Math.abs(element.getColumn() - 2);
			} else if (element.getNumber() == 1) {
				temp = element.getLine();
				temp += element.getColumn();
			} else if (element.getNumber() == 2) {
				temp = element.getLine();
				temp += Math.abs(element.getColumn() - 1);
			} else if (element.getNumber() == 3) {
				temp = element.getLine();
				temp += Math.abs(element.getColumn() - 2);
			} else if (element.getNumber() == 4) {
				temp = Math.abs(element.getLine() - 1);
				temp += element.getColumn();
			} else if (element.getNumber() == 5) {
				temp = Math.abs(element.getLine() - 1);
				temp += Math.abs(element.getColumn() - 1);
			} else if (element.getNumber() == 6) {
				temp = Math.abs(element.getLine() - 1);
				temp += Math.abs(element.getColumn() - 2);
			} else if (element.getNumber() == 7) {
				temp = Math.abs(element.getLine() - 2);
				temp += element.getColumn();
			} else if (element.getNumber() == 8) {
				temp = Math.abs(element.getLine() - 2);
				temp += Math.abs(element.getColumn() - 1);
			}

			manhattan += temp;
		}

		return manhattan;
	}

	/**
	 * Heuristic found on the Internet
	 * 
	 * @param gameBoard
	 * @return the value of the heuristic
	 */
	public static Integer heuristicX(GameBoard gameBoard) {
		Integer d = 0;
		Integer aux = 0;

		for (Element element : gameBoard.getElements()) {
			if (element.getNumber() != null) {
				aux = (gameBoard.getElements().indexOf(element) + 1) - element.getNumber();
				d += aux * aux;
			} else {
				aux = (gameBoard.getElements().indexOf(element) + 1) - 9;
				d += aux * aux;
			}
		}

		return d;
	}
}
