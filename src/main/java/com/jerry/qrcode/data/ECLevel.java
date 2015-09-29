package com.jerry.qrcode.data;

public enum ECLevel {
	L("7%"), M("15%"), Q("25%"), H("30%");
	String recoveryRate;
	private ECLevel(String recoveryRate) {
		this.recoveryRate = recoveryRate;
	}
	public String toString() {
		return "This Level of Error Correction Allowing recovery of " + recoveryRate;
	}
	
}
