package com.que2;

import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Matrix m = new Matrix();

		// matrix 1
		System.out.println("Enter the matrix1 order (Row x Col): ");
		System.out.println("Row:");
		int row1 = sc.nextInt();
		System.out.println("Col:");
		int col1 = sc.nextInt();

		int[][] mat1 = new int[row1][col1];
		System.out.println("Enter Matrix1 Elements:");
		for (int i = 0; i < row1; i++) {
			for (int j = 0; j < col1; j++) {
				mat1[i][j] = sc.nextInt();
			}
		}

		// matrix 2
		System.out.println("Enter the matrix2 order (Row x Col): ");
		System.out.println("Row:");
		int row2 = sc.nextInt();
		System.out.println("Col:");
		int col2 = sc.nextInt();
		int[][] mat2 = new int[row2][col2];
		System.out.println("Enter Matrix2 Elements:");
		for (int i = 0; i < row2; i++) {
			for (int j = 0; j < col2; j++) {
				mat2[i][j] = sc.nextInt();
			}
		}
		boolean exit = false;
		while (!exit) {
			System.out.println("1. Addition 2. Subtraction 3. Multiplication ");
			System.out.println("4. Transpose 5. Scalar Product 6. Symmetry Check 0. Exit");
			System.out.println("Enter choice: ");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				m.matrixAddition(mat1, mat2);
				break;
			case 2:
				m.matrixSubtraction(mat1, mat2);
				break;
			case 3:
				m.matrixMultiplication(mat1, mat2);
				break;
			case 4:
				System.out.println("1.Matrix1 2.Matrix2 \n Enter choice: ");
				int ch = sc.nextInt();
				switch (ch) {
				case 1:
					m.transposeMatrix(mat1);
					break;
				case 2:
					m.transposeMatrix(mat2);
					break;
				default:
					System.out.println("Invalid choice!!!");
					break;
				}

				break;
			case 5:
				System.out.println("Enter the scalar value for scalar product of matrix:");
				int scalar = sc.nextInt();
				System.out.println("1.Matrix1 2.Matrix2 \n Enter choice: ");
				int num = sc.nextInt();
				switch (num) {
				case 1:
					m.scalarProduct(mat1, scalar);
					break;
				case 2:
					m.scalarProduct(mat2, scalar);
					break;
				default:
					System.out.println("Invalid choice!!!");
					break;
				}

				break;
			case 6:
				System.out.println("1.Matrix1 2.Matrix2 \n Enter choice: ");
				int select = sc.nextInt();
				switch (select) {
				case 1:
					m.matrixSymmetry(mat1);
					break;
				case 2:
					m.matrixSymmetry(mat2);
					break;
				default:
					System.out.println("Invalid choice!!!");
					break;
				}

				break;
			case 0:
				exit = true;
				break;

			default:
				System.out.println("Invalid choice!!!");
				break;
			}
		}	

		sc.close();
	}

}
