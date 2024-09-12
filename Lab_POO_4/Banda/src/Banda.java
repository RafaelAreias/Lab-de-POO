public class Banda {
    private Musica[] musicas;
    private String nome;
    private int numeroDeIntegrantes;

    public Banda(String nome, int numeroDeIntegrantes) {
        this.nome = nome;
        this.numeroDeIntegrantes = numeroDeIntegrantes;

        musicas = new Musica[30];
    }

    public void tocarMusica(int posicao){
        System.out.println("Tocando " + musicas[posicao].getNome() + " do álbum " + musicas[posicao].getAlbum() + "\n");
    }

    public void tocarShow(){
        for(int i = 0; i < musicas.length; i++){
            if(musicas[i] != null){
                System.out.println("Musica: "+ musicas[i].getNome());
                System.out.println("Album: "+ musicas[i].getAlbum() + "\n");
            }
        }
    }

    public boolean adicionarMusica(Musica musica){
        for(int i = 0; i < musicas.length; i++){
            if(musicas[i] == null){
                musicas[i] = musica;
                return true;
            }
        }

        return false;
    }

    public boolean deletarMusica(String nome){
        for(int i = 0; i < musicas.length; i++){
            if(musicas[i].getNome().equals(nome)){
                musicas[i] = null;
                return true;
            }
        }
        return false;
    }
}
