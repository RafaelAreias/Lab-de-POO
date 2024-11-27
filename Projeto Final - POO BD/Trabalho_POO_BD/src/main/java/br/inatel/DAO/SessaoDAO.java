package br.inatel.DAO;

import br.inatel.Model.Sessao;

import java.sql.SQLException;
import java.util.ArrayList;

public class SessaoDAO extends ConnectionDAO implements OperacoesCRUD<Sessao> {

    public void testConnection() {
        connectToDb();
    }

    @Override
    public boolean insert(Sessao sessao) {
        connectToDb();

        boolean sucesso;
        String sql = "INSERT INTO Sessao (data_horario, sala_id, filme_id) VALUES (?, ?, ?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, sessao.getDataHorario());
            pst.setInt(2, sessao.getSalaId());
            pst.setInt(3, sessao.getFilmeId());
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
    public boolean update(int id, Sessao sessao) {
        connectToDb();

        boolean sucesso;
        String sql = "UPDATE Sessao SET data_horario = ?, sala_id = ?, filme_id = ? WHERE idSessao = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, sessao.getDataHorario());
            pst.setInt(2, sessao.getSalaId());
            pst.setInt(3, sessao.getFilmeId());
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
        String sql = "DELETE FROM Sessao WHERE idSessao = ?";
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
    public ArrayList<Sessao> select() {
        connectToDb();

        ArrayList<Sessao> sessoes = new ArrayList<>();
        String sql = "SELECT * FROM Sessao";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de sessões:");
            while (rs.next()) {
                Sessao sessaoAux = new Sessao(
                        rs.getInt("idSessao"),
                        rs.getString("data_horario"),
                        rs.getInt("sala_id"),
                        rs.getInt("filme_id")
                );
                System.out.println("ID: " + sessaoAux.getIdSessao() +
                        " | Data e horário: " + sessaoAux.getDataHorario() +
                        " | Sala: " + sessaoAux.getSalaId() +
                        " | Filme: " + sessaoAux.getFilmeId());
                System.out.println("----------------------");
                sessoes.add(sessaoAux);
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
        return sessoes;
    }
}
