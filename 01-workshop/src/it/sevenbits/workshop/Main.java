package it.sevenbits.workshop;

import it.sevenbits.workshop.matrix.Matrix;
import it.sevenbits.workshop.queue.DoubleEndedQueue;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        // Размерности для матриц
        int rowsCount, columnsCount;

        // Двусторонняя очередь
        DoubleEndedQueue deq = new DoubleEndedQueue();

        // Поток для записи
        Scanner scanner = new Scanner(System.in);

        // Считывание размерности для 1-й матрицы
        System.out.print("Input rows count: ");
        rowsCount = scanner.nextInt();
        System.out.print("Input columns count: ");
        columnsCount = scanner.nextInt();
        System.out.println();


        // Добавление 1-й матрицы в начало дека
        deq.addFirst(new Matrix(rowsCount,columnsCount));


        // Считывание размерности для 2-й матрицы
        System.out.print("Input rows count: ");
        rowsCount = scanner.nextInt();
        System.out.print("Input columns count: ");
        columnsCount = scanner.nextInt();
        System.out.println();


        // Добавление 2-й матрицы в конец дека
        deq.addLast(new Matrix(rowsCount, columnsCount));


        // Считывание размерности для 3-й матрицы
        System.out.print("Input rows count: ");
        rowsCount = scanner.nextInt();
        System.out.print("Input columns count: ");
        columnsCount = scanner.nextInt();
        System.out.println();


        // Добавление 3-й матрицы в конец дека
        deq.addLast(new Matrix(rowsCount, columnsCount));


        // Считывание размерности для 4-й матрицы
        System.out.print("Input rows count: ");
        rowsCount = scanner.nextInt();
        System.out.print("Input columns count: ");
        columnsCount = scanner.nextInt();
        System.out.println();


        // Добавление 4-й матрицы в начало дека
        deq.addFirst(new Matrix(rowsCount, columnsCount));


        // вывод самого первого элемента дека
        System.out.println(deq.getFirst());

        // вывод самого последнего элемента дека
        System.out.println(deq.getLast());

        // вывод всего дека
        System.out.println(deq);
    }
}
