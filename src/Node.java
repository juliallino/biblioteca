public class Node {
    int isbn;
    Node ladoEsquerdo;
    Node ladoDireito;

    public Node(int isbn) {
        this.isbn = isbn;
        this.ladoEsquerdo = null;
        this.ladoDireito = null;
    }
}

