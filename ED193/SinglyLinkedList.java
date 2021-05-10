
public class SinglyLinkedList<T> {
    private Node<T> first; // Primeiro no da lista
    private int size; // Tamanho da lista

    // Construtor (cria lista vazia)
    SinglyLinkedList() {
        first = null;
        size = 0;
    }

    // Retorna o tamanho da lista
    public int size() {
        return size;
    }

    // retorn valor na posicao determinada em pos
    public T get(int pos) {
        Node<T> cur = first;
        if (isEmpty() || pos >= size || pos < 0)
            return null;
        for (int i = 0; i < pos; i++) {
            cur = cur.getNext();
        }
        return cur.getValue();
    }

    // remove e devolve o elemento na posicao pos
    public T remove(int pos) {
        if (isEmpty() || pos > size || pos < 0)
            return null;

        Node<T> cur = first;
        T valor;
        for (int i = 0; i < pos - 1; i++) {
            cur = cur.getNext();
        }
        valor = cur.getNext().getValue();
        cur.setNext(cur.getNext().getNext());
        return valor;
    }

    // Devolve true se a lista estiver vazia ou falso caso contrario
    public boolean isEmpty() {
        return (size == 0);
    }

    // Adiciona v ao inicio da lista
    public void addFirst(T v) {
        Node<T> newNode = new Node<T>(v, first);
        first = newNode;
        size++;
    }

    // cria e devolve lista identica ao do objeto atual
    public SinglyLinkedList<T> copy() {
        SinglyLinkedList<T> newList = new SinglyLinkedList<T>();
        if (isEmpty())
            return newList;
        Node<T> cur = first;
        newList.addFirst(cur.getValue());
        for (int i = 1; i < size - 1; i++) {
            cur = cur.getNext();
            newList.addLast(cur.getValue());
        }
        return newList;
    }

    // duplica os elelenntos da lista no objeto
    public void duplicate() {
        if (isEmpty())
            ;
        else {
            Node<T> cur = first;
            Node<T> doubleando;
            while (cur != null) {
                doubleando = new Node<T>(cur.getValue(), cur.getNext());
                cur.setNext(doubleando);
                size++;
                cur = cur.getNext().getNext();
            }
        }

    }

    // Adiciona v ao final da lista
    public void addLast(T v) {
        Node<T> newNode = new Node<T>(v, null);
        if (isEmpty()) {
            first = newNode;
        } else {
            Node<T> cur = first;
            while (cur.getNext() != null)
                cur = cur.getNext();
            cur.setNext(newNode);
        }
        size++;
    }

    // Retorna o primeiro valor da lista (ou null se a lista for vazia)
    public T getFirst() {
        if (isEmpty())
            return null;
        return first.getValue();
    }

    // Retorna o ultimo valor da lista (ou null se a lista for vazia)
    public T getLast() {
        if (isEmpty())
            return null;
        Node<T> cur = first;
        while (cur.getNext() != null)
            cur = cur.getNext();
        return cur.getValue();
    }

    // Remove o primeiro elemento da lista (se for vazia nao faz nada)
    public void removeFirst() {
        if (isEmpty())
            return;
        first = first.getNext();
        size--;
    }

    // Remove o ultimo elemento da lista (se for vazia nao faz nada)
    public void removeLast() {
        if (isEmpty())
            return;
        if (size == 1) {
            first = null;
        } else {
            // Ciclo com for e uso de de size para mostrar alternativa ao while
            Node<T> cur = first;
            for (int i = 0; i < size - 2; i++)
                cur = cur.getNext();
            cur.setNext(cur.getNext().getNext());
        }
        size--;
    }

    // conta e devolve a quantidade de ocorrencias do elemento value
    public int count(T value) {
        if (isEmpty())
            return 0;
        Node<T> cur = first;
        int acc = 0;

        for (int i = 0; i < size && cur != null; i++) {
            if (cur.getValue().equals(value))
                acc++;
            cur = cur.getNext();
        }
        return acc;

    }

    // remove da lista todas as ocorrencias do valor value
    public void removeAll(T value) {
        if (isEmpty())
            ;
        else {
            Node<T> cur = first.getNext();
            Node<T> anterior = first;
            for (int i = 0; i < size && cur != null; i++) {
                if (cur.getValue().equals(value))
                    anterior.setNext(cur.getNext());
                else
                    anterior = anterior.getNext();

                cur = cur.getNext();

            }
        }

    }

    // Converte a lista para uma String
    public String toString() {
        String str = "{";
        Node<T> cur = first;
        while (cur != null) {
            str += cur.getValue();
            cur = cur.getNext();
            if (cur != null)
                str += ",";
        }
        str += "}";
        return str;
    }
}