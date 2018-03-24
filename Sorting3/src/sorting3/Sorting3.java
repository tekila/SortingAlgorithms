/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package sorting3;

import java.util.Scanner;

/**
 *
 * @author pegai
 */

class Dado
{
    private String nome;//ascendente
    private String cor; //ascendente
    private String tamanho;//descendente

    public Dado(String nome, String cor, String tamanho) {
        this.nome = nome;
        this.cor = cor;
        this.tamanho = tamanho;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }
    
    
    public boolean ehMenorQue(Dado a)    
    {
        if(this.cor.compareTo(a.getCor()) == 0 )
        {//mesmas cores, precisa desempatar
            if(this.tamanho.compareTo(a.getTamanho()) == 0)
            {//mesmos tamanhos, precisa desempatar
                if(this.nome.compareTo(a.nome) < 0) return true; //this.nome vem antes de a.nome
                else return false;
            }else if(this.tamanho.compareTo(a.getTamanho()) > 0) //g<m<p 
            {
                return true;
            } else return false;
        } else if(this.cor.compareTo(a.getCor()) < 0)
        {
            return true;
        } else return false;
    }
    
    public void print()
    {
            System.out.println(this.cor + " " + this.tamanho + " " + this.nome);
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
        if(p<r)
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
        i = p;
        for(j = p; j<r; j++)
        {
            if(dados[j].ehMenorQue(aux))
            {
                swap(dados, i, j);
                i++;
            }
        }
        swap(dados, i, r);
        return i;
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
         
            dados[i] = new Dado(sc.next(), sc.next(), sc.next());
        }
        
        QuickSort qs = new QuickSort(dados);
        qs.sort(dados);
        
        for (int i = 0; i < dados.length; i++) {
         
            dados[i].print();
        }
        
        
    }
    
}
