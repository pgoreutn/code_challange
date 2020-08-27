package com.code.challange.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Account {
    private String id;
    private String accountNumber;
    private Double balance;
    private String user;
}
