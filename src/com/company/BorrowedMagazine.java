package com.company;

import java.util.Date;

public class BorrowedMagazine {
    private int t1;
    String StudentName;
    String MagazineName;



    public BorrowedMagazine( String studentName, String MagazineName,int d,int m,int y) {
        StudentName = studentName;
       this. MagazineName = MagazineName;
        Date BorrowDate=new Date(d,m,y);
        t1= (int) BorrowDate.getTime();
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public String getMagazineName() {
        return MagazineName;
    }

    public void setMagazineName(String magazineName) {
        MagazineName = magazineName;
    }

    public int GetDate()
    {

        return t1/(1000*24*60*60);


    }

 public String toString (){
        return MagazineName +" , "+ StudentName;
 }

}
