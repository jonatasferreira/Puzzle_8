/**
 * 
 */
package com.ia.core.model;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;


/**
 * This class represents a game board. 
 * It will be used to store the states traversed in the search for solution.
 * 
 * @author Anderson Soares, Jonatas Carneiro, Pedro Almir
 *
 */
public class GameBoard {
	/**
	 * Reports the level of this node.
	 */
	private Integer level = 0;
	/**
	 * Position x
	 */
	private int positionNodeX;
	/**
	 * Position y
	 */
	private int positonNodeY;
	/**
	 * List of elements
	 */
	private List<Element> elements;
	/**
	 *  Represents the empty element
	 */
	private Element emptyElement;
	/**
	 * Represents the father of this node.
	 * If father is null then this is the root
	 */
	private GameBoard father;
	/**
	 * Serve to represent the successors in the decision tree
	 */
	private List<GameBoard> successors = new LinkedList<GameBoard>();
	/**
	 * Serve to determine whether the node is still open.
	 */
	private boolean isOpened = true;
	
	public GameBoard(){
		this.elements = new LinkedList<Element>();
		Collections.sort(this.elements, new Comparator<Element>() {

			@Override
			public int compare(Element e1, Element e2) {
				if(e1.getPosition() > e2.getPosition()){
					return 1;
				}else if(e1.getPosition() < e2.getPosition()){
					return -1;
				}else{
					return 0;
				}
			}
			
		});
	}
	
	/**
	 * @param pieces
	 * @param emptyPiece
	 * @param level
	 * @param father
	 */
	public GameBoard(List<Element> pieces, Element emptyPiece, Integer level, GameBoard father) {
		super();
		this.elements = pieces;
		this.emptyElement = emptyPiece;
		this.level = level;
		this.isOpened = true;
		this.father = father;
		Collections.sort(this.elements, new Comparator<Element>() {

			@Override
			public int compare(Element e1, Element e2) {
				if(e1.getPosition() > e2.getPosition()){
					return 1;
				}else if(e1.getPosition() < e2.getPosition()){
					return -1;
				}else{
					return 0;
				}
			}
			
		});
	}
	
	/**
	 * @param gameBoard
	 */
	public GameBoard(GameBoard gameBoard) {
		if (gameBoard.getElements() != null) {
			// Initialize the game board
			elements = new LinkedList<Element>();

			for (Element element : gameBoard.getElements()) {
				if (element.getNumber() != null) {
					Element newElement = new Element(element);
					elements.add(newElement);
				} else {
					Element newElement = new Element(element);
					elements.add(newElement);
					emptyElement = newElement;
				}
			}
		}
	}
	
	/**
	 * @return the father
	 */
	public GameBoard getFather() {
		return father;
	}
	/**
	 * @return the elements
	 */
	public List<Element> getElements() {
		return elements;
	}

	/**
	 * @param elements the elements to set
	 */
	public void setElements(List<Element> elements) {
		this.elements = elements;
	}

	/**
	 * @return the emptyElement
	 */
	public Element getEmptyElement() {
		return emptyElement;
	}

