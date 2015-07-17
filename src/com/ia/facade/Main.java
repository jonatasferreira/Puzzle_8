/**
 * 
 */
package com.ia.facade;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import com.ia.core.algorithms.astar.AStar;
import com.ia.core.algorithms.breadth.BreadthFirstSearch;
import com.ia.core.algorithms.depth.DepthFirstSearch;
import com.ia.core.model.Element;
import com.ia.core.model.GameBoard;
import com.ia.view.ControllerFrame;
import com.ia.view.FrameButton;
import com.ia.view.FrameTree;
import com.ia.view.SeeExecution;

/**
 * @author Anderson Soares, Jonatas Carneiro, Pedro Almir
 *
 */
public class Main {
	private static FrameTree frameTree;
	private static FrameButton fb;
	private static ControllerFrame c;
	private static GameBoard initialBoard;
	private static AStar aStar;
	private static Thread se;
	private static BreadthFirstSearch breadthFirst;
	private static List<GameBoard> gameBoardList;
	private static List<GameBoard> gameBoardsVerified;
	private static List<GameBoard> solutionList;
	private static DepthFirstSearch depthFirst;
	public static boolean flagSeeEx = false;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		c = new ControllerFrame();
		se = new SeeExecution(c);
		fb = new FrameButton(c);
		fb.setVisible(true);

		
		se.run();
	}

	/**
	 * 
	 */
	public static void runAStar(){
		initialBoard = c.getBoard();
		aStar = new AStar();
		initialBoard.printMatrix();
		
		/* A* Algorithm */
		aStar = new AStar();
		
		/* A* Algorithm: Begin */
		Long begin = System.currentTimeMillis();
		aStar.starSearch(initialBoard);
		Long end = System.currentTimeMillis();
		/* A* Algorithm: End */
		
		if(aStar.getSolution().size() > 0){
			if( ! aStar.getSolution().get(0).isSolution()){
				System.out.println("Not found a solution!");
			}
			else{
				fb.setTimeTest(getTime(end, begin));
				fb.setStepsTest("" + aStar.getSteps());
				System.out.println("\n");
				for(int i = aStar.getSolution().size() - 1; i >= 0; i--){
					aStar.getSolution().get(i).printMatrix();
					System.out.println("\n");
				}
				
				int p = JOptionPane.showConfirmDialog( null ,
						"Deseja ver a execução no tabuleiro!" ,
						"Question" ,
						JOptionPane.YES_NO_OPTION,
						JOptionPane.PLAIN_MESSAGE
						);
				if(p == 0){
					setListIntSolu(initialBoard, aStar.getSolution());
					solutionList = aStar.getSolution();
					flagSeeEx = true;
				}
			}
		}else{
			System.out.println("\n\nBoard ord!");
		}
	}
	
	/**
	 * 
	 */
	public static void runBreadth(){
		initialBoard = c.getBoard();
		breadthFirst = new BreadthFirstSearch();
		
		gameBoardList = new LinkedList<GameBoard>();
		gameBoardList.add(initialBoard);
		gameBoardsVerified = new LinkedList<GameBoard>();
		solutionList = new LinkedList<GameBoard>();
		
		/* Breadth First Search Algorithm: Begin */
		Long begin = System.currentTimeMillis();
		breadthFirst.findRecordingMovements(gameBoardList, gameBoardsVerified, solutionList);
		Long end = System.currentTimeMillis();

		
		/* Breadth First Search Algorithm: End */
		if(solutionList.size() > 1){
			if(!solutionList.get(0).isSolution()){
				System.out.println("Not found a solution!");
			}
			else{
				fb.setTimeTest(getTime(end, begin));
				fb.setStepsTest("" + (solutionList.size()-1));
				
				Integer steps = solutionList.size() - 1;
				System.out.println("\n\nSolution(Steps: "+ steps +"):");
				for(int i = solutionList.size() - 1; i >= 0; i--){
					solutionList.get(i).printMatrix();
					System.out.println("\n");
				}
				
				int p = JOptionPane.showConfirmDialog( null ,
						"Deseja ver a execução no tabuleiro!" ,
						"Question" ,
						JOptionPane.YES_NO_OPTION,
						JOptionPane.PLAIN_MESSAGE
						);
				if(p == 0){
					setListIntSolu(initialBoard, solutionList);
					flagSeeEx = true;
				}
			}
		}else{
			System.out.println("\n\nBoard ord!");
		}
	}
	
	/**
	 * 
	 */
	public static void runDepth(){
		initialBoard = c.getBoard();
		
		/* Maximum depth equal to 50 levels */
		depthFirst = new DepthFirstSearch(50);
		solutionList = new LinkedList<GameBoard>();
		initialBoard.printMatrix();
		
		/* Depth First Search Algorithm: Begin */
		Long begin = System.currentTimeMillis();
		depthFirst.depthFirstSearch(initialBoard);
		Long end = System.currentTimeMillis();
		
		solutionList.addAll(depthFirst.getMovements());
		Integer steps = depthFirst.getSteps();
		System.out.println("\n\nSolution(Steps: "+ steps +"):");
		for(int i = solutionList.size() - 1; i >= 0; i--){
			solutionList.get(i).printMatrix();
			System.out.println("\n");
		}

		
		if(solutionList.size() > 1){
			if(!solutionList.get(0).isSolution()){
				System.out.println("Not found a solution!");
			}
			else{
				fb.setTimeTest(getTime(end, begin));
				fb.setStepsTest("" + (solutionList.size()-1));
				
				System.out.println("\n\nSolution(Steps: "+ steps +"):");
				for(int i = solutionList.size() - 1; i >= 0; i--){
					solutionList.get(i).printMatrix();
					System.out.println("\n");
				}
				
				int p = JOptionPane.showConfirmDialog( null ,
						"Deseja ver a execução no tabuleiro!" ,
						"Question" ,
						JOptionPane.YES_NO_OPTION,
						JOptionPane.PLAIN_MESSAGE
						);
				if(p == 0){
					setListIntSolu(initialBoard, solutionList);
					flagSeeEx = true;
				}
			}
		}else{
			System.out.println("\n\nBoard ord!");
		}
	}
	
	/**
	 * @param initialBoard
	 * @param solutionList
	 */
	private static void setListIntSolu(GameBoard initialBoard, List<GameBoard> solutionList){
		int positionEmptyBegin = initialBoard.getEmptyElement().getPosition();
		for(int i = solutionList.size() - 1; i >= 0; i--){
			for(int j=0; j<solutionList.get(i).getElements().size(); j++){
				if(solutionList.get(i).getElements().get(j).getPosition() == positionEmptyBegin){
					
					if(solutionList.get(i).getElements().get(j).getNumber() != null){
						SeeExecution.list.add(solutionList.get(i).getElements().get(j).getNumber());
					}
					
					positionEmptyBegin = solutionList.get(i).getEmptyElement().getPosition();
					
					try {
						Thread.sleep(30L);
					} catch (InterruptedException e) {
						Thread.currentThread().notify();
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	public static void seeTree(){
		frameTree = new FrameTree(initialBoard);
		frameTree.setVisible(true);
	}
	
	
	/**
	 * @param end
	 * @param begin
	 * @return String
	 */
	private static String getTime(Long end, Long begin){
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
		return temp;
	}
}
