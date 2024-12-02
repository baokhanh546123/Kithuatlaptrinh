package MyJavaFXApp;
import javafx.application.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.event.Event;
public class ClickMe extends Application {
	Button btn;
	public static void main(String [] args) {
		System.out.print("JavaFx");
		launch(args); //Chay chuong trinh
		
	}
	public void start(Stage primaryStage) {
		btn = new Button(); // tao nut
		btn.setText("Bam vao day"); // tao noi dung
		btn.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				System.out.print("Heelo");
			}
		}); // tao dong 
		
		BorderPane pane = new BorderPane(); //Tao khung
		pane.setCenter(btn);//Them nut vao khung
		
		Scene scene = new Scene(pane , 380 , 190); // Tao khung hinh 
		primaryStage.setTitle("My App"); // Dat ten tieu de
		primaryStage.setScene(scene); // Khung hinh
		primaryStage.show(); //Show
		
	}
	public void buttonClick() {
		if (btn.getText() == "Bam vao day")
			btn.setText("Ban da kich vao toi ");
		
	}
}
