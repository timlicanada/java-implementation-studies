public class Matrix3x3rc {
	RC3x3Row row1 = new RC3x3Row();
	RC3x3Row row2 = new RC3x3Row();
	RC3x3Row row3 = new RC3x3Row();
	public Matrix3x3rc(long[]input){
		row1.setC1(input[0]);
		row1.setC2(input[1]);
		row1.setC3(input[2]);
		row2.setC1(input[3]);
		row2.setC2(input[4]);
		row2.setC3(input[5]);
		row3.setC1(input[6]);
		row3.setC2(input[7]);
		row3.setC3(input[8]);
	}
	public long determinant(){
		long m11 = row1.getC1();
		long m12 = row1.getC2();
		long m13 = row1.getC3();
		long m21 = row2.getC1();
		long m22 = row2.getC2();
		long m23 = row2.getC3();
		long m31 = row3.getC1();
		long m32 = row3.getC2();
		long m33 = row3.getC3();
		
		return (m11*m22*m33)+(m12*m23*m31)+(m13*m21*m32)-(m13*m22*m31)-(m12*m21*m33)-(m11*m23*m32);		
	}
}

//Works Cited (used for 3x3 det formula)
//"Determinant." Wikipedia. Wikimedia Foundation, 14 Nov. 2013. 
//Web. 17 Nov. 2013. <http://en.wikipedia.org/wiki/Determinant>.



