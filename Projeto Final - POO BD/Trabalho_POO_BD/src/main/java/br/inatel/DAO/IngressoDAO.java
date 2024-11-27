package br.inatel.DAO;

import br.inatel.Model.Ingresso;
import java.sql.*;
import java.util.ArrayList;

public class IngressoDAO extends ConnectionDAO implements OperacoesCRUD<Ingresso> {

    @Override
    public boolean insert(Ingresso ingresso) {
        connectToDb();

        boolean sucesso;
        String sql = "INSERT INTO Ingresso (preco, poltrona, sessao_id, cliente_id) VALUES (?, ?, ?, ?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setFloat(1, ingresso.getPreco());
            pst.setString(2, ingresso.getPoltrona());
            pst.setInt(3, ingresso.getSessaoId());
            pst.setInt(4, ingresso.getClienteId());
            pst.execute();
            sucesso = true;

        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
            sucesso = false;
        } finally {
            closeConnections();
        }
        return sucesso;
    }

    @Override
    public boolean update(int id, Ingresso ingresso) {
        connectToDb();

        boolean sucesso;
        String sql = "UPDATE Ingresso SET preco = ?, poltrona = ?, sessao_id = ?, cliente_id = ? WHERE idIngresso = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setFloat(1, ingresso.getPreco());
            pst.setString(2, ingresso.getPoltrona());
            pst.setInt(3, ingresso.getSessaoId());
            pst.setInt(4, ingresso.getClienteId());
            pst.setInt(5, id);
            pst.execute();
            sucesso = true;

        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
            sucesso = false;
        } finally {
            closeConnections();
        }
        return sucesso;
    }

    @Override
    public boolean delete(int id) {
        connectToDb();

        boolean sucesso;
        String sql = "DELETE FROM Ingresso WHERE idIngresso = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            sucesso = true;

        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
            sucesso = false;
        } finally {
            closeConnections();
        }
        return sucesso;
    }

    @Override
    public ArrayList<Ingresso> select() {
        connectToDb();

        ArrayList<Ingresso> ingressos = new ArrayList<>();
        String sql = "SELECT * FROM Ingresso";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Ingresso ingressoAux = new Ingresso(
                        rs.getInt("idIngresso"),
                        rs.getFloat("preco"),
                        rs.getString("poltrona"),
                        rs.getInt("sessao_id"),
                        rs.getInt("cliente_id")
                );
                ingressos.add(ingressoAux);
            }

        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
        } finally {
            closeConnections();
        }
        return ingressos;
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
