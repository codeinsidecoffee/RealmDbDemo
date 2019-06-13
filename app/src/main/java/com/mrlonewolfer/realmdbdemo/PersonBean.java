package com.mrlonewolfer.realmdbdemo;


import androidx.annotation.NonNull;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class PersonBean extends RealmObject {
//    public PersonBean(String firstName, String lastName) {
//        this.id =MyApplication.id.incrementAndGet() ;
//        this.firstName = firstName;
//        this.lastName = lastName;
//    }

    @PrimaryKey
    private  int id;

    private String firstName,lastName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @NonNull
    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
