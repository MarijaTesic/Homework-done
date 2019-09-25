package domaci08292019drugi;

public class Blok {
	protected char[][] kockice;
	protected int N;

	public Blok(int n) {
		this.N = n;
		this.kockice = new char[n][n];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				kockice[i][j] = ' ';
			}
		}
	}

	public void rotacija() {
		for (int i = 0; i < N / 2; i++) {
			for (int j = i; j < N - i - 1; j++) {
				char temp = kockice[i][j];
				kockice[i][j] = kockice[N - 1 - j][i];
				kockice[N - 1 - j][i] = kockice[N - 1 - i][N - 1 - j];
				kockice[N - 1 - i][N - 1 - j] = kockice[j][N - 1 - i];
				kockice[j][N - 1 - i] = temp;
			}
		}
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(kockice[i][j]);
				if (j == N - 1) {
					sb.append("\n");
				}
			}
		}

		return sb.toString();
	}

}
