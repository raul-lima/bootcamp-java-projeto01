package br.com.alura.bootcamp.projeto01.factory;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {


    public Connection getConnection() throws ClassNotFoundException {
        try {
            String url = "jdbc:mysql://localhost:3306/livraria?useTimezone=true&serverTimezone=UTC";
            String usuario = "root";
            String senha = "root";


            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conexao = DriverManager.getConnection(url, usuario, senha);

            return conexao;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ocorreu um erro!");
            throw new RuntimeException(e);
        }
    }

}
