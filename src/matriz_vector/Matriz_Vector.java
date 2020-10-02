/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matriz_vector;

import java.util.Scanner;

/**
 *
 * @author alumnat
 */
public class Matriz_Vector {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Añadimos la posibilidad de hacer input
        Scanner input = new Scanner(System.in);

        int col = (int) (Math.random() * 9) + 2;
        int row = (int) (Math.random() * 9) + 2;

        System.out.println("Convertir vector a matriz (1). "
                + "Convertir matriz a vector (2) ");
        int option = input.nextInt();

        int matrix[][] = new int[0][0];
        int vector[] = new int[0];

        switch (option) {
            case 1:
                vector = random_vector(col, row);
                System.out.println("");
                matrix = vector_to_matrix(col, row, vector);
                System.out.println("");
                break;
            case 2:
                matrix = random_matrix(col, row);
                System.out.println("");
                vector = matrix_to_vector(col, row, matrix);
                System.out.println("");
                break;
            default:
                System.out.println("Por favor, pon una opcion valida");
                break;
        }

        System.out.println("Seleccionar la posicion del valor a cambiar en el vector (1). "
                + "Seleccionar la posicion del valor a cambiar en la matriz (2) ");
        option = input.nextInt();
        boolean valid = false;
        switch (option) {
            case 1:
                while (valid == false) {

                    System.out.print("Seleccionar la posicion del valor a"
                            + " cambiar en el vector: ");
                    int position = input.nextInt();

                    if (position > 0 && position <= vector.length) {
                        System.out.print("Elige el valor: ");
                        int value = input.nextInt();
                        update_vector(position, value, vector);
                        System.out.println("");
                        matrix = vector_to_matrix(col, row, vector);
                        System.out.println("");
                        valid = true;
                    } else {
                        System.out.println("Por favor, pon una opcion valida."
                                + " El vector es de tamaño" + vector.length);
                    }

                }
                break;
            case 2:
                while (valid == false) {

                    System.out.println("\nSeleccionar la posicion del valor a"
                            + " cambiar en la matriz: ");
                    System.out.print("\nPosicion de la columna: ");
                    int position_col = input.nextInt();

                    System.out.print("Posicion de la fila: ");
                    int position_row = input.nextInt();

                    if ((position_col > 0 && position_col <= col) && (position_row > 0 && position_row <= row)) {
                        System.out.print("Elige el valor: ");
                        int value = input.nextInt();
                        update_matrix(position_col, position_row, value, matrix);
                        System.out.println("");
                        vector = matrix_to_vector(col, row, matrix);
                        System.out.println("");
                        valid = true;
                    } else {
                        System.out.println("Por favor, pon una opcion valida."
                                + " La matriz es de " + col + "x" + row);
                    }

                }
                break;
            default:
                System.out.println("Por favor, pon una opcion valida");
                break;
        }

    }

    public static int[] random_vector(int col, int row) {

        int vector[] = new int[col * row];

        System.out.println("Vector de tamaño: " + vector.length);
        for (int i = 0; i < (col * row); i++) {
            vector[i] = (int) (Math.random() * 10) + 1;
            System.out.print(vector[i] + " ");
        }

        System.out.println("");

        return vector;
    }

    public static int[][] vector_to_matrix(int col, int row, int vector[]) {

        System.out.println("Matriz de: " + col + "x" + row);

        int[][] matrix = new int[col][row];

        int index = 0;

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                matrix[i][j] = vector[index++];
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }

        return matrix;
    }

    public static int[] update_vector(int position, int value, int[] vector) {

        System.out.println("");

        //Cambiamos el valor del vector
        vector[position - 1] = value;

        //Mostrar por pantalla el vector
        System.out.println("Vector de tamaño: " + vector.length);

        for (int i = 0; i < vector.length; i++) {
            System.out.print(vector[i] + " ");
        }

        System.out.println("");
        return vector;
    }

    public static int[][] random_matrix(int col, int row) {

        int[][] matrix = new int[col][row];

        System.out.println("Matriz de: " + col + "x" + row);

        //Generamos la matriz y la mostramos por pantalla
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                matrix[i][j] = (int) (Math.random() * 10) + 1;
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }

        return matrix;
    }

    public static int[] matrix_to_vector(int col, int row, int matrix[][]) {

        System.out.println("Vector de tamaño: " + col * row);

        int[] vector = new int[col * row];

        int index = 0;

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                vector[index++] = (int) matrix[i][j];
                System.out.print(vector[index - 1] + " ");
            }
        }

        return vector;
    }

    public static int[][] update_matrix(int position_col, int position_row, int value, int[][] matrix) {
        System.out.println("");

        //Cambiamos el valor del vector
        matrix[position_col - 1][position_row - 1] = value;

        //Mostrar por pantalla el vector
        System.out.println("Matriz de: " + matrix.length + "x" + matrix[0].length);

        int index = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
        return matrix;
    }
}
