package AppPackage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class CSVReader {
	public static final String SEPARATOR=";";
	public static final String QUOTE="\"";
	public String[] enterName() {
		String name;
		String[] resultado = null;
		BufferedReader br = null;
		Main sendName = new Main();
		
		try {
	         
	         br =new BufferedReader(new FileReader("files/Libro1.csv"));
	         String line = br.readLine();
	         while (null!=line) {
	        	String [] fields = line.split(SEPARATOR);
	            /**System.out.println(Arrays.toString(fields));
	            **/
	            fields = removeTrailingQuotes(fields);
	            /**
	            System.out.println(Arrays.toString(fields));*/
	            line = br.readLine();
	            /**int x = 0;
	            System.out.println("Linea: "+fields.length);*/
	            sendName.printName(Arrays.deepToString(fields));
	            resultado = fields;
	            /**
	        	while (x<fields.length) {
		        	resultado = resultado.concat(fields[x]);
		        	sendName.printName(resultado);
		        	
		        	System.out.println(Arrays.toString(fields));
		        	System.out.println("Linea");
		        	x++;
		    
		        }
		        */
	   
	         }
	         
	        
	      } catch (Exception e) {
	         System.err.println("Error! "+e.getMessage());
	      } finally {
	         if (null!=br){
	            try {
	               br.close();
	            } catch (IOException e) {
	               System.err.println("Error closing file !! "+e.getMessage());
	            }
	         }
	}
		return resultado;
	}
   private static String[] removeTrailingQuotes(String[] fields) {
      String result[] = new String[fields.length];
      for (int i=0;i<result.length;i++){
         result[i] = fields[i].replaceAll("^"+QUOTE, "").replaceAll(QUOTE+"$", "");
      }
      return result;
   }
	}

/**
 
		Scanner sc = new Scanner(System.in);
		
		
	
		
		
		
		System.out.println("Enter your name");
		name = sc.nextLine();
		
		
		
 */
