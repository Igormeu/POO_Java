/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package myworkspace.main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import java.sql.DriverManager;

import java.sql.Connection;

import java.sql.ResultSet;

import java.sql.Statement;

import java.sql.PreparedStatement;

import java.sql.SQLException;

/**
 *
 * @author Administrador
 */
public class Main {

    public static void main(String[] args) {
        banco cursor = new banco ();
        cursor.openConnection();
                        
                     
 
        JFrame window = new JFrame("Cadastrar Produtos");
        
        JPanel conteiner = new JPanel ();
        
        conteiner.setLayout(null);
        
        //Conf Elementos
        
        JLabel title = new JLabel ("Sistema de cadastro de produtos");
        title.setFont(new Font("Arial",Font.PLAIN,14));
        title.setBounds(10,10,400,20); //x,y,largura,altura
        conteiner.add(title);
        
        JLabel label_name = new JLabel ("Nome: ");
        label_name.setFont(new Font("Arial",Font.PLAIN,12));
        label_name.setBounds(10,50,80,20);
        conteiner.add(label_name);
        
        TextField name = new TextField(500);
        name.setFont(new Font("Arial",Font.PLAIN,12));
        name.setBounds(90,50,400,20);
        conteiner.add(name);
        
        JLabel label_price = new JLabel ("Preco: ");
        label_price.setFont(new Font("Arial",Font.PLAIN,12));
        label_price.setBounds(10,90,80,20);
        conteiner.add(label_price);
        
        TextField price = new TextField(500);
        price.setFont(new Font("Arial",Font.PLAIN,12));
        price.setBounds(90,90,400,20);
        conteiner.add(price);
        
        JLabel label_amount = new JLabel ("Quantidade: ");
        label_amount.setFont(new Font("Arial",Font.PLAIN,12));
        label_amount.setBounds(10,130,80,20);
        conteiner.add(label_amount);
        
        TextField amount = new TextField(500);
        amount.setFont(new Font("Arial",Font.PLAIN,12));
        amount.setBounds(90,130,400,20);
        conteiner.add(amount);
        
        //Label Auxiliar
        JLabel label_auxiliar = new JLabel ();
        label_auxiliar.setFont(new Font("Arial",Font.PLAIN,12));
        label_auxiliar.setBounds(620,50,80,20);
        conteiner.add(label_auxiliar);
        
        TextField aux = new TextField(500);
        aux.setFont(new Font("Arial",Font.PLAIN,12));
        aux.setBounds(700,50,200,20);
        aux.setVisible(false);
        conteiner.add(aux);
        
        //Label Auxiliar2
        JLabel label_auxiliar2 = new JLabel ();
        label_auxiliar2.setFont(new Font("Arial",Font.PLAIN,12));
        label_auxiliar2.setBounds(620,90,80,20);
        conteiner.add(label_auxiliar2);
        
        TextField aux2 = new TextField(500);
        aux2.setFont(new Font("Arial",Font.PLAIN,12));
        aux2.setBounds(700,90,200,20);
        aux2.setVisible(false);
        conteiner.add(aux2);
        
        
        //Alert
        JLabel alert = new JLabel ();
        alert.setFont(new Font("Arial",Font.PLAIN,12));
        alert.setBounds(10,170,400,20);
        conteiner.add(alert);
        
        
        JButton button =new JButton("Cadastrar Produto");
        button.setFont(new Font("Arial",Font.PLAIN,12));
        button.setBounds(120,200,150,40);
        conteiner.add(button);
        
        JButton button2 =new JButton("Limpar exibição");
        button2.setFont(new Font("Arial",Font.PLAIN,12));
        button2.setBounds(280,200,150,40);
        conteiner.add(button2);
        
        JButton button3 =new JButton();
        button3.setText("<html>Listar itens<br>cadastrados</html>");
        button3.setFont(new Font("Arial",Font.PLAIN,12));
        button3.setBounds(440,200,150,40);
        conteiner.add(button3);
        
        JButton button4 =new JButton("Atualizar Produto");
        button4.setFont(new Font("Arial",Font.PLAIN,12));
        button4.setBounds(600,200,150,40);
        conteiner.add(button4);
        
        JButton button5 =new JButton("Deletar Produto");
        button5.setFont(new Font("Arial",Font.PLAIN,12));
        button5.setBounds(760,200,150,40);
        conteiner.add(button5);
        
        TextField display = new TextField(10000);
        display.setFont(new Font("Arial",Font.PLAIN,12));
        display.setBounds(440,300,400,400);
        conteiner.add(display); 
        
        //ArrayList<Products> lista = new ArrayList<>(); - ArrayList
        
        
        //Inserir
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                
     
                String name_input = name.getText();
                String price_input = price.getText();
                String amount_input = amount.getText();
                
                
                
                try{
                    float convet_price = Float.parseFloat(price_input);
                    int convet_amount = Integer.parseInt(amount_input);
                     
                    Products p = new Products (name_input,convet_price,convet_amount);
                    
                    if (!p.getName().isBlank()){
                        cursor.insertDate(name_input, convet_price, convet_amount);
                        
                        alert.setText("Cadastro realizado com sucesso!");
                        alert.setForeground(Color.GREEN);
//                        
                        name.setText("");
                        price.setText("");
                        amount.setText("");
                    }
                    else{
                        alert.setText("Os valores não são validos!");
                        alert.setForeground(Color.YELLOW);
                    }
     
                }
                catch(Exception error){
                    alert.setText("Erro interno!");
                    alert.setForeground(Color.RED);
                }

            }
        });
        
        //Limpar Campos
        button2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                name.setText("");
                price.setText("");
                amount.setText("");
                display.setText("");               
                //botao.setBackground(Color.BLUE);
                Graphics editor=conteiner.getGraphics();
                //desenhar(editor);
            }
        });
        
        //Listar
        button3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                
                String elementos = cursor.selectDate();

                display.setText(elementos);

            }
        });
        
        //Update
        button4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                
                //Receber escolha, id e new value e atualizar
                label_auxiliar.setText("ID: ");
                aux.setVisible(true);
                
                label_auxiliar2.setText("Escolha: ");
                aux2.setVisible(true);
                
                String id = aux.getText();
                String escolha = aux2.getText();
                String dado = "";
                
                int convert_escolha = Integer.parseInt(escolha);
                
                // Variáveis para armazenar os dados convertidos

                switch (convert_escolha) {
                    case 1:
                        // Quando escolha for 1, obtém o texto do campo 'name' como String
                        dado = name.getText();  // Texto do campo name
                        cursor.updateDate(convert_escolha,Integer.parseInt(id) ,dado);
                        System.out.println("Nome: " + dado);
                        break;

                    case 2:
                        dado = price.getText();  // Texto do campo price
               
                        cursor.updateDate(convert_escolha,Integer.parseInt(id) ,dado);
                        System.out.println("Preço: " + price);

                        break;

                    case 3:
                        dado = amount.getText();  // Texto do campo amount
                        
                        cursor.updateDate(convert_escolha,Integer.parseInt(id) ,dado);
                        System.out.println("Quantidade: " + amount);

                        break;

                    default:
                        System.out.println("Escolha inválida.");
                        break;
                    }
                }
        });
        
        //delete
        button5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                
                //Receber id e deletar

            }
        });
        
        //Conf Finais
        
        window.add(conteiner);
        
        window.setSize(1000,1000);
        
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //If a operação ocorrer faça cursor.closeConnection()
    }

    }
