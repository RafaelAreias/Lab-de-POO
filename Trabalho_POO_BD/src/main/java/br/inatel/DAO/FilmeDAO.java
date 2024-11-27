package br.inatel.DAO;

import br.inatel.Model.Filme;

import java.sql.SQLException;
import java.util.ArrayList;

public class FilmeDAO extends ConnectionDAO implements OperacoesCRUD<Filme> {

    public void testConnection() {
        connectToDb();
    }

    @Override
    public boolean insert(Filme filme) {
        connectToDb();

        boolean sucesso;
        String sql = "INSERT INTO Filme (titulo, duracao, classificacao) VALUES (?, ?, ?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, filme.getTitulo());
            pst.setInt(2, filme.getDuracao());
            if (filme.getClassificacao() != null) {
                pst.setInt(3, filme.getClassificacao());
            } else {
                pst.setNull(3, java.sql.Types.INTEGER); // Tratar a classificação como null, se for o caso
            }
            pst.execute();
            sucesso = true;
        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }

    @Override
    public boolean update(int id, Filme filme) {
        connectToDb();

        boolean sucesso;
        String sql = "UPDATE Filme SET titulo = ?, duracao = ?, classificacao = ? WHERE idFilme = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, filme.getTitulo());
            pst.setInt(2, filme.getDuracao());
            if (filme.getClassificacao() != null) {
                pst.setInt(3, filme.getClassificacao());
            } else {
                pst.setNull(3, java.sql.Types.INTEGER); // Tratar a classificação como null, se for o caso
            }
            pst.setInt(4, id);
            pst.execute();
            sucesso = true;
        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }

    @Override
    public boolean delete(int id) {
        connectToDb();

        boolean sucesso;
        String sql = "DELETE FROM Filme WHERE idFilme = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            sucesso = true;
        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }

    @Override
    public ArrayList<Filme> select() {
        connectToDb();

        ArrayList<Filme> filmes = new ArrayList<>();
        String sql = "SELECT * FROM Filme";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de filmes:");
            while (rs.next()) {
                Filme filmeAux = new Filme(
                        rs.getInt("idFilme"),
                        rs.getString("titulo"),
                        rs.getInt("duracao"),
                        rs.getObject("classificacao") != null ? rs.getInt("classificacao") : null
                );
                System.out.println("Título: " + filmeAux.getTitulo() +
                        " | Duração: " + filmeAux.getDuracao() +
                        " | Classificação: " + filmeAux.getClassificacao());
                System.out.println("----------------------");
                filmes.add(filmeAux);
            }
        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
        } finally {
            try {
                con.close();
                st.close();
                rs.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return filmes;
    }
}
