package application;
	

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


@SuppressWarnings("unused")
public class Main extends Application {
	public static final String SEPARATOR=";";
	public static final String QUOTE="\"";
	public static int veces = 0;
	
	public static String CSVReader(int Num) {
		
		BufferedReader br = null;
		String Change = null;
		try {
	         br =new BufferedReader(new FileReader("files/Libro1.csv"));
	         String line = br.readLine();
	         int temp = 0;
	         while (null!=line && temp<=veces){
	 	         String [] fields = line.split(SEPARATOR);
	 	         /**System.out.println(fields[1]);
	 	         /**System.out.println(Arrays.toString(fields));*/
	 	            
	 	         fields = removeTrailingQuotes(fields);
	 	         /**System.out.println(Arrays.toString(fields));*/
	 	         String res = fields[Num]; 
	 	         String forward = res;
	 	         Change = forward;
	 	         veces++;
	 	         line = br.readLine();
	 	         temp++;    
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
		System.out.println(Change);
		return Change;
		
	}
	private static String[] removeTrailingQuotes(String[] fields) {
	      String result[] = new String[fields.length];
	      for (int i=0;i<result.length;i++){
	         result[i] = fields[i].replaceAll("^"+QUOTE,"").replaceAll(QUOTE+"$","");
	      }
	      return result;
	   }
    public static void main(String[] args) {
    	
        launch(args);
    }

    @SuppressWarnings("unchecked")
	@Override
    public void start(Stage primaryStage) {

        @SuppressWarnings("rawtypes")
		TableView tableView = new TableView();

        TableColumn<String, Person> column1 = new TableColumn<>("First Name");
        column1.setCellValueFactory(new PropertyValueFactory<>("firstName"));


        TableColumn<String, Person> column2 = new TableColumn<>("Last Name");
        column2.setCellValueFactory(new PropertyValueFactory<>("lastName"));


        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);
        
        
        String Nombre = CSVReader(0);
        String Segundo = CSVReader(1);
        
        
        
        tableView.getItems().add(new Person(Nombre, Segundo));
        String Nombre2 = CSVReader(0);
        String Segundo2 = CSVReader(1);
        tableView.getItems().add(new Person(Nombre2, Segundo2));

        VBox vbox = new VBox(tableView);

        Scene scene = new Scene(vbox);

        primaryStage.setScene(scene);

        primaryStage.show();
    }
}
