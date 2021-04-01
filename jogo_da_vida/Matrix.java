import java.util.*;

public class Matrix {
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
             ans += data[i][j] + " ";
          ans += "\n";
       }
       return ans;
    }
  


    public void mudaEstado(int i, int j){
        if(data[i][j] == '.') data[i][j] = 'O';
        else data[i][j] = '.';
    }

    
    


}
