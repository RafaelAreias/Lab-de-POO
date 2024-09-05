public class Autor {

    private String nome;
    private Saga[] sagas;

    public String getNome() {
        return nome;
    }

    public static void setNome(String nome) {
        this.nome = nome;
    }

    public Autor(Saga[] sagas) {

    }

    public void listarSagas()
    {
        for(int i=0;i<sagas.length;i++){
            if(sagas[i]!=null){
                System.out.println("Nota: " + sagas[i].getNota());
                sagas[i].listarLivros();
            }
        }
    }

    public void adicionarSaga(Saga saga)
    {
        for (int i = 0; i < sagas.length; i++) {
            if (this.sagas[i] == null) {
                this.sagas[i] = new Saga();
                this.sagas[i] = saga;
            }
        }
    }
}
