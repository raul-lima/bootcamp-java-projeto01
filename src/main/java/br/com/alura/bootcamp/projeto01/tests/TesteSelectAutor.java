package br.com.alura.bootcamp.projeto01.tests;

import br.com.alura.bootcamp.projeto01.dao.AutorDao;
import br.com.alura.bootcamp.projeto01.models.Autor;

import java.sql.*;
import java.util.List;

public class TesteSelectAutor {

    public static void main(String[] args) {


        try {

            String url = "jdbc:mysql://localhost:3306/livraria?useTimezone=true&serverTimezone=UTC";
            String usuario = "root";
            String senha = "root";

            Connection conexao = DriverManager.getConnection(url, usuario, senha);

            AutorDao dao = new AutorDao(conexao);

            List<Autor> autores = dao.listar();

            autores.forEach(System.out::println);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ocorreu um erro");
        }


    }
}
