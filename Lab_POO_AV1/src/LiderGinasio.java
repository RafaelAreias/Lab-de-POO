public class LiderGinasio extends Treinador {

    private String cidadeGinasio;
    private String tipoGinasio;

    public LiderGinasio(String nome, int numPokebola, int numinsignia, int dinheiro, String cidadeGinasio, String tipoGinasio) {
        super(nome, numPokebola, numinsignia, dinheiro);
        this.cidadeGinasio = cidadeGinasio;
        this.tipoGinasio = tipoGinasio;
    }

    @Override
    public void mostraInfo(){
        super.mostraInfo();
        System.out.println("Cidade do ginásio: "+cidadeGinasio);
        System.out.println("Tipo do ginásio: "+tipoGinasio);
    }
}