	/**
	 * @param emptyElement the emptyElement to set
	 */
	public void setEmptyElement(Element emptyElement) {
		this.emptyElement = emptyElement;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(Integer level) {
		this.level = level;
	}

	/**
	 * @param father the father to set
	 */
	public void setFather(GameBoard father) {
		this.father = father;
	}
	/**
	 * @return the successors
	 */
	public List<GameBoard> getSuccessors() {
		return successors;
	}
	/**
	 * @param successors the successors to set
	 */
	public void setSuccessors(List<GameBoard> successors) {
		this.successors = successors;
	}
	/**
	 * @return the isOpened
	 */
	public boolean isOpened() {
		return isOpened;
	}
	/**
	 * @param isOpened the isOpened to set
	 */
	public void setOpened(boolean isOpened) {
		this.isOpened = isOpened;
	}
	/**
	 * @return the level
	 */
	public Integer getLevel() {
		return level;
	}
	/**
	 * @return the positionNodeX
	 */
	public int getPositionNodeX() {
		return positionNodeX;
	}
	/**
	 * @param positionNodeX the positionNodeX to set
	 */
	public void setPositionNodeX(int positionNodeX) {
		this.positionNodeX = positionNodeX;
	}
	/**
	 * @return the positonNodeY
	 */
	public int getPositonNodeY() {
		return positonNodeY;
	}
	/**
	 * @param positonNodeY the positonNodeY to set
	 */
	public void setPositonNodeY(int positonNodeY) {
		this.positonNodeY = positonNodeY;
	}
	
	/**
	 * Verify if this game board is the solution of game.
	 * 
	 * Solution:
	 * 
	 * 		1 2 3
	 * 		4 5 6
	 * 		8 9 0
	 * 
	 * @return
	 */
	public boolean isSolution(){
		for(Element element : this.elements){
			if(!element.isCorrectPosition()){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Print game board
	 */
	public void printMatrix() {
		int i = 0;
		List<Element> order = this.elements;
		order = this.getElementsOrderByPosition(order);
		for (Element element : order) {
			if (i == 3) {
				System.out.println("");
				i = 0;
			}
			if(i == 0)
				System.out.print("\t");
			if (element.getNumber() != null && element.getNumber() != 0)
				System.out.print(String.valueOf(element.getNumber()) + " ");
			else
				System.out.print("N ");
			i++;
		}
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((elements == null) ? 0 : elements.hashCode());
		result = prime * result
				+ ((emptyElement == null) ? 0 : emptyElement.hashCode());
		return result;
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GameBoard other = (GameBoard) obj;
		if (elements == null) {
			if (other.elements != null)
				return false;
		} else if (!elements.equals(other.elements))
			return false;
		if (emptyElement == null) {
			if (other.emptyElement != null)
				return false;
		} else if (!emptyElement.equals(other.emptyElement))
			return false;
		return true;
	}
	
	/**
	 * Returns an List of trays where each bin represents 
	 * a possible following after moving parts that can be 
	 * moved to the position blank.
	 */
	public List<GameBoard> getGameBoardSuccessors() {
		List<Element> elements;

		try {
			elements = new LinkedList<Element>();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Heap sem memória suficiente!\n" + e);
			return null;
		}

		List<GameBoard> successors;
		// initialize the return list
		try {
			successors = new LinkedList<GameBoard>();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Heap sem memória suficiente!\n" + e);
			return null;
		}

		GameBoard gameBoard;
		try {
			gameBoard = new GameBoard(this);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Heap sem memória suficiente!\n" + e);
			return null;
		}

		// Get the parts which can be moved
		elements = gameBoard.elementsThatCanMove();

		for (int i = 0; i < elements.size(); i++) {
			// move a respectiva peça
			gameBoard.moveElement(elements.get(i));

			// insere o tabuleiro ao ArrayList
			successors.add(gameBoard);

			// cria outra instância deste tabuleiro
			try {
				gameBoard = new GameBoard(this);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Heap sem memória suficiente!\n" + e);
				return null;
			}

			// adquire novamente as peças que podem ser movidas
			try {
				elements = new LinkedList<Element>();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Heap sem memória suficiente!\n" + e);
				return null;
			}

			elements = gameBoard.elementsThatCanMove();
		}

		return successors;
	}
	
	/**
	 * Returns a list with the possible parts that are moving
	 */
	public List<Element> elementsThatCanMove() {
		List<Element> elementsThatCanMove = new LinkedList<Element>();

		if (emptyElement.getLine() - 1 >= 0)
			elementsThatCanMove.add(elements.get(((emptyElement.getLine() - 1) * 3) + emptyElement.getColumn()));
		if ((emptyElement.getLine() + 1) * 3 < elements.size())
			elementsThatCanMove.add(elements.get(((emptyElement.getLine() + 1) * 3) + emptyElement.getColumn()));
		if (emptyElement.getColumn() - 1 >= 0)
			elementsThatCanMove.add(elements.get((emptyElement.getLine() * 3) + (emptyElement.getColumn() - 1)));
		if (emptyElement.getColumn() + 1 < 3)
			elementsThatCanMove.add(elements.get((emptyElement.getLine() * 3) + (emptyElement.getColumn() + 1)));

		return elementsThatCanMove;
	}
	
	/**
	 * Moves past the respective number for parameter to position the empty part
  	 * the board. The position of the part becomes empty position in a part 
  	 * belonging previously moved.
	 */
	public void moveElement(Element element) {
		// Checks whether the number is next to the part empty
		if ((element.getLine() == emptyElement.getLine() && 
				(element.getColumn() == emptyElement.getColumn() - 1 || 
				element.getColumn() == emptyElement.getColumn() + 1))
				|| ((element.getLine() == emptyElement.getLine() - 1 || element
						.getLine() == emptyElement.getLine() + 1) && element
						.getColumn() == emptyElement.getColumn())) {

			// Updates the position of pieces on the board
			updateElementPosition(element);
		}
	}
	
	/*
	 * Update the element position
	 */
	public void updateElementPosition(Element element) {
		Integer line = emptyElement.getLine(), column = emptyElement.getColumn();

		elements.remove((element.getLine() * 3) + element.getColumn());
		elements.add((element.getLine() * 3) + element.getColumn(), emptyElement);

		elements.remove((line * 3) + column);
		elements.add((line * 3) + column, element);

		// update the position in the game board
		emptyElement.setLine(element.getLine());
		emptyElement.setColumn(element.getColumn());
		emptyElement.setPosition(emptyElement.getLine(), emptyElement.getColumn());
		element.setLine(line);
		element.setColumn(column);
		element.setPosition(element.getLine(), element.getColumn());
	}
	
	/**
	 * Verifies that you can move the piece.
	 * @param element
	 */
	public Boolean verifiesElementCanMove(Element element) {
		// Checks whether the number is next to the part empty
		if ((element.getLine() == emptyElement.getLine() 
				&& (element.getColumn() == emptyElement.getColumn() - 1 
				|| element.getColumn() == emptyElement.getColumn() + 1))
				|| ((element.getLine() == emptyElement.getLine() - 1 
				|| element.getLine() == emptyElement.getLine() + 1) 
				&& element.getColumn() == emptyElement.getColumn())) {
			return true;
		}

		return false;
	}
	
	/**
	 * @param elements
	 * @return
	 */
	public List<Element> getElementsOrderByPosition(List<Element> elements){
		Collections.sort(elements, new Comparator<Element>() {

			@Override
			public int compare(Element e1, Element e2) {
				if(e1.getPosition() > e2.getPosition()){
					return 1;
				}else if(e1.getPosition() < e2.getPosition()){
					return -1;
				}else{
					return 0;
				}
			}
			
		});
		return elements;
	}
	
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		int i = 0;
		List<Element> order = this.elements;
		order = this.getElementsOrderByPosition(order);
		for (Element element : order) {
			if (i == 3) {
				buffer.append("\n");
				i = 0;
			}
			if (element.getNumber() != null && element.getNumber() != 0)
				buffer.append(String.valueOf(element.getNumber()) + " ");
			else
				buffer.append("N ");
			i++;
		}
		buffer.append("\n\n");
		return buffer.toString();
	}

	
	
	
}
