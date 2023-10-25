package org.example;

public class Book {
    //Very very small quibble, but you don't need the word book in front of some of these properties
    //since the class name is book
    public int bookId;
    public String bookIsbn;
    public String bookTitle;
    public boolean isCheckedOut;
    public String checkedOutTo;


    public Book(int bookId, String bookIsbn, String bookTitle, boolean isCheckedOut, String checkedOutTo) {
        this.bookId = bookId;
        this.bookIsbn = bookIsbn;
        this.bookTitle = bookTitle;
        this.isCheckedOut = isCheckedOut;
        this.checkedOutTo = checkedOutTo;
    }

    //You could do the constructor like this for less typing since you know in the beginning it won't be checked out
    //and it's not checked out to anyone
    public Book(int id, String isbn, String title) {
        this.bookId = id;
        this.bookIsbn = isbn;
        this.bookTitle = title;
        this.isCheckedOut = false;
        this.checkedOutTo = "";
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookIsbn() {
        return bookIsbn;
    }

    public void setBookIsbn(String bookIsbn) {
        this.bookIsbn = bookIsbn;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        isCheckedOut = checkedOut;
    }

    public String getCheckedOutTo() {
        return checkedOutTo;
    }

    public void setCheckedOutTo(String checkedOutTo) {
        this.checkedOutTo = checkedOutTo;
    }

    //There was a bug here. Compare my changes to the original code and you'll see why the checked out books
    //never showed in the checked out list
    public void checkOut(String name) {
        if (isCheckedOut == true){
            System.out.println("That book is already checked out");
        }
        else{
            this.isCheckedOut = true;
            this.checkedOutTo = name;
        }

    }

    public String checkIn(){
        if (isCheckedOut == false){
            checkedOutTo = "";
        }
        return checkedOutTo;
    }
}
