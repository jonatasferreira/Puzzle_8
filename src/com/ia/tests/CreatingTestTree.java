package com.ia.tests;


import java.util.LinkedList;

import com.ia.core.model.Element;
import com.ia.core.model.GameBoard;


public class CreatingTestTree{
	private GameBoard board;
	

	public CreatingTestTree() {}

	public GameBoard creating(GameBoard pai){
		if(pai != null){
			board = createGameBoardForTest();
			board.setFather(pai);
			board.setLevel(pai.getLevel()+1);
			pai.getSuccessors().add(board);
		}
		else{
			board = createGameBoardForTest();
			board.setLevel(0);
			board.setFather(board);
			
			board.setOpened(false);// Node locked appears in red
		}
		
		
		if(board.getLevel() <= 4){// Node only has children only up to level 2
			// creating three children for each node
			new CreatingTestTree().creating(board);
			new CreatingTestTree().creating(board);
		}
		
		return board;
	}
	

	/**
	 * @return the board
	 */
	public GameBoard getBoard() {
		return board;
	}
	
	/**
	 * @return GameBoard
	 */
	public static GameBoard createGameBoardForTest(){
		GameBoard temp = new GameBoard();
		Element element1 = new Element(1, 0, 0);
		Element element2 = new Element(2, 0, 1);
		Element element3 = new Element(3, 0, 2);
		Element element4 = new Element(4, 1, 1);
		Element element5 = new Element(5, 1, 0);
		Element element6 = new Element(6, 1, 2);
		Element element7 = new Element(7, 2, 2);
		Element element8 = new Element(8, 2, 1);
		Element element9 = new Element(null, 2, 0);
		temp.getElements().add(element1);
		temp.getElements().add(element2);
		temp.getElements().add(element3);
		temp.getElements().add(element4);
		temp.getElements().add(element5);
		temp.getElements().add(element6);
		temp.getElements().add(element7);
		temp.getElements().add(element8);
		temp.getElements().add(element9);
		temp.setEmptyElement(element9);
		
		temp.setSuccessors(new LinkedList<GameBoard>());
		return temp;
	}
}
