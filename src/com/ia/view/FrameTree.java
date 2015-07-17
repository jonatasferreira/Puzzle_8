/**
 * 
 */
package com.ia.view;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

import com.ia.core.model.GameBoard;


/**
 * @author Jonatas
 *
 */
public class FrameTree extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PanelTree panelTree;
	private GameBoard root = null;
	private Point lastPoint = null;
	
	
	public FrameTree(GameBoard r) {
		this.root = r;
		setTitle("Tree");
		setSize(723, 641);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLocationRelativeTo(null);
		
		panelTree = new PanelTree(root);
		panelTree.setLocation(0, 0);
		getContentPane().add(panelTree);
		
		panelTree.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent arg0) {
				if (lastPoint != null) {
					lastPoint = null;
				}
			}

			@SuppressWarnings("static-access")
			@Override
			public void mouseDragged(MouseEvent me) {
				if (lastPoint == null) {
					lastPoint = me.getPoint();
				}
				panelTree.aumentoX += me.getPoint().x - lastPoint.x;
				panelTree.aumentoY += me.getPoint().y - lastPoint.y;

				lastPoint = me.getPoint();

				repaint();

			}
		});
	}


	/**
	 * @param root the root to set
	 */
	public void setRoot(GameBoard root) {
		this.root = root;
	}
	
	
}
