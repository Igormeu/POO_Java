/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package myworkspace.main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Administrador
 */
public class Main {

    public static void main(String[] args) {
        JFrame window = new JFrame("Cadastrar Produtos");
        
        JPanel conteiner = new JPanel ();
        
        conteiner.setLayout(null);
        
        //Conf Elementos
        
        JLabel title = new JLabel ("Sistema de cadastro de produtos");
        title.setFont(new Font("Arial",Font.PLAIN,24));
        conteiner.add(title);
        
        JLabel label_name = new JLabel ("Nome: ");
        label_name.setFont(new Font("Arial",Font.PLAIN,16));
        conteiner.add(label_name);
        
        TextField name = new TextField(500);
        name.setFont(new Font("Arial",Font.PLAIN,12));
        conteiner.add(name);
        
        JLabel label_price = new JLabel ("Preco: ");
        label_price.setFont(new Font("Arial",Font.PLAIN,16));
        conteiner.add(label_price);
        
        TextField price = new TextField(500);
        price.setFont(new Font("Arial",Font.PLAIN,12));
        conteiner.add(price);
        
        JLabel label_amount = new JLabel ("Quantidade: ");
        label_amount.setFont(new Font("Arial",Font.PLAIN,16));
        conteiner.add(label_amount);
        
        TextField amount = new TextField(500);
        amount.setFont(new Font("Arial",Font.PLAIN,12));
        conteiner.add(amount);
        
        //Conf Finais
        
        window.add(conteiner);
        
        window.setSize(1000,1000);
        
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    }
