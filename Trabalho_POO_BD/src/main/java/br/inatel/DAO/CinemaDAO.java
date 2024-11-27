package br.inatel.DAO;
import br.inatel.Model.Cinema;
import java.sql.*;
import java.util.ArrayList;

public class CinemaDAO extends ConnectionDAO implements OperacoesCRUD<Cinema>{

    public void testConnection() {
        connectToDb();
    }

    @Override
    public boolean insert(Cinema cinema) {
        connectToDb();

        boolean sucesso;
        String sql = "INSERT INTO cinema (nome, shopping_id) VALUES (?, ?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, cinema.getNome());
            pst.setInt(2, cinema.getId_shopping());
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
    public boolean update(int id, Cinema cinema) {
        connectToDb();

        boolean sucesso;
        String sql = "UPDATE cinema SET nome = ? WHERE id = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, cinema.getNome());
            pst.setInt(2, id);
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
        String sql = "DELETE FROM cinema WHERE id = ?";
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

    public ArrayList<Cinema> select() {
        connectToDb();

        ArrayList<Cinema> cinemas = new ArrayList<>();
        String sql = "SELECT * FROM cinema";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de usuários:");
            while (rs.next()) {
                Cinema cinemaAux = new Cinema(rs.getString("nome"), rs.getInt("id_shopping"));
                System.out.println("Nome: " + cinemaAux.getNome());
                System.out.println("----------------------");
                cinemas.add(cinemaAux);
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
        return cinemas;
    }

}