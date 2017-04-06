package person;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class PersonView extends Application {

    BodyBag theBag = new BodyBag(100);


    @Override
    public void start(Stage primaryStage) throws Exception {
        PersonPane personPane = new PersonPane();

        Scene scene = new Scene(personPane.returnPane(), 690, 800);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Persons");
        primaryStage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }


}