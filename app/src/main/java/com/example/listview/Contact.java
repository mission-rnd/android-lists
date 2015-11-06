package com.example.listview;

/**
 * Created by KH1731 on 04-11-2015.
 */
public class Contact {

    public String FirstName;
    public String LastName;
    public String FullName;
    public String Company;
    public String College;

    public Contact(String firstName, String lastName, String company, String college){
        this.FirstName = firstName;
        this.LastName = lastName;
        this.College = college;
        this.Company = company;
        this.FullName = LastName + "," + FirstName;

    }
    @Override
    public String toString(){
        return this.FullName;

    };
};



