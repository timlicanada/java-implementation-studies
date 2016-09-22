//Tim Li - 1205961
//2S03 Assignment 1 - A1 Corrected File
//October 16, 2013

package se2s03;

//Please note that I have completed the assignment 1 generator bonus.
//It is written in Java, and is in the same Zip file as this java program.
//To access, it is in a1Generator folder -> src folder -> a1Generator folder -> a1Generator.java

public class A1 {
    public int cases(int v, int u, int w) {
        if (v <= 3){
        	if (u <= -5){
        		if (w <= 12){
        			return 7;
        		}else{
        			return 9;
        		}
        	}else{
        		if (w <= 4){
        			return 10;
        		}else{
        			return 1;
        		}
        	}
        } else{
         	if (w<=2){
        		if (u <= 9){
        			return 6;
        		}else{
        			return 3;
        		}
        	}else{
        		if (u <= -6){
        			return 5;
        		}else{
        			return 2;
        		}
        	}
        } 	
    } 
}


