/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package sorting1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pegai
 */

//<editor-fold defaultstate="collapsed" desc="ClassAluno">
class Aluno
{
    int problemasresolvidos;
    String nome;

    public Aluno(int problemasresolvidos, String nome) {
        this.problemasresolvidos = problemasresolvidos;
        this.nome = nome;
    }
    
    public void printAluno()
    {
        System.out.print(this.nome);
    }
    
    public int getProblemasresolvidos() {
        return problemasresolvidos;
    }

    public void setProblemasresolvidos(int problemasresolvidos) {
        this.problemasresolvidos = problemasresolvidos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
   
}
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="InsertionSort">

class InsertionSort
{
    private Aluno[] array;
    
    public InsertionSort(Aluno[] array) {
        this.array = array;
    }
    
    public Aluno[] getArray() {
        return array;
    }
    
    public void setArray(Aluno[] array) {
        this.array = array;
    }
    
    /**
     * Algoritmo estavel
     */
    public void sort()
    {
        int i, j;
        //primeiro elemento esta ordenado. (suposicao)
        for(i = 1; i< this.array.length; i++)
        {
            j = i;
            //enquanto array[1] for menor que o j-esimo elemento ordenado, precisa colocar ele na posicao j-1.
            while ( j>0 && compara(j, this.array[j-1]))
            {
                //troca os elemenos de posicao
                Aluno temp = this.array[j];
                this.array[j] = this.array[j-1];
                this.array[j-1] = temp;
                //continua iterando ate achar a posicao correta
                j--;
            }
        }
    }
    
    private boolean compara(int j, Aluno temp)
    {
        if(this.array[j].getProblemasresolvidos()>temp.getProblemasresolvidos()) return true;
        else if(this.array[j].getProblemasresolvidos()==temp.getProblemasresolvidos())
        {
            if(this.array[j].getNome().compareTo(temp.getNome())<0) return true;
            else return false;
        }
        else return false;
    }
    
    public void sortOptimized()
    {
        /**
         * ficar trocando toda iteracao os elementos de posicao eh custoso
         * posso armazenar o elemento a ser trocado antes do loop
         * ir "andando" com os elementos "pra frente" ate achar o local certo
         * fora do loop insere ele no local
         */
        int i, j;
        Aluno temp;
        //primeiro elemento esta ordenado. (suposicao)
        for(i = 1; i< this.array.length; i++)
        {
            temp = this.array[i];
            j = i-1;
            while ( j>=0 && (compara(j, temp) ))
            {
                //vai "andando"
                this.array[j+1] = this.array[j];
                j--;
            }
            this.array[j+1] = temp;
        }
    }
}
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="SelectionSort">

class SelectionSort
{
    private Aluno[] array;
    
    public SelectionSort(Aluno[] array) {
        this.array = array;
    }
    
    public Aluno[] getArray() {
        return array;
    }
    
    public void setArray(Aluno[] array) {
        this.array = array;
    }
    
    private boolean compara(Aluno a1, Aluno a2)
    {
        if(a1.getProblemasresolvidos()<a2.getProblemasresolvidos()) return true;
        else if(a1.getProblemasresolvidos()==a2.getProblemasresolvidos())
        {
            if(a1.getNome().compareTo(a2.getNome())>0) return true;
            else return false;
        }
        else return false;
    }
    
    /**
     * retorna o indice do menor valor do vetor
     */
    private int __min(int unsortedStart)
    {
        int min = unsortedStart;
        for (int i = unsortedStart+1; i < this.array.length; i++) {
            if(compara(this.array[i], this.array[min]))min = i;
            //if(this.array[i]<this.array[min])min =i;
        }
        return min;
    }
    
