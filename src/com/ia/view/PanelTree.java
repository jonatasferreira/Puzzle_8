/**
 * 
 */
package com.ia.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import com.ia.core.model.GameBoard;

/**
 * @author Jonatas
 *
 */
public class PanelTree extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Graphics g;
	private GameBoard root;
	static int aumentoX = 0;
	static int aumentoY = 0;
	
	/**
	 * Limit successors in the tree
	 */
	private int maxSuccessors = 4;
	/**
	 * Amount of node by level.
	 */
	public ArrayList<Integer> amountNodeLevel;
	/**
	 * 
	 */
	public ArrayList<Integer> indexNodeLevel;
	/**
	 * Height of the tree
	 */
	public int heightTree; 
	/**
	 * Horizontal distance between the node
	 */
	private static final int distanceHorizNode = 140;
	
	/**
	 * @param root
	 */
	public PanelTree(GameBoard root){
		this.root = root;
	}
	
	public void paint(Graphics gPaint) {
		if (root != null) {
			g = gPaint;
			g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 15));
			drawTree((getWidth() / 2 + aumentoX)-45, 15 + aumentoY, root);
		}
	}
	
	/** Draw the whole tree
	 * @param x
	 * @param y
	 * @param gb
	 */
	private void drawTree(int x, int y, GameBoard gb){
		indexNodeLevel = new ArrayList<Integer>();
		amountNodeLevel = new ArrayList<Integer>();
		heightTree = heightTree(gb);
		displayInstructions(x, y);

		drawAllNodes(gb, x, y);
		
		drawAllEdges(gb);
	}
	
	/** Draw all edges of the tree
	 * @param gb
	 */
	private void drawAllEdges(GameBoard gb){
		int x1 = gb.getPositionNodeX();
		int y1 = gb.getPositonNodeY();
		int x2;
		int y2;
		
		List<GameBoard> successors = gb.getSuccessors();
		for(int i=0; i<gb.getSuccessors().size(); i++){
			x2 = successors.get(i).getPositionNodeX();
			y2 = successors.get(i).getPositonNodeY();
			
			g.setColor(Color.BLACK);
			g.drawLine(x1+45, y1+90, x2+45, y2);
			
			drawAllEdges(successors.get(i));
		}
	}
	
	/** Draws all nodes from the root
	 * @param gb
	 * @param x
	 * @param y
	 */
	private void drawAllNodes(GameBoard gb, int x, int y){
		drawNodeBoard(positonXNode(indexNodeLevel.get(gb.getLevel()), amountNodeLevel.get(gb.getLevel()), x), 
				y+(distanceHorizNode * gb.getLevel()), gb); // draws the root
		int index = indexNodeLevel.get(gb.getLevel());
		indexNodeLevel.set(gb.getLevel(), ++index);
		
		List<GameBoard> successors = gb.getSuccessors();
		for(int i=0; i<successors.size(); i++){
			drawAllNodes(successors.get(i), x, y);
		}
	}
	
	/** Draw a node
	 * @param x
	 * @param y
	 * @param node
	 */
	private void drawNodeBoard(int x, int y, GameBoard node){
		node.setPositionNodeX(x);
		node.setPositonNodeY(y);
		
		g.setColor(Color.WHITE);
		g.fillRoundRect(x, y, 90, 90, 2, 2);
		if(node.isOpened()) g.setColor(Color.BLACK);
		else  g.setColor(Color.RED);
		g.drawRoundRect(x, y, 90, 90, 2, 2);

		g.drawLine(x + 30, y, x + 30, y + 90);
		g.drawLine(x + 60, y, x + 60, y + 90);

		g.drawLine(x, y + 30, x + 90, y + 30);
		g.drawLine(x, y + 60, x + 90, y + 60);

		int altura = g.getFontMetrics(getFont()).getHeight();

		String[][] valores = { { "1", "2", "3" }, { "4", "5", "6" },
				{ "7", "8", " " } };
	
		g.setColor(Color.BLACK);
		for(int i=0; i<node.getElements().size(); i++){
			switch(node.getElements().get(i).getPosition()){
				case 1:
					valores[0][0] = getNumberString(node.getElements().get(i).getNumber());
					break;
				case 2:
					valores[0][1] = getNumberString(node.getElements().get(i).getNumber());
					break;
				case 3:
					valores[0][2] = getNumberString(node.getElements().get(i).getNumber());
					break;
				case 4:
					valores[1][0] = getNumberString(node.getElements().get(i).getNumber());
					break;
				case 5:
					valores[1][1] = getNumberString(node.getElements().get(i).getNumber());
					break;
				case 6:
					valores[1][2] = getNumberString(node.getElements().get(i).getNumber());
					break;
				case 7:
					valores[2][0] = getNumberString(node.getElements().get(i).getNumber());
					break;
				case 8:
					valores[2][1] = getNumberString(node.getElements().get(i).getNumber());
					break;
				default:  // 9
					valores[2][2] = getNumberString(node.getElements().get(i).getNumber());
					break;
			}
		}

		g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				String valor = valores[j][i];
				int largura = g.getFontMetrics(getFont()).charWidth(
						valor.charAt(0))
						* valor.length();
				g.drawString(valor, x + (i * 30) + (15 - largura / 2),
						y + (j * 30) + (30 - altura / 2));
			}
		}
	}
	
	private String getNumberString(Integer i){
		if(i != null){
			return ""+i;
		}else{
			return " ";
		}
	}
	
	/** Displays instructions on the colors of the nodes
	 * @param xRoot
	 * @param yRoot
	 */
	private void displayInstructions(int xRoot, int yRoot){
		g.setColor(Color.WHITE);
		g.fillRoundRect(xRoot-400, yRoot, 90, 30, 2, 2);
		g.setColor(Color.RED);
		g.fillRoundRect(xRoot-400, yRoot+50, 90, 30, 2, 2);
		
		g.setColor(Color.BLACK);
		g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 15));
		g.drawString("Open Node", xRoot - 300,	yRoot+20);
		g.drawString("Closed Node", xRoot - 300,	yRoot+70);
	}
	
	/** Calculates the x position of the node in the tree
	 * @param sequenceNode
	 * @param amountNodeLevel
	 * @param xRoot
	 * @return
	 */
	private int positonXNode(int sequenceNode, int amountNodeLevel, int xRoot){
		if(amountNodeLevel % 2 == 1){
			int k = amountNodeLevel/2;
			if(sequenceNode < k){
				k = 110*(k-sequenceNode);
				xRoot = xRoot-k;
				return xRoot;
			}
			else{
				k = 110*(sequenceNode-k);
				xRoot = xRoot+k;
				return xRoot;
			}
		}
		else{
			int k = amountNodeLevel/2;
			if(sequenceNode < k){
				k = 55 + (110*(k-sequenceNode-1));
				xRoot = xRoot-k;
				return xRoot;
			}
			else{
				k = 55 + (110*(sequenceNode-k));
				xRoot = xRoot+k;
				return xRoot;
			}
		}
	}
	
	/** Returns the height of the tree.
	 * @param root
	 * @return
	 */
	private int heightTree(GameBoard root){
		int i=0;
		int moreSubtree = -1;
		int successor[] = new int[maxSuccessors];
		if (root == null){
			return -1; // tree height is empty -1
		}
		else {
			for(i=0; i<root.getSuccessors().size() && i<maxSuccessors; i++){
				successor[i] = heightTree(root.getSuccessors().get(i));
			}
			for(;i<maxSuccessors; i++){
			   successor[i] = -1;
			}
			moreSubtree = successor[0];
			for(i = 1; i<maxSuccessors; i++){
				if(successor[i] > moreSubtree){
					moreSubtree = successor[i];
				}
			}
			setNodeLevel(root.getLevel());
			return moreSubtree + 1;
	   }
	}

	/** Accumulates the number of nodes at each level
	 * @param amountNodeLevel the amountNodeLevel to set
	 */
	private void setNodeLevel(int nodeLevel) {

		while( amountNodeLevel.size()-1 < nodeLevel ){
			amountNodeLevel.add(0);
			indexNodeLevel.add(0);
		}
		amountNodeLevel.set(nodeLevel, amountNodeLevel.get(nodeLevel) + 1);
		indexNodeLevel.set(nodeLevel,0);
	}

	/** Set a root of the tree Panel
	 * @param root the root to set
	 */
	public void setRoot(GameBoard nodeRoot) {
		root = nodeRoot;
	}
}
