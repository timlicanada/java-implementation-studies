package se2s03;

public class BadCode {
    public static int f5(int x, int y, int z) {
    	int i,aa,bb,cc; 
    	
        i = (x * x) + 96;
        aa = (38 * x) + (98 - y);
        if (i <=0){//all while loops are now in if-then-else construct
        	bb = (z * y) - 38;
        }else{//do nothing
        }
        
        i = (y * y) + 96;
        bb = (43 * z) + (x - 98);
        if(i<=0){
        	cc = (x * x) * z;
        }else{//do nothing       	
        }
        
        i = (z * z) + 96;
        cc = (23 * y) + (y - x);    
        if(i<=0){
        	aa = z - 43;
        }else{//do nothing    	
        }
   
        return (aa + bb) + cc;
    }
}
