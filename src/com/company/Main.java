package com.company;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {

   public static Scanner sc = new Scanner(System.in);
    public static void display() {
        System.out.println(" Welcome To Library System \n Enter 1 : Student \n Enter 2: Manger of Library");
        try {
            int x = sc.nextInt();
            if (x == 1) {
                Student();
            } else  if (x==2){
                Manager();

            }
        } catch (Exception e) {
            System.out.println(" invalid try again !");
            display();
        }
    }
    public static void Student()
    { try {
        System.out.println(" Enter 1 : to Search " +
                "\n Enter 2 : to Borrow" +
                " \n Enter 3 : to Refund " +
                "\n Enter 0 : to Back .");
        int x = sc.nextInt();
        if (x == 1) {
            System.out.println(" Enter 1 : to Search BOOK " +
                    "\n Enter 2 : to Search BOOKLET " +
                    " \n Enter 3 : to Search MAGAZINE ");

            int y = sc.nextInt();
            if (y == 1) {
                OperatinBook.SearchForBook();
                Student();
            } else if (y == 2) {
                OperationOfBooklet.SearchForBooklet();
                Student();
            } else if (y == 3) {
                OperationOfMagazine.SearchForMagazine();
                Student();
            } else {
                Student();
            }
        } else if
        (x == 2) {
            System.out.println(" Enter 1 : to Borrow BOOK " +
                    "\n Enter 2 : to Borrow BOOKLET" +
                    " \n Enter 3 : to Borrow MAGAZINE");
            int z = sc.nextInt();
            if (z == 1) {
                OperatinBook.BorrowBook();
                Student();
            } else if (z == 2) {
                OperationOfBooklet.BorrowBooklet();
                Student();
            } else if (z == 3) {
                OperationOfMagazine.BorrowMagazine();
                Student();

            } else {
                Student();
            }
        } else if (x == 3) {
            System.out.println(" Enter 1 : to Refund BOOK " +
                    "\n Enter 2 : to Refund BOOKLET " +
                    " \n Enter 3 : to Refund MAGAZINE  ");
            int w = sc.nextInt();
            if (w == 1) {
                OperatinBook.RefundBook();
                Student();
            } else if (w == 2) {
                OperationOfBooklet.RefundBooklet();
                Student();
            } else if (w == 3) {
                OperationOfMagazine.RefundMagazine();
                Student();
            } else {
                Student();
            }
        } else {
            display();
        }
    }
    catch (Exception f ){
        System.out.println("invalid !");
        Student();
    }


    }
    public static void Manager(){
   try {     System.out.println(" Enter 1 : to Add  " +
                " \n Enter 2:  to Modify " +
                " \n Enter 3 : to Delete " +
                " \n Enter 4 : to Search" +
                " \n  Enter 5: Display f available publications " +
                "\n Enter 6 : Display borrowed publications " +
                "\n Enter 7 : Display list of over-period borrowed publications " +
                "\n Enter 0 : to Back .");
        int n = sc.nextInt();
        if (n==1){
            System.out.println(" Enter 1 : to Add  BOOK "
                    +" \n Enter 2 : to Add  BOOKLET "
                    +"\n Enter 3 : to Add  MAGAZINE");
            int h=sc.nextInt();
            if (h==1 ){
                OperatinBook.addbook();
                Manager();
            }
            else if (h==2)
            {
                OperationOfBooklet.addBooklet();
                Manager();
            }
            else if( h==3){
                OperationOfMagazine.addMagazine();
                Manager();
            }
            else {
                Manager();

            }

        }
        else if (n==2){
            System.out.println(" Enter 1 : to Modify   BOOK "
                    +" \n Enter 2 : to Modify   BOOKLET "
                    +"\n Enter 3 : to Modify   MAGAZINE");
            int u=sc.nextInt();
            if(u==1){
                OperatinBook.ModifyBook();
                Manager();
            }
            else if(u==2){
                OperationOfBooklet.ModifyBooklet();
                Manager();
            }
            else if (u==3){
                OperationOfMagazine.ModifyMagazine();
                Manager();
            }
            else {
                Manager();
            }

        }
        else if (n==3){

                System.out.println(" Enter 1 : to Delete  BOOK "
                        +" \n Enter 2 : to Delete   BOOKLET "
                        +"\n Enter 3 : to Delete   MAGAZINE");
                int e=sc.nextInt();
                if(e==1){
                 OperatinBook.DeleteBook();
                 Manager();
                }
                else if(e==2){
                  OperationOfBooklet.DeleteBooklet();
                  Manager();
                }
                else if (e==3){
                 OperationOfMagazine.DeleteMagazine();
                   Manager();
                }
                else{
                    Manager();
            }
        }
        else if (n==4){

            System.out.println(" Enter 1 : to Search   BOOK "
                    +" \n Enter 2 : to Search   BOOKLET "
                    +"\n Enter 3 : to Search   MAGAZINE");
            int j=sc.nextInt();
            if(j==1){
               OperatinBook.SearchForBook();
               Manager();
            }
            else if(j==2){
             OperationOfBooklet.SearchForBooklet();
             Manager();
            }
            else if (j==3){
               OperationOfMagazine.SearchForMagazine();
               Manager();
            }
            else {
               Manager();

            }
        }
     else if(n==5){
         System.out.println("The available books ::");
         OperatinBook.DisplayAvailableBook();
            System.out.println("The available booklets ::");
         OperationOfBooklet.DisplayAvailableBooklet();
            System.out.println("The available Magazines ::");
         OperationOfMagazine.DisplayAvailableMagazine();
         Manager();
        }
     else if ( n==6){
            System.out.println("The Borrowed books ::");
            OperatinBook.DisplayBorrowBook();
            System.out.println("The  Borrowed booklets ::");
            OperationOfBooklet.DisplayBorrowBooklet();
            System.out.println("The Borrowed Magazines ::");
            OperationOfMagazine.DisplayBorrowMagazine();
            Manager();
        }
     else if (n ==7){
            System.out.println("The Over_period books ::");
            OperatinBook.DisplayOverPeriodBook();
            System.out.println("The  Over_period booklets ::");
            OperationOfBooklet.DisplayOverPeriodBooklet();
            System.out.println("The Over_period Magazines ::");
            OperationOfMagazine.DisplayOverPeriodMagazine();
            Manager();
        }
     else {
         display();
        }

    }

    catch (Exception e ){
       System.out.println("Invalid !");
       Manager();
   }
    }
    public static void main(String[] args) {

        try {
            display();
        } catch (Exception e) {
            display();
        }
    }
}