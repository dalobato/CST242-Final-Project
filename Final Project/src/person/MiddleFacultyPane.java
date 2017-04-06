package person;

import javafx.geometry.Insets;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class MiddleFacultyPane {

    GridPane facultyPane = new GridPane();
    Label rankLbl;
    TextField rankField;
    Label salaryLbl;
    TextField salaryField;
    Label coursesTeachingLbl;
    TextField coursesTeachingField;

    public MiddleFacultyPane() {

        facultyPane.setPadding(new Insets(20, 20, 20, 20));
        facultyPane.setStyle("-fx-background-color: TOMATO;");
        facultyPane.setHgap(10);
        facultyPane.setVgap(10);


        rankLbl = new Label("Rank:");
        rankField = new TextField();
        salaryLbl = new Label("Salary:");
        salaryField = new TextField();
        coursesTeachingLbl = new Label("Courses Teaching:");
        coursesTeachingField = new TextField();


        facultyPane.add(rankLbl, 2, 10);
        facultyPane.add(rankField, 2, 11);
        facultyPane.add(salaryLbl, 2, 12);
        facultyPane.add(salaryField, 2, 13);
        facultyPane.add(coursesTeachingLbl, 2, 14);
        facultyPane.add(coursesTeachingField, 2, 15);

    }

    public GridPane returnFacPane() {
        return facultyPane;
    }


}