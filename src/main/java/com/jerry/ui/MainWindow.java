package com.jerry.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.jerry.qrcode.data.ECLevel;
import com.jerry.qrcode.data.ModuleMatrix;
import com.jerry.qrcode.data.ModuleMatrixFactory;
import com.jerry.qrcode.data.Version;
import com.jerry.qrcode.exception.NegativePetemeterException;
import com.jerry.util.SwingConsole;

public class MainWindow extends JPanel{
	ModuleMatrix matrix;
	static final int DrawingUnit = 5; 		//in px
	
	MainWindow() throws NegativePetemeterException {
		matrix = ModuleMatrixFactory.getMaxtrix(Version.VersionCode.V5, ECLevel.M);
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		byte[][] data = matrix.getData();
		for(int i = 0; i < matrix.getRow(); i++) 
			for(int j = 0; j < matrix.getColumn(); j++)
				if(data[i][j] == ModuleMatrixFactory.BLACKMODULE) {
					g.setColor(Color.BLACK);
					g.fillRect(i * DrawingUnit, j * DrawingUnit, DrawingUnit, DrawingUnit);	
				} else {
					g.setColor(Color.WHITE);
					g.fillRect(i * DrawingUnit, j * DrawingUnit, DrawingUnit, DrawingUnit);
				}			
	}

	public static void main(String[] args) throws NegativePetemeterException {
		JFrame f = new JFrame();
		MainWindow main = new MainWindow();
		f.getContentPane().add(main, BorderLayout.CENTER);
		SwingConsole.run(f, "Snake", 500, 500);
	}
}
