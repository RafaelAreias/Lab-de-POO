public class Saga {

    private int nota;
    private Livro[] livros = new Livro[10];;

    public void setNota(int nota) {
        this.nota = nota;
    }

    public int getNota() {
        return nota;
    }

    public void listarLivros()
    {
        for(int i=0;i<livros.length;i++){
            if(livros[i]!=null){
                System.out.println("Título: " + livros[i].getTitulo());
                System.out.println("Páginas: "+ livros[i].getPaginas());
            }
        }
    }

    public void adicionarLivro(Livro livro)
    {
        for (int i = 0; i < livros.length; i++) {
            if (this.livros[i] == null) {
                this.livros[i] = livro;
                break;
            }
        }
    }
}
