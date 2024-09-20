public class Pokemon {

    private static int numTotalPokemon = 0;
    private int idPokemon;
    private String nome;
    private String[] tipos = new String[2];
    public Ataque ataque;

    public Pokemon(String nome, String[] tipos) {
        this.nome = nome;
        this.tipos = tipos;
        ataque = new Ataque();
        numTotalPokemon++;
        idPokemon = numTotalPokemon;
    }

    public void atacar(){
        System.out.println(nome + " está atacando");
        ataque.mostraInfo();
    }

    public void mostraInfo(){
        System.out.println("Id: " + idPokemon);
        System.out.println("Nome: " + nome);
        System.out.println("Tipos: " + tipos[0] + ", " + tipos[1]);
        ataque.mostraInfo();
    }
}
