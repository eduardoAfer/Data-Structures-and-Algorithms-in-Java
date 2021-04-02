import java.util.*;

class Coordenadas {
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
             ans += data[i][j] + "";
          ans += "\n";
       }
       return ans;
    }
}



 class Matrix {

    int LINS;
    int COLS;
    char [][] data;


    Matrix(int LINS, int COLS){
        this.LINS = LINS;
        this.COLS = COLS;
        data = new char[LINS][COLS];
        
    }


    public void read(Scanner in){
        for(int i = 0; i < LINS; i++){
            data[i] = in.next().toCharArray();            
        }
    }

    @Override
    public String toString() {
       String ans = "";
       for (int i=0; i<LINS; i++) {
          for (int j=0; j<COLS; j++)
             ans += data[i][j] + "";
          ans += "\n";
       }
       return ans;
    }
  

    //altera todas as celulas da matria que nao for palavra para '.'
    public void alteraEstado(int i, int j){ data[i][j] = '.'; }

    //encontra a ocorrencia da primeira letra da paralvra na matriz
    public void verifOcorrenciaPal(String letra, Coordenadas coordMat, int LINS, int COLS){

        int tamanho = letra.length();
        for(int i = 0; i < LINS; i++){
            for(int j = 0; j < COLS; j++){    

                //verifica primeira letra da paralvra na matriz
                if(letra.charAt(0) == data[i][j]){
                    //System.out.println(letra.charAt(0));


                    if(verifHorizInv(letra, i, j, tamanho) == tamanho){
                                            //System.out.println(coordMat);

                            for(int k = 0; k < tamanho; k++) coordMat.mudaEstado(i, j - k);                            
                    }

                    else if(verifHorizReg(letra, i, j, tamanho) == tamanho){
                        for(int k = 0; k < tamanho; k++) coordMat.mudaEstado(i, j + k);    
                    }
                    else if(verifVertCima(letra, i, j, tamanho) == tamanho){
                        for(int k = 0; k < tamanho; k++) coordMat.mudaEstado(i - k, j);                            

                    }
                    else if(verifVertBaixo(letra, i, j, tamanho) == tamanho){
                        for(int k = 0; k < tamanho; k++) coordMat.mudaEstado(i + k, j);                            

                    }
                }
            }
        }
    } 
            
        
    

    //verifica palvaras na horizontal da direita para a esquerda 
    public int verifHorizInv(String letra, int i, int j, int tamanho){
        int acc = 0;  // acumulador de letras encontradas
        int tamanho_aux = 0;
            for(;j >= 0 && tamanho_aux < tamanho; j--, tamanho_aux++){
                //System.out.println("horinver " + letra.charAt(0));

                if(letra.charAt(acc) != data[i][j])  {
                   // System.out.println("horInv " + letra.charAt(acc)+ "data[k][j]) = " + data[i][j]);

                    break;
                } 
                acc++;
        }
        return acc;
    }

    //verifica palvaras na horizontal da esq para a dir 
    public int verifHorizReg(String letra, int i, int j, int tamanho){
        int acc = 0;  // acumulador de letras encontrada
        int tamanho_aux = 0;
            for(;j < COLS && tamanho_aux < tamanho; j++, tamanho_aux++){
                //System.out.println("horireg " + letra.charAt(0));
                if(letra.charAt(acc) != data[i][j]){
                    //System.out.println("horreg " + letra.charAt(acc)+ "data[k][j]) = " + data[i][j]);

                    break;
                } 
                acc++;   
        }
        return acc;
    }

    public int verifVertCima(String letra, int i, int j, int tamanho){
        int acc = 0;  // acumulador de letras encontrada 
        int tamanho_aux = 0;
        for(; i >= 0 && tamanho_aux < tamanho; i--, tamanho_aux++){
                if(letra.charAt(acc) != data[i][j]){
                    //System.out.println("vertcima " + letra.charAt(acc)+ "data[k][j]) = " + data[i][j]);

                    break;
                } 
                acc++;
        }
        return acc;
    }
    

    public int verifVertBaixo(String letra, int i, int j, int tamanho){
        int acc = 0;  // acumulador de letras encontrada
        int tamanho_aux = 0;
        int k = i;
        for(; k < LINS && tamanho_aux < tamanho ; k++, tamanho_aux++){
                if(letra.charAt(acc) != data[k][j])  {
                    //System.out.println("vertBaixo " + letra.charAt(acc) + "data[k][j]) = " + data[k][j]);

                    break;
                } 
                acc++;
            }
        
        return acc;
    }

   
  

}




public class SopaDeLetras {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int input = 1;

        while(1 == 1){
            
           
            int LINS = stdin.nextInt();
            int COLS = stdin.nextInt();

            if(LINS == 0 && COLS == 0) break;

            System.out.println("Input #" + input);
            
            Matrix mat = new Matrix(LINS, COLS);
            mat.read(stdin);

            int N = stdin.nextInt();

            Coordenadas coordMat = new Coordenadas(LINS, COLS);

            ArrayList<String> lista = new ArrayList<String>();

            for(int i = 0; i < N; i++){
                String pal = stdin.next();
                lista.add(pal); 
            }

            for(int i = 0; i < N; i++){
                mat.verifOcorrenciaPal(lista.get(i), coordMat, LINS, COLS);
               
            }

            for(int i = 0; i < LINS; i++){
                for(int j = 0; j < COLS; j++){
                    if(coordMat.data[i][j] == false) mat.alteraEstado(i, j);
                    //System.out.println("coordMat\n " + coordMat);
                    //System.out.println("mat\n" + mat);

                }
            }

            System.out.print(mat);
            
            input++;
        }
    }
}
