package MyJavaFXApp;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class test extends Application {
    @Override
    public void start(Stage primaryStage) {
    	Button btn = new Button("Hello Wolrd");
    	btn.setOnAction(event -> System.out.println("Button Clicked"));
    	StackPane root = new StackPane();
    	root.getChildren().add(btn);
    	Scene scence = new Scene(root , 360 , 180);
    	primaryStage.setTitle("My app");
    	primaryStage.setScene(scence);
    	primaryStage.show();
    	
    }

    public static void main(String[] args) {
        launch(args);
    }
}
