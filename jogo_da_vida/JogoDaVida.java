import java.util.*;


class Coordenada {
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


class Matrix {
    int L, C;
    char [][] data;



    Matrix(int L, int C){
        this.L = L;
        this.C = C;
        data = new char [L][C];
    }



    public void read(Scanner in){
        for(int i = 0; i < L; i++){
            data[i] = in.next().toCharArray();            
        }
    }
    @Override
    public String toString() {
       String ans = "";
       for (int i=0; i<L; i++) {
          for (int j=0; j<C; j++)
             ans += data[i][j] + "";
          ans += "\n";
       }
       return ans;
    }
  


    public void mudaEstado(int i, int j){
        if(data[i][j] == '.') data[i][j] = 'O';
        else data[i][j] = '.';
    }

    
    


}


public class JogoDaVida {
    public static void main(String [] args){
        Scanner stdin = new Scanner(System.in);

        int L = stdin.nextInt();
        int C = stdin.nextInt();
        int I = stdin.nextInt();

        Matrix mat = new Matrix(L, C);
        mat.read(stdin);

        for(int m = 0; m < I; m++){

            Coordenada coordMat = new Coordenada(L, C);

            for(int i = 0; i < L; i++){
                for(int j = 0; j < C; j++){
                    //verifica vizinhos a partir de celula viva
                    if(mat.data[i][j] == 'O') verificaVizinhos1(mat, i, j, L, C, coordMat);
                    

                    //verifica vizinhos a partir de celula morta
                    else verificaVizinhos2(mat, i, j, L, C, coordMat);
                }
            }

            //altera todos os estados das coordenadas gravadas
            for(int i = 0; i < L; i++){
                for(int j = 0; j < C; j++){
                    if(coordMat.data[i][j]) mat.mudaEstado(i, j);
                }
            }

        }
        System.out.print(mat);
        

    }



    public static void verificaVizinhos1(Matrix mat, int i, int j, int L, int C, Coordenada coordMat){
        int vizinhosVivos = 0;
        for(int m = i -1; m <= i+1; m++){
            for(int n = j -1; n <= j+1; n++){
                if(m < 0 || n < 0 || m >= L || n >= C || (m == i && n == j)) continue;
                else{
                    if(mat.data[m][n] == 'O') vizinhosVivos++;
                }

            }
        }
        if(vizinhosVivos <= 1) coordMat.gravaCoordenada(i, j);
        else if(vizinhosVivos >= 4) coordMat.gravaCoordenada(i, j);
       
    }

    public static void verificaVizinhos2(Matrix mat, int i, int j, int L, int C, Coordenada coordMat){
        int vizinhosVivos = 0;
        for(int m = i -1; m <= i+1; m++){
            for(int n = j -1; n <= j+1; n++){
                if(m < 0 || n < 0 || m >= L || n >= C || (m == i && n == j)) continue;
                else{
                    //System.out.println("m =  " + m + "\n"  + "n= "+ n );
                    if(mat.data[m][n] == 'O') {
                        //System.out.println("m =  " + m + "\n"  + "n= "+ n );
                        vizinhosVivos++;
                    }
                }
            }
        }
        if(vizinhosVivos == 3) coordMat.gravaCoordenada(i, j);
       
    }

}



