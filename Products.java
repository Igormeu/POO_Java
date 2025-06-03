/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myworkspace.main;

import java.util.*;

/**
 *
 * @author Administrador
 */
public class Products {
    private String name;
    private double price;
    private int amount;

    Products (){
    
    }
    
    Products (String name, double price, int amount){
        
        if(this.cadastrar_produto(name, price, amount)== 7){
            this.name = name;
            this.price = price;
            this.amount = amount;
        }
        else {
            this.name = null;
            this.price = -1;
            this.amount = -1;
        
        }
    
    
    }
    
    int cadastrar_produto (String name, double price, int amount){
        int validation = 0;
        
        if (!name.isEmpty()){
            validation += 1;
        }
        if (price >= 0){
            validation += 2;
        }
        if (amount >= 0){
            validation += 4;
        }
        
        return validation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    
    
    
    
    
}
