package br.inatel.DAO;

import br.inatel.Model.Cliente;
import java.sql.*;
import java.util.ArrayList;

public class ClienteDAO extends ConnectionDAO implements OperacoesCRUD<Cliente> {

    @Override
    public boolean insert(Cliente cliente) {
        connectToDb();

        boolean sucesso;
        String sql = "INSERT INTO cliente (idCliente, Nome, Idade) VALUES (?, ?, ?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, cliente.getIdCliente());
            pst.setString(2, cliente.getNome());
            pst.setString(3, cliente.getIdade());
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
    public boolean update(int id, Cliente cliente) {
        connectToDb();

        boolean sucesso;
        String sql = "UPDATE cliente SET Nome = ?, Idade = ? WHERE idCliente = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, cliente.getNome());
            pst.setString(2, cliente.getIdade());
            pst.setInt(3, id);
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
        String sql = "DELETE FROM cliente WHERE idCliente = ?";
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
    public ArrayList<Cliente> select() {
        connectToDb();

        ArrayList<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM cliente";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Cliente clienteAux = new Cliente(
                        rs.getInt("idCliente"),
                        rs.getString("Nome"),
                        rs.getString("Idade")
                );
                clientes.add(clienteAux);
            }

        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
        } finally {
            closeConnections();
        }
        return clientes;
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
