package com.example.csvdatatodb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private long userId;
    private String namePrefix;
    private String firstName;
    private String lastName;
}
