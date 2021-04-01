
public class Coordenada {
    int L;
    int C;
    boolean [][] data;

    Coordenada(int L, int C){ 
        this.L = L;
        this.C = C;
        data = new boolean [L][C];
    }

    public void gravaCoordenada(int i, int j){
        data[i][j] = true;
    }

    public void resetCoord(int L, int C){
        for(int i = 0; i < L; i++){
            for(int j = 0; j < C; j++){
                data[i][j] = false;
            }
        }
    }



}
