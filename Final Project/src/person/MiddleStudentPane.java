package person;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class MiddleStudentPane {

    GridPane studentPane = new GridPane();
    ListView<String> coursesTookList;
    ListView<String> coursesTakingList;
    TextArea coursesNeededArea;
    ListView<String> major;
    TextField creditsTakingField;
    TextField gpaField;
    Label coursesTookLbl;
    Label coursesTakingLbl;
    Label coursesNeededLbl;
    Label majorLbl;

    public MiddleStudentPane() {

        studentPane.setPadding(new Insets(20, 20, 20, 20));
        studentPane.setStyle("-fx-background-color: LIGHTBLUE;");
        studentPane.setHgap(10);
        studentPane.setVgap(10);
        coursesTookList = new ListView<String>();
        coursesTakingList = new ListView<String>();
        coursesNeededArea = new TextArea();
        major = new ListView<String>();
        creditsTakingField = new TextField("Enter credits taking here");
        gpaField = new TextField("Enter GPA here");

        coursesTookLbl = new Label("Courses Took:");
        coursesTookList.setPrefHeight(200);
        coursesTookList.setPrefWidth(200);
        coursesTookList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        coursesTookList.getItems().addAll("CST101", "ENG101", "MAT101", "HIS101", "BIO101", "CST141", "ENG141", "MAT141",
                "HIS141", "BIO141", "CST242", "ENG242", "MAT242", "HIS242", "BIO242");

        coursesTakingLbl = new Label("Courses Taking:");
        coursesTakingList.setPrefHeight(200);
        coursesTakingList.setPrefWidth(200);
        coursesTakingList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        coursesTakingList.getItems().addAll("CST101", "ENG101", "MAT101", "HIS101", "BIO101", "CST141", "ENG141", "MAT141",
                "HIS141", "BIO141", "CST242", "ENG242", "MAT242", "HIS242", "BIO242");

        coursesNeededLbl = new Label("Courses Needed:");
        coursesNeededArea.setPrefHeight(200);
        coursesNeededArea.setPrefWidth(200);
        //coursesNeededList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        //coursesNeededist.getItems().addAll("CST101", "ENG101", "MAT101", "HIS101", "BIO101", "CST141", "ENG141", "MAT141",
        //"HIS141", "BIO141", "CST242", "ENG242", "MAT242", "HIS242", "BIO242");


        majorLbl = new Label("Major:");
        major.setPrefHeight(200);
        major.setPrefWidth(200);
        major.getItems().addAll("Computer Science", "English", "Mathematics", "History", "Biology");




        studentPane.add(coursesTookLbl, 0, 0);
        studentPane.add(coursesTookList, 0, 1);
        studentPane.add(coursesTakingLbl, 1, 0);
        studentPane.add(coursesTakingList, 1, 1);
        studentPane.add(coursesNeededLbl, 0, 2);
        studentPane.add(coursesNeededArea, 0, 3);
        studentPane.add(majorLbl, 1, 2);
        studentPane.add(major, 1, 3);
        studentPane.add(creditsTakingField, 0, 4);
        studentPane.add(gpaField, 1, 4);



    }

    public GridPane returnStPane(){
        return studentPane;
    }

}