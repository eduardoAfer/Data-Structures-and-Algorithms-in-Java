import javax.print.attribute.standard.NumberUpSupported;
import java.util.*;

public class BTree<T> {
   private BTNode<T> root; // raiz da arvore

   // Construtor
   BTree() {
      root = null;
   }

   // Getter e Setter para a raiz
   public BTNode<T> getRoot() {
      return root;
   }

   public void setRoot(BTNode<T> r) {
      root = r;
   }

   // Verificar se arvore esta vazia
   public boolean isEmpty() {
      return root == null;
   }

   // --------------------------------------------------------

   // Numero de nos da arvore
   public int numberNodes() {
      return numberNodes(root);
   }

   private int numberNodes(BTNode<T> n) {
      if (n == null)
         return 0;
      return 1 + numberNodes(n.getLeft()) + numberNodes(n.getRight());
   }

   // --------------------------------------------------------

   // Altura da arvore
   public int depth() {
      return depth(root);
   }

   private int depth(BTNode<T> n) {
      if (n == null)
         return -1;
      return 1 + Math.max(depth(n.getLeft()), depth(n.getRight()));
   }

   // --------------------------------------------------------

   // O elemento value esta contido na arvore?
   public boolean contains(T value) {
      return contains(root, value);
   }

   private boolean contains(BTNode<T> n, T value) {
      if (n == null)
         return false;
      if (n.getValue().equals(value))
         return true;
      return contains(n.getLeft(), value) || contains(n.getRight(), value);
   }

   // --------------------------------------------------------

   // Imprimir arvore em PreOrder
   public void printPreOrder() {
      System.out.print("PreOrder:");
      printPreOrder(root);
      System.out.println();
   }

   private void printPreOrder(BTNode<T> n) {
      if (n == null)
         return;
      System.out.print(" " + n.getValue());
      printPreOrder(n.getLeft());
      printPreOrder(n.getRight());
   }

   // --------------------------------------------------------

   // Imprimir arvore em InOrder
   public void printInOrder() {
      System.out.print("InOrder:");
      printInOrder(root);
      System.out.println();
   }

   private void printInOrder(BTNode<T> n) {
      if (n == null)
         return;
      printInOrder(n.getLeft());
      System.out.print(" " + n.getValue());
      printInOrder(n.getRight());
   }

   // --------------------------------------------------------

   // Imprimir arvore em PostOrder
   public void printPostOrder() {
      System.out.print("PostOrder:");
      printPostOrder(root);
      System.out.println();
   }

   private void printPostOrder(BTNode<T> n) {
      if (n == null)
         return;
      printPostOrder(n.getLeft());
      printPostOrder(n.getRight());
      System.out.print(" " + n.getValue());
   }

   // --------------------------------------------------------

   // Imprimir arvore numa visita em largura (usando TAD Fila)
   public void printBFS() {
      System.out.print("BFS:");

      MyQueue<BTNode<T>> q = new LinkedListQueue<BTNode<T>>();
      q.enqueue(root);
      while (!q.isEmpty()) {
         BTNode<T> cur = q.dequeue();
         if (cur != null) {
            System.out.print(" " + cur.getValue());
            q.enqueue(cur.getLeft());
            q.enqueue(cur.getRight());
         }
      }
      System.out.println();
   }

   // --------------------------------------------------------

   // Imprimir arvore numa visita em profundidade (usando TAD Pilha)
   public void printDFS() {
      System.out.print("DFS:");

      MyStack<BTNode<T>> q = new LinkedListStack<BTNode<T>>();
      q.push(root);
      while (!q.isEmpty()) {
         BTNode<T> cur = q.pop();
         if (cur != null) {
            System.out.print(" " + cur.getValue());
            q.push(cur.getLeft());
            q.push(cur.getRight());
         }
      }
      System.out.println();
   }

   // --------------------------------------------------------
   // imprime o numero de folhas de uma arvore

   public int numberLeafs() {
      return numberLeafs(root);
   }

   public int numberLeafs(BTNode<T> n) {

      if (n == null)
         return 0;
      if (n.getLeft() == null && n.getRight() == null)
         return 1;

      return (numberLeafs(n.getLeft()) + numberLeafs(n.getRight()));
   }

   // --------------------------------------------------------
   // devolve true caso arvore seja estritamente binária
   // ou false caso nao o seja

   public boolean strict() {
      return strict(root);
   }

   public boolean strict(BTNode<T> nodo) {
      if (nodo == null)
         return true;
      if ((nodo.getLeft() == null && nodo.getRight() != null) || (nodo.getLeft() != null && nodo.getRight() == null))
         return false;

      return (strict(nodo.getLeft()) && strict(nodo.getRight()));

   }

   // --------------------------------------------------------
   // devolve o valor guardado no caminho indicado pela string s.
   /*
    * public T path(String s) { if (s.charAt(0) == 'R') return root.getValue();
    * 
    * int i = 0; BTNode<T> nodo = root;
    * 
    * while (i < s.length()) {
    * 
    * if (s.charAt(i) == 'E') nodo = nodoEsq(nodo); else if (s.charAt(i) == 'D')
    * nodo = nodoDir(nodo); i++; } return (nodo.getValue()); }
    * 
    * public BTNode<T> nodoEsq(BTNode<T> nodo) { return nodo.getLeft(); }
    * 
    * public BTNode<T> nodoDir(BTNode<T> nodo) { return nodo.getRight(); }
    */
   // ----------------------------------------------------------

   public int levelCalculate() {
      return levelCalculate(root) - 1;
   }

   public int levelCalculate(BTNode<T> nodo) {
      if (nodo == null)
         return 0;
      return Math.max(1 + levelCalculate(nodo.getLeft()), 1 + levelCalculate(nodo.getRight()));

   }

   // -------------------------------------------
   public int nodesLevel(int k) {
      return nodesLevel(root, k);
   }

   public int nodesLevel(BTNode<T> nodo, int k) {
      if (nodo == null)
         return 0;
      if (k == 0)
         return 1;
      return nodesLevel(nodo.getLeft(), k - 1) + nodesLevel(nodo.getRight(), k - 1);
   }
   // --------------------------------------------
}
