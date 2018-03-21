/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting3;

import java.util.Scanner;

/**
 *
 * @author pegai
 */

class Dado
{
    private int chave;

    public Dado(int chave) {
        this.chave = chave;
    }
    
    public int getChave() {
        return chave;
    }

    public void setChave(int chave) {
        this.chave = chave;
    }
    
    
    public boolean ehMenorQue(Dado a)    
    {
        return this.chave < a.getChave();
    }
}

class QuickSort
{
    private int size;
    public QuickSort(Dado[] dados)
    {
        this.size = dados.length;
    }
    private void quickSort(Dado[] dados, int p, int r)
    {
        if(p>r)
        {
            int q = particiona(dados, p, r);
            quickSort(dados, p, q-1);
            quickSort(dados, q+1, r);
        }
    }
    
    private void swap(Dado[] dados, int i, int j)
    {
        Dado aux = dados[i];
        dados[i] = dados[j];
        dados[j] = aux;
    }
    /**
     * 
     * @param dados conjunto de dados a ser ordenado
     * @param p inicio do vetor a ser ordenado
     * @param r fim do vetor a ser ordenado
     */
    private int particiona(Dado[] dados, int p, int r)
    {
        Dado aux = dados[r];
        int i, j;
        i = p-1;
        for(j = p; j<r; j++)
        {
            if(dados[i].ehMenorQue(aux))
            {
                i++;
                swap(dados, i, j);
            }
        }
        swap(dados, i+1, r-1);
        return i+1;
    }
    public void sort(Dado[] dados)
    {
        quickSort(dados, 0, size-1);
    }
}

public class Sorting3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n;
        n = Integer.parseInt(sc.nextLine());
        Dado [] dados = new Dado[n];
        for (int i = 0; i < dados.length; i++) {
         
            dados[i] = new Dado(sc.nextInt());
        }
        
        QuickSort is = new QuickSort(dados);
        is.sort(dados);
        
    }
    
}
