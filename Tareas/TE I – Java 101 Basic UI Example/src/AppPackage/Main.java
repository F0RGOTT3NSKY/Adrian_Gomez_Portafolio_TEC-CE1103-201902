package AppPackage;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;



public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		TableView tableView = new TableView();

        TableColumn<String, Person> column1 = new TableColumn<>("First Name");
        column1.setCellValueFactory(new PropertyValueFactory<>("firstName"));


        TableColumn<String, Person> column2 = new
        TableColumn<>("Last Name");
        column2.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        
        CSVReader callClass = new CSVReader();
       
        String [] GG = callClass.enterName();

        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);
        
        int x = 0;
        String res = "";
        String res2 = "";
        System.out.println("Checkpoint1 " +GG.length);
        while(x<GG.length) {
        	res = "";
        	res2= "";
        	if(x==GG.length) {
        		System.out.println("Checkpoint");
        		x++;	
        	}
        	else {
        		System.out.println("Checkpoint "+GG[x]);
        		res.concat("\"");
        		res.concat(GG[x]);
        		res.concat("\"");
        		res2.concat("\"");
        		res2.concat(GG[x+1]);
        		res2.concat("\"");
        		System.out.println("res: "+res+"res2: "+res2);
        		tableView.getItems().add(new Person(res,res2));
        		x = x+2;
        	}
        }
           

        VBox vbox = new VBox(tableView);

        Scene scene = new Scene(vbox);

        primaryStage.setScene(scene);

        primaryStage.show();
        
    }
	
	public static void main(String[] args) {
		CSVReader callClass = new CSVReader();
		callClass.enterName();
		
		launch (args);
		
	}
	public String printName(String recievedName) {
		System.out.println("You entered: "+ recievedName);
		return recievedName;
	}
	
public class Person {
	

	private String firstName = null;
	private String lastName = null;

	public Person() {
	}

	public Person(String firstName, String lastName) {
		this.firstName = firstName;
	    this.lastName = lastName;
	}

	public String getFirstName() {
	    return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
		}
	}

	
}
