//Tim Li - 1205961
//2S03 Assignment 1 Bonus - Number Generator
//October 16, 2013

package a1Generator;

import java.io.*;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

//IMPORTANT:
//This program assumes the list of student numbers is separated BY LINE, and that
//the STUDENT ID NUMBER FILE is in the SAME FOLDER as this java file.
//
//Please note that there is a sample ID number file called "SampleIds.txt" ready 
//for use in the same folder, with 5 student numbers.

public class a1Generator {
	public static void main (String args[ ]) throws IOException{
		List<Integer> IDList = new ArrayList<>();
		String target,folderTarget;
		a1Generator key = new a1Generator ();
		int[] A1ReturnValues = new int[8];
		int[] A1BreakValues = new int[7];
		int[] A2InitValues = new int[4]; //this includes a0, a1, x, y in A2
		
		System.out.println("Welcome to McMaster 2S03 Assignment 1 Generator, by Tim Li (1205961)");
		while(true){
		IDList = key.getIDList();//get list of student IDs
		if(IDList==null){//if getIDList method returns null, it's the exit condition
			break;
		}
			while(true){
				System.out.println("\n\n"+IDList.size()+" student IDs located.");
				try{
					target = key.getTarget();
					for (int count=0; count<= (IDList.size()-1);count++){
						folderTarget = target+"/"+IDList.get(count);
						new File(folderTarget).mkdir();//create folder for one student ID
						folderTarget = folderTarget+"/se2s03";
						new File(folderTarget).mkdir();//create folder for A1 and A2 called se2s03
						
						//next 3 lines are for randomizing A1 return and break point vales along with A2 initial values
						A1ReturnValues = key.getRandValues(8,1,20);//parameters are size, min, max
						A1BreakValues = key.getRandValues(7,-20,20);
						A2InitValues = key.getRandValues(4,-10,10);
						
						//next few lines create java files for A1, A2, A1Test and A2Test
						File A1 = new File(folderTarget+"/A1.java");//create file in folder
						PrintWriter A1Output = new PrintWriter(new FileWriter(folderTarget+"/A1.java"));//create a instance of PrintWriter object
						key.setA1Output(A1Output, A1ReturnValues, A1BreakValues);//use PrintWriter and relevant values to write in file
						
						File A2 = new File(folderTarget+"/A2.java");
						PrintWriter A2Output = new PrintWriter(new FileWriter(folderTarget+"/A2.java"));
						key.setA2Output(A2Output,A2InitValues);
						
						File A1Test = new File(target+"/"+IDList.get(count)+"/A1Test.java");
						PrintWriter A1TOutput = new PrintWriter(new FileWriter(target+"/"+IDList.get(count)+"/A1Test.java"));
						key.setA1TestOutput(A1TOutput, A1ReturnValues, A1BreakValues);
						
						File A2Test = new File(target+"/"+IDList.get(count)+"/A2Test.java");
						PrintWriter A2TOutput = new PrintWriter(new FileWriter(target+"/"+IDList.get(count)+"/A2Test.java"));
						key.setA2TestOutput(A2TOutput, A2InitValues);
					}					
					System.out.println("The files have been successfully generated in directory "+target);
					System.out.println("");
					break;
				}
				catch(FileNotFoundException e){
					System.out.println("Directory not found. Please try again.");
				}
			}			
		}
		System.out.println("Thank you for using this program. Have a great day/evening!");
	}
	
	public List<Integer> getIDList()throws IOException{
		String line;
		String fileName = ""; //name of text file with student numbers
		String attempt="";//a variable for while try catch construct
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please enter the name of the text file containing student numbers.");
		System.out.println("\tNote: type 'SampleIDs.txt' to see an example,type 'x' to terminate this program.");
		while(true){
			try{//attempt String variable stores input representing student number list location, and tries to access data
				attempt = br.readLine();
				if (attempt.equals("x")){//'x' is input indicating an exit
					break;
				}
				BufferedReader brAttempt = new BufferedReader(new FileReader(attempt));
				break;
			}
			catch (FileNotFoundException e){
				System.out.println("File not found, please try again.");
				System.out.println("Note: type 'SampleIDs.txt' to see an example.");
			}
		}
		if (attempt.equals("x")){
			return null;
		}
		else{
			fileName = attempt;//at this point, it is confirmed data can be accessed
			BufferedReader input = new BufferedReader(new FileReader(fileName));		
			List<Integer> IDList = new ArrayList<>();
			line = input.readLine(); //reads ONE line
			while (line !=null){//data is added to IDList integer list
				IDList.add(Integer.parseInt(line));
				line = input.readLine();
			}
			return IDList;
		}
	}
	
