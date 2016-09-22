public class Matrix3x3flat {
	long m11,m12,m13,m21,m22,m23,m31,m32,m33; //row, then column
	public Matrix3x3flat(long[] input){//assuming inputs are going left to right columns, up to down rows
		this.m11 = input[0];
		this.m12 = input[1];
		this.m13 = input[2];
		this.m21 = input[3];
		this.m22 = input[4];
		this.m23 = input[5];
		this.m31 = input[6];
		this.m32 = input[7];
		this.m33 = input[8];	
	}
	public long determinant(){
		return (m11*m22*m33)+(m12*m23*m31)+(m13*m21*m32)-(m13*m22*m31)-(m12*m21*m33)-(m11*m23*m32);
	}
}

//Works Cited (used for 3x3 det formula)
//"Determinant." Wikipedia. Wikimedia Foundation, 14 Nov. 2013. 
//Web. 17 Nov. 2013. <http://en.wikipedia.org/wiki/Determinant>.