public class Main {
    public static void main(String[] args) {
        Treinador treinador1 = new Treinador("João", 5,0, 1000);
        Treinador treinador2 = new Treinador("Gabriela", 2, 1,200);
        Treinador treinador3 = new Treinador("Chris", 7, 2,0);
        Pokemon pokemon1 = new Pokemon("Bulbassauro", new String[]{"água","planta"});
        Pokemon pokemon2 = new Pokemon("Pikachu", new String[]{"elétrico" , "vazio"});
        Pokemon pokemon3 = new Pokemon("Charmander",new String[]{"fogo","vazio"});

        treinador1.comprarPokebola(3);
        treinador3.comprarPokebola(2);

        treinador2.capturarPokemon(pokemon1);
        treinador2.capturarPokemon(pokemon2);
        treinador1.capturarPokemon(pokemon3);

        treinador2.lutar(treinador1, 2, 1);

        pokemon1.mostraInfo();

        LiderGinasio lider1 = new LiderGinasio("Mario", 10, 5, 500, "Santa Rita", "Grande");
        lider1.mostraInfo();
    }
}