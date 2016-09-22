public class MatrixArrayFlat {
	long[] mValue;
	public MatrixArrayFlat(long [] input){//this method assumes n x n matrix
		this.mValue = new long[input.length];
		for (int i =0; i<=(input.length-1); i++){
			mValue[i]=input[i];
		}
	}
	public long determinant(){
		return calculate(convert2D(mValue));
	}
	public long[][] convert2D(long[] oneDArray){
		int counter=0;
		int n = (int)Math.sqrt(oneDArray.length);
		long[][] twoDMatrix = new long[n][n];
		for (int i =0; i<=((n)-1); i++){//nested for loop creates 2D array to represent matrix
			for (int j=0; j<=((n)-1);j++){
				twoDMatrix[i][j]=oneDArray[counter];
				counter++;
			}
		}
		return twoDMatrix;
	}
	
	public long calculate(long[][]matrix){
		int sum=0; 
	    int sign;
	    if(matrix.length==1){  //bottom case of recursion. size 1 matrix determinant is itself.
	      return(matrix[0][0]);
	    }
	    for(int i=0;i<matrix.length;i++){ //finds determinant using row-by-row expansion
	      long[][]shrinkMatrix= new long[matrix.length-1][matrix.length-1]; //creates smaller matrix- values not in same row, column
	      for(int a=1;a<matrix.length;a++){
	        for(int b=0;b<matrix.length;b++){
	          if(b<i){
	            shrinkMatrix[a-1][b]=matrix[a][b];
	          }
	          else if(b>i){
	            shrinkMatrix[a-1][b-1]=matrix[a][b];
	          }
	        }
	      }
	      if(i%2==0){ //sign changes based on i
	        sign=1;
	      }
	      else{
	        sign=-1;
	      }
	      sum+=sign*matrix[0][i]*(calculate(shrinkMatrix)); 
	    }
	    return(sum); //returns determinant value. once stack is finished, returns final determinant
	  }
}

//Works Cited (algorithm and code for recursive calculate method)
//"Matrix Determinant Calculator." Professor Java. Web. 17 Nov. 2013.
//<http://professorjava.weebly.com/matrix-determinant.html&gt>;.
