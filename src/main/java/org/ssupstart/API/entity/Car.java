package org.ssupstart.API.entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Car {
    private int id;
    private String name;
    private String company;

    public Car(int id, String name, String company) {
        this.id = id;
        this.name = name;
        this.company = company;
    }
}
