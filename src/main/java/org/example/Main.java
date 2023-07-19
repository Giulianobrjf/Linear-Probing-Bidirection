package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

                Scanner scan = new Scanner(System.in);

                System.out.println("Hash Table Test\n\n");
                System.out.println("Digite uma entrada");

                Linear_Probing lpht = new Linear_Probing(scan.nextInt(),3);

                lpht.insert("12","20");
                lpht.printHashTable();
                lpht.insert("5","22");
                lpht.printHashTable();
                lpht.insert("15","4");
                lpht.printHashTable();
                lpht.insert("19","13");
                lpht.printHashTable();
        char ch;

                do
                {
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

                        // Case 1
                        case 1:


                            System.out.println("Digite um indice e um valor");
                            lpht.insert(scan.next(), scan.next());

                            break;


                        case 2:


                            System.out.println("Digite um indice");
                            lpht.remove(scan.next());

                            break;


                        case 3:


                            System.out.println("Digite um valor");
                            System.out.println("Valor = "
                                    + lpht.get(scan.next()));

                            break;


                        case 4:

                            lpht.makeEmpty();

                            System.out.println("Hash Table Limpa\n");

                            break;


                        case 5:

                            System.out.println("Tamanho = " + lpht.getTamanho());
                            break;
                        case 6:

                            System.out.println("Digite um indice");
                            lpht.removeA(scan.next());


                            break;
                        case 7:

                            lpht.removeAllA();


                            break;

                        default:

                            System.out.println("Entrada errada \n ");

                            break;
                    }


                    lpht.printHashTable();


                    System.out.println(
                            "\n Deseja continuar (Digite y ou n)\n");

                    ch = scan.next().charAt(0);
                } while (ch == 'Y' || ch == 'y');


            }
        }