package br.com.alura.bootcamp.projeto01.servlet;

import br.com.alura.bootcamp.projeto01.dao.AutorDao;
import br.com.alura.bootcamp.projeto01.factory.ConnectionFactory;
import br.com.alura.bootcamp.projeto01.models.Autor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet("/autores")
public class AutoresServlet extends HttpServlet {

    private AutorDao dao;

    public AutoresServlet() throws ClassNotFoundException {

        this.dao = new AutorDao(new ConnectionFactory().getConnection());

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("autores", dao.listar());

        req.getRequestDispatcher("WEB-INF/jsp/autores.jsp").forward(req, resp);
    }

    // O botão de gravar vai mandar uma requisição do tipo post, o que redireciona para o método doPost
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String nome = req.getParameter("nome");
        String email = req.getParameter("email");
        LocalDate dataNascimento = LocalDate.parse(req.getParameter("dataNascimento"), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String miniCurriculo = req.getParameter("miniCurriculo");

        Autor autor = new Autor(nome, email, dataNascimento, miniCurriculo);

        dao.cadastrar(autor);

        // Faz uma requisição get. Ou seja, redireciona pro método doGet deste servlet

        resp.sendRedirect("autores");
    }


}
