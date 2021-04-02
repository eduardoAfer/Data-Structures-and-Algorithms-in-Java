public class Coordenadas {
    int LINS, COLS;
    boolean[][] data;


    Coordenadas(int LINS, int COLS){
        this.LINS = LINS;
        this.COLS = COLS;
        data = new boolean[LINS][COLS];
    }

    public void mudaEstado(int i, int j){
        data[i][j] = true;
    }

    @Override
    public String toString() {
       String ans = "";
       for (int i=0; i<LINS; i++) {
          for (int j=0; j<COLS; j++)
             ans += data[i][j] + " ";
          ans += "\n";
       }
       return ans;
    }
}
