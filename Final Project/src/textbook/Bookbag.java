package textbook;

/**
 * Created by dalob on 4/5/2017.
 */
public class Bookbag implements Serializable {
    private Textbook[] bookArray;
    private int nElems;

    public Bookbag(int maxSize){
        bookArray = new Textbook[maxSize];
        nElems = 0;
    }


    public void add(Textbook textbook) {
        bookArray[nElems] = textbook;
        nElems++;

    }


    public Textbook removeByBookISBN(String isbn) {
        int i;
        for (i = 0; i < nElems; i++) {
            if (bookArray[i].getBookISBN().equals(isbn)) {
                break;
            }
        }
        if (i == nElems) {
            return null;
        } else {
            Textbook t = bookArray[i];
            for (int j = i; j < nElems - 1; j++) {
                bookArray[j] = bookArray[j + 1];
            }
            nElems--;
            return t;
        }
    }

    // searchById(id:String)
    public Textbook searchByISBN(String isbn) {
        for (int i = 0; i < nElems; i++) {
            if (bookArray[i].getBookISBN().equals(isbn)) {
                return bookArray[i];
            }
        }
        return null;
    }

    // update()
    public void update(Textbook t, String id) {
        for (int i = 0; i < nElems; i++) {
            if (bookArray[i].getBookISBN().equals(id)) {
                bookArray[i] = t;

            }
        }
    }

}
