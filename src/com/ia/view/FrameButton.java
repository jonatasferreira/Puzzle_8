/**
 * 
 */
package com.ia.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

import com.ia.facade.Main;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author Anderson Soares, Jonatas Carneiro, Pedro Almir
 *
 */
public class FrameButton extends JFrame {
	private ControllerFrame controller;
	private JButton btnSeeTree;
	private JRadioButton rdbtnA;
	private JRadioButton rdbtnBreadth;
	private JRadioButton rdbtnDeapth;
	private JLabel labelStepsTest;
	private JLabel labelTimeTest;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public FrameButton(ControllerFrame controller) {
		this.controller = controller;
		getContentPane().setBackground(Color.WHITE);
		setSize(200, 350);
		setLocation(500, 20);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panelButton = new JPanel();
		panelButton.setBackground(Color.WHITE);
		panelButton.setBounds(10, 11, 164, 288);
		getContentPane().add(panelButton);
		panelButton.setLayout(null);
		
		JLabel labelSlidePuzzle = new JLabel("Slide Puzzle");
		labelSlidePuzzle.setBounds(36, 5, 92, 20);
		labelSlidePuzzle.setFont(new Font("Cambria", Font.BOLD, 16));
		labelSlidePuzzle.setHorizontalAlignment(SwingConstants.CENTER);
		panelButton.add(labelSlidePuzzle);
		
		rdbtnA = new JRadioButton("A*");
		rdbtnA.setBackground(Color.WHITE);
		rdbtnA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				rdbtnBreadth.setSelected(false);
				rdbtnDeapth.setSelected(false);
				labelTimeTest.setText(" ");
				labelStepsTest.setText(" ");
				btnSeeTree.setVisible(false);
			}
		});
		rdbtnA.setFont(new Font("Cambria", Font.BOLD, 12));
		rdbtnA.setBounds(6, 32, 109, 23);
		panelButton.add(rdbtnA);
		
		rdbtnBreadth = new JRadioButton("Breadth");
		rdbtnBreadth.setBackground(Color.WHITE);
		rdbtnBreadth.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				rdbtnA.setSelected(false);
				rdbtnDeapth.setSelected(false);
				labelTimeTest.setText(" ");
				labelStepsTest.setText(" ");
				btnSeeTree.setVisible(false);
			}
		});
		rdbtnBreadth.setFont(new Font("Cambria", Font.BOLD, 12));
		rdbtnBreadth.setBounds(6, 58, 109, 23);
		panelButton.add(rdbtnBreadth);
		
		rdbtnDeapth = new JRadioButton("Depth");
		rdbtnDeapth.setBackground(Color.WHITE);
		rdbtnDeapth.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				rdbtnA.setSelected(false);
				rdbtnBreadth.setSelected(false);
				labelTimeTest.setText(" ");
				labelStepsTest.setText(" ");
				btnSeeTree.setVisible(false);
			}
		});
		rdbtnDeapth.setFont(new Font("Cambria", Font.BOLD, 12));
		rdbtnDeapth.setBounds(6, 84, 109, 23);
		panelButton.add(rdbtnDeapth);
		
		JButton btnShuffle = new JButton("Shuffle");
		btnShuffle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				labelTimeTest.setText(" ");
				labelStepsTest.setText(" ");
				btnSeeTree.setVisible(false);
				buttonShuffle();
			}
		});
		btnShuffle.setFont(new Font("Cambria", Font.BOLD, 12));
		btnShuffle.setBounds(6, 126, 89, 23);
		panelButton.add(btnShuffle);
		
		JButton btnRun = new JButton("Run");
		btnRun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				labelTimeTest.setText(" ");
				labelStepsTest.setText(" ");
				btnSeeTree.setVisible(true);
				buttonRun();
			}
		});
		btnRun.setFont(new Font("Cambria", Font.BOLD, 12));
		btnRun.setBounds(6, 160, 89, 23);
		panelButton.add(btnRun);
		
		btnSeeTree = new JButton("See tree");
		btnSeeTree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				labelTimeTest.setText(" ");
				labelStepsTest.setText(" ");
				seeTree();
			}
		});
		btnSeeTree.setFont(new Font("Cambria", Font.BOLD, 12));
		btnSeeTree.setBounds(6, 194, 89, 23);
		panelButton.add(btnSeeTree);
		btnSeeTree.setVisible(false);
		
		JLabel lblTime = new JLabel("Time:");
		lblTime.setFont(new Font("Cambria", Font.BOLD, 14));
		lblTime.setBounds(6, 228, 58, 14);
		panelButton.add(lblTime);
		
		labelTimeTest = new JLabel("");
		labelTimeTest.setBounds(74, 228, 80, 14);
		panelButton.add(labelTimeTest);
		
		JLabel labelSteps = new JLabel("Steps:");
		labelSteps.setFont(new Font("Cambria", Font.BOLD, 14));
		labelSteps.setBounds(6, 253, 46, 14);
		panelButton.add(labelSteps);
		
		labelStepsTest = new JLabel("");
		labelStepsTest.setBounds(74, 253, 80, 14);
		panelButton.add(labelStepsTest);
	}
	
	private void buttonShuffle(){
		controller.shuffleFramePuzzle();
	}
	
	private void buttonRun(){
		if((rdbtnA.isSelected() == true) && (rdbtnBreadth.isSelected() == false) && (rdbtnDeapth.isSelected() == false)){
			Main.runAStar();
		}else if((rdbtnA.isSelected() == false) && (rdbtnBreadth.isSelected() == true) && (rdbtnDeapth.isSelected() == false)){
			Main.runBreadth();
		}else if((rdbtnA.isSelected() == false) && (rdbtnBreadth.isSelected() == false) && (rdbtnDeapth.isSelected() == true)){
			Main.runDepth();
		}else{}
	}
	
	private void seeTree(){
		Main.seeTree();
	}
	
	public void setTimeTest(String t){
		labelTimeTest.setText(t);
	}
	
	public void setStepsTest(String t){
		labelStepsTest.setText(t);
	}
}
