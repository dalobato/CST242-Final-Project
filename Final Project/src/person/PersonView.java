package person;

import com.sun.xml.internal.ws.client.sei.ResponseBuilder;
import javafx.application.Application;
import javafx.collections.ObservableList;
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
import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;


public class PersonView extends Application {

    int updateFLAG;
    Person temp;
    String idToUpdate;
    BodyBag theBag;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        PersonPane root = new PersonPane();


        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("savePersons.dat"))){
            theBag = (BodyBag) ois.readObject();
            ois.close();

        }catch(Exception e) {
            theBag = new BodyBag(100);
        }

        root.getBottomButtonsPane().getInsertBtn().setOnAction(e -> {
            Stage selectionStage = new Stage();
            HBox selectionBox = new HBox();
            selectionBox.setAlignment(Pos.CENTER);
            selectionBox.setPadding(new Insets(20));
            selectionBox.setSpacing(10);

            Label selectionLabel = new Label("Select to add as Student or Faculty:");
            Button studentBtn = new Button("Student");
            Button facultyBtn = new Button("Faculty");
            selectionBox.getChildren().addAll(selectionLabel, studentBtn, facultyBtn);

            Scene selectionScene = new Scene(selectionBox);
            selectionStage.setScene(selectionScene);
            selectionStage.show();

            studentBtn.setOnAction(e1 -> {
                try {
                    //CoursesTook
                    ObservableList<String> cTook = root.getMiddleStudentPane().getCoursesTookList().getSelectionModel().getSelectedItems();
                    ArrayList<String> coursesTook = new ArrayList<>();
                    for (String m : cTook) {
                        coursesTook.add(m);
                    }

                    //CoursesTaking
                    ObservableList<String> cTaking = root.getMiddleStudentPane().getCoursesTakingList().getSelectionModel().getSelectedItems();
                    ArrayList<String> coursesTaking = new ArrayList<>();
                    for (String m : cTaking) {
                        coursesTaking.add(m);
                    }

                    //Courses Needed
                    String cNeeded = root.getMiddleStudentPane().getCoursesNeededArea().getText();
                    ArrayList<String> coursesNeeded = new ArrayList<>(Arrays.asList(cNeeded.split(",[ ]*")));

                    ///Student s = new Student(fName, lName, phone, address, coursesTook, coursesTaking, coursesNeeded, gpa, creditsTaking, major);
                    Student s = new Student(root.getTopPane().getFirstNameField().getText(), root.getTopPane().getLastNameField().getText(),
                            root.getTopPane().getPhoneField().getText(), root.getTopPane().getAddressPane().getAddress(), coursesTook, coursesTaking,
                            coursesNeeded,
                            Double.parseDouble(root.getMiddleStudentPane().getGpaField().getText()),
                            Double.parseDouble(root.getMiddleStudentPane().getCreditsTakingField().getText()),
                            root.getMiddleStudentPane().getMajor().getSelectionModel().getSelectedItem());

                    theBag.insert(s);

                    root.getTopPane().clearFields();
                    root.getTopPane().getAddressPane().clearFields();
                    root.getMiddleStudentPane().clearFields();
                    root.getMiddleFacultyPane().clearFields();
                    selectionStage.close();

                    Stage confirmationStage = new Stage();
                    confirmationStage.setTitle("Confirmed");
                    VBox confVBox = new VBox(20);
                    confVBox.setPadding(new Insets(20, 20, 20, 20));
                    confVBox.setAlignment(Pos.CENTER);
                    Label message = new Label("Added:");
                    TextArea output = new TextArea();
                    output.setEditable(false);
                    output.setText(s.toString());
                    Button closeBtn = new Button("OK");
                    confVBox.getChildren().addAll(message, output, closeBtn);
                    Scene confScene = new Scene(confVBox);
                    confirmationStage.setScene(confScene);
                    confirmationStage.show();
                    closeBtn.setOnAction(e2 -> {
                        confirmationStage.close();
                    });
                } catch (Exception error) {
                    Stage errorStage = new Stage();
                    errorStage.setTitle("Error");
                    VBox errorVBox = new VBox(20);
                    errorVBox.setPadding(new Insets(20, 20, 20, 20));
                    errorVBox.setAlignment(Pos.CENTER);
                    Label message = new Label("Error. Please fill out all student field entries, highlighted in BLUE.");
                    Button closeBtn = new Button("OK");
                    errorVBox.getChildren().addAll(message, closeBtn);
                    Scene confScene = new Scene(errorVBox);
                    errorStage.setScene(confScene);
                    errorStage.show();
                    closeBtn.setOnAction(e2 -> {
                        errorStage.close();
                    });
                }
            });

            facultyBtn.setOnAction(e1 -> {
                try {
                    //Get coursesTeaching to ArrayList
                    String cTeaching = root.getMiddleFacultyPane().getCoursesTeachingField().getText();
                    ArrayList<String> coursesTeaching = new ArrayList<>(Arrays.asList(cTeaching.split(",[ ]*")));

                    //Faculty f = new Faculty(fName, lName, phone, address, rank, salary, coursesTeaching);
                    Faculty f = new Faculty(root.getTopPane().getFirstNameField().getText(), root.getTopPane().getLastNameField().getText(),
                            root.getTopPane().getPhoneField().getText(), root.getTopPane().getAddressPane().getAddress(),
                            root.getMiddleFacultyPane().getRankField().getText(),
                            Double.parseDouble(root.getMiddleFacultyPane().getSalaryField().getText()),
                            coursesTeaching);

                    theBag.insert(f);

                    root.getTopPane().clearFields();
                    root.getTopPane().getAddressPane().clearFields();
                    root.getMiddleStudentPane().clearFields();
                    root.getMiddleFacultyPane().clearFields();
                    selectionStage.close();

                    Stage confirmationStage = new Stage();
                    confirmationStage.setTitle("Confirmed");
                    VBox confVBox = new VBox(20);
                    confVBox.setPadding(new Insets(20, 20, 20, 20));
                    confVBox.setAlignment(Pos.CENTER);
                    Label message = new Label("Added:");
                    TextArea output = new TextArea();
                    output.setEditable(false);
                    output.setText(f.toString());
                    Button closeBtn = new Button("OK");
                    confVBox.getChildren().addAll(message, output, closeBtn);
                    Scene confScene = new Scene(confVBox);
                    confirmationStage.setScene(confScene);
                    confirmationStage.show();
                    closeBtn.setOnAction(e2 -> {
                        confirmationStage.close();
                    });
                } catch (Exception error) {
                    Stage errorStage = new Stage();
                    errorStage.setTitle("Error");
                    VBox errorVBox = new VBox(20);
                    errorVBox.setPadding(new Insets(20, 20, 20, 20));
                    errorVBox.setAlignment(Pos.CENTER);
                    Label message = new Label("Error. Please fill out all faculty field entries, highlighted in RED.");
                    Button closeBtn = new Button("OK");
                    errorVBox.getChildren().addAll(message, closeBtn);
                    Scene confScene = new Scene(errorVBox);
                    errorStage.setScene(confScene);
                    errorStage.show();
                    closeBtn.setOnAction(e2 -> {
                        errorStage.close();
                    });
                }
            });
        });

        root.getBottomButtonsPane().getRemoveBtn().setOnAction(e -> {
            Stage removeStage = new Stage();
            removeStage.setTitle("Remove");
            VBox removeVBox = new VBox(20);
            removeVBox.setPadding(new Insets(20));
            removeVBox.setAlignment(Pos.CENTER);
            Label removeLbl = new Label("Enter ID to remove");
            TextField removeField = new TextField();
            Button removeBtn = new Button("Search");
            removeVBox.getChildren().addAll(removeLbl, removeField, removeBtn);
            Scene removeScene = new Scene(removeVBox, 250, 250);
            removeStage.setScene(removeScene);
            removeStage.show();

            removeBtn.setOnAction(e1 -> {
                try {
                    Stage foundStage = new Stage();
                    foundStage.setTitle("Found");
                    VBox foundVBox = new VBox(20);
                    foundVBox.setPadding(new Insets(20, 20, 20, 20));
                    foundVBox.setAlignment(Pos.CENTER);
                    Label message = new Label("Removed :");
                    TextArea output = new TextArea();
                    output.setEditable(false);
                    output.setText(theBag.searchById(removeField.getText()).toString());
                    theBag.removeById(removeField.getText());
                    Button closeBtn = new Button("OK");
                    foundVBox.getChildren().addAll(message, output, closeBtn);
                    Scene fScene = new Scene(foundVBox);
                    foundStage.setScene(fScene);
                    foundStage.show();
                    closeBtn.setOnAction(e2 -> {
                        foundStage.close();
                    });
                } catch (Exception error) {
                    Stage errorStage = new Stage();
                    VBox errorBox = new VBox();
                    errorBox.setAlignment(Pos.CENTER);
                    errorBox.setPadding(new Insets(20));
                    Label errorLbl = new Label("ID Not found.");
                    Button errorBtn = new Button("OK");
                    errorBox.getChildren().addAll(errorLbl, errorBtn);
                    Scene errorScene = new Scene(errorBox, 200, 200);
                    errorStage.setScene(errorScene);
                    errorStage.show();

                    errorBtn.setOnAction(e2 -> {
                        errorStage.close();
                    });
                }
            });
        });

        root.getBottomButtonsPane().getUpdateBtn().setOnAction(e -> {

            if (updateFLAG == 0) {
                Stage updateStage = new Stage();
                VBox updateBox = new VBox();
                updateBox.setAlignment(Pos.CENTER);
                updateBox.setPadding(new Insets(20));
                updateBox.setSpacing(20);
                Label updateLbl = new Label("Enter ID of person you want to update");
                TextField updateField = new TextField();
                Button updateBtn = new Button("Update");

                updateBox.getChildren().addAll(updateLbl, updateField, updateBtn);
                Scene updateScene = new Scene(updateBox);
                updateStage.setScene(updateScene);
                updateStage.show();

                updateBtn.setOnAction(e1 -> {
                    try {
                        temp = theBag.searchById(updateField.getText());
                        idToUpdate = updateField.getText();

                        if (temp instanceof Student) {
                            Student s = (Student) temp;
                            root.getTopPane().setFields(s);
                            root.getTopPane().getAddressPane().setFields(s);
                            root.getMiddleStudentPane().setFields(s);

                            updateStage.close();
                            root.getBottomButtonsPane().getInsertBtn().setDisable(true);
                            root.getBottomButtonsPane().getSearchBtn().setDisable(true);
                            root.getBottomButtonsPane().getRemoveBtn().setDisable(true);
                            updateFLAG = 1;

                        } else if (temp instanceof Faculty) {
                            Faculty f = (Faculty) temp;
                            root.getTopPane().setFields(f);
                            root.getTopPane().getAddressPane().setFields(f);
                            root.getMiddleFacultyPane().setFields(f);

                            updateStage.close();
                            root.getBottomButtonsPane().getInsertBtn().setDisable(true);
                            root.getBottomButtonsPane().getSearchBtn().setDisable(true);
                            root.getBottomButtonsPane().getRemoveBtn().setDisable(true);
                            updateFLAG = 1;
                        }
                    } catch (Exception error) {
                        Stage errorStage = new Stage();
                        VBox errorBox = new VBox();
                        errorBox.setAlignment(Pos.CENTER);
                        errorBox.setPadding(new Insets(20));
                        Label errorLbl = new Label("ID Not found.");
                        Button errorBtn = new Button("OK");
                        errorBox.getChildren().addAll(errorLbl, errorBtn);
                        Scene errorScene = new Scene(errorBox, 200, 200);
                        errorStage.setScene(errorScene);
                        errorStage.show();

                        errorBtn.setOnAction(e2 -> {
                            errorStage.close();
                        });
                    }
                });
            } else if (updateFLAG == 1) {

                try {

                    if (temp instanceof Student) {
                        Student s = (Student) theBag.searchById(idToUpdate);
                        s.setFirstName(root.getTopPane().getFirstNameField().getText());
                        s.setLastName(root.getTopPane().getLastNameField().getText());
                        s.setPhone(root.getTopPane().getPhoneField().getText());
                        s.setAddress(root.getTopPane().getAddressPane().getAddress());

                        //CoursesTook
                        ObservableList<String> cTook = root.getMiddleStudentPane().getCoursesTookList().getSelectionModel().getSelectedItems();
                        ArrayList<String> coursesTook = new ArrayList<>();
                        for (String m : cTook) {
                            coursesTook.add(m);
                        }
                        s.setCoursesTook(coursesTook);

                        //CoursesTaking
                        ObservableList<String> cTaking = root.getMiddleStudentPane().getCoursesTakingList().getSelectionModel().getSelectedItems();
                        ArrayList<String> coursesTaking = new ArrayList<>();
                        for (String m : cTaking) {
                            coursesTaking.add(m);
                        }
                        s.setCoursesTaking(coursesTaking);

                        //Courses Needed
                        String cNeeded = root.getMiddleStudentPane().getCoursesNeededArea().getText();
                        ArrayList<String> coursesNeeded = new ArrayList<>(Arrays.asList(cNeeded.split(",[ ]*")));
                        s.setCoursesNeeded(coursesNeeded);

                        //Major
                        s.setMajor(root.getMiddleStudentPane().getMajor().getSelectionModel().getSelectedItem());

                        //CreditsTaking
                        s.setCreditsTaking(Double.parseDouble(root.getMiddleStudentPane().getCreditsTakingField().getText()));

                        //GPA
                        s.setGpa(Double.parseDouble(root.getMiddleStudentPane().getGpaField().getText()));

                        theBag.update(s, idToUpdate);

                        //Clear and Reset
                        root.getTopPane().clearFields();
                        root.getTopPane().getAddressPane().clearFields();
                        root.getMiddleStudentPane().clearFields();
                        root.getMiddleFacultyPane().clearFields();

                        Stage confirmationStage = new Stage();
                        confirmationStage.setTitle("Confirmed");
                        VBox confVBox = new VBox(20);
                        confVBox.setPadding(new Insets(20, 20, 20, 20));
                        confVBox.setAlignment(Pos.CENTER);
                        Label message = new Label("Updated:");
                        TextArea output = new TextArea();
                        output.setEditable(false);
                        output.setText(s.toString());
                        Button closeBtn = new Button("OK");
                        confVBox.getChildren().addAll(message, output, closeBtn);
                        Scene confScene = new Scene(confVBox);
                        confirmationStage.setScene(confScene);
                        confirmationStage.show();
                        closeBtn.setOnAction(e2 -> {
                            updateFLAG = 0;
                            confirmationStage.close();
                            root.getBottomButtonsPane().getRemoveBtn().setDisable(false);
                            root.getBottomButtonsPane().getSearchBtn().setDisable(false);
                            root.getBottomButtonsPane().getInsertBtn().setDisable(false);
                        });
                    } else if (temp instanceof Faculty) {
                        Faculty f = (Faculty) theBag.searchById(idToUpdate);

                        //topPane
                        f.setFirstName(root.getTopPane().getFirstNameField().getText());
                        f.setLastName(root.getTopPane().getLastNameField().getText());
                        f.setPhone(root.getTopPane().getPhoneField().getText());
                        f.setAddress(root.getTopPane().getAddressPane().getAddress());

                        //Rank
                        f.setRank(root.getMiddleFacultyPane().getRankField().getText());
                        //Salary
                        f.setSalary(Double.parseDouble(root.getMiddleFacultyPane().getSalaryField().getText()));
                        //CoursesTeaching
                        String cTeaching = root.getMiddleFacultyPane().getCoursesTeachingField().getText();
                        ArrayList<String> coursesTeaching = new ArrayList<>(Arrays.asList(cTeaching.split(",[ ]*")));
                        f.setCoursesTeaching(coursesTeaching);

                        theBag.update(f, idToUpdate);

                        //Clear and Reset
                        root.getTopPane().clearFields();
                        root.getTopPane().getAddressPane().clearFields();
                        root.getMiddleStudentPane().clearFields();
                        root.getMiddleFacultyPane().clearFields();

                        Stage confirmationStage = new Stage();
                        confirmationStage.setTitle("Confirmed");
                        VBox confVBox = new VBox(20);
                        confVBox.setPadding(new Insets(20, 20, 20, 20));
                        confVBox.setAlignment(Pos.CENTER);
                        Label message = new Label("Updated:");
                        TextArea output = new TextArea();
                        output.setEditable(false);
                        output.setText(f.toString());
                        Button closeBtn = new Button("OK");
                        confVBox.getChildren().addAll(message, output, closeBtn);
                        Scene confScene = new Scene(confVBox);
                        confirmationStage.setScene(confScene);
                        confirmationStage.show();
                        closeBtn.setOnAction(e2 -> {
                            updateFLAG = 0;
                            confirmationStage.close();
                            root.getBottomButtonsPane().getRemoveBtn().setDisable(false);
                            root.getBottomButtonsPane().getSearchBtn().setDisable(false);
                            root.getBottomButtonsPane().getInsertBtn().setDisable(false);
                        });


                    }
                }catch (Exception error){
                    Stage errorStage = new Stage();
                    errorStage.setTitle("Error");
                    VBox errorVBox = new VBox(20);
                    errorVBox.setPadding(new Insets(20, 20, 20, 20));
                    errorVBox.setAlignment(Pos.CENTER);
                    Label message = new Label("Error. Please fill out all the necessary fields correctly.");
                    Button closeBtn = new Button("OK");
                    errorVBox.getChildren().addAll(message, closeBtn);
                    Scene confScene = new Scene(errorVBox);
                    errorStage.setScene(confScene);
                    errorStage.show();
                    closeBtn.setOnAction(e2 -> {
                        errorStage.close();
                    });
                }
            }
        });

        root.getBottomButtonsPane().getSearchBtn().setOnAction(e -> {
            Stage searchStage = new Stage();
            searchStage.setTitle("Search");
            VBox searchVBox = new VBox(20);
            searchVBox.setPadding(new Insets(20));
            searchVBox.setAlignment(Pos.CENTER);
            Label searchLbl = new Label("Enter ID to search for");
            TextField searchField = new TextField();
            Button searchBtn = new Button("Search");
            searchVBox.getChildren().addAll(searchLbl, searchField, searchBtn);
            Scene searchScene = new Scene(searchVBox, 250, 250);
            searchStage.setScene(searchScene);
            searchStage.show();

            searchBtn.setOnAction(e1 -> {
                try {
                    Stage foundStage = new Stage();
                    foundStage.setTitle("Found");
                    VBox foundVBox = new VBox(20);
                    foundVBox.setPadding(new Insets(20, 20, 20, 20));
                    foundVBox.setAlignment(Pos.CENTER);
                    Label message = new Label("Found:");
                    TextArea output = new TextArea();
                    output.setEditable(false);
                    output.setText(theBag.searchById(searchField.getText()).toString());
                    Button closeBtn = new Button("OK");
                    foundVBox.getChildren().addAll(message, output, closeBtn);
                    Scene fScene = new Scene(foundVBox);
                    foundStage.setScene(fScene);
                    foundStage.show();
                    closeBtn.setOnAction(e2 -> {
                        foundStage.close();
                    });
                } catch (Exception error) {
                    Stage errorStage = new Stage();
                    VBox errorBox = new VBox();
                    errorBox.setAlignment(Pos.CENTER);
                    errorBox.setPadding(new Insets(20));
                    Label errorLbl = new Label("ID Not found.");
                    Button errorBtn = new Button("OK");
                    errorBox.getChildren().addAll(errorLbl, errorBtn);
                    Scene errorScene = new Scene(errorBox, 200, 200);
                    errorStage.setScene(errorScene);
                    errorStage.show();

                    errorBtn.setOnAction(e2 -> {
                        errorStage.close();
                    });
                }
            });
        });

        root.getBottomButtonsPane().getSaveBtn().setOnAction(e -> {

        });

        Scene scene = new Scene(root.getPersonPane(), 690, 800);

        primaryStage.setScene(scene);
        primaryStage.show();

        primaryStage.setOnCloseRequest(e -> {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("savePersons.dat"))) {
                oos.writeObject(theBag);
                oos.close();
            } catch (Exception error) {
                error.printStackTrace();
            }
        });
    }
}