    /**
     * Algoritmo instavel
     */
    public void sort()
    {
        int min;
        Aluno temp;
        for(int i = 0;i<this.array.length; i++)
        {
            min = __min(i);
            temp = this.array[i];
            this.array[i] = this.array[min];
            this.array[min] = temp;
        }
    }
    
    
    /**
     * A questao chave eh: como efetuar a menor quantidade de movimentacoes possiveis?
     *
     * nao ha necessidade de trocar os elementos se dois numeros sao iguais.
     */
    public void sortOptimized()
    {
        int min;
        Aluno temp;
        for(int i = 0;i<this.array.length; i++)
        {
            min = __min(i);
            if(min != i ){
                temp = this.array[i];
                this.array[i] = this.array[min];
                this.array[min] = temp;
            }
        }
    }
}
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="BubbleSort">

class BubbleSort
{
    private Aluno[] array;
    
    public BubbleSort(Aluno[] array) {
        this.array = array;
    }
    
    public Aluno[] getArray() {
        return array;
    }
    
    public void setArray(Aluno[] array) {
        this.array = array;
    }
    private boolean compara(Aluno a1, Aluno a2)
    {
        if(a1.getProblemasresolvidos()<a2.getProblemasresolvidos()) return true;
        else if(a1.getProblemasresolvidos()==a2.getProblemasresolvidos())
        {
            if(a1.getNome().compareTo(a2.getNome())>0) return true;
            else return false;
        }
        else return false;
    }
       
    /**
     *Algoritmo estavel
     */
    public void sort()
    {
        for(int j  = 0; j<this.array.length; j++){
            for (int i = 1; i < this.array.length-j; i++) {
                if (compara(this.array[i-1], this.array[i]))
                {
                    //if(this.array[i-1]>this.array[i])
                    Aluno temp = this.array[i-1];
                    this.array[i-1] = this.array[i];
                    this.array[i] = temp;
                }
            }
        }
    }
    
    
    /**
     * a Otimizacao eh simples. Basta notar quando nenhum elemento
     * foi trocado de posicao. Nesse momento encerra o algoritmo.
     */
    public void sortOptimized()
    {
       boolean mudou = false;
        for(int j  = 0; j<this.array.length; j++){
            for (int i = 1; i < this.array.length-j; i++) {
                if(compara(this.array[i-1], this.array[i]))
                {
                    Aluno temp = this.array[i-1];
                    this.array[i-1] = this.array[i];
                    this.array[i] = temp;
                    mudou = true;
                }
            }
            if(!mudou) break;
        }
    }
}
//</editor-fold>


public class Sorting1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        //esse codigo aqui foi usado para validar o funcionamento dos sorts.
        //em um projeto separado eu criei um gerador de string aleatorias para 
        //servirem como nome, e escrevi-as num arquivo. Esse arquivo foi copiado
        //para a pasta desse projeto, onde efetuei a leitura e a ordenacao
        //Para validar o funcionamento, importei os nomes tambem no excel
        //e os ordenei por la. todos os testes rodados foram bem sucedidos
        //Isso foi feito para validar o funcionamento do Judge, pois
        //para os sort houveram 10 runtime errors, sendo que
        //claramente nao existe nenhum erro de execucao
//        Aluno[] alunos = new Aluno[10000];
//        String fileName = "testes.txt";
//        String line = null;
//        try{
//            int i = 0;
//            FileReader fr = new FileReader(fileName);
//            BufferedReader br = new BufferedReader(fr);
//            while((line = br.readLine())!= null)
//            {
//                String[] partes = line.split(" ");
//                alunos[i] = new Aluno(Integer.parseInt(partes[1]), partes[0]);
//                i++;
//            }
//        }
//        catch(FileNotFoundException e)
//        {
//        } catch (IOException ex) {
//            Logger.getLogger(Sorting1.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
        
        int n;
        n = Integer.parseInt(sc.nextLine());
        Aluno [] alunos = new Aluno[n];
        for (int i = 0; i < alunos.length; i++) {
            String linha = sc.nextLine();
            String[] partes = linha.split(" ");
            alunos[i] = new Aluno(Integer.parseInt(partes[1]), partes[0]);
        }
        
        BubbleSort is = new BubbleSort(alunos);
        is.sortOptimized();
        is.getArray()[0].printAluno();
    }
    
}
