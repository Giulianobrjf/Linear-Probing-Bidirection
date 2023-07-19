package org.example;

import java.util.Arrays;
import java.util.List;

public class Linear_Probing {

    private int tamanhoatual, tamanhomaximo, incremento;
    private List<String> indices;
    private List<String> valores;

    public Linear_Probing(int tamanhomaximo, int incremento)
    {
        tamanhoatual = 0;
        this.tamanhomaximo = tamanhomaximo;
        indices = Arrays.asList(new String[tamanhomaximo]);;
        valores = Arrays.asList(new String[tamanhomaximo]);;
        this.incremento = incremento;
    }


    public void makeEmpty()
    {
        tamanhoatual = 0;
        indices = Arrays.asList(new String[tamanhomaximo]);
        valores = Arrays.asList(new String[tamanhomaximo]);
    }


    public int getTamanho() { return tamanhoatual; }

    public boolean isFull()
    {
        return tamanhoatual == tamanhomaximo;
    }


    public boolean isEmpty() { return getTamanho() == 0; }


    public boolean contains(String valor)
    {
        return get(valor) != null;
    }

    private int hash(String valor)
    {
        return Integer.parseInt(valor) % tamanhomaximo;
    }
    public int incrementando(int indice){
        int i = (int) ((indice + incremento * Math.pow(-1, incremento)) % tamanhomaximo);
        if(i < 0){
            i = tamanhomaximo + i;
        }
        return i;
    }

    public void insert(String indice, String valor)
    {
        int tmp = hash(indice);
        int i = tmp;

        if(!isFull()){
        while (indices.get(i) != null){
            i = incrementando(i);
        }
        indices.set(i, indice);
        valores.set(i, valor);
        tamanhoatual++;
        }
        else{
            System.out.println("Tabela Cheia");
        }

    }

    public String get(String indice)
    {
        int i = hash(indice);
        while (indices.get(i) != null) {
            if (indices.get(i).equals(indice))
                return valores.get(i);
            i = incrementando(i);
        }
        return null;
    }


    public void remove(String indice)
    {

        if (!contains(indice))
            return;

        int i = hash(indice);
        while (!indice.equals(indices.get(i)))
            i = incrementando(i);
        indices.set(i,null);
        valores.set(i,null);

        for (i = incrementando(i); indices.get(i) != null;
             i = incrementando(i)) {
            String tmp1 = indices.get(i), tmp2 = valores.get(i);
            indices.set(i,null);
            valores.set(i,null);
            tamanhoatual--;
            insert(tmp1, tmp2);
        }
        tamanhoatual--;
    }
    public void removeA(String indice){

        int i = hash(indice);

        while (indices.get(i) != null) {
            if (indices.get(i).equals(indice)) {
                indices.set(i, "A");
                valores.set(i, "A");
                tamanhoatual--;
                break;
            }
            i = incrementando(i);
        }
    }
    public void removeAllA() {
        for (int i = 0; i < tamanhomaximo; i++) {
            if(valores.get(i) == "A"){
                System.out.println(i);
                valores.set(i,null);
                indices.set(i,null);
                remove(String.valueOf(i));
            }
        }
    }


    public void printHashTable()
    {
        System.out.println("\nHash Table: ");
        for (int i = 0; i < tamanhomaximo; i++)
            if (indices.get(i) != null)
                System.out.println(indices.get(i) + " " + valores.get(i));
        System.out.println();
    }
}
