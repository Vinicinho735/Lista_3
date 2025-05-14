import java.util.ArrayList;
import java.util.List;

public class App {

    public static int funcaoHash(String palavra, int tam){
        int hash = 0;
        //  ex: Abobora  -> pega letra A->int da tabela ascii
        // A -> valor 65
        /// 65 -> 0
        /// 90 -> 25
        hash = 13+palavra.toUpperCase().charAt(0);  // pega a inicial

        return hash % tam;
    }

    public static boolean buscarPalavra(String palavra, ArrayList<String>[] tabelaHash, int tam) {
        // Calcula a categoria usando a função hash
        int categoria = funcaoHash(palavra, tam);
        
        // Verifica se a palavra está presente na categoria correta
        return tabelaHash[categoria].contains(palavra);
    }

    public static void main(String[] args) throws Exception {
        int totalCategorias = 26;
        ArrayList<String> tabelaHash[] = new ArrayList[totalCategorias];
        
        // Inicializar a tabela
        for (int i = 0; i < tabelaHash.length; i++) {
            tabelaHash[i] = new ArrayList<String>();
        }
        
        // Adicionando palavras
        List<String> listaPalavra = GeradorPalavras.lerPalavras();
        for (String palavra : listaPalavra) {
            int categoria = funcaoHash(palavra, totalCategorias);
            tabelaHash[categoria].add(palavra);
        }
        
        // Testando o método buscarPalavra
        String palavraBusca = "aabora"; // Exemplo de palavra a ser buscada
        if (buscarPalavra(palavraBusca, tabelaHash, totalCategorias)) {
            System.out.println("Palavra '" + palavraBusca + "' encontrada.");
        } else {
            System.out.println("Palavra '" + palavraBusca + "' não encontrada.");
        }
    }
}
