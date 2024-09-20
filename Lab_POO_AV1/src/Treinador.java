public class Treinador {

    private String nome;
    private int numPokebola;
    private int numInsignia;
    private int dinheiro;
    private Pokemon[] time = new Pokemon[6];

    public Treinador(String nome, int numPokebola, int numInsignia, int dinheiro) {
        this.nome = nome;
        this.numPokebola = numPokebola;
        this.numInsignia = numInsignia;
        this.dinheiro = dinheiro;
    }

    public void comprarPokebola(int quantidade){
        int custo = quantidade * 100;
        if(dinheiro >= custo){
            dinheiro -= custo;
            numPokebola += quantidade;
            System.out.println("Treinador " + nome + " agora tem " + dinheiro + " dinheiros e " + numPokebola + " pokebolas");
        }
        else System.out.println("Treinador " + nome + " não tem dinheiro suficiente");
    }

    public void lutar(Treinador oponente, int posTimeTreinador, int posTimeOponente){
        time[posTimeTreinador-1].atacar();
        oponente.time[posTimeTreinador-1].atacar();

        if(oponente instanceof LiderGinasio)
            oponente.numInsignia++;
    }

    public void capturarPokemon(Pokemon pokemon) {
        for(int i = 0; i < time.length; i++) {
            if (time[i] == null) {
                time[i] = pokemon;
                break;
            }
        }
    }

    public void mostraInfo(){
        System.out.println("Nome do treinador: " + nome);
        System.out.println("Número de pokebolas: " + numPokebola);
        System.out.println("Número de insignias: " + numInsignia);
        System.out.println("Qtd dinheiro: " + dinheiro);
    }
}
