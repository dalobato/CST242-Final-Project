package person;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

/**
 * Created by dalob on 4/6/2017.
 */
public class Test {
    public static void main(String[] args){
        ObservableList<String> oList =FXCollections.observableArrayList();
        oList.addAll("Test1", "Test2", "Test3", "Test4");

        ArrayList<String> aList = new ArrayList<String>();

        for(int i = 0; i==oList.size(); i++){
            aList.add(oList.get(i));
        }

        System.out.println(aList.toString());
    }
}
