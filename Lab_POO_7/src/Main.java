public class Main {
    public static void main(String[] args) {

        Ciclista ciclista = new Ciclista();
        Corredor corredor = new Corredor();
        Nadador nadador = new Nadador();

        corredor.colocarEquipamento();
        corredor.treinar();

        ciclista.colocarEquipamento();
        ciclista.treinar();

        nadador.treinar();
    }
}