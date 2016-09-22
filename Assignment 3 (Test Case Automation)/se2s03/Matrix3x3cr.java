public class Matrix3x3cr {
	CR3x3Column column1 = new CR3x3Column();
	CR3x3Column column2 = new CR3x3Column();
	CR3x3Column column3 = new CR3x3Column();
	
	public Matrix3x3cr(long[]input){
		column1.setR1(input[0]);
		column1.setR2(input[3]);
		column1.setR3(input[6]);
		column2.setR1(input[1]);
		column2.setR2(input[4]);
		column2.setR3(input[7]);
		column3.setR1(input[2]);
		column3.setR2(input[5]);
		column3.setR3(input[8]);
	}
	public long determinant(){
		long m11 = column1.getR1();
		long m21 = column1.getR2();
		long m31 = column1.getR3();
		long m12 = column2.getR1();
		long m22 = column2.getR2();
		long m32 = column2.getR3();
		long m13 = column3.getR1();
		long m23 = column3.getR2();
		long m33 = column3.getR3();
		
		return (m11*m22*m33)+(m12*m23*m31)+(m13*m21*m32)-(m13*m22*m31)-(m12*m21*m33)-(m11*m23*m32);		

	}
}

//Works Cited (used for 3x3 det formula)
//"Determinant." Wikipedia. Wikimedia Foundation, 14 Nov. 2013. 
//Web. 17 Nov. 2013. <http://en.wikipedia.org/wiki/Determinant>.



