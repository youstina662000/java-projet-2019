package com.company;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class OperatinBook  {
  public  static Scanner sc = Main.sc;
    static ArrayList<Book> books = new ArrayList<Book>();
   static ArrayList<BorrowedBook> borrowedBooks=new ArrayList<BorrowedBook>();
   static ArrayList<String> OverPeriod=new ArrayList<String>();
static Payment payment=new Payment();
    public static void addbook() {
        System.out.println(" \nEnter name ");
        String name = sc.next().toLowerCase();
        System.out.println("\n Enter Id ");
        int id = sc.nextInt();
        System.out.println("\nEnter Price  ");
        double price = sc.nextDouble();
        payment.TotalCash=payment.TotalCash-price;
        System.out.println("\nEnter NumberOfCopies   ");
        int numberofcope = sc.nextInt();
        Book b = new Book(name, id, price, numberofcope);
        books.add(b);
    }

    public static void ModifyBook() {
        System.out.println("enter 1 to modify price \n  " +
                "2 to modify name \n " +
                "3 to modify id\n " +
                "4 to modify number of copies ");
        int h = sc.nextInt();

            if (h==1) {
                System.out.println("enter the name of the book you want to modify");
                String x = sc.next().toLowerCase();

                for (int i = 0; i < books.size(); i++) {
                    Book c = books.get(i);
                    if (c.getName().equals(x)) {
                        System.out.println("enter the modified price");
                        double P = sc.nextDouble();
                        c.setPrice(P);
                        System.out.println("done ");

                        break;

                    }
                }
            }
            if (h==2){
                System.out.println("enter the name of the book you want to modify");
                String y = sc.next().toLowerCase();

                for (int i = 0; i < books.size(); i++) {
                    Book c = books.get(i);
                    if (c.getName().equals(y)) {
                        System.out.println("enter the modified name");
                        String P = sc.nextLine();
                        c.setName(P);
                        System.out.println("done ");

                        break;
                    }
                }}
            if(h==3) {
                System.out.println("enter the name of the book you want to modify");
                String w = sc.next().toLowerCase();

                for (int i = 0; i < books.size(); i++) {
                    Book c = books.get(i);
                    if (c.getName().equals(w)) {
                        System.out.println("enter the modified ID");
                        int P = sc.nextInt();
                        c.setId(P);
                        System.out.println("done ");

                        break;
                    }
                }
            }


            if (h==4) {
                System.out.println("enter the name of the book you want to modify");
                String o = sc.next().toLowerCase();

                for (int i = 0; i < books.size(); i++) {
                    Book c = books.get(i);
                    if (c.getName().equals(o)) {
                        System.out.println("enter the modified NumberOfCopies");
                        int P = sc.nextInt();
                        c.setNumbofcopies(P);
                        System.out.println("done ");

                        break;
                    }
                }

            }

            }

    public static void DeleteBook() {
        System.out.println("enter the name of the book you want to delete");
        String x = sc.next().toLowerCase();

        for (int i = 0; i < books.size(); i++) {
            Book c = books.get(i);
            if (c.getName().equals(x)) {
                books.remove(i);
                break;

            }
        }
    }

    public static void SearchForBook() {
        System.out.println("enter the name of the book ");
        String x = sc.next().toLowerCase();
        boolean exist = false;
        for (int i = 0; i < books.size(); i++) {
            Book c = books.get(i);
            if (c.getName().contains(x)) {
                exist = true;
                break;
            }
        }
        if(!exist)
            System.out.println("It's NOT available");
        else
            System.out.println("It's available");

    }

public static void BorrowBook(){

        System.out.println("enter your name");
        String a=sc.next();
        System.out.println("enter the name of the book you want to borrow");
        String x=sc.next();
        System.out.println("enter the date of issue ");
        int d1=sc.nextInt();
    int m1=sc.nextInt();
    int y1=sc.nextInt();
    y1-=1900;

    for (int i = 0; i < books.size(); i++) {
        Book c = books.get(i);
        if (c.getName().equals(x)) {
            if (c.getNumbofcopies()>1){
                c.borrowing();
                
                BorrowedBook z=new BorrowedBook(a,x,d1,m1,y1);
                borrowedBooks.add(z);
                payment.TotalBorrowingCash+=payment.BorrowingPrice;
            }
        }
        else
            System.out.println("it's not exist");
    }

}

 public static void  DisplayAvailableBook()
{
    for (int i=0;i<books.size();i++){
        Book a=books.get(i);
    System.out.println(a.getName());
}
}

public static void RefundBook()
{
    

    int v;
    System.out.println("enter your name");
    String a=sc.next().toLowerCase();


    System.out.println("enter the name of the book you want to refund");
    String x=sc.next().toLowerCase();
    System.out.println("enter the date of return ");
    int d2=sc.nextInt();
    int m2=sc.nextInt();
    int y2=sc.nextInt();
    y2-=1900;
for (int i=0;i<borrowedBooks.size();i++)
{
    BorrowedBook b=borrowedBooks.get(i);
if(b.getBookName().equals(x)) {
    Date RefundDate = new Date(d2, m2, y2);
    int t2 = (int) RefundDate.getTime();
    t2 = t2 / (1000 * 24 * 60 * 60);
    int diff = t2 - b.GetDate();
    if (diff > 20) {
        System.out.println("you have been late to return back the book ,you should pay extra 25.00 L.E ");
        OverPeriod.add(x);
        payment.TotalFine += payment.fine;

    }
    borrowedBooks.remove(i);
}
    for (int j=0;j<books.size();j++)
    {
    Book g=books.get(j);
    if(g.getName().equals(x)){
        g.refund();
    }
    }

}


}
    public static void DisplayBorrowBook(){
        for (int i=0;i<borrowedBooks.size();i++){
            System.out.println(borrowedBooks.toString()); //override toString
        }
    }
public static void DisplayOverPeriodBook(){
        for (int i=0;i<OverPeriod.size();i++)
        {
            System.out.println(OverPeriod.toString());
        }
}
    
}