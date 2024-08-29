public class Jogador {

    Arma arma;
    int energia;
    int vida;

    Jogador(Arma arma,int vida,int energia){
        this.arma = arma;
        this.vida = vida;
        this.energia = energia;
    }

    void atacar(Jogador alvo){
        if(this.energia >= arma.custoDeEnergia){
            alvo.vida -= arma.dano;
            this.energia -= arma.custoDeEnergia;
            System.out.println("Ataque bem sucedido");
        }

        else
            System.out.println("Sem energia");
    }

    @Override
    public String toString(){
        return "Informações Jogador: \nVida: " + vida + "\nEnergia: " + energia + "\nInformações da arma: \n"+ "Custo de energia: " +arma.custoDeEnergia +"\nDano: "+ arma.dano+"\n";
    }
}
