package com.pablovass.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class JsonData {
    private int id;
    private String name;
    private String username;
    private String email;
    // Otros campos y getters y setters
}