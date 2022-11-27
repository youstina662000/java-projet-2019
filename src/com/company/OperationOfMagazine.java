package com.company;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class OperationOfMagazine {

    static ArrayList<Magazine> magazines = new ArrayList<Magazine>();
    static ArrayList<BorrowedMagazine> borrowedMagazines=new ArrayList<BorrowedMagazine>();
    static ArrayList<String> OverPeriodMagazine=new ArrayList<String>();
    static Payment payment=new Payment();

    static  Scanner sc = Main.sc;
    public  static void addMagazine() {
        System.out.println(" \nEnter name ");

        String name = sc.next().toLowerCase();
        System.out.println("\n Enter Id ");
        int id = sc.nextInt();
        System.out.println("\nEnter Price  ");
        double price = sc.nextDouble();
        System.out.println("\nEnter NumberOfCopies   ");
        int numberofcope = sc.nextInt();

        Magazine m= new Magazine(name, id, price, numberofcope);
        magazines .add(m);
    }


    public static  void ModifyMagazine (){
        System.out.println("enter 1 to modify price \n  " +
                "2 to modify name \n " +
                "3 to modify id\n " +
                "4 to modify number of copies ");
        int r = sc.nextInt();

        if (r==1) {
            System.out.println("enter the name of the magazine  you want to modify");
            String x = sc.next().toLowerCase();

            for (int i = 0; i < magazines.size(); i++) {
                Magazine c = magazines.get(i);
                if (c.getName().equals(x)) {
                    System.out.println("enter the modified price");
                    double P = sc.nextDouble();
                    c.setPrice(P);
                    System.out.println("done ");

                    break;

                }
            }
        }
        if (r==2){
            System.out.println("enter the name of the magazine you want to modify");
            String y = sc.next().toLowerCase();

            for (int i = 0; i < magazines.size(); i++) {
                Magazine c = magazines.get(i);
                if (c.getName().equals(y)) {
                    System.out.println("enter the modified name");
                    String P = sc.next();
                    c.setName(P);
                    System.out.println("done ");

                    break;
                }
            }}
        if(r==3) {
            System.out.println("enter the name of the magazine  you want to modify");
            String w = sc.next().toLowerCase();

            for (int i = 0; i < magazines.size(); i++) {
                Magazine c = magazines.get(i);
                if (c.getName().equals(w)) {
                    System.out.println("enter the modified ID");
                    int P = sc.nextInt();
                    c.setId(P);
                    System.out.println("done ");

                    break;
                }
            }
        }


        if (r==4) {
            System.out.println("enter the name of the magazine you want to modify");
            String o = sc.next().toLowerCase();

            for (int i = 0; i < magazines.size(); i++) {
                Magazine c = magazines.get(i);
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

    public  static void DeleteMagazine() {
        System.out.println("enter the name of the magazine you want to delete");
        String x = sc.next().toLowerCase();

        for (int i = 0; i < magazines.size(); i++) {
            Magazine c = magazines.get(i);
            if (c.getName().equals(x))
            {
                magazines.remove(i);
                break;

            }
        }
    }

    public static void SearchForMagazine ()
    {
        System.out.println("enter the name of the magazine ");
        String x = sc.next().toLowerCase();
        boolean exist =false;
        for (int i = 0; i < magazines.size(); i++)
        {
            Magazine c = magazines.get(i);
            if (c.getName().equals(x))
            {

                exist =true;
                break;
            }
        }
        if(exist==false)
            System.out.println("It's NOT available");
        else
            System.out.println("It's available");

    }

    public static void BorrowMagazine(){

        System.out.println("enter your name");
        String a=sc.next();
        System.out.println("enter the name of the magazines you want to borrow");
        String x=sc.next();
        System.out.println("enter the date of issue ");
        int d1=sc.nextInt();
        int m1=sc.nextInt();
        int y1=sc.nextInt();
        y1-=1900;

        for (int i = 0; i < magazines.size(); i++) {
            Magazine c = magazines.get(i);
            if (c.getName().equals(x)) {
                if (c.getNumbofcopies()>1){
                    c.borrowing();

                    BorrowedMagazine z=new BorrowedMagazine(a,x,d1,m1,y1);
                    borrowedMagazines.add(z);
                    payment.TotalBorrowingCash+=payment.BorrowingPrice;
                }
            }
            else
                System.out.println("it's not exist");
        }

    }



    public static void  DisplayAvailableMagazine()
    {
        for (int i=0;i<magazines.size();i++){
            Magazine a=magazines.get(i);
            System.out.println(a.getName());
        }
    }

    public static void RefundMagazine()
    {
        int v;
        System.out.println("enter your name");
        String a=sc.next().toLowerCase();
        System.out.println("enter the name of the booklet you want to refund");
        String x=sc.next().toLowerCase();
        System.out.println("enter the date of return ");
        int d2=sc.nextInt();
        int m2=sc.nextInt();
        int y2=sc.nextInt();
        y2-=1900;
        for (int i=0;i<borrowedMagazines.size();i++) {
            BorrowedMagazine b = borrowedMagazines.get(i);
            if (b.getMagazineName().equals(x)) {
                Date RefundDate = new Date(d2, m2, y2);
                int t2 = (int) RefundDate.getTime();
                t2 = t2 / (1000 * 24 * 60 * 60);
                int diff = t2 - b.GetDate();
                if (diff > 20) {
                    System.out.println("you have been late to return back the magazine ,you should pay extra 25.00 L.E ");
                    OverPeriodMagazine.add(x);
                    payment.TotalFine += payment.fine;
                }
                borrowedMagazines.remove(i);
            }
            for (int j = 0; j < magazines.size(); j++) {
                Magazine g = magazines.get(j);
                if (g.getName().equals(x)) {
                    g.refund();
                }
            }
        }
    }
    public static void DisplayBorrowMagazine(){
        for (int i=0;i<borrowedMagazines.size();i++){
            System.out.println(borrowedMagazines.toString()); //override toString
        }
    }

    public static void DisplayOverPeriodMagazine(){
        for (int i=0;i<OverPeriodMagazine.size();i++)
        {
            System.out.println(OverPeriodMagazine.toString());
        }
    }


}
