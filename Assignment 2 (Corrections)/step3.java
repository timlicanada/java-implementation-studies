package se2s03;

public class BadCode {
    public static int f5(int x, int y, int z) {
    	int aa,bb,cc;
    	
    	aa = (38 * x) + (98 - y); 
        bb = (43 * z) + (x - 98);
        cc = (23 * y) + (y - x);
        
        return (aa + bb) + cc;//the 3 i assignments are (x * x) + 96, (y * y) + 96, and (z * z) + 96
    	//therefore, the i<=0 cases are unreachable, since all 3 i assignments receive positive values
        //there is also no longer any use for the i variable, so it has been removed
    }
}
