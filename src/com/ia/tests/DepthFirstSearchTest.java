/**
 * 
 */
package com.ia.tests;

import static org.junit.Assert.fail;

import java.util.LinkedList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.ia.core.algorithms.depth.DepthFirstSearch;
import com.ia.core.model.Element;
import com.ia.core.model.GameBoard;

/**
 * @author Anderson Soares, Jonatas Carneiro, Pedro Almir
 *
 */
public class DepthFirstSearchTest {
	
	private GameBoard initialBoard;
	private DepthFirstSearch depthFirst;
	private List<GameBoard> solutionList;
	private Integer steps;
	
	@Before
	public void setUp(){
		initialBoard = createGameBoardForTest();
		
		/* Maximum depth equal to 50 levels */
		depthFirst = new DepthFirstSearch(50);
		
		solutionList = new LinkedList<GameBoard>();
	}
	
	/**
	 * 
	 */
	@Test
	public void test(){
		System.out.println("Initial:");
		initialBoard.printMatrix();
		depthFirst.depthFirstSearch(initialBoard);
		
		solutionList.addAll(depthFirst.getMovements());
		
		steps = depthFirst.getSteps();
		
		
		System.out.println("\n\nSolution(Steps: "+ steps +"):");
		for(int i = solutionList.size() - 1; i >= 0; i--){
			solutionList.get(i).printMatrix();
			System.out.println("\n");
		}
		Assert.assertEquals(new Integer(14), steps);
		if(!solutionList.get(0).isSolution()){
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
