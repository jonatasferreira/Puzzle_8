package com.ia.view;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * @author Anderson Soares, Jonatas Carneiro, Pedro Almir
 *
 */
public class FramePuzzle extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel labelN1;
	private JLabel labelN2;
	private JLabel labelN3;
	private JLabel labelN4;
	private JLabel labelN5;
	private JLabel labelN6;
	private JLabel labelN7;
	private JLabel labelN8;
	private JPanel panelBackground;
	
	FramePuzzle() {
		setLocation(20, 20);
		setSize(458, 480);
		setResizable(false);
		getContentPane().setLayout(null);
		
		panelBackground = new JPanel();
		panelBackground.setBackground(new Color(153, 204, 204));
		panelBackground.setBounds(0, 0, 452, 452);
		getContentPane().add(panelBackground);
		panelBackground.setLayout(null);
		
		labelN1 = new JLabel("");
		labelN1.setIcon(new ImageIcon(FramePuzzle.class.getResource("/Image/n1.jpg")));
		labelN1.setBounds(2, 2, 148, 148);
		panelBackground.add(labelN1);
		
		labelN2 = new JLabel("");
		labelN2.setIcon(new ImageIcon(FramePuzzle.class.getResource("/Image/n2.jpg")));
		labelN2.setBounds(152, 2, 148, 148);
		panelBackground.add(labelN2);
		
		labelN3 = new JLabel("");
		labelN3.setIcon(new ImageIcon(FramePuzzle.class.getResource("/Image/n3.jpg")));
		labelN3.setBounds(302, 2, 148, 148);
		panelBackground.add(labelN3);
		
		labelN4 = new JLabel("");
		labelN4.setIcon(new ImageIcon(FramePuzzle.class.getResource("/Image/n4.jpg")));
		labelN4.setBounds(2, 152, 148, 148);
		panelBackground.add(labelN4);
		
		labelN5 = new JLabel("");
		labelN5.setIcon(new ImageIcon(FramePuzzle.class.getResource("/Image/n5.jpg")));
		labelN5.setBounds(152, 152, 148, 148);
		panelBackground.add(labelN5);
		
		labelN6 = new JLabel("");
		labelN6.setIcon(new ImageIcon(FramePuzzle.class.getResource("/Image/n6.jpg")));
		labelN6.setBounds(302, 152, 148, 148);
		panelBackground.add(labelN6);
		
		labelN7 = new JLabel("");
		labelN7.setIcon(new ImageIcon(FramePuzzle.class.getResource("/Image/n7.jpg")));
		labelN7.setBounds(2, 302, 148, 148);
		panelBackground.add(labelN7);
		
		labelN8 = new JLabel("");
		labelN8.setIcon(new ImageIcon(FramePuzzle.class.getResource("/Image/n8.jpg")));
		labelN8.setBounds(152, 302, 148, 148);
		panelBackground.add(labelN8);
	}
	
	void resetFramePuzzle(){
		labelN1.setBounds(2, 2, 148, 148);
		labelN2.setBounds(152, 2, 148, 148);
		labelN3.setBounds(302, 2, 148, 148);
		labelN4.setBounds(2, 152, 148, 148);
		labelN5.setBounds(152, 152, 148, 148);
		labelN6.setBounds(302, 152, 148, 148);
		labelN7.setBounds(2, 302, 148, 148);
		labelN8.setBounds(152, 302, 148, 148);
		this.repaint();
	}
	
	void setPositionNumber(int number, EnumPositionNumber position){
		switch(number){
			case 1:
				labelN1.setBounds(getHorPosition(position), getVerPosition(position), 148, 148);
//				labelN1.repaint();
				break;
			case 2:
				labelN2.setBounds(getHorPosition(position), getVerPosition(position), 148, 148);
//				labelN2.repaint();
				break;
			case 3:
				labelN3.setBounds(getHorPosition(position), getVerPosition(position), 148, 148);
//				labelN3.repaint();
				break;
			case 4:
				labelN4.setBounds(getHorPosition(position), getVerPosition(position), 148, 148);
//				labelN4.repaint();
				break;
			case 5:
				labelN5.setBounds(getHorPosition(position), getVerPosition(position), 148, 148);
//				labelN5.repaint();
				break;
			case 6:
				labelN6.setBounds(getHorPosition(position), getVerPosition(position), 148, 148);
//				labelN6.repaint();
				break;
			case 7:
				labelN7.setBounds(getHorPosition(position), getVerPosition(position), 148, 148);
//				labelN7.repaint();
				break;
			case 8:
				labelN8.setBounds(getHorPosition(position), getVerPosition(position), 148, 148);
//				labelN8.repaint();
				break;
		}
		//panelBackground.repaint();
		this.repaint();
	}
	
	private int getHorPosition(EnumPositionNumber position){
		switch(position){
			case pos00:
				return 2;
			case pos01:
				return 152;
			case pos02:
				return 302;
			case pos10:
				return 2;
			case pos11:
				return 152;
			case pos12:
				return 302;
			case pos20:
				return 2;
			case pos21:
				return 152;
			default:  // pos22
				return 302;
		}
	}
	
	private int getVerPosition(EnumPositionNumber position){
		switch(position){
			case pos00:
				return 2;
			case pos01:
				return 2;
			case pos02:
				return 2;
			case pos10:
				return 152;
			case pos11:
				return 152;
			case pos12:
				return 152;
			case pos20:
				return 302;
			case pos21:
				return 302;
			default:  // pos22
				return 302;
		}
	}

	/**
	 * @return the labelN1
	 */
	public JLabel getLabelN1() {
		return labelN1;
	}

	/**
	 * @param labelN1 the labelN1 to set
	 */
	public void setLabelN1(JLabel labelN1) {
		this.labelN1 = labelN1;
	}

	/**
	 * @return the labelN2
	 */
	public JLabel getLabelN2() {
		return labelN2;
	}

	/**
	 * @param labelN2 the labelN2 to set
	 */
	public void setLabelN2(JLabel labelN2) {
		this.labelN2 = labelN2;
	}

	/**
	 * @return the labelN3
	 */
	public JLabel getLabelN3() {
		return labelN3;
	}

	/**
	 * @param labelN3 the labelN3 to set
	 */
	public void setLabelN3(JLabel labelN3) {
		this.labelN3 = labelN3;
	}

	/**
	 * @return the labelN4
	 */
	public JLabel getLabelN4() {
		return labelN4;
	}

	/**
	 * @param labelN4 the labelN4 to set
	 */
	public void setLabelN4(JLabel labelN4) {
		this.labelN4 = labelN4;
	}

	/**
	 * @return the labelN5
	 */
	public JLabel getLabelN5() {
		return labelN5;
	}

	/**
	 * @param labelN5 the labelN5 to set
	 */
	public void setLabelN5(JLabel labelN5) {
		this.labelN5 = labelN5;
	}

	/**
	 * @return the labelN6
	 */
	public JLabel getLabelN6() {
		return labelN6;
	}

	/**
	 * @param labelN6 the labelN6 to set
	 */
	public void setLabelN6(JLabel labelN6) {
		this.labelN6 = labelN6;
	}

	/**
	 * @return the labelN7
	 */
	public JLabel getLabelN7() {
		return labelN7;
	}

	/**
	 * @param labelN7 the labelN7 to set
	 */
	public void setLabelN7(JLabel labelN7) {
		this.labelN7 = labelN7;
	}

	/**
	 * @return the labelN8
	 */
	public JLabel getLabelN8() {
		return labelN8;
	}

	/**
	 * @param labelN8 the labelN8 to set
	 */
	public void setLabelN8(JLabel labelN8) {
		this.labelN8 = labelN8;
	}
	
}
