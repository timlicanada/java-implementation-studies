//Tim Li - 1205961
//2S03 Assignment 1 - A2 Corrected Files
//October 16, 2013

package se2s03;

//Please note that I have completed the assignment 1 generator bonus.
//It is written in Java, and is in the same Zip file as this java program.
//To access, it is in a1Generator folder -> src folder -> a1Generator folder -> a1Generator.java

public class A2 {
    public int Rec(int n) {
        int a0 = 3, a1 = -2, an = 0 ;
        int x = 2, y = -1 ;
        
        if ( n == 0 ) return a0;
        if ( n == 1 ) return a1;
        
        for ( int i=2; i <= n; i++ ) {
            an= x * a0 + y * a1;
            a0 = a1;
            a1 = an;
        }
        return an;
    }
}