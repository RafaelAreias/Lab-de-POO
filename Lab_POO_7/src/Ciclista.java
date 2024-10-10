public class Ciclista extends Atleta implements Equipamento{

    @Override
    public void treinar() {
        System.out.println("Ciclista está treinando...");
    }

    @Override
    public void colocarEquipamento() {
        System.out.println("Corredor colocou o capacete");
    }
}
