public class Main {
    public static void main(String[] args) {
        Arquivo arquivo = new Arquivo();

        Jogo jogo1 = new Jogo(1,"GTA",105.00);
        Jogo jogo2 = new Jogo(2,"Far Cry",149.99);

        arquivo.escrever(jogo1);
        arquivo.escrever(jogo2);

        arquivo.lerJogo(149.99);

    }
}
