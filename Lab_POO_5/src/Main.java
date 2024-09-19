public class Main {
    public static void main(String[] args) {

        Produto[] produtos = new Produto[5];
        produtos[0] = new Camiseta("T-shirt", 75, "Preto", "M");
        produtos[1] = new Notebook("Nitro 5", 4000, 512, "GTX 1650", "i5");
        produtos[2] = new Produto("Televisão", 2000);

        for(int i=0; produtos[i]!=null; i++)
        {
            if(produtos[i] instanceof Camiseta)
                System.out.println("Camiseta: " + produtos[i].etiquetaPreco());

            else if(produtos[i] instanceof Notebook)
                System.out.println("Notebook: " + produtos[i].etiquetaPreco());

            else
                System.out.println("Produto: " + produtos[i].etiquetaPreco());
        }
    }
}