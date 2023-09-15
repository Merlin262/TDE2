import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Pilha<Integer> pilha1 = new Pilha<>();
        Pilha<Integer> pilha2 = new Pilha<>();
        Pilha<Integer> pilha3 = new Pilha<>();

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insira o tamanho da pilha: ");
        int tamanho = scanner.nextInt();
        // Preenche a pilha1 com números aleatórios na faixa de 1 a 100
        for (int i = 0; i < tamanho; i++) { // Altere 10 para o número desejado de elementos na pilha1
            int numero = random.nextInt(100) + 1;
            pilha1.adicionar(numero);
        }

        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Informe se deseja a ordenação em ordem crescente ou decrescente: (1- Crescente; 2- Decrescente)");
        int ordem = scanner1.nextInt();

        Pilha.crescente(ordem);

        // Imprime as pilhas iniciais
        System.out.println("Pilha 1: ");
        pilha1.imprimirPilha(pilha1);
        System.out.println("Pilha 2: ");
        pilha2.imprimirPilha(pilha2);
        System.out.println("Pilha 3: ");
        pilha3.imprimirPilha(pilha3);

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
                    if (pilha1.estaVazia()) {
                        System.out.println("A pilha esta vazia, escolha outra");
                    } else {
                        Pilha.movimentar(pilha1, pilha2);
                        System.out.println("Pilha 1: ");
                        pilha1.imprimirPilha(pilha1);
                        System.out.println("Pilha 2: ");
                        pilha2.imprimirPilha(pilha2);
                        System.out.println("Pilha 3: ");
                        pilha3.imprimirPilha(pilha3);
                        cont++;
                        if (pilha1.estaVazia() && pilha3.estaVazia() && pilha2.estaOrdenada(pilha2) && Pilha.crescente(ordem)) {
                            System.out.println("A pilha esta ordenada em " + cont + " tentativas");
                            break;
                        } else if (pilha1.estaVazia() && pilha3.estaVazia() && pilha2.estaOrdenadaDec(pilha2) && !Pilha.crescente(ordem)) {
                            System.out.println("A pilha esta ordenada em " + cont + " tentativas");
                            break;
                        }
                    }
                } else if (origem == 2 && destino == 3) {
                    if (pilha2.estaVazia()) {
                        System.out.println("A pilha esta vazia, escolha outra");
                    } else {
                        Pilha.movimentar(pilha2, pilha3);
                        System.out.println("Pilha 1: ");
                        pilha1.imprimirPilha(pilha1);
                        System.out.println("Pilha 2: ");
                        pilha2.imprimirPilha(pilha2);
                        System.out.println("Pilha 3: ");
                        pilha3.imprimirPilha(pilha3);
                        cont++;
                        if (pilha1.estaVazia() && pilha2.estaVazia() && pilha3.estaOrdenada(pilha3) && Pilha.crescente(ordem)) {
                            System.out.println("A pilha esta ordenada em " + cont + " tentativas");
                            break;
                        } else if (pilha1.estaVazia() && pilha2.estaVazia() && pilha3.estaOrdenadaDec(pilha3) && !Pilha.crescente(ordem)) {
                            System.out.println("A pilha esta ordenada em " + cont + " tentativas");
                            break;
                        }
                    }
                } else if (origem == 3 && destino == 1) {
                    if (pilha3.estaVazia()) {
                        System.out.println("A pilha esta vazia, escolha outra");
                    } else {
                        Pilha.movimentar(pilha3, pilha1);
                        System.out.println("Pilha 1: ");
                        pilha1.imprimirPilha(pilha1);
                        System.out.println("Pilha 2: ");
                        pilha2.imprimirPilha(pilha2);
                        System.out.println("Pilha 3: ");
                        pilha3.imprimirPilha(pilha3);
                        cont++;
                        if (pilha2.estaVazia() && pilha3.estaVazia() && pilha1.estaOrdenada(pilha1) && Pilha.crescente(ordem)) {
                            System.out.println("A pilha esta ordenada em " + cont + " tentativas");
                            break;
                        } else if (pilha2.estaVazia() && pilha3.estaVazia() && pilha1.estaOrdenadaDec(pilha1) && !Pilha.crescente(ordem)) {
                            System.out.println("A pilha esta ordenada em " + cont + " tentativas");
                            break;
                        }
                    }
                } else if (origem == 3 && destino == 2) {
                    if (pilha3.estaVazia()) {
                        System.out.println("A pilha esta vazia, escolha outra");
                    } else {
                        Pilha.movimentar(pilha3, pilha2);
                        System.out.println("Pilha 1: ");
                        pilha1.imprimirPilha(pilha1);
                        System.out.println("Pilha 2: ");
                        pilha2.imprimirPilha(pilha2);
                        System.out.println("Pilha 3: ");
                        pilha3.imprimirPilha(pilha3);
                        cont++;
                        if (pilha1.estaVazia() && pilha3.estaVazia() && pilha2.estaOrdenada(pilha2) && Pilha.crescente(ordem)) {
                            System.out.println("A pilha esta ordenada em " + cont + " tentativas");
                            break;
                        } else if (pilha1.estaVazia() && pilha3.estaVazia() && pilha2.estaOrdenadaDec(pilha2) && !Pilha.crescente(ordem)) {
                            System.out.println("A pilha esta ordenada em " + cont + " tentativas");
                            break;
                        }
                    }
                } else if (origem == 1 && destino == 3) {
                    if (pilha1.estaVazia()) {
                        System.out.println("A pilha esta vazia, escolha outra");
                    } else {
                        Pilha.movimentar(pilha1, pilha3);
                        System.out.println("Pilha 1: ");
                        pilha1.imprimirPilha(pilha1);
                        System.out.println("Pilha 2: ");
                        pilha2.imprimirPilha(pilha2);
                        System.out.println("Pilha 3: ");
                        pilha3.imprimirPilha(pilha3);
                        cont++;
                        if (pilha1.estaVazia() && pilha2.estaVazia() && pilha3.estaOrdenada(pilha3) && Pilha.crescente(ordem)) {
                            System.out.println("A pilha esta ordenada em " + cont + " tentativas");
                            break;
                        } else if (pilha1.estaVazia() && pilha2.estaVazia() && pilha3.estaOrdenadaDec(pilha3) && !Pilha.crescente(ordem)) {
                            System.out.println("A pilha esta ordenada em " + cont + " tentativas");
                            break;
                        }
                    }
                } else if (origem == 2 && destino == 1) {
                    if (pilha2.estaVazia()) {
                        System.out.println("A pilha esta vazia, escolha outra");
                    } else {
                        Pilha.movimentar(pilha2, pilha1);
                        System.out.println("Pilha 1: ");
                        pilha1.imprimirPilha(pilha1);
                        System.out.println("Pilha 2: ");
                        pilha2.imprimirPilha(pilha2);
                        System.out.println("Pilha 3: ");
                        pilha3.imprimirPilha(pilha3);
                        cont++;
                        if (pilha2.estaVazia() && pilha3.estaVazia() && pilha1.estaOrdenada(pilha1) && Pilha.crescente(ordem)) {
                            System.out.println("A pilha esta ordenada em " + cont + " tentativas");
                            break;
                        } else if (pilha2.estaVazia() && pilha3.estaVazia() && pilha1.estaOrdenadaDec(pilha1) && !Pilha.crescente(ordem)) {
                            System.out.println("A pilha esta ordenada em " + cont + " tentativas");
                            break;
                        }
                    }
                }

            } else if (opcao == 2 && Pilha.crescente(ordem)) {
                pilha1.organizarPilha(pilha1, pilha2, pilha3);
                System.out.println("Pilha 1: ");
                pilha1.imprimirPilha(pilha1);
                System.out.println("Pilha 2: ");
                pilha2.imprimirPilha(pilha2);
                System.out.println("Pilha 3: ");
                pilha3.imprimirPilha(pilha3);
                break;
            } else if (opcao == 2 && !Pilha.crescente(ordem)) {
                pilha1.organizarPilhaDec(pilha1, pilha2, pilha3);
                System.out.println("Pilha 1: ");
                pilha1.imprimirPilha(pilha1);
                System.out.println("Pilha 2: ");
                pilha2.imprimirPilha(pilha2);
                System.out.println("Pilha 3: ");
                pilha3.imprimirPilha(pilha3);
                break;
            } else if (opcao == 0) {
                break;
            } else {
                System.out.println("Digite uma opção válida");
            }
        }

    }
}