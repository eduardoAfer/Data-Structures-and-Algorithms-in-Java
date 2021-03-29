import java.util.Scanner;

public class Matrix {
   int data[][]; // os elementos da matriz em si
   int rows;     // numero de linhas
   int cols;     // numero de colunas

   // construtor padrao de matriz
   Matrix(int r, int c) {
      data = new int[r][c];
      rows = r;
      cols = c;
   }

   // Ler os rows x cols elementos da matriz
   public void read(Scanner in) {
      for (int i=0; i<rows; i++)
         for (int j=0; j<cols; j++)
            data[i][j] = in.nextInt();
   }

   // Representacao em String da matriz
   @Override
   public String toString() {
      String ans = "";
      for (int i=0; i<rows; i++) {
         for (int j=0; j<cols; j++)
            ans += data[i][j] + " ";
         ans += "\n";
      }
      return ans;
   }

   public static Matrix identity(int n){
       Matrix mat = new Matrix(n, n); 
       for(int i = 0; i < n; i++){
           for(int j = 0; j < n ; j++){
               if( i == j ) mat.data[i][j] = 1;
               else mat.data[i][j] = 0;
           }
       }
       return mat;
   }
   

   public Matrix transpose(){
       Matrix mat = new Matrix(cols, rows);
        for(int i = 0; i < cols; i++){
            for(int j = 0; j < rows ; j++){
              mat.data[i][j] = data[j][i];
            }
        }
        return mat;
   } 
   
   public Matrix sum(Matrix m){
       Matrix mat = new Matrix(rows, cols);
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols ; j++){
             mat.data[i][j] = data[i][j] + m.data[i][j];
            }
        }
        return mat;
   }
   public Matrix multiply(Matrix m){
        Matrix mat = new Matrix(rows, m.cols); 
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < mat.cols; j++){
                for(int k = 0; k < cols ; k++){
                    mat.data[i][j] += data[i][k] * m.data[k][j];
                }
            }
            
        }
        return mat;
    }
    
}