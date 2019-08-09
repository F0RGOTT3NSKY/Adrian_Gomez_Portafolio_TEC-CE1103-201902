package application;
	

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
	public static final String SEPARATOR=";";
	public static final String QUOTE="\"";

    public static void main(String[] args) {    	
        launch(args);
    }

    @SuppressWarnings("unchecked")
	@Override
    public void start(Stage primaryStage) throws FileNotFoundException,ArrayIndexOutOfBoundsException,FileNotFoundException {
        @SuppressWarnings("rawtypes")
		TableView tableView = new TableView();
        TableColumn<String, Person> column1 = new TableColumn<>("First Name");
        column1.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        TableColumn<String, Person> column2 = new TableColumn<>("Last Name");
        column2.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);
        
        BufferedReader br = null;
		try {
	         br =new BufferedReader(new FileReader("files/Libro1.csv"));
	         String line = br.readLine();
	         while (null!=line){
	 	         String [] fields = line.split(SEPARATOR);
	 	         System.out.println(Arrays.toString(fields));
	 	            
	 	         fields = removeTrailingQuotes(fields);
	 	         String Nombre = fields[0];
	 	         String Segundo = fields[1];
	 	         try {
	 	        	 int ExcesoColumnas = fields.length;
	 	        	 if (ExcesoColumnas==2) {
	 	        		 @SuppressWarnings("unused")
						Object nulo = null;
	 	        	 }
	 	        	 else {
	 	        		 System.out.println(fields[ExcesoColumnas]);	 	        
	 	        	 }
	 	         }catch(ArrayIndexOutOfBoundsException f) {
	 	        	 System.err.println("ERROR el archivo tiene mas columnas de las permitidas asi que no se mostrarán los datos fuera de lo permitido!");
	 	        	 JOptionPane.showMessageDialog(null, "El archivo tiene mas columnas de las permitidas asi que no se mostrarán los datos fuera de lo permitido!", "ERROR", JOptionPane.ERROR_MESSAGE); 
	 	         }
	 	         tableView.getItems().add(new Person(Nombre, Segundo));
	 	         System.out.println(Arrays.toString(fields));
	 	         line = br.readLine();   
	         }
		  } catch (ArrayIndexOutOfBoundsException t) {
			 System.err.println("ERROR el archivo tiene Filas en blanco!");
			 JOptionPane.showMessageDialog(null, "El archivo tiene Filas en blanco!", "ERROR", JOptionPane.ERROR_MESSAGE);
		  } catch (FileNotFoundException r) {
			 System.err.println("Error! "+r.getMessage());
			 JOptionPane.showMessageDialog(null, "The system cannot find the file specified!", "ERROR", JOptionPane.ERROR_MESSAGE); 
			 
		  } catch (Exception e) {
	         System.err.println("Error inesperado! "+e.getMessage());
	         
	      } finally {
	         if (null!=br){
	            try {
	               br.close();
	            } catch (IOException e) {
	               System.err.println("Error closing file !! "+e.getMessage());
	            }
	         }
	      }
        VBox vbox = new VBox(tableView);
        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private static String[] removeTrailingQuotes(String[] fields) {
	      String result[] = new String[fields.length];
	      for (int i=0;i<result.length;i++){
	         result[i] = fields[i].replaceAll("^"+QUOTE,"").replaceAll(QUOTE+"$","");
	      }
	      return result;
	   }
}
