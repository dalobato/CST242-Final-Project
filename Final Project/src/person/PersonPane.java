package person;


import java.util.ArrayList;
import java.util.Arrays;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sun.font.CreatedFontTracker;

public class PersonPane {

    private GridPane personPane;
    private TopPersonPane topPane;
    private MiddleStudentPane middleStudentPane;
    private MiddleFacultyPane middleFacultyPane;
    private BottomButtonsPane bottomButtonsPane;


    public PersonPane() {

        personPane = new GridPane();
        topPane = new TopPersonPane();
        middleStudentPane = new MiddleStudentPane();
        middleFacultyPane = new MiddleFacultyPane();
        bottomButtonsPane = new BottomButtonsPane();



        personPane.setAlignment(Pos.CENTER);
        personPane.setPadding(new Insets(20));

        personPane.add(topPane.returnTopPane(), 0, 0);
        personPane.add(middleStudentPane.returnStPane(), 0, 1);
        personPane.add(middleFacultyPane.returnFacPane(), 0, 2);
        personPane.add(bottomButtonsPane.returnButtonsPane(), 0, 3);


    }

    public GridPane getPersonPane() {
        return personPane;
    }

    public TopPersonPane getTopPane() {
        return topPane;
    }

    public MiddleStudentPane getMiddleStudentPane() {
        return middleStudentPane;
    }

    public MiddleFacultyPane getMiddleFacultyPane() {
        return middleFacultyPane;
    }

    public BottomButtonsPane getBottomButtonsPane() {
        return bottomButtonsPane;
    }
}