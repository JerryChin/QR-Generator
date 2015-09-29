package com.jerry.qrcode.data;

import com.jerry.qrcode.exception.NegativePetemeterException;

public class ModuleMatrixFactory {
	public static final byte BLACKMODULE = 1;
	public static final byte WHITEMODULE = 0;
	
	public static final byte VERTICAL = 1;
	public static final byte HORIZONTAL = 0;
	public static ModuleMatrix getMaxtrix(final Version version, final ECLevel m) throws NegativePetemeterException {
		
		ModuleMatrix matrix = new ModuleMatrix(version.getModulesSide(), version.getModulesSide());

		//Adding Function Patterns
		//1. Finder pattern
		setupFinder(0, 0, matrix);
		setupFinder(0, version.getModulesSide()-7, matrix);
		setupFinder(version.getModulesSide()-7, 0, matrix);
		
		//2. Separator pattern
		//2.1 upper left
		drawLine(0, 8, 7, VERTICAL, matrix, WHITEMODULE);
		drawLine(0, 8, 7, HORIZONTAL, matrix, WHITEMODULE);
		
		//2.2 upper right
		drawLine(0, 8, version.getModulesSide() - 8, VERTICAL, matrix, WHITEMODULE);
		drawLine(version.getModulesSide() - 8, version.getModulesSide(), 7, HORIZONTAL, matrix, WHITEMODULE);
		
		//2.3 lower left
		drawLine(version.getModulesSide() - 8, version.getModulesSide(), 7, VERTICAL, matrix, WHITEMODULE);
		drawLine(0, 8, version.getModulesSide() - 8, HORIZONTAL, matrix, WHITEMODULE);
		
		//3. timing pattern
		setupTimingPattern(version.getModulesSide(), matrix);
		
		//3. Alignment patterns are present only in QR Code symbols of version 2 or large
		
		 
		return matrix;
	}
	
	//x and y are the coordinate of the finder pattern's upper-left corner to be set up.
	private static ModuleMatrix setupFinder(int x, int y, final ModuleMatrix matrix) throws NegativePetemeterException {
		if(matrix == null)
			throw new NullPointerException();
		if(x < 0 || y < 0)
			throw new NegativePetemeterException();
		
		for(int i = 0; i < 7; i++) {
			for(int j = 0; j < 7; j++) {
				matrix.setFunctionData(i + x, j + y, BLACKMODULE);
			}
		}
		
		for(int i = 1; i < 6; i++) {
			matrix.setFunctionData(x + 1, y + i, WHITEMODULE);
			matrix.setFunctionData(x + i, y + 1, WHITEMODULE);
			matrix.setFunctionData(x + 5, y + i, WHITEMODULE);
			matrix.setFunctionData(x + i, y + 5, WHITEMODULE);
		}
		
		return matrix;
	}
	
	private static ModuleMatrix drawLine(final int from, final int to, final int alignment, final int Direction,
			final ModuleMatrix matrix, final byte color) {
			if(Direction == VERTICAL) {
				for(int i = from; i < to; i++) {
					matrix.setFunctionData(i, alignment, color);
				}
			} else {
				for(int i = from; i < to; i++) {
					matrix.setFunctionData(alignment, i, color);
				}
			}
		return matrix;
	}
	
	private static ModuleMatrix setupTimingPattern(final int modulesSide, final ModuleMatrix matrix) {
		int length = modulesSide - 16;
		for(int i = 0; i < length; i++) {
			if(i % 2 == 0) {
				matrix.setFunctionData(i + 8, 6, BLACKMODULE);
				matrix.setFunctionData(6, i + 8, BLACKMODULE);
			} else {
				matrix.setFunctionData(i + 8, 6, WHITEMODULE);
				matrix.setFunctionData(6, i + 8, WHITEMODULE);
			}
		}
		
		return matrix;
	}
}