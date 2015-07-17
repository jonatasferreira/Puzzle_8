/**
 * 
 */
package com.ia.view;

import java.util.LinkedList;
import java.util.List;

import com.ia.facade.Main;

/**
 * @author Anderson Soares, Jonatas Carneiro, Pedro Almir
 *
 */
public class SeeExecution extends Thread {
	public static List<Integer> list = new LinkedList<Integer>();
	public ControllerFrame c;
	
	public SeeExecution(ControllerFrame c) {
		super();
		this.c = c;
	}
	
	public void run(){
		while(true){
			while(( ! Main.flagSeeEx ) || (c == null) || (list.size() == 0)){
				try {
					Thread.sleep(1500L);
				} catch (InterruptedException e) {
					Thread.currentThread().notify();
					e.printStackTrace();
				}
			}
			Main.flagSeeEx = false;
			for(int i = 0; i<list.size(); i++){
//				System.out.println(" >> Tam list = "+list.size()+"  >> number = "+list.get(i));
				c.slideNumber(list.get(i));
				try {
					Thread.sleep(300L);
				} catch (InterruptedException e) {
					Thread.currentThread().notify();
					e.printStackTrace();
				}
			}
			list = new LinkedList<Integer>();
		}
	}
	
}
