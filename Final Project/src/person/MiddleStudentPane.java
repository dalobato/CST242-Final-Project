package person;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class MiddleStudentPane {

    private GridPane studentPane;
    private ListView<String> coursesTookList;
    private ListView<String> coursesTakingList;
    private TextArea coursesNeededArea;
    private ListView<String> major;
    private TextField creditsTakingField;
    private TextField gpaField;
    private Label coursesTookLbl;
    private Label coursesTakingLbl;
    private Label coursesNeededLbl;
    private Label majorLbl;

    public MiddleStudentPane() {

        studentPane = new GridPane();
        studentPane.setAlignment(Pos.CENTER);
        studentPane.setVgap(10);

        studentPane.setPadding(new Insets(10, 20, 20, 20));
        studentPane.setStyle("-fx-background-color: LIGHTBLUE;");

        coursesTookList = new ListView<String>();
        coursesTakingList = new ListView<String>();
        coursesNeededArea = new TextArea();
        major = new ListView<String>();
        creditsTakingField = new TextField("Enter credits taking here");
        gpaField = new TextField("Enter GPA here");

        coursesTookLbl = new Label("Courses Took:");
        coursesTookList.setPrefWidth(200);
        coursesTookList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        coursesTookList.getItems().addAll("CST101", "ENG101", "MAT101", "HIS101", "BIO101", "CST141", "ENG141", "MAT141",
                "HIS141", "BIO141", "CST242", "ENG242", "MAT242", "HIS242", "BIO242");

        coursesTakingLbl = new Label("Courses Taking:");
        coursesTakingList.setPrefWidth(200);
        coursesTakingList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        coursesTakingList.getItems().addAll("CST101", "ENG101", "MAT101", "HIS101", "BIO101", "CST141", "ENG141", "MAT141",
                "HIS141", "BIO141", "CST242", "ENG242", "MAT242", "HIS242", "BIO242");

        coursesNeededLbl = new Label("Courses Needed:");
        coursesNeededArea.setPrefWidth(200);



        majorLbl = new Label("Major:");
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

    public void setStudentPane(GridPane studentPane){
        this.studentPane = studentPane;
    }

    public ListView<String> getCoursesTookList() {
        return coursesTookList;
    }

    public void setCoursesTookList(ListView<String> coursesTookList) {
        this.coursesTookList = coursesTookList;
    }

    public ListView<String> getCoursesTakingList() {
        return coursesTakingList;
    }

    public void setCoursesTakingList(ListView<String> coursesTakingList) {
        this.coursesTakingList = coursesTakingList;
    }

    public TextArea getCoursesNeededArea() {
        return coursesNeededArea;
    }

    public void setCoursesNeededArea(TextArea coursesNeededArea) {
        this.coursesNeededArea = coursesNeededArea;
    }

    public ListView<String> getMajor() {
        return major;
    }

    public void setMajor(ListView<String> major) {
        this.major = major;
    }

    public TextField getCreditsTakingField() {
        return creditsTakingField;
    }

    public void setCreditsTakingField(TextField creditsTakingField) {
        this.creditsTakingField = creditsTakingField;
    }

    public TextField getGpaField() {
        return gpaField;
    }

    public void setGpaField(TextField gpaField) {
        this.gpaField = gpaField;
    }

    public void clearFields(){
        coursesTookList.getSelectionModel().clearSelection();
        coursesTakingList.getSelectionModel().clearSelection();
        coursesNeededArea.clear();
        major.getSelectionModel().clearSelection();
        creditsTakingField.setText("Enter credits taking here");
        gpaField.setText("Enter GPA here");
    }

    public void setFields(Student s){
        for (String temp : s.getCoursesTook()) {
            coursesTookList.getSelectionModel().select(temp);
        }
        for (String temp : s.getCoursesTaking()) {
            coursesTakingList.getSelectionModel().select(temp);
        }
        for (String temp : s.getCoursesNeeded()) {
            coursesNeededArea.appendText(temp + ", ");
        }
        major.getSelectionModel().select(s.getMajor());
        creditsTakingField.setText(String.valueOf(s.getCreditsTaking()));
        gpaField.setText(String.valueOf(s.getGpa()));
    }
}