package com.jerry.qrcode.service;

import com.jerry.qrcode.data.ModuleMatrix;

public class PlaceCodewords {
	public static ModuleMatrix place(byte[] codewords, final ModuleMatrix matrix){
		codewords = new byte[]{0x10, 0x28, (byte) 0x9e, 0x3d, 0x22, (byte) 0x81, 0x0, (byte) 0xec, 0x11
				,(byte) 0xec, 0x11, (byte) 0xec, 0x11, (byte) 0xec, 0x11, (byte) 0xec
				,(byte) 0x89, 0x73, (byte) 0x87, 0x7d, 0x73, (byte) 0x84, (byte) 0xbc, 0x79, 0x70, (byte) 0xa6
		};
		
		for(int i = 0; i < 8)
			
		return matrix;
		
	}
}
