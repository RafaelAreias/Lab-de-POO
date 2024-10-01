package br.inatel.DAO;
import br.inatel.Model.Sala;
import java.sql.*;
import java.util.ArrayList;

public class SalaDAO extends ConnectionDAO {

    public void testConnection() {
        connectToDb();
    }

    public boolean insertSala(Sala sala) {
        connectToDb();

        boolean sucesso;
        String sql = "INSERT INTO sala (numero, capacidade, id_sala) VALUES (?, ?, ?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, sala.getId_sala());
            pst.setInt(2, sala.getNumero());
            pst.setInt(3, sala.getCapacidade());
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

    public boolean updateSala(int id, Sala sala) {
        connectToDb();

        boolean sucesso;
        String sql = "UPDATE sala SET numero = ?, capacidade = ? WHERE id_sala = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, sala.getNumero());
            pst.setInt(2, sala.getCapacidade());
            pst.setInt(3, id);
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

    public boolean deleteSala(int id) {
        connectToDb();

        boolean sucesso;
        String sql = "DELETE FROM sala WHERE id_sala = ?";
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

    public ArrayList<Sala> selectSala() {
        connectToDb();

        ArrayList<Sala> salas = new ArrayList<>();
        String sql = "SELECT * FROM sala";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de salas:");
            while (rs.next()) {
                Sala salaAux = new Sala(rs.getInt("Numero"), rs.getInt("Capacidade"), rs.getInt("id_sala"));
                System.out.println("Numero: " + salaAux.getNumero() + " Capacidade: " + salaAux.getCapacidade());
                System.out.println("----------------------");
                salas.add(salaAux);
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
        return salas;
    }


}
