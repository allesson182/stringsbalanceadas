import java.util.Scanner;

public class VerificaBalanceamento {

        /*Implemente um algoritmo que verifique se uma string possui chaves, parentesis e colchetes balanceados. Em
    uma dada string, você deve indicar se os parênteses e colchetes estão balanceados. Diz-se que uma string está
    balanceada quando para cada parenteses ou colchetes abrindo, existe um equivalente fechando. Por exemplo, a
    string: (()[]) está balanceada, enquanto as strings ((()) e )( não estão balanceadas.
    Input format
    Você irá receber um número inteiro n indicando a quantidade de strings que virão a seguir. Depois, você receberá
    n strings, uma em cada linha.A string contém no máximo 255 caracteres e pode ser composta pelos caracteres ')',
    '(', ']', '[' e ' '. O caracter branco deve ser ignorado.
    Também é possível receber uma linha vazia.
    Output format
    Para cada string, você deve imprimir uma linha contendo a palavra "S" caso a string esteja balanceada e "N" caso
    contrário.
     */

    //metodo que recebe uma string e verifica se os parenteses e colchetes estão balanceados e também recebe um inteiro n que indica a quantidade de strings que virão a seguir
    public static void verificaBalanceamento(String str, int n) {
        //cria um array de char com o tamanho da string
        char[] array = new char[str.length()];
        //cria um inteiro que será usado como contador
        int cont = 0;
        //cria um for que percorre a string
        for (int i = 0; i < str.length(); i++) {
            //verifica se o caracter na posição i é igual a '(' ou '['
            if (str.charAt(i) == '(' || str.charAt(i) == '[') {
                //se for, adiciona o caracter no array na posição cont
                array[cont] = str.charAt(i);
                //incrementa o contador
                cont++;
            }
            //verifica se o caracter na posição i é igual a ')' ou ']'
            else if (str.charAt(i) == ')' || str.charAt(i) == ']') {
                //verifica se o contador é igual a 0
                if (cont == 0) {
                    //se for, imprime N
                    System.out.println("N");
                    //retorna para o método
                    return;
                }
                //verifica se o caracter na posição i é igual a ')' e o caracter na posição cont-1 é igual a '('
                else if (str.charAt(i) == ')' && array[cont - 1] == '(') {
                    //se for, decrementa o contador
                    cont--;
                }
                //verifica se o caracter na posição i é igual a ']' e o caracter na posição cont-1 é igual a '['
                else if (str.charAt(i) == ']' && array[cont - 1] == '[') {
                    //se for, decrementa o contador
                    cont--;
                }
                //se não for nenhum dos casos acima, imprime N
                else {
                    System.out.println("N");
                    //retorna para o método
                    return;
                }
            }
        }
        //verifica se o contador é igual a 0
        if (cont == 0) {
            //se for, imprime S
            System.out.println("S");
        }
        //se não for, imprime N
        else {
            System.out.println("N");
        }
    }


    public static void main(String[] args) {
        //imprime uma mensagem na tela informando como funciona o fluxo
        System.out.println("O código irá receber um número inteiro n indicando a quantidade de strings que virão a seguir." +
                "\n Depois, você receberá n strings, uma em cada linha. A string contém no máximo 255 caracteres e pode ser composta" +
                "\n pelos caracteres ')', '(', ']', '[' e ' '\n O caracter branco deve ser ignorado. Também é possível receber uma linha vazia.");
        System.out.println("");

        //imprime a mensagem para o usuario saber o que deve ser digitado
        System.out.println("Digite o número inteiro n que indica a quantidade de strings que virão a seguir: ");
        //cria um Scanner para ler a entrada
        Scanner sc = new Scanner(System.in);
        //lê um inteiro n que indica a quantidade de strings que virão a seguir
        int n = sc.nextInt();
        //cria um for que percorre n vezes
        System.out.println("Digite as strings: ");
        for (int i = 0; i < n; i++) {
            //lê uma string
            //imprime uma mensagem para o usuario saber o que deve ser digitado mas na primeira vez não imprime

            String str = sc.nextLine();
            //verifica se a string é vazia
            if (str.equals("")) {
                //se for, decrementa o contador
                i--;
            }
            //se não for, chama o método verificaBalanceamento
            else {
                verificaBalanceamento(str, n);
            }
        }
    }
}
