import java.io.*;

public class Arquivo {

    public void escrever(Jogo jogo){
        // Criando os objetos de escrita
        FileOutputStream fluxoSaida = null;
        OutputStreamWriter geradorFluxoSaida = null;
        BufferedWriter bufferSaida = null;
        try {
            //Inicializando os objetos
            fluxoSaida = new FileOutputStream("scratch.txt");
            geradorFluxoSaida = new OutputStreamWriter(fluxoSaida);
            bufferSaida = new BufferedWriter(geradorFluxoSaida);
            // Escrita no arquivo
            bufferSaida.write("Livro: { ID = " + jogo.getId() + ", Nome = " + jogo.getNome() + ", Preço = " + jogo.getPreco() + " }");
            bufferSaida.newLine();

        }catch (Exception e){
            System.err.printf(String.valueOf(e));
        } finally {
            try {
                // Fechando o buffer
                assert bufferSaida != null;
                bufferSaida.close();
                System.out.println("Sistema Encerrado");
            } catch (IOException e) {
                System.err.printf(String.valueOf(e));
            }
        }
    }

    public void lerJogo(double preco){
        // Criando os objetos de leitura
        FileInputStream fluxoEntrada = null;
        InputStreamReader geradorFluxoEntrada = null;
        BufferedReader bufferEntrada = null;

        try {
            // Inicializando os objetos
            fluxoEntrada = new FileInputStream("Scratch.txt");
            geradorFluxoEntrada = new InputStreamReader(fluxoEntrada);
            bufferEntrada = new BufferedReader(geradorFluxoEntrada);
            // Leitura do arquivo
            String leitura  = bufferEntrada.readLine();
            while (leitura != null){
                if (leitura.contains("Preço = " + preco)){
                    System.out.println(leitura);
                }
                leitura = bufferEntrada.readLine();
            }

        }catch (Exception e){
            System.err.printf(String.valueOf(e));
        } finally {
            // Fechando o buffer
            try {
                assert bufferEntrada != null;
                bufferEntrada.close();
                System.out.println("Sistema Encerrado");
            } catch (IOException e) {
                System.err.printf(String.valueOf(e));
            }
        }

    }

}


