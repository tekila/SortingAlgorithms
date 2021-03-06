/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//package sorting4;

import java.util.Scanner;

/**
 *
 * @author pegai
 */


class Pessoa
{
    private int altura;

    public Pessoa(int altura) {
        this.altura = altura;
    }

    public int getAltura() {
        return altura;
    }
    
    public int getAlturaRadix(int i)
    {
        return (int) (this.altura/Math.pow(10, i)%10);
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
    
    @Override
    public String toString()
    {
        return Integer.toString(this.altura);
    }
    
    public void print()
    {
        System.out.print(this.altura + " ");
    }
    
}

class CountingSort    
{
    private int auxSize;  //tamanho do vetor a ser ordenado
    private int upperBound; //limite superior de dados
    private int lowerBound; //limite inferior de dados
    
    public CountingSort(Pessoa[] pessoas, int upper, int lower) {
        this.auxSize = pessoas.length;
        this.upperBound = upper;
        this.lowerBound = lower;
    }

    public void sort(Pessoa[] pessoas)
    {
        this.auxSize = pessoas.length;
        Pessoa[] pessoasAux = new Pessoa[auxSize];
        int[] alturasContagem = new int[upperBound - lowerBound + 1];
        /**
         * 20->0
         * 21->1
         * 22->2
         * ....
         * 228->208
         * 229->209
         * 230->210
         */
        //contar o numero de chaves em cada valor:
        for(int j = 0; j<pessoas.length; j++)
        {
            alturasContagem[pessoas[j].getAltura()-lowerBound]++;
        }
        //acumular o numero de contagens, pra saber os indices corretos
        for(int i = 1; i<alturasContagem.length; i++)
        {
            alturasContagem[i] += alturasContagem[i-1];
        }
        //ordenar
        for(int j = pessoas.length-1; j>=0; j--)
        {
            pessoasAux[alturasContagem[pessoas[j].getAltura()-lowerBound]-1] = pessoas[j];
            alturasContagem[pessoas[j].getAltura()-lowerBound]--;
        }
        //copiar
        for (int i = 0; i < pessoasAux.length; i++) {
            pessoas[i] = pessoasAux[i];
        }
        
    }
    
}

class RadixSort    
{
    private int auxSize;  //tamanho do vetor a ser ordenado
    private int upperBound; //limite superior de dados
    private int lowerBound; //limite inferior de dados
    
    public RadixSort(Pessoa[] pessoas, int upper, int lower) {
        this.auxSize = pessoas.length;
    }
    
    public void countingSort(Pessoa[] pessoas, int exp)
    {
        this.auxSize = pessoas.length;
        Pessoa[] pessoasAux = new Pessoa[auxSize];
        int[] alturasContagem = new int[10]; //digitos so vao de 0 a 9
        
        //contar o numero de chaves para cada digito
        for(int j = 0; j<pessoas.length; j++)
        {
            alturasContagem[pessoas[j].getAlturaRadix(exp)]++;
        }
        //acumular o numero de contagens, pra saber os indices corretos
        for(int i = 1; i<alturasContagem.length; i++)
        {
            alturasContagem[i] += alturasContagem[i-1];
        }
        //ordenar
        for(int j = pessoas.length-1; j>=0; j--)
        {
            pessoasAux[alturasContagem[pessoas[j].getAlturaRadix(exp)]-1] = pessoas[j];
            alturasContagem[pessoas[j].getAlturaRadix(exp)]--;
        }
        //copiar
        for (int i = 0; i < pessoasAux.length; i++) {
            pessoas[i] = pessoasAux[i];
        }
    }
    
    public void sort(Pessoa[] pessoas)
    {
        for(int i = 0; i<3; i++)
        {
            this.countingSort(pessoas, i);
        }
    }
    
}

public class Sorting4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n;
        n = Integer.parseInt(sc.nextLine());
        Pessoa [] dados = new Pessoa[n];
        for (int i = 0; i < dados.length; i++) {
         
            dados[i] = new Pessoa(sc.nextInt());
        }
        
        RadixSort rs = new RadixSort(dados, 230, 20);
        rs.sort(dados);
            
        for (int i = 0; i < dados.length; i++) {
         
            dados[i].print();
        }
    }
    
}
