package tnsjavatask;

import java.util.Scanner;

public class AdditionOfMatrices {
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the number of  rows in matrix");
		int a=sc.nextInt();
		System.out.println("enter the number of columns in matrix");
		int b=sc.nextInt();
		int c[][]=new int[a][b];
		int d[][]=new int[a][b];
		int e[][]=new int[a][b];
		System.out.println("The first matrix is");
		for(int i=0;i<a;i++) {
			for(int j=0;j<b;j++) {
				c[i][j]=sc.nextInt();
			}
		}
		System.out.println("The Second matrix is");
		for(int i=0;i<a;i++) {
			for(int j=0;j<b;j++) {
				d[i][j]=sc.nextInt();
			}
		}
		for(int i=0;i<a;i++) {
			for(int j=0;j<b;j++) {
				e[i][j]=c[i][j]+d[i][j];
			}
		}
		System.out.println("Result matrix is");
		for(int i=0;i<a;i++) {
			for(int j=0;j<b;j++) {
				System.out.print(e[i][j]+" ");
			}
			System.out.println();
		}
	}

}