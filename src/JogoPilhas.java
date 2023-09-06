import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public class JogoPilhas {
    public static void main(String[] args) {
        Stack<Integer> pilha1 = new Stack<>();
        Stack<Integer> pilha2 = new Stack<>();
        Stack<Integer> pilha3 = new Stack<>();
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insira o tamanho da pilha: ");
        int tamanho = scanner.nextInt();
        // Preenche a pilha1 com números aleatórios na faixa de 1 a 100
        for (int i = 0; i < tamanho; i++) { // Altere 10 para o número desejado de elementos na pilha1
            int numero = random.nextInt(100) + 1;
            pilha1.push(numero);
        }

        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Informe se deseja a ordenação em ordem crescente ou decrescente: (1- Crescente; 2- Decrescente)");
        int ordem = scanner1.nextInt();

        crescente(ordem);

        // Imprime as pilhas iniciais
        System.out.println("Pilha 1 (antes da ordenação): " + pilha1);
        System.out.println("Pilha 2: " + pilha2);
        System.out.println("Pilha 3: " + pilha3);

        int cont = 0;
        while (true) {
            System.out.println("Selecione sua opção: ");
            System.out.println("0 - sair do jogo.");
            System.out.println("1 - movimentar.");
            System.out.println("2 - Solução automática.");

            int opcao = scanner.nextInt();

            if (opcao == 1) {
                System.out.println("Qual pilha você deseja movimentar? (1, 2 ou 3)");
                int origem = scanner.nextInt();
                System.out.println("Qual a pilha de destino? (1, 2 ou 3)");
                int destino = scanner.nextInt();
                if (origem == destino) {
                    System.out.println("Não é possivel tirar e colocar na mesma pilha");
                } else if (origem == 1 && destino == 2) {
                    if (pilha1.isEmpty()) {
                        System.out.println("A pilha esta vazia, escolha outra");
                    } else {
                        movimentar(pilha1, pilha2);
                        System.out.println("Pilha 1: " + pilha1);
                        System.out.println("Pilha 2: " + pilha2);
                        System.out.println("Pilha 3: " + pilha3);
                        cont++;
                        if (pilha1.isEmpty() && pilha3.isEmpty() && estaOrdenada(pilha2) && crescente(ordem)) {
                            System.out.println("A pilha esta ordenada em " + cont + " tentativas");
                            break;
                        } else if (pilha1.isEmpty() && pilha3.isEmpty() && estaOrdenadaDecrescente(pilha2) && !crescente(ordem)) {
                            System.out.println("A pilha esta ordenada em " + cont + " tentativas");
                            break;
                        }
                    }
                } else if (origem == 2 && destino == 3) {
                    if (pilha2.isEmpty()) {
                        System.out.println("A pilha esta vazia, escolha outra");
                    } else {
                        movimentar(pilha2, pilha3);
                        System.out.println("Pilha 1: " + pilha1);
                        System.out.println("Pilha 2: " + pilha2);
                        System.out.println("Pilha 3: " + pilha3);
                        cont++;
                        if (pilha1.isEmpty() && pilha2.isEmpty() && estaOrdenada(pilha3) && crescente(ordem)) {
                            System.out.println("A pilha esta ordenada em " + cont + " tentativas");
                            break;
                        } else if (pilha1.isEmpty() && pilha2.isEmpty() && estaOrdenadaDecrescente(pilha3) && !crescente(ordem)) {
                            System.out.println("A pilha esta ordenada em " + cont + " tentativas");
                            break;
                        }
                    }
                } else if (origem == 3 && destino == 1) {
                    if (pilha3.isEmpty()) {
                        System.out.println("A pilha esta vazia, escolha outra");
                    } else {
                        movimentar(pilha3, pilha1);
                        System.out.println("Pilha 1: " + pilha1);
                        System.out.println("Pilha 2: " + pilha2);
                        System.out.println("Pilha 3: " + pilha3);
                        cont++;
                        if (pilha2.isEmpty() && pilha3.isEmpty() && estaOrdenada(pilha1) && crescente(ordem)) {
                            System.out.println("A pilha esta ordenada em " + cont + " tentativas");
                            break;
                        } else if (pilha2.isEmpty() && pilha3.isEmpty() && estaOrdenadaDecrescente(pilha1) && !crescente(ordem)) {
                            System.out.println("A pilha esta ordenada em " + cont + " tentativas");
                            break;
                        }
                    }
                } else if (origem == 3 && destino == 2) {
                    if (pilha3.isEmpty()) {
                        System.out.println("A pilha esta vazia, escolha outra");
                    } else {
                        movimentar(pilha3, pilha2);
                        System.out.println("Pilha 1: " + pilha1);
                        System.out.println("Pilha 2: " + pilha2);
                        System.out.println("Pilha 3: " + pilha3);
                        cont++;
                        if (pilha1.isEmpty() && pilha3.isEmpty() && estaOrdenada(pilha2) && crescente(ordem)) {
                            System.out.println("A pilha esta ordenada em " + cont + " tentativas");
                            break;
                        } else if (pilha1.isEmpty() && pilha3.isEmpty() && estaOrdenadaDecrescente(pilha2) && !crescente(ordem)) {
                            System.out.println("A pilha esta ordenada em " + cont + " tentativas");
                            break;
                        }
                    }
                } else if (origem == 1 && destino == 3) {
                    if (pilha1.isEmpty()) {
                        System.out.println("A pilha esta vazia, escolha outra");
                    } else {
                        movimentar(pilha1, pilha3);
                        System.out.println("Pilha 1: " + pilha1);
                        System.out.println("Pilha 2: " + pilha2);
                        System.out.println("Pilha 3: " + pilha3);
                        cont++;
                        if (pilha1.isEmpty() && pilha2.isEmpty() && estaOrdenada(pilha3) && crescente(ordem)) {
                            System.out.println("A pilha esta ordenada em " + cont + " tentativas");
                            break;
                        } else if (pilha1.isEmpty() && pilha2.isEmpty() && estaOrdenadaDecrescente(pilha3) && !crescente(ordem)) {
                            System.out.println("A pilha esta ordenada em " + cont + " tentativas");
                            break;
                        }
                    }
                } else if (origem == 2 && destino == 1) {
                    if (pilha1.isEmpty()) {
                        System.out.println("A pilha esta vazia, escolha outra");
                    } else {
                        movimentar(pilha2, pilha1);
                        System.out.println("Pilha 1: " + pilha1);
                        System.out.println("Pilha 2: " + pilha2);
                        System.out.println("Pilha 3: " + pilha3);
                        cont++;
                        if (pilha2.isEmpty() && pilha3.isEmpty() && estaOrdenada(pilha1) && crescente(ordem)) {
                            System.out.println("A pilha esta ordenada em " + cont + " tentativas");
                            break;
                        } else if (pilha2.isEmpty() && pilha3.isEmpty() && estaOrdenadaDecrescente(pilha1) && !crescente(ordem)) {
                            System.out.println("A pilha esta ordenada em " + cont + " tentativas");
                            break;
                        }
                    }
                }

            } else if (opcao == 2 && crescente(ordem)) {
                organizarPilha(pilha1, pilha2, pilha3);
                System.out.println("Pilha 1 (após a ordenação): " + pilha3);
                break;
            } else if (opcao == 2 && !crescente(ordem)) {
                organizarPilhaDec(pilha1, pilha2, pilha3);
                System.out.println("Pilha 1 (após a ordenação): " + pilha3);
                break;
            } else if (opcao == 0) {
                break;
            } else {
                System.out.println("Digite uma opção válida");
            }

        }

    }

    public static boolean crescente(int ordem) {
        if (ordem == 1) {
            return true;
        } else {
            return false;
        }
    }

    public static void organizarPilha(Stack<Integer> origem, Stack<Integer> auxiliar, Stack<Integer> destino) {
        int cont = 0;
        while (!origem.isEmpty()) {

            int elemento = origem.pop();
            cont++;
            // Move elementos maiores da pilha destino para a pilha auxiliar
            while (!destino.isEmpty() && destino.peek() > elemento) {
                auxiliar.push(destino.pop());
                cont++;
            }

            // Coloca o elemento na pilha destino
            destino.push(elemento);
            cont++;

            // Move elementos de volta da pilha auxiliar para a pilha destino
            while (!auxiliar.isEmpty()) {
                destino.push(auxiliar.pop());
                cont++;
            }
        }
        System.out.println("A quantidade minimo de movimentos necessários: " + cont);
    }

    public static void organizarPilhaDec(Stack<Integer> origem, Stack<Integer> auxiliar, Stack<Integer> destino) {
        int cont = 0;
        while (!origem.isEmpty()) {

            int elemento = origem.pop();
            cont++;
            // Move elementos maiores da pilha destino para a pilha auxiliar
            while (!destino.isEmpty() && destino.peek() < elemento) {
                auxiliar.push(destino.pop());
                cont++;
            }

            // Coloca o elemento na pilha destino
            destino.push(elemento);
            cont++;

            // Move elementos de volta da pilha auxiliar para a pilha destino
            while (!auxiliar.isEmpty()) {
                destino.push(auxiliar.pop());
                cont++;
            }
        }
        System.out.println("A quantidade minimo de movimentos necessários: " + cont);
    }

    public static void movimentar(Stack<Integer> origem, Stack<Integer> destino) {
        int elemento = origem.pop(); // Remove o elemento da pilha de origem
        destino.push(elemento); // Adiciona o elemento à pilha de destino
    }

    public static boolean estaOrdenada(Stack<Integer> pilha) {
        Stack<Integer> auxiliar = new Stack<>();
        int elementoAtual = pilha.pop();
        auxiliar.push(elementoAtual);
        boolean ordenada = true;

        while (!pilha.isEmpty()) {
            int proximoElemento = pilha.pop();

            if (proximoElemento > elementoAtual) {
                ordenada = false;
                break;
            }

            auxiliar.push(proximoElemento);
            elementoAtual = proximoElemento;
        }

        // Restaurar a pilha original
        while (!auxiliar.isEmpty()) {
            pilha.push(auxiliar.pop());
        }

        return ordenada;
    }

    public static boolean estaOrdenadaDecrescente(Stack<Integer> pilha) {

        Stack<Integer> auxiliar = new Stack<>();
        int elementoAtual = pilha.pop();
        auxiliar.push(elementoAtual);
        boolean ordenada = true;

        while (!pilha.isEmpty()) {
            int proximoElemento = pilha.pop();

            if (proximoElemento < elementoAtual) { // Verifica se o próximo elemento é menor
                ordenada = false;
                break;
            }

            auxiliar.push(proximoElemento);
            elementoAtual = proximoElemento;
        }

        // Restaurar a pilha original
        while (!auxiliar.isEmpty()) {
            pilha.push(auxiliar.pop());
        }

        return ordenada;

    }
}