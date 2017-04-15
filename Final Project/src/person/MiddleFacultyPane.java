package person;

import javafx.geometry.Insets;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class MiddleFacultyPane {

    private GridPane facultyPane;
    private Label rankLbl;
    private TextField rankField;
    private Label salaryLbl;
    private TextField salaryField;
    private Label coursesTeachingLbl;
    private TextField coursesTeachingField;

    public MiddleFacultyPane() {

        facultyPane = new GridPane();
        facultyPane.setStyle("-fx-background-color: TOMATO;");
        facultyPane.setAlignment(Pos.CENTER);
        facultyPane.setPadding(new Insets(10, 20, 20, 20));
        facultyPane.setHgap(10);



        rankLbl = new Label("Rank:");
        rankField = new TextField();
        salaryLbl = new Label("Salary:");
        salaryField = new TextField();
        coursesTeachingLbl = new Label("Courses Teaching:");
        coursesTeachingField = new TextField();


        facultyPane.add(rankLbl, 0, 0);
        facultyPane.add(rankField, 0, 1);
        facultyPane.add(salaryLbl, 1, 0);
        facultyPane.add(salaryField, 1, 1);
        facultyPane.add(coursesTeachingLbl, 2, 0);
        facultyPane.add(coursesTeachingField, 2, 1);

    }

    public GridPane returnFacPane() {
        return facultyPane;
    }

    public void setFacultyPane(GridPane facultyPane){
        this.facultyPane = facultyPane;
    }

    public TextField getRankField() {
        return rankField;
    }

    public void setRankField(TextField rankField) {
        this.rankField = rankField;
    }

    public TextField getSalaryField() {
        return salaryField;
    }

    public void setSalaryField(TextField salaryField) {
        this.salaryField = salaryField;
    }

    public TextField getCoursesTeachingField() {
        return coursesTeachingField;
    }

    public void setCoursesTeachingField(TextField coursesTeachingField) {
        this.coursesTeachingField = coursesTeachingField;
    }

    public void clearFields(){
        rankField.clear();
        salaryField.clear();
        coursesTeachingField.clear();
    }

    public void setFields(Faculty f){
        rankField.setText(f.getRank());
        salaryField.setText(String.valueOf(f.getSalary()));
        for (String temp : f.getCoursesTeaching()) {
            coursesTeachingField.appendText(temp + ", ");
        }
    }
}