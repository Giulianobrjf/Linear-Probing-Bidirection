package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Hash Table Test\n\n");
        System.out.println("Digite o tamanho máximo da tabela:");
        int tamanhomaximo = scan.nextInt();
        System.out.println("Digite o incremento:");
        int incremento = scan.nextInt();

        Linear_Probing lpht = new Linear_Probing(tamanhomaximo, incremento);


        lpht.insert("1", "A");
        lpht.insert("24", "B");
        lpht.insert("2", "C");
        lpht.insert("47", "D");
        lpht.insert("70", "E");
        lpht.insert("10", "F");
        lpht.insert("33", "G");
        lpht.insert("20", "I");

        lpht.printHashTable();
        char ch;

        do {
            // Menu
            System.out.println("\nHash Table Operações\n");
            System.out.println("1. Inserir ");
            System.out.println("2. Remover");
            System.out.println("3. Procurar");
            System.out.println("4. Limpar");
            System.out.println("5. Tamanho");
            System.out.println("6. Define Avaliable");
            System.out.println("7. Remove todos Avaliable");
            int choice = scan.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Digite um índice e um valor:");
                    lpht.insert(scan.next(), scan.next());
                    break;

                case 2:
                    System.out.println("Digite um índice:");
                    lpht.remove(scan.next());
                    break;

                case 3:
                    System.out.println("Digite um indice:");
                    System.out.println("Valor = " + lpht.get(scan.next()));
                    break;

                case 4:
                    lpht.makeEmpty();
                    System.out.println("Hash Table Limpa\n");
                    break;

                case 5:
                    System.out.println("Tamanho = " + lpht.getTamanho());
                    break;

                case 6:
                    System.out.println("Digite um índice:");
                    lpht.removeA(scan.next());
                    break;

                case 7:
                    lpht.removeAllA();
                    break;

                default:
                    System.out.println("Entrada inválida.\n");
                    break;
            }

            lpht.printHashTable();

            System.out.println("\nDeseja continuar (Digite y ou n):");
            ch = scan.next().charAt(0);
        } while (ch == 'y' || ch == 'Y');
    }
}