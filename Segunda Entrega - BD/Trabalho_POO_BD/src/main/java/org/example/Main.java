package org.example;

import br.inatel.DAO.CinemaDAO;
import br.inatel.DAO.SalaDAO;

public class Main {

    public static void main(String[] args) {

        CinemaDAO cinemaDAO = new CinemaDAO();
        cinemaDAO.testConnection();
        SalaDAO salaDAO = new SalaDAO();
        salaDAO.testConnection();
    }
}