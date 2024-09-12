public class Main {
    public static void main(String[] args) {

        Musica[] musicas = new Musica[100];
        Banda banda = new Banda("Banda do Chaves", 4);

        musicas[0] = new Musica();
        musicas[0].setNome("Walk of Life");
        musicas[0].setAlbum("Brothers in Arms");

        musicas[1] = new Musica();
        musicas[1].setNome("Dancing Queen");
        musicas[1].setAlbum("Arrival");

        musicas[2] = new Musica();
        musicas[2].setNome("Send Me an Angel");
        musicas[2].setAlbum("Crazy World");

        banda.adicionarMusica(musicas[0]);
        banda.adicionarMusica(musicas[1]);
        banda.adicionarMusica(musicas[2]);

        banda.deletarMusica("Dancing Queen");
        banda.tocarMusica(2);
        banda.tocarShow();
    }
}