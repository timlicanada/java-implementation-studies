public class MatrixArrayRC {
	long [][]mValues;// row, column
	public MatrixArrayRC(long [] input){//this method assumes n x n matrix
		int counter=0;
		int size = (int)Math.sqrt(input.length);
		this.mValues = new long[size][size];
		for (int i =0; i<=size-1; i++){//each row
			for (int j=0; j<=size-1; j++){//each column
				this.mValues[i][j]=input[counter];
				counter++;
			}
		}
	}	
	public long determinant(){
		return calculate(mValues);
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


