/**
 * 
 */
package com.ia.tests;

import org.junit.Before;
import org.junit.Test;

import com.ia.view.FrameTree;



/**
 * @author Anderson Soares, Jonatas Carneiro, Pedro Almir
 *
 */
public class TreeTest {
	private FrameTree f;
	
	@Before
	public void setUp(){
	}
	
	@Test
	public void treeTest(){
		CreatingTestTree c = new CreatingTestTree();
		f = new FrameTree(c.creating(null));
		f.setVisible(true);
		try {
			Thread.sleep(5000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
