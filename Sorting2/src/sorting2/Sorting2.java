/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package sorting2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;


/**
 *
 * @author pegai
 */

class Aluno{
    private String nome;
    private int nota;
    private int estabilidade; //essa variavel serve pra gerar uma
    //estabilidade artificial. ela recebe
    //a ordem de entrada do aluno no 
    //programa.
    private boolean trocouDeLugar;
    
    public int getEstabilidade()
    {
        return this.estabilidade;
    }
    
    @Override
    public String toString()
    {
        return Integer.toString(nota);
    }
    
    public void setTroca()
    {
        this.trocouDeLugar = true;
    }
    
    public boolean getTroca()
    {
        return this.trocouDeLugar;
    }
    
    public Aluno(String nome, int nota, int posicao) {
        this.nome = nome;
        this.nota = nota;
        this.estabilidade = posicao;
        this.trocouDeLugar = false;
    }

    public void printAluno() {
        System.out.println(this.nome);
    }
    public void printAlunoNota()
    {
        System.out.println(this.nome + " " + this.nota);
    }

    public boolean ehMaiorQue(Aluno a) {
        if (this.nota > a.nota) {
            return true;
        } else if(this.ehIgual(a))
        {
            return this.estabilidade > a.estabilidade;
        }else{
            return false;
        }
    }

    public boolean ehMenorQue(Aluno a) {
         if (this.nota < a.nota) {
            return true;
        } else if(this.ehIgual(a))
        {
            return this.estabilidade > a.estabilidade;
        }else{
            return false;
        }
    }

    public boolean ehIgual(Aluno a) {
        if (this.nota == a.nota) {
            return true;
        } else {
            return false;
        }
    }

}

class HeapSort {

    private Aluno[] alunos;
    private int heapSize;
    
    public Aluno[] getAlunos()
    {
        return this.alunos;
    }

    public HeapSort(Aluno[] alunos) {
        this.alunos = alunos;
    }

    private Aluno esquerda(int i) {
        if (2 * i < alunos.length) {
            return alunos[2 * i];
        } else {
            return null; //nao tem filho esquerdo
        }
    }

    private Aluno direita(int i) {
        if (2 * i + 1 < alunos.length) {
            return alunos[2 * i + 1];
        } else {
            return null;//nao tem filho direito
        }
    }

    private boolean ehFolha(int i) {
        if (esquerda(i) == null && direita(i) == null) {
            return true;
        } else {
            return false;
        }
    }

    private void swap(int a, int b) {
        Aluno aux;
        aux = this.alunos[a];
        this.alunos[a] = this.alunos[b];
        this.alunos[b] = aux;
    }

    public void heapfy(int i) //metodo de refazer heap
    {
        if (ehFolha(i)) {
            return;
        } else {
            int maior = i;
            int esq = 2*i;
            int dir = 2*i+1;
            if(esq<=heapSize  && alunos[esq].ehMenorQue(alunos[maior])) maior = esq;
            if(dir<=heapSize  && alunos[dir].ehMenorQue(alunos[maior])) maior = dir;
            if (maior == i) //Heap nao violado
            {
                return;
            } else {
                /*heap violado. Substituir o maior na raiz 
					 * no filho substituido
                 */
                swap(i, maior);
                this.alunos[i].setTroca();
                this.alunos[maior].setTroca();  
                heapfy(maior);
            }
        }
    }

    public void build()//outOfBoundsException pode ocorrer aqui!!!
    {
        int esq = (int) (Math.floor(this.heapSize / 2+1));
        while (esq >= 0) {
            heapfy(esq);
            esq--;
        }
    }

    public void sort() {
        this.heapSize = this.alunos.length-1;
        build();
        int i;
        for (i = this.heapSize; i >=0 ; i--) {
            swap(0, i);
            this.heapSize--;
            heapfy(0);
        }        
    }
}



public class Sorting2 {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n;
        n = Integer.parseInt(sc.nextLine());
        Aluno [] alunos = new Aluno[n];
        for (int i = 0; i < alunos.length; i++) {
            alunos[i] = new Aluno(sc.next(), sc.nextInt(), i);
        }
        
        /**
         * Codigo abaixo para testes de execucao dos algoritmos
        */
//        Aluno[] alunos = new Aluno[100];
//        String fileName = "testes.txt";
//        String line = null;
//        try{
//            int i = 0;
//            FileReader fr = new FileReader(fileName);
//            BufferedReader br = new BufferedReader(fr);
//            while((line = br.readLine())!= null && i<100)
//            {
//                String[] partes = line.split(" ");
//                alunos[i] = new Aluno(partes[0], Integer.parseInt(partes[1]), i);
//                i++;
//            }
//        }
//        catch(FileNotFoundException e)
//        {
//        } catch (IOException ex) {
//            Logger.getLogger(Sorting2.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
        
        HeapSort hs = new HeapSort(alunos);
        hs.sort();
        int i;
        for(i = 0; i<hs.getAlunos().length; i++)
        {
            Aluno a = hs.getAlunos()[i];
            //a.printAluno();
            if(a.getEstabilidade() == i) a.printAluno();
        }
        

    }
    
}
