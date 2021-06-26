public class ED211 {
    public static int countEven(BTree<Integer> t) {
        return countEven(t.getRoot());

    }

    public static int countEven(BTNode<Integer> nodo) {
        if (nodo == null)
            return 0;
        int acc = 0;
        if (nodo.getValue() % 2 == 0)
            acc++;

        return acc + countEven(nodo.getLeft()) + countEven(nodo.getRight());

    }

}
