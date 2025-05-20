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
    private Double price;
    private int amount;

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }
    
    public void setName(String name) {
        try{
            if (!(name.length() < 1)){
               this.name = name; 
            }
            
        }
        catch (Exception e){
            System.out.println("Não foi possível definir " + name + " como o nome do produto");
        
        }
        
    }
    
    public void setPrice(Double price) {
        try{
            if (price >= 0){
                this.price = price;
            }
            
        }
        catch(Exception e){
            System.out.println("Não foi possível definir " + price + " como o preço do produto");
        }
        
    }

    public void setAmount(int amount) {
        try{
            if (amount >= 0){
                this.amount = amount;
            }
            
        }
        catch(Exception e){
            System.out.println("Não foi possível definir " + amount + " como a quantidade do produto");
        }
    }
    
    public String returnItens (){
        String itens = ""+this.getName()+this.getAmount()+this.getPrice();
        return itens;
    
    }

    
    
    
    
}
