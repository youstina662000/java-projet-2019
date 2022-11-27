package com.company;


public abstract  class Publication {

    private String name;
    private int id;
    private double price;

    private int  numbofcopies;

    public Publication() {
    }

    public Publication (String name, int id, double price, int nc){
        this. name = name;
        this.id=id;
        this. price=price;

        numbofcopies=nc;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public int getNumbofcopies() {
        return numbofcopies;
    }

    public void setNumbofcopies(int numbofcopies) {
        this.numbofcopies = numbofcopies;
    }

    public void borrowing(){
        numbofcopies--;
    }
    public void refund(){
        numbofcopies++;
    }


}

