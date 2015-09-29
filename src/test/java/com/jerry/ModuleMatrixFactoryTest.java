package com.jerry;

import java.util.Arrays;

import com.jerry.qrcode.data.ECLevel;
import com.jerry.qrcode.data.ModuleMatrix;
import com.jerry.qrcode.data.ModuleMatrixFactory;
import com.jerry.qrcode.data.Version;
import com.jerry.qrcode.exception.NegativePetemeterException;

public class ModuleMatrixFactoryTest {

	public static void main(String[] args) throws NegativePetemeterException {
		// TODO Auto-generated method stub
		ModuleMatrix matrix = ModuleMatrixFactory.getMaxtrix(Version.VersionCode.V1, ECLevel.M);
		System.out.println(matrix);
	}

}
