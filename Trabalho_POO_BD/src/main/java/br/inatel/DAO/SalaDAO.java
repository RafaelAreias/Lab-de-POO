package br.inatel.DAO;

import br.inatel.Model.Sala;

import java.sql.SQLException;
import java.util.ArrayList;

public class SalaDAO extends ConnectionDAO  implements OperacoesCRUD<Sala> {

    public void testConnection() {
        connectToDb();
    }

    @Override
    public boolean insert(Sala sala) {
        connectToDb();

        boolean sucesso;
        String sql = "INSERT INTO sala (capacidade, numero, cinema_id) VALUES (?, ?, ?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, sala.getCapacidade());
            pst.setInt(2, sala.getNumero());
            pst.setInt(3, sala.getId_cinema());
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
    public boolean update(int id, Sala sala) {
        connectToDb();

        boolean sucesso;
        String sql = "UPDATE sala SET capacidade = ?, numero = ? WHERE idSala = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, sala.getCapacidade());
            pst.setInt(2, sala.getNumero());
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

    @Override
    public boolean delete(int id) {
        connectToDb();

        boolean sucesso;
        String sql = "DELETE FROM sala WHERE idSala = ?";
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
    public ArrayList<Sala> select() {
        connectToDb();

        ArrayList<Sala> salas = new ArrayList<>();
        String sql = "SELECT * FROM Sala";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Sala salaAux = new Sala(
                        rs.getInt("numero"),
                        rs.getInt("capacidade"),
                        rs.getInt("cinema_id")
                );
                salas.add(salaAux);
            }

        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
        } finally {
            closeConnections();
        }
        return salas;
    }

    public Sala select_unico(int id) {
        connectToDb();

        Sala sala = null;
        String sql = "SELECT * FROM sala WHERE idSala = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();

            if (rs.next()) {
                sala = new Sala(
                        rs.getInt("numero"),
                        rs.getInt("capacidade"),
                        rs.getInt("cinema_id")
                );
                System.out.println("Sala encontrada:");
                System.out.println("Número: " + sala.getNumero());
                System.out.println("Capacidade: " + sala.getCapacidade());
                System.out.println("ID do Cinema: " + sala.getId_cinema());
            } else {
                System.out.println("Nenhuma sala encontrada com o ID: " + id);
                System.out.println("");
            }
        } catch (SQLException exc) {
            System.out.println("Erro ao buscar sala: " + exc.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (con != null) con.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sala;
    }

    private void closeConnections() {
        try {
            if (con != null) con.close();
            if (pst != null) pst.close();
            if (st != null) st.close();
            if (rs != null) rs.close();
        } catch (SQLException exc) {
            System.out.println("Erro ao fechar conexões: " + exc.getMessage());
        }
    }
}
