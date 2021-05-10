public class TestSinglyLinkedList {
    public static void main(String[] args) {

        // Criacao de lista de inteiros
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        SinglyLinkedList<Integer> listVazia = new SinglyLinkedList<Integer>();
        SinglyLinkedList<String> listString = new SinglyLinkedList<String>();

        listString.addFirst("eduardo");
        listString.addFirst("miguel");
        listString.addFirst("joao");
        listString.addFirst("malu");

        System.out.println(listString);
        System.out.println(listString.remove(-1));

        listString.duplicate();
        System.out.println(listString);

        System.out.println(listString);

        // Adicionando numeros de 1 a 5 ao final da lista
        for (int i = 1; i <= 5; i++)
            list.addLast(i);
        System.out.println(list);

        // Adicionando numeros de 6 a 10 ao inicio da lista
        for (int i = 6; i <= 10; i++)
            list.addFirst(i);
        System.out.println(list);

        list.remove(5);
        System.out.println(list);

        System.out.println("lista na posicao 2 = " + listString.get(2));

        SinglyLinkedList<Integer> newList = list.copy();
        System.out.println("nova lista -> " + newList);

        list.duplicate();
        System.out.print("lista duplicada -> " + list);

    }
}