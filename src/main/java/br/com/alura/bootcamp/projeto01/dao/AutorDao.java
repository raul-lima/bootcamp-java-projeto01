package br.com.alura.bootcamp.projeto01.dao;

import br.com.alura.bootcamp.projeto01.models.Autor;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AutorDao {

    private Connection conexao;

    public AutorDao(Connection conexao) {
        this.conexao = conexao;
    }

    public void cadastrar(Autor autor) {
        try {

            String sql = "insert into autores(nome, email, data_de_nascimento, mini_curriculo) values (?, ?, ?, ?)";

            PreparedStatement ps = conexao.prepareStatement(sql);

            ps.setString(1, autor.getNome());
            ps.setString(2, autor.getEmail());
            ps.setDate(3, Date.valueOf(autor.getDataNascimento()));
            ps.setString(4, autor.getMiniCurriculo());

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao conectar ao MySQL");
        }
    }

    public List<Autor> listar() {

        try {

            String sql = "select * from autores";

            PreparedStatement ps = conexao.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            List<Autor> autores = new ArrayList<>();

            while (rs.next()) {

                Autor autor = new Autor();

                autor.setNome(rs.getString("nome"));
                autor.setEmail(rs.getString("email"));
                autor.setDataNascimento(rs.getObject("data_de_nascimento", LocalDate.class));
                autor.setMiniCurriculo(rs.getString("mini_curriculo"));

                autores.add(autor);

            }

            return autores;


        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
