/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myworkspace.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author 202403930111
 */
public class banco {
        //Banco dados
        private String URL = "jdbc:postgresql://localhost:5432/postgres";
        private String USER = "postgres";//usuario
        private String PASSWORD = "Estacio@123";//senha
        private Connection conn = null;
        
        //Funcao, testar funcionabilidade
        int openConnection (){
            try{
            // Estabelecendo a conexão
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            if (conn != null) {
                System.out.println("Conexão aberta com sucesso");
                return 1; 
                
            } else {
                System.out.println("Falha ao abrir a conexão");
                return 0;
            }
            }catch (SQLException e) {
                return 0;
            
            } 
            
        }
        int closeConnection (){
            try {
                // Fechar a conexão se ela foi aberta
                if (conn != null) {
                    conn.close();
                    return 1;
                }
            } catch (SQLException ex) {         
                return 0;
                
                }
            return 999;
        }
 
        

        void insertDate (String name, float price, int amount){
           try  {
                    String INSERIR="INSERT INTO produtos (name,price,amount) VALUES (?,?,?)";
                    PreparedStatement pstmt = conn.prepareStatement(INSERIR);
                    pstmt.setString(1, name);//primeiro campo
                    pstmt.setFloat(2,price);//segundo campo
                    pstmt.setInt(3, amount);//terceiro campo
                    int rowsInserted = pstmt.executeUpdate();
                    System.out.println("Linhas inseridas: " + rowsInserted);
        } catch (SQLException e) {
                    System.out.println("Erro ao tentar inserir : " + e);
        }

        
        }
        
        String selectDate (){
            String CONSULTA = "SELECT id, name, price, amount FROM produtos";
            StringBuilder result = new StringBuilder();


            try  {
                        Statement stmt = conn.createStatement();
                        ResultSet rs = stmt.executeQuery(CONSULTA);
                        while (rs.next()) {//enquanto a tabela possuir registros
                            int id = rs.getInt("id");
                            String name = rs.getString("name");
                            float price = rs.getFloat("price");
                            int amount = rs.getInt("amount");
                            //Exibir linha

                             result.append("ID: ").append(id)
                                .append(", Nome: ").append(name)
                                .append(", Preço: ").append(price)
                                .append(", Quantidade: ").append(amount)
                                .append("\n\n");
                        }
                        return result.toString();
            } catch (SQLException e) {
                        System.out.println("Ocorreu algum erro na consulta");
                        return result.toString();
            }
        }

     
        int updateDate (int escolha, int id,String dado){
            String UPDATE_NAME = "UPDATE produtos SET name = ? WHERE id = ?";
            String UPDATE_PRICE = "UPDATE produtos SET price = ? WHERE id = ?";
            String UPDATE_AMOUNT = "UPDATE produtos SET amount = ? WHERE id = ?";

                try  {
                    PreparedStatement pstmt = null;
                    
                    if (escolha == 1){
                        pstmt = conn.prepareStatement(UPDATE_NAME);

                        pstmt.setInt(2, id);  // Novo telefone
                        pstmt.setString(1, dado);  // ID do contato a ser atualizado (supondo que seja o ID 1)
                    }

                    else if (escolha == 2){
                         pstmt = conn.prepareStatement(UPDATE_PRICE);

                        pstmt.setInt(2, id);  // Novo telefone
                        pstmt.setFloat(1, Float.parseFloat(dado)); // ID do contato a ser atualizado (supondo que seja o ID 1)

                    }

                    else if (escolha == 3){
                        pstmt = conn.prepareStatement(UPDATE_AMOUNT);

                        pstmt.setInt(2, id);  // Novo telefone
                        pstmt.setInt(1, Integer.parseInt(dado)); // ID do contato a ser atualizado (supondo que seja o ID 1)

                    }
                    
                    int rowsUpdated = pstmt.executeUpdate();
                    return rowsUpdated;
                    
                } catch (SQLException e) {
                    System.out.println("Erro ao tentar atualizar |" + e);
                    return 0;
                }
                catch(NumberFormatException e){
                    System.out.println("Dado invalido | " + e);
                    return 0;
                }
        }
        
        int deleteDate (int id){
            String DELETE = "DELETE FROM produtos WHERE id = ?";
            
                try {
                    PreparedStatement pstmt = conn.prepareStatement(DELETE);
                    pstmt.setInt(1,id);  // ID do contato a ser excluído (supondo que seja o ID 1)

                    int rowsDeleted = pstmt.executeUpdate();
                    return rowsDeleted;
                } catch (SQLException e) {
                    return 0;
                }
        }
             
}
