package com.company;

import java.util.Date;

public class BorrowedBooklet {
    private int t1;
    String StudentName;
    String BookletName;


    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }




    public String getBookletName() {
        return BookletName;
    }

    public void setBookletName(String bookletName) {
        BookletName = bookletName;
    }

    public BorrowedBooklet( String studentName, String bookletName,int d,int m,int y) {
        StudentName = studentName;
        BookletName = bookletName;
        Date BorrowDate=new Date(d,m,y);
        t1= (int) BorrowDate.getTime();
        //long fel date
    }


    public int GetDate()
    {

        return t1/(1000*24*60*60);


    }
    public String toString(){
        return BookletName +" , " + StudentName ;
    }



}
