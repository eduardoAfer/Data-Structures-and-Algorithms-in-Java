public class TestList {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        SinglyLinkedList<String> listString = new SinglyLinkedList<String>();

        list.addLast(2);
        list.addLast(4);
        list.addLast(6);
        list.addLast(8);
        list.addLast(10);

        listString.addLast("a");
        listString.addLast("b");
        listString.addLast("c");
        listString.addLast("d");
        listString.addLast("e");

        System.out.println(list);

        SinglyLinkedList<Integer> newList = list.cut(2, 3);
        System.out.println(newList);

        listString.shift(4);
        System.out.println(listString);

    }
}
