public class ED212 {
    public static int[] sumLevels(BTree<Integer> t) {

        int[] vet = new int[t.depth() + 1];
        sumLevels(t.getRoot(), 0, vet);
        return vet;

    }

    public static int[] sumLevels(BTNode<Integer> nodo, int level, int[] vet) {
        if (nodo == null)
            return vet;

        vet[level] += nodo.getValue();

        sumLevels(nodo.getLeft(), level + 1, vet);
        sumLevels(nodo.getRight(), level + 1, vet);

        return vet;
    }
}
