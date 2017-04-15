package person;

import com.sun.org.apache.xpath.internal.operations.String;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.*;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.awt.*;
import java.util.Observable;

public class AddressPane {

    private GridPane addressPane;
    private Label streetNumberLbl;
    private Label streetNameLbl;
    private Label cityLbl;
    private Label stateLbl;
    private Label zipLbl;
    private TextField streetNumberField;
    private TextField streetNameField;
    private TextField cityField;
    private ListView<String> stateList;
    private TextField zipField;


    private ComboBox stateBox;

    public AddressPane() {

        streetNumberLbl = new Label("Street Number");
        streetNameLbl = new Label("Street Name");
        cityLbl = new Label("City");
        stateLbl = new Label("State");
        zipLbl = new Label("Zip");
        streetNumberField = new TextField();
        streetNameField = new TextField();
        cityField = new TextField();
        stateBox = new ComboBox();
        stateBox.setPrefWidth(70);
        stateBox.getItems().addAll("AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI",
                "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA",
                "WV", "WI", "WY");

        zipField = new TextField();

        addressPane = new GridPane();
        addressPane.setPadding(new Insets(20, 50, 20, 50));
        addressPane.setHgap(20);
        addressPane.setAlignment(Pos.CENTER);
        addressPane.add(streetNumberLbl, 0, 0);
        addressPane.add(streetNumberField, 0, 1);

        addressPane.add(streetNameLbl, 1, 0);
        addressPane.add(streetNameField, 1, 1);

        addressPane.add(cityLbl, 0, 2);
        addressPane.add(cityField, 0, 3);

        addressPane.add(zipLbl, 1, 2);
        addressPane.add(zipField, 1, 3);


        addressPane.add(stateLbl, 2, 0);
        addressPane.add(stateBox, 2, 1);

        addressPane.setAlignment(Pos.CENTER);
        addressPane.setPadding(new Insets(20));

    }

    public GridPane getAddressPane() {
        return addressPane;
    }

    public void setAddressPane(GridPane addressPane) {
        this.addressPane = addressPane;
    }

    public void clearFields(){
        streetNumberField.clear();
        streetNameField.clear();
        cityField.clear();
        zipField.clear();
        stateBox.getSelectionModel().clearSelection();
    }

    public void setFields(Person p){
        streetNumberField.setText(p.getAddress().getStreetNumber());
        streetNameField.setText(p.getAddress().getStreetName());
        cityField.setText(p.getAddress().getCity());
        zipField.setText(p.getAddress().getZip());
        stateBox.getSelectionModel().select(p.getAddress().getState());
    }

    public Address getAddress(){
        return new Address(streetNumberField.getText(), streetNameField.getText(), cityField.getText(), stateBox.getValue().toString(), zipField.getText());
    }
}