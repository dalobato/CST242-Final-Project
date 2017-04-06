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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PersonPane extends PersonView {


    Faculty chen;
    Student me;
    VBox personPane = new VBox(20);
    TopPersonPane topPersonPane = new TopPersonPane();
    HBox middlePane = new HBox(20);
    MiddleStudentPane middleStudentPane = new MiddleStudentPane();
    MiddleFacultyPane middleFacultyPane = new MiddleFacultyPane();
    BottomButtonsPane bottomButtonsPane = new BottomButtonsPane();

    public PersonPane() {

        bottomButtonsPane.insertBtn.setOnAction((ActionEvent e) -> {
            Stage typeStage = new Stage();
            typeStage.setTitle("New");
            HBox typeHBox = new HBox(20);
            typeHBox.setPadding(new Insets(20, 20, 20, 20));
            typeHBox.setAlignment(Pos.CENTER);

            Label lbl1 = new Label("Select student or faculty to enter ");
            Button studentBtn = new Button("Student");
            Button facultyBtn = new Button("Faculty");

            typeHBox.getChildren().addAll(lbl1, studentBtn, facultyBtn);
            Scene scene = new Scene(typeHBox);
            typeStage.setScene(scene);
            typeStage.show();

            studentBtn.setOnAction((ActionEvent e1) -> {
                //Check fields
                if (topPersonPane.firstNameField.getText() == null || topPersonPane.lastNameField.getText() == null || topPersonPane.phoneField.getText() == null
                        || topPersonPane.addressPane.streetNumberField.getText() == null || topPersonPane.addressPane.streetNameField.getText() == null
                        || topPersonPane.addressPane.cityField.getText() == null || topPersonPane.addressPane.stateList.getSelectionModel().getSelectedItem() == null
                        || topPersonPane.addressPane.zipField.getText() == null || middleStudentPane.coursesTookList.getSelectionModel().getSelectedItems() == null
                        || middleStudentPane.coursesTakingList.getSelectionModel().getSelectedItems() == null || middleStudentPane.coursesNeededArea.getText() == null
                        || middleStudentPane.gpaField.getText() == null || middleStudentPane.creditsTakingField.getText() == null) {

                    Stage errorStage = new Stage();
                    errorStage.setTitle("Error");
                    VBox errorVBox = new VBox(20);
                    errorVBox.setPadding(new Insets(20, 20, 20, 20));
                    errorVBox.setAlignment(Pos.CENTER);
                    Label message = new Label("Error. Please fill out all student field entries.");
                    Button closeBtn = new Button("OK");
                    errorVBox.getChildren().addAll(message, closeBtn);
                    Scene confScene = new Scene(errorVBox);
                    errorStage.setScene(confScene);
                    errorStage.show();
                    closeBtn.setOnAction(e2 -> {
                        errorStage.close();
                    });
                } else {

                    String fName = topPersonPane.firstNameField.getText();
                    String lName = topPersonPane.lastNameField.getText();
                    String phone = topPersonPane.phoneField.getText();
                    String streetNum = topPersonPane.addressPane.streetNumberField.getText();
                    String streetName = topPersonPane.addressPane.streetNameField.getText();
                    String city = topPersonPane.addressPane.cityField.getText();
                    String state = topPersonPane.addressPane.stateList.getSelectionModel().getSelectedItem();
                    String zip = topPersonPane.addressPane.zipField.getText();
                    Address address = new Address(streetNum, streetName, city, state, zip);

                    ObservableList<String> coursesTo;
                    coursesTo = middleStudentPane.coursesTookList.getSelectionModel().getSelectedItems();
                    ArrayList<String> coursesTook = new ArrayList<String>();
                    for (String m : coursesTo) {
                        coursesTook.add(m);
                    }

                    ObservableList<String> coursesTa;
                    coursesTa = middleStudentPane.coursesTakingList.getSelectionModel().getSelectedItems();
                    ArrayList<String> coursesTaking = new ArrayList<String>();
                    for (String m : coursesTa) {
                        coursesTaking.add(m);
                    }

                    ArrayList<String> coursesNeeded = new ArrayList<String>();
                    coursesNeeded.add(middleStudentPane.coursesNeededArea.getText());

                    double gpa = Double.parseDouble(middleStudentPane.gpaField.getText());
                    double creditsTaking = Double.parseDouble(middleStudentPane.creditsTakingField.getText());
                    String major = middleStudentPane.major.getSelectionModel().getSelectedItem();

                    Student s = new Student(fName, lName, phone, address, coursesTook, coursesTaking, coursesNeeded, gpa, creditsTaking, major);
                    me = s;
                    theBag.insert(s);

                    topPersonPane.firstNameField.clear();
                    topPersonPane.lastNameField.clear();
                    topPersonPane.phoneField.clear();
                    topPersonPane.addressPane.streetNumberField.clear();
                    topPersonPane.addressPane.streetNameField.clear();
                    topPersonPane.addressPane.cityField.clear();
                    topPersonPane.addressPane.cityField.clear();
                    topPersonPane.addressPane.stateList.getSelectionModel().clearSelection();
                    topPersonPane.addressPane.zipField.clear();
                    middleStudentPane.coursesNeededArea.clear();
                    middleStudentPane.coursesTookList.getSelectionModel().clearSelection();
                    middleStudentPane.coursesTakingList.getSelectionModel().clearSelection();
                    middleStudentPane.gpaField.clear();
                    middleStudentPane.creditsTakingField.clear();
                    middleStudentPane.major.getSelectionModel().clearSelection();
                    middleFacultyPane.coursesTeachingField.clear();
                    middleFacultyPane.rankField.clear();
                    middleFacultyPane.salaryField.clear();

                    typeStage.close();

                    Stage confirmStage = new Stage();
                    confirmStage.setTitle("Confirmed");
                    VBox confVBox = new VBox(20);
                    confVBox.setPadding(new Insets(20, 20, 20, 20));
                    confVBox.setAlignment(Pos.CENTER);
                    Label message = new Label("Added: " + s.getFirstName() + " " + s.getLastName() + " at ID Number: " + s.getId());
                    Button closeBtn = new Button("OK");
                    confVBox.getChildren().addAll(message, closeBtn);
                    Scene confScene = new Scene(confVBox);
                    confirmStage.setScene(confScene);
                    confirmStage.show();
                    closeBtn.setOnAction(e2 -> {
                        confirmStage.close();
                    });
                }
            });

            facultyBtn.setOnAction(e1 -> {

                //check fields
                if (topPersonPane.firstNameField.getText() == null || topPersonPane.lastNameField.getText() == null || topPersonPane.phoneField.getText() == null
                        || topPersonPane.addressPane.streetNumberField.getText() == null || topPersonPane.addressPane.streetNameField.getText() == null
                        || topPersonPane.addressPane.cityField.getText() == null || topPersonPane.addressPane.stateList.getSelectionModel().getSelectedItem() == null
                        || topPersonPane.addressPane.zipField.getText() == null || middleFacultyPane.rankField.getText() == null || middleFacultyPane.salaryField.getText() == null
                        || middleFacultyPane.coursesTeachingField.getText() == null) {

                    Stage errorStage = new Stage();
                    errorStage.setTitle("Error");
                    VBox errorVBox = new VBox(20);
                    errorVBox.setPadding(new Insets(20, 20, 20, 20));
                    errorVBox.setAlignment(Pos.CENTER);
                    Label message = new Label("Error. Please fill out all faculty field entries.");
                    Button closeBtn = new Button("OK");
                    errorVBox.getChildren().addAll(message, closeBtn);
                    Scene confScene = new Scene(errorVBox);
                    errorStage.setScene(confScene);
                    errorStage.show();
                    closeBtn.setOnAction(e2 -> {
                        errorStage.close();
                    });
                } else {

                    String fName = topPersonPane.firstNameField.getText();
                    String lName = topPersonPane.lastNameField.getText();
                    String phone = topPersonPane.phoneField.getText();

                    String streetNum = topPersonPane.addressPane.streetNumberField.getText();
                    String streetName = topPersonPane.addressPane.streetNameField.getText();
                    String city = topPersonPane.addressPane.cityField.getText();
                    String state = topPersonPane.addressPane.stateList.getSelectionModel().getSelectedItem();
                    String zip = topPersonPane.addressPane.zipField.getText();
                    Address address = new Address(streetNum, streetName, city, state, zip);

                    String rank = middleFacultyPane.rankField.getText();
                    Double salary = Double.parseDouble(middleFacultyPane.salaryField.getText());
                    ArrayList<String> coursesTeaching = new ArrayList<String>();
                    coursesTeaching.add(middleFacultyPane.coursesTeachingField.getText());

                    Faculty f = new Faculty(fName, lName, phone, address, rank, salary, coursesTeaching);
                    chen = f;
                    theBag.insert(f);

                    topPersonPane.firstNameField.clear();
                    topPersonPane.lastNameField.clear();
                    topPersonPane.phoneField.clear();
                    topPersonPane.addressPane.streetNumberField.clear();
                    topPersonPane.addressPane.streetNameField.clear();
                    topPersonPane.addressPane.cityField.clear();
                    topPersonPane.addressPane.cityField.clear();
                    topPersonPane.addressPane.stateList.getSelectionModel().clearSelection();
                    topPersonPane.addressPane.zipField.clear();
                    middleStudentPane.coursesNeededArea.clear();
                    middleStudentPane.coursesTookList.getSelectionModel().clearSelection();
                    middleStudentPane.coursesTakingList.getSelectionModel().clearSelection();
                    middleStudentPane.gpaField.clear();
                    middleStudentPane.creditsTakingField.clear();
                    middleStudentPane.major.getSelectionModel().clearSelection();
                    middleFacultyPane.coursesTeachingField.clear();
                    middleFacultyPane.rankField.clear();
                    middleFacultyPane.salaryField.clear();

                    typeStage.close();

                    Stage confirmStage = new Stage();
                    confirmStage.setTitle("Confirmed");
                    VBox confVBox = new VBox(20);
                    confVBox.setPadding(new Insets(20, 20, 20, 20));
                    confVBox.setAlignment(Pos.CENTER);
                    Label message = new Label("Added: " + f.getFirstName() + " " + f.getLastName() + " at ID Number: " + f.getId());
                    Button closeBtn = new Button("OK");
                    confVBox.getChildren().addAll(message, closeBtn);
                    Scene confScene = new Scene(confVBox);
                    confirmStage.setScene(confScene);
                    confirmStage.show();
                    closeBtn.setOnAction(e2 -> {
                        confirmStage.close();
                    });
                }
            });
        });

        bottomButtonsPane.removeBtn.setOnAction(e -> {
            Stage removeStage = new Stage();
            removeStage.setTitle("Search");
            VBox removeVBox = new VBox(20);
            removeVBox.setPadding(new Insets(20, 20, 20, 20));
            removeVBox.setAlignment(Pos.CENTER);
            Label removeLbl = new Label("Enter the ID of the Student of Faculty member you would like to remove.");
            TextField removeField = new TextField();
            Button removeBtn = new Button("OK");
            removeVBox.getChildren().addAll(removeLbl, removeField, removeBtn);
            Scene removeScen = new Scene(removeVBox);
            removeStage.setScene(removeScen);
            removeStage.show();
            removeBtn.setOnAction(e1 -> {
                String id = removeField.getText();

                if (theBag.searchById(id) == null) {
                    Stage errorStage = new Stage();
                    errorStage.setTitle("Error");
                    VBox errorVBox = new VBox(20);
                    errorVBox.setPadding(new Insets(20, 20, 20, 20));
                    errorVBox.setAlignment(Pos.CENTER);
                    Label message = new Label("No student or faculty found at that ID.");
                    Button closeBtn = new Button("OK");
                    errorVBox.getChildren().addAll(message, closeBtn);
                    Scene confScene = new Scene(errorVBox);
                    errorStage.setScene(confScene);
                    errorStage.show();
                    closeBtn.setOnAction(e2 -> {
                        errorStage.close();
                        removeStage.close();
                    });
                } else {
                    Stage fStage = new Stage();
                    fStage.setTitle("Found");
                    VBox fVBox = new VBox(20);
                    fVBox.setPadding(new Insets(20, 20, 20, 20));
                    fVBox.setAlignment(Pos.CENTER);
                    Label msg = new Label("Removed :");
                    TextArea opt = new TextArea();
                    opt.setEditable(false);
                    opt.setText(theBag.searchById(id).toString());
                    theBag.removeById(id);
                    Button closeBtn = new Button("OK");
                    fVBox.getChildren().addAll(msg, opt, closeBtn);
                    Scene fScene = new Scene(fVBox);
                    fStage.setScene(fScene);
                    fStage.show();
                    closeBtn.setOnAction(e2 -> {
                        fStage.close();
                        removeStage.close();
                    });
                }
            });
        });

        bottomButtonsPane.updateBtn.setOnAction(e -> {

        });

        bottomButtonsPane.searchBtn.setOnAction(e -> {
            Stage searchStage = new Stage();
            searchStage.setTitle("Search");
            VBox searchVBox = new VBox(20);
            searchVBox.setPadding(new Insets(20, 20, 20, 20));
            searchVBox.setAlignment(Pos.CENTER);
            Label searchLbl = new Label("Enter the ID of the Student of Faculty member you would like to search for.");
            TextField searchField = new TextField();
            Button searchBtn = new Button("OK");
            searchVBox.getChildren().addAll(searchLbl, searchField, searchBtn);
            Scene searchScene = new Scene(searchVBox);
            searchStage.setScene(searchScene);
            searchStage.show();
            searchBtn.setOnAction(e1 -> {
                String id = searchField.getText();

                if (theBag.searchById(id) == null) {
                    Stage errorStage = new Stage();
                    errorStage.setTitle("Error");
                    VBox errorVBox = new VBox(20);
                    errorVBox.setPadding(new Insets(20, 20, 20, 20));
                    errorVBox.setAlignment(Pos.CENTER);
                    Label message = new Label("No student or faculty found at that ID.");
                    Button closeBtn = new Button("OK");
                    errorVBox.getChildren().addAll(message, closeBtn);
                    Scene confScene = new Scene(errorVBox);
                    errorStage.setScene(confScene);
                    errorStage.show();
                    closeBtn.setOnAction(e2 -> {
                        errorStage.close();
                        searchStage.close();
                    });
                } else {
                    Stage foundStage = new Stage();
                    foundStage.setTitle("Found");
                    VBox foundVBox = new VBox(20);
                    foundVBox.setPadding(new Insets(20, 20, 20, 20));
                    foundVBox.setAlignment(Pos.CENTER);
                    Label message = new Label("Found :");
                    TextArea output = new TextArea();
                    output.setEditable(false);
                    output.setText(theBag.searchById(id).toString());

                    Button closeBtn = new Button("OK");
                    foundVBox.getChildren().addAll(message, output, closeBtn);
                    Scene foundScene = new Scene(foundVBox);
                    foundStage.setScene(foundScene);
                    foundStage.show();
                    closeBtn.setOnAction(e2 -> {
                        foundStage.close();
                        searchStage.close();
                    });
                }
            });
        });

        middlePane.getChildren().addAll(middleStudentPane.returnStPane(), middleFacultyPane.returnFacPane());
        personPane.getChildren().addAll(topPersonPane.returnTopPane(), middlePane, bottomButtonsPane.returnBtnPane());
    }


    //This is a test to see if GitHub is all as great as they say it is. woot

    //From PC TO MAC NOW

    public VBox returnPane() {
        return personPane;
    }
}