public class BST {
    private Node raiz;

    public BST() {
        this.raiz = null;
    }

    public void insert(int isbn) {
        raiz = insertRec(raiz, isbn);
    }

    private Node insertRec(Node raiz, int isbn) {
        if (raiz == null) {
            raiz = new Node(isbn);
            return raiz;
        }
        if (isbn < raiz.isbn) {
            raiz.ladoEsquerdo = insertRec(raiz.ladoEsquerdo, isbn);
        } else if (isbn > raiz.isbn) {
            raiz.ladoDireito = insertRec(raiz.ladoDireito, isbn);
        }
        return raiz;
    }

    public boolean buscar(int isbn) {
        return buscarRec(raiz, isbn);
    }

    private boolean buscarRec(Node raiz, int isbn) {
        if (raiz == null) {
            return false;
        }
        if (raiz.isbn == isbn) {
            return true;
        }
        if (isbn < raiz.isbn) {
            return buscarRec(raiz.ladoEsquerdo, isbn);
        }
        return buscarRec(raiz.ladoDireito, isbn);
    }

    public void delete(int isbn) {
        raiz = deleteRec(raiz, isbn);
    }

    private Node deleteRec(Node raiz, int isbn) {
        if (raiz == null) {
            return raiz;
        }
        if (isbn < raiz.isbn) {
            raiz.ladoEsquerdo = deleteRec(raiz.ladoEsquerdo, isbn);
        } else if (isbn > raiz.isbn) {
            raiz.ladoDireito = deleteRec(raiz.ladoDireito, isbn);
        } else {
            if (raiz.ladoEsquerdo == null) {
                return raiz.ladoDireito;
            } else if (raiz.ladoDireito == null) {
                return raiz.ladoEsquerdo;
            }
            raiz.isbn = minValor(raiz.ladoDireito);
            raiz.ladoDireito = deleteRec(raiz.ladoDireito, raiz.isbn);
        }
        return raiz;
    }

    private int minValor(Node raiz) {
        int minValor = raiz.isbn;
        while (raiz.ladoEsquerdo != null) {
            minValor = raiz.ladoEsquerdo.isbn;
            raiz = raiz.ladoEsquerdo;
        }
        return minValor;
    }
}
