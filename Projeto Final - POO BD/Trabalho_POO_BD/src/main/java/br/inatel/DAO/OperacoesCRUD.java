package br.inatel.DAO;
import java.util.ArrayList;

public interface OperacoesCRUD<Tipo> {
    boolean insert(Tipo obj);
    boolean update(int id, Tipo obj);
    boolean delete(int id);
    ArrayList<Tipo> select();
}
