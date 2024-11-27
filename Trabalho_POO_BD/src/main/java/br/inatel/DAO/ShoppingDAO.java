package br.inatel.DAO;

import br.inatel.Model.Shopping;
import java.sql.*;
import java.util.ArrayList;

public class ShoppingDAO extends ConnectionDAO implements OperacoesCRUD<Shopping> {

    @Override
    public boolean insert(Shopping shopping) {
        connectToDb();

        boolean sucesso;
        String sql = "INSERT INTO Shopping (nome, endereco, horario_funcionamento) VALUES (?, ?, ?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, shopping.getNome());
            pst.setString(2, shopping.getEndereco());
            pst.setString(3, shopping.getHorarioFuncionamento());
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
    public boolean update(int id, Shopping shopping) {
        connectToDb();

        boolean sucesso;
        String sql = "UPDATE Shopping SET nome = ?, endereco = ?, horario_funcionamento = ? WHERE idShopping = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, shopping.getNome());
            pst.setString(2, shopping.getEndereco());
            pst.setString(3, shopping.getHorarioFuncionamento());
            pst.setInt(4, id);
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
        String sql = "DELETE FROM Shopping WHERE idShopping = ?";
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
    public ArrayList<Shopping> select() {
        connectToDb();

        ArrayList<Shopping> shoppings = new ArrayList<>();
        String sql = "SELECT * FROM Shopping";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Shopping shoppingAux = new Shopping(
                        rs.getString("nome"),
                        rs.getString("endereco"),
                        rs.getString("horario_funcionamento")
                );
                shoppings.add(shoppingAux);
            }

        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
        } finally {
            closeConnections();
        }
        return shoppings;
    }

    public Shopping select_unico(int id) {
        connectToDb();

        Shopping shopping = null;
        String sql = "SELECT * FROM shopping WHERE idShopping = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();

            if (rs.next()) {
                shopping = new Shopping(
                        rs.getString("nome"),
                        rs.getString("endereco"),
                        rs.getString("horario_funcionamento")
                );
                System.out.println("Shopping encontrado:");
                System.out.println("Nome: " + shopping.getNome());
                System.out.println("Endereço: " + shopping.getEndereco());
                System.out.println("Horário de funcionamento: " + shopping.getHorarioFuncionamento());
            } else {
                System.out.println("Nenhum shopping encontrado com o ID: " + id);
            }
        } catch (SQLException exc) {
            System.out.println("Erro ao buscar shopping: " + exc.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (con != null) con.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return shopping;
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