	public String getTarget()throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please enter the output location for all the directories.");
		System.out.println("Eg. \"D:/School Files\" is the correct format.");
		return br.readLine();	
	}
	
	public int[] getRandValues(int size, int min, int max){//method randomizes integers, stores them in an array, and returns the array
		int[] randValues = new int[size];//size parameter implemented here
		List<Integer> checkUnique = new ArrayList<>();//this array stores all previous output that is unique
		boolean checkUniqueVal;

		//next block is for randomizing break values
		randValues[0]= min+(int)(Math.random()*((max-min)+1));//randomizes one number between a min and max range
		checkUnique.add(randValues[0]);
		for (int i=1; i<=(size-1); i++){			
			do{// a double-check that the number is unique
				checkUniqueVal=false;
				randValues[i]= min+(int)(Math.random()*((max-min)+1));
				for (int j=0; j<=checkUnique.size()-1; j++){
					if (checkUnique.get(j)==randValues[i]){
						checkUniqueVal = true;
					}
				}		
			}while(checkUniqueVal);//number will be regenerated if not unique
			checkUnique.add(randValues[i]);
		}	
		return randValues;
	}
	//the next 4 methods write via PrintWriter object, and uses the format of the given java Assignment files and takes the integer arrays of randomly generated numbers
	public void setA1Output(PrintWriter outputA1, int[] returnValues, int[] breakValues){	
		outputA1.println("package se2s03;\n");
		outputA1.println("public class A1 {");
		outputA1.println("\tpublic int cases(int v, int u, int w) {");
		outputA1.println("\t\tif (v <= "+breakValues[0]+"){");
		outputA1.println("\t\t\tif (u <= "+breakValues[1]+"){");
		outputA1.println("\t\t\t\tif (w <= "+breakValues[2]+"){");
		outputA1.println("\t\t\t\t\treturn "+returnValues[0]+";");
		outputA1.println("\t\t\t\t}else{");
		outputA1.println("\t\t\t\t\treturn "+returnValues[1]+";");
		outputA1.println("\t\t\t\t}");
		outputA1.println("\t\t\t}else{");
		outputA1.println("\t\t\t\tif (w <= "+breakValues[3]+"){");
		outputA1.println("\t\t\t\t\treturn "+returnValues[2]+";");
		outputA1.println("\t\t\t\t}else{");
		outputA1.println("\t\t\t\t\treturn "+returnValues[3]+";");
		outputA1.println("\t\t\t\t}");
		outputA1.println("\t\t\t}");
		outputA1.println("\t\t}else{");
		outputA1.println("\t\t\tif (u <= "+breakValues[4]+"){");
		outputA1.println("\t\t\t\tif (w <= "+breakValues[5]+"){");
		outputA1.println("\t\t\t\t\treturn "+returnValues[4]+";");
		outputA1.println("\t\t\t\t}else{");
		outputA1.println("\t\t\t\t\treturn "+returnValues[5]+";");
		outputA1.println("\t\t\t\t}");
		outputA1.println("\t\t\t}else{");
		outputA1.println("\t\t\t\tif (w <= "+breakValues[6]+"){");
		outputA1.println("\t\t\t\t\treturn "+returnValues[6]+";");
		outputA1.println("\t\t\t\t}else{");
		outputA1.println("\t\t\t\t\treturn "+returnValues[7]+";");
		outputA1.println("\t\t\t\t}");
		outputA1.println("\t\t\t}");
		outputA1.println("\t\t}");	
		outputA1.println("\t}");
		outputA1.println("}");
		outputA1.close();
	}
	
	public void setA2Output(PrintWriter outputA2, int[] A2InitValues){
		outputA2.println("package se2s03;\n");
		outputA2.println("public class A2 {");
		outputA2.println("\tpublic int Rec(int n){");
		outputA2.println("\t\tint a0 = "+A2InitValues[0]+", a1 = "+A2InitValues[1]+", an = 0;");
		outputA2.println("\t\tint x = "+A2InitValues[2]+", y = "+A2InitValues[3]+";");
		outputA2.println("");
		outputA2.println("\t\tif (n == 0) return a0;");
		outputA2.println("\t\tif (n == 1) return a1;");
		outputA2.println("");
		outputA2.println("\t\tfor (int i=2; i <= n; i++){");
		outputA2.println("\t\t\tan = x * a0 + y * a1");
		outputA2.println("\t\t\ta0 = a1;");
		outputA2.println("\t\t\ta1 = an");
		outputA2.println("\t\t}");
		outputA2.println("\t\treturn an;");
		outputA2.println("\t\t}");
		outputA2.println("}");
		outputA2.close();
	}
	
	public void setA1TestOutput(PrintWriter outputTestA1, int[]returnValues, int[] breakValues){
		int testCaseNum = 72;
		int min = -30;
		int max = 30;	//min and max values for test case variables
		int u, v, w, randReturn; //3 variables to contain random numbers later, along with the case result
		outputTestA1.println("import static org.junit.Assert.*");
		outputTestA1.println("");
		outputTestA1.println("import org.junit.BeforeClass;");
		outputTestA1.println("import org.junit.Test;");
		outputTestA1.println("");
		outputTestA1.println("import se2s03.A1;");
		outputTestA1.println("");
		outputTestA1.println("public class A1Test {");
		outputTestA1.println("");
		outputTestA1.println("\tprivate static A1 tester;");
		outputTestA1.println("");
		outputTestA1.println("\t@BeforeClass");
		outputTestA1.println("\tpublic static void setUp(){");
		outputTestA1.println("\t\ttester = new A1();");
		outputTestA1.println("\t}");
		outputTestA1.println("");
		outputTestA1.println("\t@Test");
		outputTestA1.println("\tpublic void casesTest(){");
		for (int i =0; i<testCaseNum; i++){
			v = min+(int)(Math.random()*((max-min)+1));
			u = min+(int)(Math.random()*((max-min)+1));
			w = min+(int)(Math.random()*((max-min)+1));
			//the following section runs the randomized values into the solution, and gets a return value
	        if (v <= breakValues[0]){
	        	if (u <= breakValues[1]){
	        		if (w <= breakValues[2]){
	        			randReturn = returnValues[0];
	        		}else{
	        			randReturn = returnValues[1];
	        		}
	        	}else{
	        		if (w <= breakValues[3]){
	        			randReturn = returnValues[2];
	        		}else{
	        			randReturn = returnValues[3];
	        		}
	        	}
	        } else{
	         	if (w<=breakValues[4]){
	        		if (u <= breakValues[5]){
	        			randReturn = returnValues[4];
	        		}else{
	        			randReturn = returnValues[5];
	        		}
	        	}else{
	        		if (u <= breakValues[6]){
	        			randReturn = returnValues[6];
	        		}else{
	        			randReturn = returnValues[7];
	        		}
	        	}
	        }
	        outputTestA1.println("\t\tassertEquals(\"cases("+v+","+u+","+w+") must be "+randReturn+"\","+" "+randReturn+", tester.cases("+v+","+u+","+w+"));");
		}
		outputTestA1.close();
	}
	
	public void setA2TestOutput(PrintWriter outputTestA2, int[] initValues){
		int testCaseNum = 31;
		int n;
        int a0 = initValues[0], a1 = initValues[1], an = 0;
        int x = initValues[2], y = initValues[3] ;	//vars for TDD case generation
		outputTestA2.println("import static org.junit.Assert.*;");
		outputTestA2.println("");
		outputTestA2.println("import org.junit.BeforeClass;");
		outputTestA2.println("import org.junit.Test;");
		outputTestA2.println("");
		outputTestA2.println("import se2s03.A2;");
		outputTestA2.println("");
		outputTestA2.println("public class A2Test {");
		outputTestA2.println("\tprivate static A2 tester;");
		outputTestA2.println("");
		outputTestA2.println("\t@BeforeClass");
		outputTestA2.println("\tpublic static void setUp(){");
		outputTestA2.println("\t\ttester = new A2();");
		outputTestA2.println("\t}");
		outputTestA2.println("");
		outputTestA2.println("\t@Test");
		outputTestA2.println("\tpublic void RecTest() {");
		for (int i =0; i<testCaseNum; i++){
			n = i;//n increases with the for loop counter that generates the test cases
        
	        //the solution below has been modified for this method, since test cases do not use return
	        if ( n == 0 ){
	        	n= a0;
	        }
	        else if ( n == 1 ){
	        	n= a1;
	        }
	        else{
		        for ( int j=2; j <= n; j++ ) {
		            an= x * a0 + y * a1;
		            a0 = a1;
		            a1 = an;
		        }
	        n = an;
	        }
	        outputTestA2.println("\t\tassertEquals(\"Rec("+i+") must be "+n+"\","+" "+n+", tester.Rec("+i+"));");
		}
		outputTestA2.close();
	}	
}