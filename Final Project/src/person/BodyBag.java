package person;

import java.io.Serializable;

public class BodyBag implements Serializable{
    private Person[] peopleArray;
    private int nElems;

    // BodyBag(maxSize:int):
    public BodyBag(int maxSize) {
        peopleArray = new Person[maxSize];
        nElems = 0;
    }

    // insert(person:Person)
    public void insert(Person person) {
        peopleArray[nElems] = person;
        nElems++;

    }

    // removeById(id:String)
    public Person removeById(String id) {
        int i;
        for (i = 0; i < nElems; i++) {
            if (peopleArray[i].getId().equals(id)) {
                break;
            }
        }
        if (i == nElems) {
            return null;
        } else {
            Person p = peopleArray[i];
            for (int j = i; j < nElems - 1; j++) {
                peopleArray[j] = peopleArray[j + 1];
            }
            nElems--;
            return p;
        }
    }

    // searchById(id:String)
    public Person searchById(String id) {
        for (int i = 0; i < nElems; i++) {
            if (peopleArray[i].getId().equals(id)) {
                return peopleArray[i];
            }
        }
        return null;
    }

    // update()
    public void update(Person p, String id) {
        for (int i = 0; i < nElems; i++) {
            if (peopleArray[i].getId().equals(id)) {
                peopleArray[i] = p;

            }
        }
    }

    public void display(){
        for(int i = 0; i < nElems; i++) {
            System.out.println(peopleArray[i]);
        }
        System.out.println();
    }

}