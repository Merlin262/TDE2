public class Node<Integer> {
    private int valor;
    private Node<Integer> proximo;

    public Node(int valor) {
        this.valor = valor;
        this.proximo = null;
    }

    public int getValor() {
        return valor;
    }

    public Node<Integer> getProximo() {
        return proximo;
    }

    public void setProximo(Node<Integer> proximo) {
        this.proximo = proximo;
    }
}