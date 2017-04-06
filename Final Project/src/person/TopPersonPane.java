package person;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;


public class TopPersonPane {

    GridPane personPane = new GridPane();
    Label firstNameLbl;
    TextField firstNameField;
    Label lastNameLbl;
    TextField lastNameField;
    Label phoneLbl;
    TextField phoneField;
    AddressPane addressPane = new AddressPane();

    VBox zip = new VBox(5);

    public TopPersonPane() {

        personPane.setAlignment(Pos.CENTER);
        personPane.setPadding(new Insets(20, 20, 20, 20));
        personPane.setHgap(10);
        personPane.setVgap(5);
        firstNameLbl = new Label("First Name");
        firstNameField = new TextField();
        lastNameLbl = new Label("Last Name");
        lastNameField = new TextField();
        phoneLbl = new Label("Phone Number");
        phoneField = new TextField();

        zip.getChildren().addAll(addressPane.zipLbl, addressPane.zipField);


        personPane.add(firstNameLbl, 0, 1);
        personPane.add(firstNameField, 0, 2);
        personPane.add(lastNameLbl, 1, 1);
        personPane.add(lastNameField, 1, 2);
        personPane.add(phoneLbl, 2, 1);
        personPane.add(phoneField, 2, 2);
        personPane.add(addressPane.streetNumberLbl, 0, 3);
        personPane.add(addressPane.streetNumberField, 0, 4);
        personPane.add(addressPane.streetNameLbl, 1, 3);
        personPane.add(addressPane.streetNameField, 1, 4);
        personPane.add(addressPane.cityLbl, 2, 3);
        personPane.add(addressPane.cityField, 2, 4);
        personPane.add(addressPane.stateLbl, 0, 5);
        personPane.add(addressPane.stateList, 0, 6);
        personPane.add(zip, 1, 6);

//        personPane.add(addressPane.zipLbl, 1, 5);
//        personPane.add(addressPane.zipField, 1, 6);

    }

    public GridPane returnTopPane() {
        return personPane;
    }

    public TextField getFirstNameField() {
        return firstNameField;
    }

    public void setFirstNameField(TextField firstNameField) {
        this.firstNameField = firstNameField;
    }

    public TextField getLastNameField() {
        return lastNameField;
    }

    public void setLastNameField(TextField lastNameField) {
        this.lastNameField = lastNameField;
    }

}