/**
 * 
 */
package com.ia.tests;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.ia.core.algorithms.astar.AStar;
import com.ia.core.model.Element;
import com.ia.core.model.GameBoard;

/**
 * @author Anderson Soares, Jonatas Carneiro, Pedro Almir
 *
 */
public class AStarTest {
	
	private GameBoard initialBoard;
	private AStar aStar;
	
	@Before
	public void setUp(){
		initialBoard = createGameBoardForTest();
		aStar = new AStar();
	}
	
	/**
	 * 
	 */
	@Test
	public void aStarTest(){
		initialBoard.printMatrix();
		System.out.println("\n");
		aStar.starSearch(initialBoard);
		for(int i = aStar.getSolution().size() - 1; i >= 0; i--){
			aStar.getSolution().get(i).printMatrix();
			System.out.println("\n");
		}
		if(!aStar.getSolution().get(0).isSolution()){
			fail("Not found a solution!");
		}
	}
	
	/**
	 * Create a game board for test
	 * @return the game board
	 */
	public GameBoard createGameBoardForTest(){
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
		return temp;
	}
}
