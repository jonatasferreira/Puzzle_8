/**
 * 
 */
package com.ia.core.model;

/**
 * This class represents the game pieces.
 * 
 * @author Anderson Soares, Jonatas Carneiro, Pedro Almir
 *
 */
public class Element {
	/**
	 * The number of the element
	 * If this number == 0 so this is the empty element
	 */
	private Integer number;
	/**
	 * Represents the position of number in game board
	 */
	private Integer position;
	/**
	 * Represents the line position of number in game board
	 * Value used for calculating the Manhattan distance
	 */
	private Integer line;
	/**
	 * Represents the column position of number in game board
	 * Value used for calculating the Manhattan distance
	 */
	private Integer column;
	
	/**
	 * @param number
	 * @param line
	 * @param column
	 */
	public Element(Integer number, Integer line, Integer column) {
		super();
		this.number = number;
		this.line = line;
		this.column = column;
		this.setPosition(line, column);
	}
	
	/**
	 * @param element
	 */
	public Element(Element element){
		this.number = element.number;
		this.line = element.line;
		this.column = element.column;
		this.position = element.getPosition();
	}
	
	/**
	 * @param line
	 * @param column
	 */
	public void setPosition(Integer line, Integer column){
		if(line == 0 && column == 0){
			this.position = 1;
		}else if(line == 0 && column == 1){
			this.position = 2;
		}else if(line == 0 && column == 2){
			this.position = 3;
		}else if(line == 1 && column == 0){
			this.position = 4;
		}else if(line == 1 && column == 1){
			this.position = 5;
		}else if(line == 1 && column == 2){
			this.position = 6;
		}else if(line == 2 && column == 0){
			this.position = 7;
		}else if(line == 2 && column == 1){
			this.position = 8;
		}else if(line == 2 && column == 2){
			this.position = 9;
		}
	}
	
	/**
	 * @return the number
	 */
	public Integer getNumber() {
		return number;
	}
	/**
	 * @param number the number to set
	 */
	public void setNumber(Integer number) {
		this.number = number;
	}
	/**
	 * @return the position
	 */
	public Integer getPosition() {
		return position;
	}
	/**
	 * @return the line
	 */
	public Integer getLine() {
		return line;
	}
	/**
	 * @param line the line to set
	 */
	public void setLine(Integer line) {
		this.line = line;
	}
	/**
	 * @return the column
	 */
	public Integer getColumn() {
		return column;
	}
	/**
	 * @param column the column to set
	 */
	public void setColumn(Integer column) {
		this.column = column;
	}
	
	/**
	 * Verify the correct position of element
	 * 
	 * @return true if is correct
	 * 
	 */
	public boolean isCorrectPosition(){
		if(number != null && number == position){
			return true;
		}else if(number == null && position == 9){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((column == null) ? 0 : column.hashCode());
		result = prime * result + ((line == null) ? 0 : line.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result
				+ ((position == null) ? 0 : position.hashCode());
		return result;
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Element other = (Element) obj;
		if (column == null) {
			if (other.column != null)
				return false;
		} else if (!column.equals(other.column))
			return false;
		if (line == null) {
			if (other.line != null)
				return false;
		} else if (!line.equals(other.line))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		return true;
	}
	
	@Override
	public String toString() { 
		return this.number + " [" + this.line + ", " + this.column + "] - Position: " + this.position;
	}
	
	
	
}
