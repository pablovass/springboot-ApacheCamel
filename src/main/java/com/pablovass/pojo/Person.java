package com.pablovass.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Person {
private String name;
private Integer age;

/*
* lombok ya me sobreescribe el metodo toString*/

}
