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
        
        TextField display = new TextField(10000);
        display.setFont(new Font("Arial",Font.PLAIN,12));
        display.setBounds(440,300,400,400);
        conteiner.add(display); 
        
        String [] name_array;
        int [] amount_array;
        double [] price_array;
        
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                display.setText("Voce digitou "+ name.getText());               
                //botao.setBackground(Color.BLUE);
                Graphics editor=conteiner.getGraphics();
                //desenhar(editor);
            }
        });
        
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
        
        //Conf Finais
        
        window.add(conteiner);
        
        window.setSize(1000,1000);
        
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    }
