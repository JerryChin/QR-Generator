package com.jerry;

import com.jerry.qrcode.data.Version;
import com.jerry.qrcode.exception.NegativePetemeterException;

public class VersionTest {
	public static void main(String[] args) throws NegativePetemeterException {
		for(Version v : Version.MicroVersionCode.values()) {
			System.out.println(v.getModulesSide());
		}
	}
}
