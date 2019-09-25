package domaci;

import java.util.Random;
import java.util.Scanner;

public class Matrica {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Unesite dimenziju kvadratne matrice : ");
		int n = sc.nextInt();

		int[][] matrica = new int[n][n];
		generisiElementeMatrice(matrica, 100);
		System.out.println("Matrica izgleda ovako: ");
		ispisiMatricu(matrica);
		System.out.println();

		int[] elementiNaglavnoj = elementiNaGlavnojDijagonali(matrica);
		System.out.println("Elementi na glavnoj dijagonali su: ");
		if(elementiNaglavnoj!=null) ispisiNiz(elementiNaglavnoj);
		else System.out.println("Greska u funkciji elementiNaGlavnojDijagonali");
		System.out.println();

		System.out.println("Elementi na sporednoj dijagonali su: ");
		int[] elementiNaSporednoj = elementiNaSporednojDijagonali(matrica);
		if(elementiNaSporednoj!=null) ispisiNiz(elementiNaSporednoj);
		else System.out.println("Greska u funkciji elementiNaSporednojDijagonali");
		System.out.println();

		System.out.println("Elementi iznad glavne dijagonale su: ");
		ispisiElementeIznadGlavneDijagonale(matrica);
		System.out.println();

		System.out.println("Elementi ispod glavne dijagonale su: ");
		ispisiElementeIspodGlavneDijagonale(matrica);
		System.out.println();

		int[][] transponovanaMatrica = transponujMatricu(matrica);
		System.out.println("Transponovana matrica izgleda ovako: ");
		if(transponovanaMatrica!=null)ispisiMatricu(transponovanaMatrica);
		else System.out.println("Greska u funkciji transponujMatricu.");
		System.out.println();

		System.out.println("Pre uklanjanja duplih elemenata niz izgleda ovako: ");
		ispisiNiz(elementiNaglavnoj);
		System.out.println();

		elementiNaglavnoj = ukloniElementeKojiSePonavljajuUnizu(elementiNaglavnoj);
		System.out.println("Nakon uklanjanja duplih elemenata niz izlgeda ovako: ");
		if(elementiNaglavnoj!=null) ispisiNiz(elementiNaglavnoj);
		else System.out.println("Greska u funkcji ukloniElementeKojiSePonavljajuUnizu");

		}

		public static void generisiElementeMatrice(int[][] matrica, int gornjaGranica){
		Random r=new Random();
		for(int i=0;i<matrica.length;i++) {
		for(int j=0;j<matrica[i].length;j++) {
		matrica[i][j]=r.nextInt(gornjaGranica);
		}
		}
		}

		public static int[] elementiNaGlavnojDijagonali(int[][] matrica){
		int []niz=new int[matrica.length];

		for(int i=0;i<matrica.length;i++) {
		niz[i] = matrica[i][i];
		}

		return niz;
		}

		public static int[] elementiNaSporednojDijagonali(int[][] matrica){
		int []niz=new int[matrica.length];

		for(int i=0;i<matrica.length;i++) {
		niz[i] = matrica[i][matrica.length - 1 - i];
		}

		return niz;
		}

		public static int[][] transponujMatricu(int[][] matrica){
		int n=matrica.length;
		int m=matrica[0].length;
		int[][]trans=new int[m][n];
		int i,j;
		for(i=0;i<matrica.length;i++) {
		for(j=0;j<matrica[i].length;j++) {
		trans[j][i]=matrica[i][j];
		}
		}

		return trans;
		}

		public static void ispisiElementeIznadGlavneDijagonale (int[][] matrica){
		for(int i = 0; i<matrica.length-1; i++){
		for(int j = i+1; j<matrica[i].length; j++){
		System.out.print(matrica[i][j] + " ");
		}
		}

		}

		public static void ispisiElementeIspodGlavneDijagonale (int[][] matrica){
		for(int i=1;i<matrica.length;i++){
		for(int j=0;j<=i-1;j++){
		System.out.print(matrica[i][j]+" ");
		}
		}
		}

		public static void ispisiMatricu(int[][] matrica){
		for(int i=0;i<matrica.length;i++) {
		for(int j=0;j<matrica[i].length;j++) {
		System.out.println(matrica[i][j]+ " ");
		}
		System.out.println();
		}
		}

		public static void ispisiNiz(int[] niz){
		System.out.println("Elementi niza su: ");
		for(int i=0;i<niz.length;i++) {
		System.out.println(niz[i]+ " ");
		}
		}

		public static int[] ukloniElementeKojiSePonavljajuUnizu(int[] niz){
		
		

		return null;

		}

		}
