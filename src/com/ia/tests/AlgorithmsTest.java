/**
 * 
 */
package com.ia.tests;

import static org.junit.Assert.fail;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.ia.core.algorithms.astar.AStar;
import com.ia.core.algorithms.breadth.BreadthFirstSearch;
import com.ia.core.algorithms.depth.DepthFirstSearch;
import com.ia.core.model.Element;
import com.ia.core.model.GameBoard;

/**
 * @author Anderson Soares, Jonatas Carneiro, Pedro Almir
 *
 */
public class AlgorithmsTest {
	
	private GameBoard initialBoard;
	private AStar aStar;
	private BreadthFirstSearch breadthFirst;
	private DepthFirstSearch depthFirst;
	private List<GameBoard> gameBoardList;
	private List<GameBoard> gameBoardsVerified;
	private List<GameBoard> solutionList;
	private Integer steps;
	
	@Before
	public void setUp(){
		initialBoard = createGameBoardForTest();
		/* A* Algorithm */
		aStar = new AStar();
		
		
		/* Breadth First Search Algorithm */
		breadthFirst = new BreadthFirstSearch();
		gameBoardList = new LinkedList<GameBoard>();
		gameBoardList.add(initialBoard);
		gameBoardsVerified = new LinkedList<GameBoard>();
		/* Depth First Search Algorithm */
		/* Maximum depth equal to 50 levels */
		depthFirst = new DepthFirstSearch(50);
		/* Used to save the solution */
		solutionList = new LinkedList<GameBoard>();
	}
	
	@Test
	public void compareTheAlgorithms(){
		System.out.println("#########################################");
		System.out.println("Problem:");
		initialBoard.printMatrix();
		System.out.println("");
		/* A* Algorithm: Begin */
		Long begin = System.currentTimeMillis();
		aStar.starSearch(initialBoard);
		Long end = System.currentTimeMillis();
		/* A* Algorithm: End */
		if(!aStar.getSolution().get(0).isSolution()){
			fail("Not found a solution!");
		}
		System.out.println("#########################################");
		System.out.println("Algorithm A*");
		System.out.println("Found the solution in: " + getTime(end, begin));
		System.out.println("Steps: " + aStar.getSteps());
		System.out.println("#########################################");
		
		
		/* Breadth First Search Algorithm: Begin */
		begin = System.currentTimeMillis();
		breadthFirst.findRecordingMovements(gameBoardList, gameBoardsVerified, solutionList);
		end = System.currentTimeMillis();
		steps = solutionList.size();
		/* Breadth First Search Algorithm: End */
		if(!solutionList.get(0).isSolution()){
			fail("Not found a solution!");
		}
		System.out.println("Algorithm Breadth First Search");
		System.out.println("Found the solution in: " + getTime(end, begin));
		System.out.println("Steps: " + steps);
		System.out.println("#########################################");
		
		
		
		/* Depth First Search Algorithm: Begin */
		begin = System.currentTimeMillis();
		depthFirst.depthFirstSearch(initialBoard);
		end = System.currentTimeMillis();
		/* Depth First Search Algorithm: End */
		solutionList = new LinkedList<GameBoard>();
		solutionList.addAll(depthFirst.getMovements());
		steps = depthFirst.getSteps();
		if(!solutionList.get(0).isSolution()){
			fail("Not found a solution!");
		}
		System.out.println("Algorithm Depth First Search");
		System.out.println("Found the solution in: " + getTime(end, begin));
		System.out.println("Steps: " + steps);
		System.out.println("#########################################");
		System.out.println(printBetterSolution(aStar.getSolution()));
	}
	
	/**
	 * @param end
	 * @param begin
	 * @return
	 */
	private String getTime(Long end, Long begin){
		Long dif = end - begin; 
		if(dif < 1000){
			return dif + " milliseconds.";
		}else if(dif >= 1000 && dif < 60000){
			return dif/1000 + " seconds.";
		}else if(dif/1000 >= 60 && dif/1000 < 3600){
			return dif/60000 + " minutes.";
		}else if(dif/1000 >= 3600 && dif/1000 < 86400){
			return dif/1440000 + " hours.";
		}else{
			return "Are you still here?!?! OMG... Sorry, but this is game over ! ! ! xD";
		}
	}
	
	/**
	 * Create a game board for test
	 * @return the game board
	 */
	public GameBoard createGameBoardForTest(){
		GameBoard temp = new GameBoard();
		Element element1 = new Element(5, 0, 0);
		Element element2 = new Element(8, 0, 1);
		Element element3 = new Element(3, 0, 2);
		Element element4 = new Element(null, 1, 1);
		Element element5 = new Element(4, 1, 0);
		Element element6 = new Element(1, 1, 2);
		Element element7 = new Element(7, 2, 2);
		Element element8 = new Element(6, 2, 1);
		Element element9 = new Element(2, 2, 0);
		temp.getElements().add(element1);
		temp.getElements().add(element2);
		temp.getElements().add(element3);
		temp.getElements().add(element4);
		temp.getElements().add(element5);
		temp.getElements().add(element6);
		temp.getElements().add(element7);
		temp.getElements().add(element8);
		temp.getElements().add(element9);
		temp.setEmptyElement(element4);
		return temp;
	}
	
	private String printBetterSolution(List<GameBoard> solution){
		if(!solution.contains(initialBoard)){
			solution.add(initialBoard);
		}
		StringBuffer buffer = new StringBuffer();
		buffer.append("\n");
		for(int i = solution.size() - 1; i >= 0; i--){
			for(int j = 0; j < 3; j++){
				if(j == 0){
					buffer.append("| ");
				}
				if(solution.get(i).getElements().get(j).getNumber() == null){
					buffer.append("N ");
				}else{
					buffer.append(solution.get(i).getElements().get(j).getNumber() + " ");
				}
				if(j == 2){
					buffer.append("|");
				}
			}
			buffer.append("   ");
		}
		buffer.append("\n");
		for(int i = solution.size() - 1; i >= 0; i--){
			for(int j = 3; j < 6; j++){
				if(j == 3){
					buffer.append("| ");
				}
				if(solution.get(i).getElements().get(j).getNumber() == null){
					buffer.append("N ");
				}else{
					buffer.append(solution.get(i).getElements().get(j).getNumber() + " ");
				}
				if(j == 5){
					buffer.append("|");
				}
			}
			buffer.append("   ");
		}
		buffer.append("\n");
		for(int i = solution.size() - 1; i >= 0; i--){
			for(int j = 6; j < 9; j++){
				if(j == 6){
					buffer.append("| ");
				}
				if(solution.get(i).getElements().get(j).getNumber() == null){
					buffer.append("N ");
				}else{
					buffer.append(solution.get(i).getElements().get(j).getNumber() + " ");
				}
				if(j == 8){
					buffer.append("|");
				}
			}
			buffer.append("   ");
		}
		return buffer.toString();
	}

}
