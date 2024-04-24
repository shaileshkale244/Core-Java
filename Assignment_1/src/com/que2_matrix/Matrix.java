package com.que2;

public class Matrix {

	public void displayMatrix(int[][] arr) {
		int row = arr.length;
		int col = arr[0].length;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void matrixMultiplication(int[][] mat1, int[][] mat2) {
		int res[][] = new int[mat1.length][mat2[0].length];
		if (mat2.length != mat1[0].length) {
			System.out.println("Multiplication not possible!");
			return;
		}
		for (int i = 0; i < mat1.length; i++) {
			for (int j = 0; j < mat2[0].length; j++) {
				for (int k = 0; k < mat2.length; k++) {
					res[i][j] += mat1[i][k] * mat2[k][j];
				}

			}
		}
		System.out.println("Multiplication of matrix:");
		displayMatrix(res);
	}

	public void transposeMatrix(int[][] mat) {
		int res[][] = new int[mat[0].length][mat.length];
		for (int i = 0; i < mat[0].length; i++) {
			for (int j = 0; j < mat.length; j++) {
				res[i][j] = mat[j][i];
			}
		}
		System.out.println("Transposed matrix:");
		displayMatrix(res);
	}

	public void scalarProduct(int[][] mat, int scalar) {
		int res[][] = new int[mat.length][mat[0].length];
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				res[i][j] = scalar * mat[i][j];
			}
		}
		System.out.println("Scalar Product of matrix: ");
		displayMatrix(res);
	}

	public void matrixAddition(int[][] mat1, int[][] mat2) {
		int res[][] = new int[mat1.length][mat2[0].length];
		if ((mat1[0].length != mat2[0].length) && (mat1.length != mat2.length)) {
			System.out.println("Addition not possible!");
			return;
		}
		for (int i = 0; i < mat1.length; i++) {
			for (int j = 0; j < mat1[0].length; j++) {
				res[i][j] += mat1[i][j] + mat2[i][j];
			}
		}
		System.out.println("Addition of matrix:");
		displayMatrix(res);
	}

	public void matrixSubtraction(int[][] mat1, int[][] mat2) {
		int res[][] = new int[mat1.length][mat2[0].length];
		if ((mat1[0].length != mat2[0].length) && (mat1.length != mat2.length)) {
			System.out.println("Subtraction not possible!");
			return;
		}
		for (int i = 0; i < mat1.length; i++) {
			for (int j = 0; j < mat1[0].length; j++) {
				res[i][j] += mat1[i][j] - mat2[i][j];
			}
		}
		System.out.println("Subtraction of matrix:");
		displayMatrix(res);
	}

	public void matrixSymmetry(int[][] matrix) {
		if (matrix.length != matrix[0].length) {
			System.out.println("Symmetry cannot be Defined !"); // Square matrix is required for symmetry
			return;
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < i; j++) {
				if (matrix[i][j] != matrix[j][i]) {
					System.out.println("Matrix is not Symmetric!");
					return;// If corresponding elements are not equal, matrix
																	// is not symmetric
				}
			}
		}

		System.out.println("Matrix is Symmetric!");
	}

}
