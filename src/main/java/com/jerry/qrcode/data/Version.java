package com.jerry.qrcode.data;

public interface Version {
	int getFormatVerInfoModules();
	int getModulesSide();
	int getRemainderBits();
	int getFunctionPatternModules();
	int getDataCapacityinCodeword();
	
	/**
	 * QR Code 2005 (the basis of this second edition of ISO/IEC 18004) is closely similar to QR Code Model 2
	 * and, in its QR Code format, differs only in the addition of the facility for symbols to appear in a mirror
	 * image orientation, for reflectance reversal (light symbols on dark backgrounds) and the option for
	 * specifying alternative character sets to the default.
	 * @see <a href="http://www.iso.org/iso/home/store/catalogue_tc/catalogue_detail.htm?csnumber=52815">http://www.iso.org</a> 
	 * @author IT-Service.Branson
	 *
	 */
	public enum VersionCode implements Version {
		//among V1 - V6, no information modules presented, 31 modules for format and version.
		V1((short)208), V2((short)359), V3((short)567), V4((short)807), V5((short)1079), V6((short)1383),
		
		V7((short)1568), V8((short)1936), V9((short)2336), V10((short)2768), V11((short)3232), V12((short)3728),
		V13((short)4256), V14((short)4651), V15((short)5243), V16((short)5867), V17((short)6523), V18((short)7211),
		V19((short)7931), V20((short)8683), V21((short)9252), V22((short)10068), V23((short)10916), V24((short)11796),
		V25((short)12708), V26((short)13652), V27((short)14628), V28((short)15371), V29((short)16411), V30((short)17483),
		V31((short)18587), V32((short)19723), V33((short)20891), V34((short)22091), V35((short)23008), V36((short)24272),
		V37((short)25568), V38((short)26896), V39((short)28256), V40((short)29648);
		
		private final short dataModules;
		
		VersionCode(short dataModules) {
			this.dataModules = dataModules;
		}
		
		public short getDataModules() {
			return dataModules;
		}
		
		@Override
		public int getModulesSide() {
			int ordinal = ordinal();
			
			return  (21 + ordinal * 4);
		}

		@Override
		public int getFormatVerInfoModules() {
			switch(ordinal()){
			case 0:
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
				return 31;
			default:
				return 67;
			}
		}

		@Override
		public int getRemainderBits() {
			return  getDataModules() % 8;
		}

		@Override
		public int getFunctionPatternModules() {
			return getModulesSide() * getModulesSide() - getDataModules() - getFormatVerInfoModules();
		}

		@Override
		public int getDataCapacityinCodeword() {
			return  getDataModules() / 8;
		}
	}
	
	/**
	 * The Micro QR Code format (also specified in this International Standard), is a variant of QR Code 2005
	 * with a reduced number of overhead modules and a restricted range of sizes, which enables small to
	 * moderate amounts of data to be represented in a small symbol, particularly suited to direct marking on
	 * parts and components, and to applications where the space available for the symbol is severely restricted
	 * @see <a href="http://www.iso.org/iso/home/store/catalogue_tc/catalogue_detail.htm?csnumber=52815">http://www.iso.org</a> 
	 * @author IT-Service.Branson
	 * 
	 */
	public enum MicroVersionCode implements Version {
		M1((short)36), M2((short)80), M3((short)132), M4((short)192);
		
		private final short dataModules;
		private final short formatVerInfoModules = 15;
		MicroVersionCode(short dataModules) {
			this.dataModules = dataModules;
		}
		
		public short getDataModules() {
			return dataModules;
		}
		
		@Override
		public int getModulesSide() {
			int ordinal = ordinal();
			
			return  (11 + ordinal * 2);
		}

		@Override
		public int getFormatVerInfoModules() {
			// TODO Auto-generated method stub
			return formatVerInfoModules;
		}

		@Override
		public int getRemainderBits() {
			return  getDataModules() % 4;
		}

		@Override
		public int getFunctionPatternModules() {
			return getModulesSide() * getModulesSide() - getDataModules() - getFormatVerInfoModules();
		}

		@Override
		public int getDataCapacityinCodeword() {
			int ordinal = ordinal();
			
			/*All codewords are 8 bits in length,
			 *except in versions M1 and M3 where the final data codeword is 4 bits in length
			 *p19. ISO/IEC 18004:2006(E)
			 */
			if(ordinal < 3)				//M1 - M3
				if(getDataModules() % 8 == 4) 
					return getDataModules() / 8 + 1;
			return  getDataModules() / 8;
		}
	}
}
