/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mergesortteste;

import java.util.Random;





/**
 *
 * @author pegai
 */

class MergeSort{
    
    int[] times;
    
    public int[] getTimes()
    {
        return this.times;
    }
    
    public MergeSort(int[] times)
    {
        this.times = times;
    }
    
    void merge(int p, int q, int r) //metodo intercala
    {
        int[] aux =  new int[times.length];
        //monta lista auxiliar
        for(int i = p; i<=r; i++) aux[i] = times[i];
        int i = p;
        int j = q+1;
        int k = p;
        
        while(i<=q && j<=r)
        {
            if(aux[i] > (aux[j]))
            {
                times[k] = aux[i];
                i++;
            } else
            {
                times[k] = aux[j];
                j++;
            }
            k++;
        }
        while(i<=q)
        {
            times[k] = aux[i];
            i++;k++;
        }
        while(j<=r)
        {
            times[k] = aux[j];
            j++;k++;
        }
    }
    
    void sort(int p, int r) //metodo ordena
    {
        if(p<r)
        {
            int q = (int)((p+r)/2);
            this.sort(p, q);
            this.sort(q+1, r);
            this.merge(p, q, r);
        }
    }
}

public class MergeSortTeste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random rd = new Random();
        final int size  = 10;
        int[] vetor = new int[size];
        
        int testes = 0;
        while(testes<10){
            for(int i = 0; i<size; i++)
            {
                int a = rd.nextInt()%1000;
                vetor[i] = a<0?(-1)*a:a;
            }

            MergeSort ms = new MergeSort(vetor);
            ms.sort(0, size-1);

            for(int i = 0; i<size; i++)
            {
                System.out.print(vetor[i]+ " ");
            }

            System.out.println();
            testes++;
        }
    }
    
}
