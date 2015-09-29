package com.jerry.qrcode.data;

import java.util.Arrays;

public class ModuleMatrix {
	static final int FUNCTIONAL = 1;
	static final int NONFUNCTIONAL = 1;
	byte[][] data;
	byte[][] flag;
	int row;
	int column;
	
	ModuleMatrix(final int row, final int column){
		this.row = row;
		this.column = column;
		
		data = new byte[row][column];
		flag = new byte[row][column];
		
		for(int i = 0; i < row; i++)
			for(int j = 0; j < column; j++) {
				flag[i][j] = NONFUNCTIONAL;
				
		}
	}
	
	public byte getData(final int row, final int column) {
		return data[row][column];
	}
	
	public byte[][] getData() {
		return data;
	}
	
	public void setFunctionData(final int row, final int column, byte data) {
		this.data[row][column] = data;
		flag[row][column] = FUNCTIONAL;
	}
	
	public void setData(final int row, final int column, byte data) {
		this.data[row][column] = data;
	}
	
	public boolean isFuntional(final int row, final int column) {
		if(flag[row][column] == FUNCTIONAL)
			return true;
		else
			return false;
	}
	/**
	 * @return the row
	 */
	public int getRow() {
		return row;
	}

	/**
	 * @param row the row to set
	 */
	public void setRow(int row) {
		this.row = row;
	}

	/**
	 * @return the column
	 */
	public int getColumn() {
		return column;
	}

	/**
	 * @param column the column to set
	 */
	public void setColumn(int column) {
		this.column = column;
	}

	@Override
	public String toString(){
		String str = "";
		for(int i = 0; i < data.length; i++){
			str += (Arrays.toString(data[i]) + "\n");
		}
		
		return str;
		
	}
	
}