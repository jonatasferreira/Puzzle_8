package com.ia.view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import com.ia.core.model.Element;
import com.ia.core.model.GameBoard;


/**
 * @author Anderson Soares, Jonatas Carneiro, Pedro Almir
 *
 */
public class ControllerFrame {
	private EnumPositionNumber lastLocationEmpty;
	private static FramePuzzle frame;
	private EnumPositionNumber[] positionNumbers = new EnumPositionNumber[9];
	boolean flagShuffle = false;

	public ControllerFrame() {
		super();
		frame = new FramePuzzle();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				if(arg0.getKeyCode() == 10){
					for(int i=0; i<300; i++){
						shuffleFramePuzzle();
						for(long k=0; k<18000000; k++);
					}
				}
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode() == 82){
					resetFramePuzzle();
				}else if(arg0.getKeyCode() == 112){
					shuffle();
				}else if(arg0.getKeyCode() == 77){
					shuffle();
				}else if(arg0.getKeyCode() == 83){
					shuffleFramePuzzle();
				}
				
			}
		});
		
		
		
		positionNumbers[1] = EnumPositionNumber.pos00; // number one
		positionNumbers[2] = EnumPositionNumber.pos01; // number two
		positionNumbers[3] = EnumPositionNumber.pos02; // number three
		positionNumbers[4] = EnumPositionNumber.pos10; // number four
		positionNumbers[5] = EnumPositionNumber.pos11; // number five
		positionNumbers[6] = EnumPositionNumber.pos12; // number six
		positionNumbers[7] = EnumPositionNumber.pos20; // number seven
		positionNumbers[8] = EnumPositionNumber.pos21; // number eight
		positionNumbers[0] = EnumPositionNumber.pos22; // room emptiness
		lastLocationEmpty = EnumPositionNumber.pos22;
		
		makeMouseListeners();
		
	}
	
	public static FramePuzzle getFrame() {
		return frame;
	}

	public GameBoard getBoard(){
		GameBoard temp = new GameBoard();
		Element element1 = new Element(getPositionFrame(EnumPositionNumber.pos00), 0, 0);
		Element element2 = new Element(getPositionFrame(EnumPositionNumber.pos01), 0, 1);
		Element element3 = new Element(getPositionFrame(EnumPositionNumber.pos02), 0, 2);
		Element element4 = new Element(getPositionFrame(EnumPositionNumber.pos10), 1, 0);
		Element element5 = new Element(getPositionFrame(EnumPositionNumber.pos11), 1, 1);
		Element element6 = new Element(getPositionFrame(EnumPositionNumber.pos12), 1, 2);
		Element element7 = new Element(getPositionFrame(EnumPositionNumber.pos20), 2, 0);
		Element element8 = new Element(getPositionFrame(EnumPositionNumber.pos21), 2, 1);
		Element element9 = new Element(getPositionFrame(EnumPositionNumber.pos22), 2, 2);
		temp.getElements().add(element1);
		temp.getElements().add(element2);
		temp.getElements().add(element3);
		temp.getElements().add(element4);
		temp.getElements().add(element5);
		temp.getElements().add(element6);
		temp.getElements().add(element7);
		temp.getElements().add(element8);
		temp.getElements().add(element9);
		for(int i=0; i<temp.getElements().size(); i++){
			if(temp.getElements().get(i).getNumber() == null){
				temp.setEmptyElement(temp.getElements().get(i));
				break;
			}
		}
		return temp;
	}
	
	private void makeMouseListeners(){
		frame.getLabelN1().addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				slideNumber(1);
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		frame.getLabelN2().addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				slideNumber(2);
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		frame.getLabelN3().addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				slideNumber(3);
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		frame.getLabelN4().addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				slideNumber(4);
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		frame.getLabelN5().addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				slideNumber(5);
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		frame.getLabelN6().addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				slideNumber(6);
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		frame.getLabelN7().addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				slideNumber(7);
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		frame.getLabelN8().addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				slideNumber(8);
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
	}
	
	public void slideNumber(int number){
		EnumPositionNumber aux;
		if((number >= 1 && number <= 8) && (this.testSlideNumber(positionNumbers[number]))){
			aux = positionNumbers[number];
			positionNumbers[number] = positionNumbers[0];
			positionNumbers[0] = aux;
			frame.setPositionNumber(number, positionNumbers[number]);
			frame.repaint();
		}
	}
	
	public EnumPositionNumber getPositionNumber(int number) throws ExceptionIndexInvalid{
		if(number >= 0 && number <= 8){
			return positionNumbers[number];
		}
		else{
			throw new ExceptionIndexInvalid("Indice invalido !");
		}
	}
	
	public Integer getPositionFrame(EnumPositionNumber positionFrame){
		for(int i=1; i<=8; i++){
			if(positionFrame == positionNumbers[i]){
				return i;
			}
		}
		return null;
	}
	
	/** Returns an integer, indicated the position of the frame number 0 - 8
	 * @param number
	 * @return
	 */
	public int getPositionFrame(int number) throws ExceptionIndexInvalid{
		if(number >= 0 && number <= 8){
			EnumPositionNumber n = getPositionNumber(number);
			switch(n){
				case pos00: 	return 1;
				case pos01:		return 2;
				case pos02:		return 3;
				case pos10:		return 4;
				case pos11:		return 5;
				case pos12:		return 6;
				case pos20:		return 7;
				case pos21:		return 8;
				default:		return 9;
			}
		}
		else{
			throw new ExceptionIndexInvalid("Indice invalido !");
		}
	}
	
	public void resetFramePuzzle(){
		frame.resetFramePuzzle();
		positionNumbers[1] = EnumPositionNumber.pos00;
		positionNumbers[2] = EnumPositionNumber.pos01;
		positionNumbers[3] = EnumPositionNumber.pos02;
		positionNumbers[4] = EnumPositionNumber.pos10;
		positionNumbers[5] = EnumPositionNumber.pos11;
		positionNumbers[6] = EnumPositionNumber.pos12;
		positionNumbers[7] = EnumPositionNumber.pos20;
		positionNumbers[8] = EnumPositionNumber.pos21;
		positionNumbers[0] = EnumPositionNumber.pos22;
	}
	
	public void shuffleFramePuzzle(){
		for(int i=0; i<200; i++){
			this.shuffle();
			try {
				Thread.sleep(5L);
			} catch (InterruptedException e) {
				Thread.currentThread().notify();
				e.printStackTrace();
			}
		}
	}
	
	private void shuffle(){
		long x;
		switch(positionNumbers[0]){
			case pos00:
				if(lastLocationEmpty == EnumPositionNumber.pos01)
					slideNumber(getPositionFrame(EnumPositionNumber.pos10));
				else
					slideNumber(getPositionFrame(EnumPositionNumber.pos01));
				
				lastLocationEmpty = EnumPositionNumber.pos00;
				break;
			case pos01:
				x = System.currentTimeMillis();
				x = (x%2);
				if(lastLocationEmpty == EnumPositionNumber.pos00){
					if(x == 0) slideNumber(getPositionFrame(EnumPositionNumber.pos11));
					else slideNumber(getPositionFrame(EnumPositionNumber.pos02));
				}
				else if(lastLocationEmpty == EnumPositionNumber.pos11){
					if(x == 0) slideNumber(getPositionFrame(EnumPositionNumber.pos00));
					else slideNumber(getPositionFrame(EnumPositionNumber.pos02));
				}
				else{
					if(x == 0) slideNumber(getPositionFrame(EnumPositionNumber.pos00));
					else slideNumber(getPositionFrame(EnumPositionNumber.pos11));
				}
				
				lastLocationEmpty = EnumPositionNumber.pos01;
				break;
			case pos02:
				if(lastLocationEmpty == EnumPositionNumber.pos12)
					slideNumber(getPositionFrame(EnumPositionNumber.pos01));
				else
					slideNumber(getPositionFrame(EnumPositionNumber.pos12));
				
				lastLocationEmpty = EnumPositionNumber.pos02;
				break;
			case pos10:
				x = System.currentTimeMillis();
				x = (x%2);
				if(lastLocationEmpty == EnumPositionNumber.pos00){
					if(x == 0) slideNumber(getPositionFrame(EnumPositionNumber.pos11));
					else slideNumber(getPositionFrame(EnumPositionNumber.pos20));
				}
				else if(lastLocationEmpty == EnumPositionNumber.pos11){
					if(x == 0) slideNumber(getPositionFrame(EnumPositionNumber.pos00));
					else slideNumber(getPositionFrame(EnumPositionNumber.pos20));
				}
				else{
					if(x == 0) slideNumber(getPositionFrame(EnumPositionNumber.pos00));
					else slideNumber(getPositionFrame(EnumPositionNumber.pos11));
				}
				
				lastLocationEmpty = EnumPositionNumber.pos10;
				break;
			case pos11:
				x = System.currentTimeMillis();
				x = (x%3);
				if(lastLocationEmpty == EnumPositionNumber.pos01){
					if(x == 0) slideNumber(getPositionFrame(EnumPositionNumber.pos10));
					else if(x == 1) slideNumber(getPositionFrame(EnumPositionNumber.pos21));
					else slideNumber(getPositionFrame(EnumPositionNumber.pos12));
				}
				else if(lastLocationEmpty == EnumPositionNumber.pos10){
					if(x == 0) slideNumber(getPositionFrame(EnumPositionNumber.pos01));
					else if(x == 1) slideNumber(getPositionFrame(EnumPositionNumber.pos21));
					else slideNumber(getPositionFrame(EnumPositionNumber.pos12));
				}
				else if(lastLocationEmpty == EnumPositionNumber.pos21){
					if(x == 0) slideNumber(getPositionFrame(EnumPositionNumber.pos01));
					else if(x == 1) slideNumber(getPositionFrame(EnumPositionNumber.pos10));
					else slideNumber(getPositionFrame(EnumPositionNumber.pos12));
				}
				else{
					if(x == 0) slideNumber(getPositionFrame(EnumPositionNumber.pos01));
					else if(x == 1) slideNumber(getPositionFrame(EnumPositionNumber.pos10));
					else slideNumber(getPositionFrame(EnumPositionNumber.pos21));
				}
				
				lastLocationEmpty = EnumPositionNumber.pos11;
				break;
			case pos12:
				x = System.currentTimeMillis();
				x = (x%2);
				if(lastLocationEmpty == EnumPositionNumber.pos02){
					if(x == 0) slideNumber(getPositionFrame(EnumPositionNumber.pos11));
					else slideNumber(getPositionFrame(EnumPositionNumber.pos22));
				}
				else if(lastLocationEmpty == EnumPositionNumber.pos11){
					if(x == 0) slideNumber(getPositionFrame(EnumPositionNumber.pos02));
					else slideNumber(getPositionFrame(EnumPositionNumber.pos22));
				}
				else{
					if(x == 0) slideNumber(getPositionFrame(EnumPositionNumber.pos11));
					else slideNumber(getPositionFrame(EnumPositionNumber.pos02));
				}
				
				lastLocationEmpty = EnumPositionNumber.pos12;
				break;
			case pos20:
				if(lastLocationEmpty == EnumPositionNumber.pos21)
					slideNumber(getPositionFrame(EnumPositionNumber.pos10));
				else
					slideNumber(getPositionFrame(EnumPositionNumber.pos21));
				
				lastLocationEmpty = EnumPositionNumber.pos20;
				break;
			case pos21:
				x = System.currentTimeMillis();
				x = (x%2);
				if(lastLocationEmpty == EnumPositionNumber.pos20){
					if(x == 0) slideNumber(getPositionFrame(EnumPositionNumber.pos11));
					else slideNumber(getPositionFrame(EnumPositionNumber.pos22));
				}
				else if(lastLocationEmpty == EnumPositionNumber.pos11){
					if(x == 0) slideNumber(getPositionFrame(EnumPositionNumber.pos20));
					else slideNumber(getPositionFrame(EnumPositionNumber.pos22));
				}
				else{
					if(x == 0) slideNumber(getPositionFrame(EnumPositionNumber.pos11));
					else slideNumber(getPositionFrame(EnumPositionNumber.pos20));
				}
				
				lastLocationEmpty = EnumPositionNumber.pos21;
				break;
			default:  // pos22
				if(lastLocationEmpty == EnumPositionNumber.pos21)
					slideNumber(getPositionFrame(EnumPositionNumber.pos12));
				else
					slideNumber(getPositionFrame(EnumPositionNumber.pos21));
				
				lastLocationEmpty = EnumPositionNumber.pos22;
		}
	}
	
	private boolean testSlideNumber(EnumPositionNumber position){
		switch(positionNumbers[0]){
			case pos00:
				if(position == EnumPositionNumber.pos01 ||
						position == EnumPositionNumber.pos10)
					return true;
				break;
			case pos01:
				if(position == EnumPositionNumber.pos00 ||
						position == EnumPositionNumber.pos11 ||
						position == EnumPositionNumber.pos02)
					return true;
				break;
			case pos02:
				if(position == EnumPositionNumber.pos01 ||
						position == EnumPositionNumber.pos12)
					return true;
				break;
			case pos10:
				if(position == EnumPositionNumber.pos00 ||
						position == EnumPositionNumber.pos11 ||
						position == EnumPositionNumber.pos20)
					return true;
				break;
			case pos11:
				if(position == EnumPositionNumber.pos01 ||
						position == EnumPositionNumber.pos10 ||
						position == EnumPositionNumber.pos12 ||
						position == EnumPositionNumber.pos21)
					return true;
				break;
			case pos12:
				if(position == EnumPositionNumber.pos02 ||
						position == EnumPositionNumber.pos11 ||
						position == EnumPositionNumber.pos22)
					return true;
				break;
			case pos20:
				if(position == EnumPositionNumber.pos10 ||
						position == EnumPositionNumber.pos21)
					return true;
				break;
			case pos21:
				if(position == EnumPositionNumber.pos20 ||
						position == EnumPositionNumber.pos11 ||
						position == EnumPositionNumber.pos22)
					return true;
				break;
			case pos22:
				if(position == EnumPositionNumber.pos12 ||
						position == EnumPositionNumber.pos21)
					return true;
				break;
		}
		return false;
	}
}





