package person;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;


public class TopPersonPane {

    private GridPane personPane;
    private Label firstNameLbl;
    private TextField firstNameField;
    private Label lastNameLbl;
    private TextField lastNameField;
    private Label phoneLbl;
    private TextField phoneField;
    private AddressPane addressPane;

    public TopPersonPane() {

        personPane = new GridPane();
        personPane.setAlignment(Pos.CENTER);
        personPane.setPadding(new Insets(20, 70, 20, 70));
        personPane.setHgap(20);
        firstNameLbl = new Label("First Name");
        firstNameField = new TextField();
        lastNameLbl = new Label("Last Name");
        lastNameField = new TextField();
        phoneLbl = new Label("Phone Number");
        phoneField = new TextField();
        addressPane = new AddressPane();




        personPane.add(firstNameLbl, 0, 0);
        personPane.add(firstNameField, 0, 1);
        personPane.add(lastNameLbl, 1, 0);
        personPane.add(lastNameField, 1, 1);
        personPane.add(phoneLbl, 2, 0);
        personPane.add(phoneField, 2, 1);
        personPane.add(addressPane.getAddressPane(), 0, 2, 3 ,9);


//        personPane.add(addressPane.streetNumberLbl, 0, 3);
//        personPane.add(addressPane.streetNumberField, 0, 4);
//        personPane.add(addressPane.streetNameLbl, 1, 3);
//        personPane.add(addressPane.streetNameField, 1, 4);
//        personPane.add(addressPane.cityLbl, 2, 3);
//        personPane.add(addressPane.cityField, 2, 4);
//        personPane.add(addressPane.stateLbl, 0, 5);
//        personPane.add(addressPane.stateList, 0, 6);
//        personPane.add(zip, 1, 6);
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

    public TextField getPhoneField() {
        return phoneField;
    }

    public void setPhoneField(TextField phoneField) {
        this.phoneField = phoneField;
    }

    public AddressPane getAddressPane() {
        return addressPane;
    }

    public void setAddressPane(AddressPane addressPane) {
        this.addressPane = addressPane;
    }

    public void clearFields(){
        firstNameField.clear();
        lastNameField.clear();
        phoneField.clear();

    }

    public void setFields(Person p){
        firstNameField.setText(p.getFirstName());
        lastNameField.setText(p.getLastName());
        phoneField.setText(p.getPhone());
    }

}