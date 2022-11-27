package com.company;

import java.util.Date;

public class BorrowedBook  {

    private int t1;
String StudentName;
    String BookName;


    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }




    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public BorrowedBook( String studentName, String bookName,int d,int m,int y) {
        StudentName = studentName;
        BookName = bookName;
        Date BorrowDate=new Date(d,m,y);
         t1= (int) BorrowDate.getTime();
    }


    public int GetDate()
    {

        return t1/(1000*24*60*60);


    }
    public String toString(){
        return BookName +" , " + StudentName ;
    }


}
