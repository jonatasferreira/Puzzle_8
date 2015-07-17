package com.ia.view;

/**
 * @author Anderson Soares, Jonatas Carneiro, Pedro Almir
 *
 */
public enum EnumPositionNumber {
	pos00(1), pos01(2), pos02(3),
	pos10(4), pos11(5), pos12(6),
	pos20(7), pos21(8), pos22(9);
	
	private int position;

	private EnumPositionNumber(int position) {
		this.position = position;
	}

	/**
	 * @return the position
	 */
	public int getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(int position) {
		this.position = position;
	}
	
	
	
	
}
