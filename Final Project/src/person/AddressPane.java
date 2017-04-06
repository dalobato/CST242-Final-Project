package person;

import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;

public class AddressPane {

    Label streetNumberLbl;
    Label streetNameLbl;
    Label cityLbl;
    Label stateLbl;
    Label zipLbl;
    TextField streetNumberField;
    TextField streetNameField;
    TextField cityField;
    ListView<String> stateList;
    TextField zipField;

    public AddressPane() {

        streetNumberLbl = new Label("Street Number");
        streetNameLbl = new Label("Street Name");
        cityLbl = new Label("City");
        stateLbl = new Label("State");
        zipLbl = new Label("Zip");
        streetNumberField = new TextField();
        streetNameField = new TextField();
        cityField = new TextField();
        stateList = new ListView<String>();
        stateList.setPrefHeight(150);
        stateList.setPrefWidth(50);
        stateList.getItems().addAll("AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI",
                "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA",
                "WV", "WI", "WY");
        stateList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        zipField = new TextField();

    }


}