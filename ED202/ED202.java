import java.util.*;

public class ED202 {

	static float min = Float.MAX_VALUE;
	static int N;

	// Escrever todos as permutacoes do array v[]
	static void permutations(float v[][]) {
		boolean used[][] = new boolean[N][N]; // $i$ esta na permutacao?
		Coord perm[][] = new Coord[N][N]; // permutacao actual
		goPerm(0, 0, v, used, perm); // chamar funcao recursiva
	}

	// Gera todos os subconjuntos a partir da posicao 'cur'
	static void goPerm(int curI, int curJ, float v[][], boolean used[][], Coord perm[][]) {
		if (curI == N && curJ == N) { // Caso base: terminamos a permutacao
			float aux = 0;
			for (int i = 0; i < N; i++) // Escrever a permutacao
				for (int j = 0; j < N; j++) {
					aux += v[perm[i][j].x][perm[i][j].y];
					System.out.println();
				}

		} else { // Se nao terminamos, continuar a gerar
			for (int i = 0; i < N; i++) // Tentar todos os elementos
				for (int j = 0; j < N; j++) {
					if (!used[i][j]) {
						used[i][j] = true;
						perm[curI][curJ] = new Coord(i, j);
						goPerm(curI, curJ + 1, v, used, perm);
						goPerm(curI + 1, 0, v, used, perm);
						used[i][j] = false;
					}

				}

		}
	}

	// -----------------------------------------------------------

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);

		N = stdin.nextInt();
		String[] lugares = new String[N];
		float[][] dist = new float[N][N];

		for (int i = 0; i < N; i++)
			stdin.next();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				dist[i][j] = stdin.nextFloat();
			}
		}

		permutations(dist);
	}

}

class Coord {
	int x, y;

	Coord(int x, int y) {
		this.x = x;
		this.y = y;
	}

}
