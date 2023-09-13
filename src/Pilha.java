public class Pilha<Integer> {
    private Node<Integer> topo;

    public void adicionar(int valor) {
        Node<Integer> newNode = new Node<>(valor);
        newNode.setProximo(topo);
        topo = newNode;
    }

    // Método para remover o elemento do topo da pilha
    public int remover() {
        if (estaVazia()) {
            throw new IllegalStateException("A pilha está vazia");
        }
        int elementoRemovido = topo.getValor();
        topo = topo.getProximo();
        return elementoRemovido;
    }

    // Método para verificar se a pilha está vazia
    public boolean estaVazia() {
        return topo == null;
    }

    public static <Integer> void movimentar(Pilha<Integer> origem, Pilha<Integer> destino) {
        if (origem.estaVazia()) {
            System.out.println("A pilha de origem está vazia");
        } else {
            int elementoMovido = origem.remover();
            destino.adicionar(elementoMovido);
        }
    }

    public void organizarPilha(Pilha<Integer> origem, Pilha<Integer> auxiliar, Pilha<Integer> destino) {
        int cont = 0;
        while (!origem.estaVazia()) {

            int elemento = origem.remover();
            cont++;
            // Move elementos maiores da pilha destino para a pilha auxiliar
            while (!destino.estaVazia() && destino.topo.getValor() < elemento) {
                auxiliar.adicionar(destino.remover());
                cont++;
            }

            // Coloca o elemento na pilha destino
            destino.adicionar(elemento);
            cont++;

            // Move elementos de volta da pilha auxiliar para a pilha destino
            while (!auxiliar.estaVazia()) {
                destino.adicionar(auxiliar.remover());
                cont++;
            }
        }
        System.out.println("A quantidade minimo de movimentos necessários: " + cont);
    }

    public void organizarPilhaDec(Pilha<Integer> origem, Pilha<Integer> auxiliar, Pilha<Integer> destino) {
        int cont = 0;
        while (!origem.estaVazia()) {

            int elemento = origem.remover();
            cont++;
            // Move elementos maiores da pilha destino para a pilha auxiliar
            while (!destino.estaVazia() && destino.topo.getValor() > elemento) {
                auxiliar.adicionar(destino.remover());
                cont++;
            }

            // Coloca o elemento na pilha destino
            destino.adicionar(elemento);
            cont++;

            // Move elementos de volta da pilha auxiliar para a pilha destino
            while (!auxiliar.estaVazia()) {
                destino.adicionar(auxiliar.remover());
                cont++;
            }
        }
        System.out.println("A quantidade minimo de movimentos necessários: " + cont);
    }

    public void imprimirPilha(Pilha<Integer> pilha) {
        Node<Integer> atual = pilha.topo;
        System.out.print("[");
        while (atual != null) {
            System.out.print(atual.getValor());
            atual = atual.getProximo();
            if (atual != null) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public boolean estaOrdenada(Pilha<Integer> pilha) {
        Pilha<Integer> auxiliar = new Pilha<>();
        int elementoAtual = pilha.remover();
        auxiliar.adicionar(elementoAtual);
        boolean ordenada = true;

        while (!pilha.estaVazia()) {
            int proximoElemento = pilha.remover();

            if (proximoElemento < elementoAtual) {
                ordenada = false;
                break;
            }

            auxiliar.adicionar(proximoElemento);
            elementoAtual = proximoElemento;
        }

        // Restaurar a pilha original
        while (!auxiliar.estaVazia()) {
            pilha.adicionar(auxiliar.remover());
        }

        return ordenada;
    }

    public boolean estaOrdenadaDec(Pilha<Integer> pilha) {
        Pilha<Integer> auxiliar = new Pilha<>();
        int elementoAtual = pilha.remover();
        auxiliar.adicionar(elementoAtual);
        boolean ordenada = true;

        while (!pilha.estaVazia()) {
            int proximoElemento = pilha.remover();

            if (proximoElemento > elementoAtual) {
                ordenada = false;
                break;
            }

            auxiliar.adicionar(proximoElemento);
            elementoAtual = proximoElemento;
        }

        // Restaurar a pilha original
        while (!auxiliar.estaVazia()) {
            pilha.adicionar(auxiliar.remover());
        }

        return ordenada;
    }

    public static boolean crescente(int ordem) {
        if (ordem == 1) {
            return true;
        } else {
            return false;
        }
    }

}
