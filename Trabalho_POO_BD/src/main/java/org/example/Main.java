package org.example;

import br.inatel.DAO.CinemaDAO;
import br.inatel.DAO.SalaDAO;
import br.inatel.DAO.ShoppingDAO;

import br.inatel.Model.Sala;
import br.inatel.Model.Cinema;
import br.inatel.Model.Shopping;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ShoppingDAO shoppingDAO = new ShoppingDAO();
        CinemaDAO cinemaDAO = new CinemaDAO();
        SalaDAO salaDAO = new SalaDAO();

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o nome do shopping center em que se encontra o cinema: ");
        String nome = sc.nextLine();
        System.out.println("Endereço: ");
        String endereco = sc.nextLine();
        System.out.println("Horário de funcionamento: ");
        String horario = sc.nextLine();

        Shopping shopping = new Shopping(nome, endereco, horario);
        shoppingDAO.insert(shopping);

        System.out.println("Digite o nome do cinema: ");
        nome = sc.nextLine();
        System.out.println("Id do shopping em que se encontra o cinema: ");
        int idShopping = sc.nextInt();
        sc.nextLine();

        Cinema cinema = new Cinema(nome, idShopping);
        cinemaDAO.insert(cinema);

        int entrada;

        do {
            System.out.println("Escolha abaixo a ação desejada: \n" +
                    "1 - Cadastrar sala \n" +
                    "2 - Buscar sala \n" +
                    "3 - Atualizar sala\n" +
                    "4 - Excluir sala\n" +
                    "5 - Encerrar programa\n");
            entrada = sc.nextInt();
            sc.nextLine();

            switch (entrada) {
                case 1:
                    System.out.println("Digite o número da sala: ");
                    int numero = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Digite a capacidade da sala: ");
                    int capacidade = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Digite o ID do cinema onde está essa sala: ");
                    int idCinema = sc.nextInt();
                    sc.nextLine();

                    Sala sala_aux1 = new Sala(numero, capacidade, idCinema);
                    salaDAO.insert(sala_aux1);
                    break;

                case 2:
                    System.out.println("Digite o ID da sala que deseja buscar:");
                    int idSala = sc.nextInt();
                    sc.nextLine();

                    Sala sala_aux2 = salaDAO.select_unico(idSala);
                    break;

                case 3:
                    System.out.println("Digite o ID da sala que deseja atualizar: ");
                    int idSala_update = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Digite o novo número da sala: ");
                    int novoNumero = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Digite a nova capacidade da sala: ");
                    int novaCapacidade = sc.nextInt();
                    sc.nextLine();

                    Sala sala_aux3 = new Sala(novoNumero, novaCapacidade);
                    salaDAO.update(idSala_update, sala_aux3);
                    break;

                case 4:
                    System.out.println("Digite o ID da sala que deseja excluir: ");
                    int idSala_aux = sc.nextInt();
                    sc.nextLine();
                    salaDAO.delete(idSala_aux);
                    break;

                case 5:
                    System.out.println("Encerrando o programa...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (entrada != 5);

        sc.close();
    }
}