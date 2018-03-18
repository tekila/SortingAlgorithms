/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//package classificacaonba;

import java.util.Scanner;


/**
 *
 * @author pegai
 */

//<editor-fold defaultstate="collapsed" desc="class:Time">
class Time{
    
    private int inscricao;
    private int cestasMarcadas;
    private int cestasRecebidas;
    private double cestaAverage;
    private int pontos;

    public int getInscricao() {
        return inscricao;
    }

    public void setInscricao(int inscricao) {
        if(this.inscricao==-1) this.inscricao = inscricao;
    }
    
    

    public Time() {
       this.cestasMarcadas = 0;
       this.cestasRecebidas = 0;
       this.pontos = 0;
       this.inscricao = -1;
    }

    public void addCestasMarcadas(int cestas){
        this.cestasMarcadas += cestas;
    }
    public void addCestasRecebidas(int cestas){
        this.cestasMarcadas += cestas;
    }
    
    public void addPontos(int pontos)
    {
        this.pontos += pontos;
    }
    
    
    public int getCestasMarcadas() {
        return cestasMarcadas;
    }

    public void setCestasMarcadas(int cestasMarcadas) {
        this.cestasMarcadas = cestasMarcadas;
    }

    public int getCestasRecebidas() {
        return cestasRecebidas;
    }

    public void setCestasRecebidas(int cestasRecebidas) {
        this.cestasRecebidas = cestasRecebidas;
    }

    public double getCestaAverage() {
        return cestaAverage;
    }

    public void setCestaAverage() {
        if(this.cestasRecebidas == 0) this.cestaAverage = this.cestasMarcadas;
        else this.cestaAverage = this.cestasMarcadas/this.cestasRecebidas;
    }

    public int getPontos() {
        return pontos;
    }

    public boolean ehIgualA(Time t)
    {
        return this.pontos == t.getPontos();
    }
    
    public boolean ehMaiorQue(Time t)
    {
        if(this.pontos>t.getPontos()) return true;
        else if(this.ehIgualA(t))
        {
            this.setCestaAverage();
            t.setCestaAverage();
            if(this.cestaAverage > t.getCestaAverage())
            {
                return true;
            }else 
            {
                if(this.cestaAverage==t.getCestaAverage())
                {
                    if(this.cestasMarcadas > t.cestasMarcadas) return true;
                    else {
                        if(this.cestasMarcadas == t.cestasMarcadas)
                        {
                            if(this.inscricao<t.getInscricao()) return true;
                            else return false;
                        }
                        else return false;
                    }
                    
                }
                else return false;
            }
        }
        else return false;
    }
    
    public void printTime()
    {
        System.out.print(this.inscricao);
    }
    
}
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="class:Time">
class MergeSort{
    
    Time[] times;
    
    public Time[] getTimes()
    {
        return this.times;
    }
    
    public MergeSort(Time[] times)
    {
        this.times = times;
    }
    
    void merge(int p, int q, int r) //metodo intercala
    {
        Time[] aux =  new Time[times.length];
        //monta lista auxiliar
        for(int i = p; i<=r; i++) aux[i] = times[i];
        int i = p;
        int j = q+1;
        int k = p;
        
        while(i<=q && j<=r)
        {
            if(aux[i].ehMaiorQue(aux[j]))
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
            int q = (int)Math.floor((p+r)/2);
            this.sort(p, q);
            this.sort(q+1, r);
            this.merge(p, q, r);
        }
    }
}

//</editor-fold>

public class ClassificacaoNBA {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n;
        int x, y, z, w;
        n = Integer.parseInt(sc.nextLine());
        Time [] times = new Time[n];
        for(int i = 0; i<n; i++)
        {
            times[i] = new Time();
        }
        for (int i = 0; i < (n*(n-1))/2; i++) {
            x = sc.nextInt();
            y = sc.nextInt();
            z = sc.nextInt();
            w = sc.nextInt();
            times[x-1].setInscricao(x);
            times[z-1].setInscricao(z);
            times[x-1].addCestasMarcadas(y);
            times[x-1].addCestasRecebidas(w);
            times[z-1].addCestasMarcadas(w);
            times[z-1].addCestasRecebidas(y);
            if(y>w) //se o time x fez mais pontos que o time z
            {
                times[x-1].addPontos(2);//ganhou
                times[z-1].addPontos(1);
            } else {
                times[x-1].addPontos(1);//perdeu
                times[z-1].addPontos(2);
            }
        }
        
        
        MergeSort ms = new MergeSort(times);
        ms.sort(0, times.length-1);
        int i;
        for(i = 0; i<ms.getTimes().length; i++)
        {
            if(i!= 0) System.out.print(" ");
            Time a = ms.getTimes()[i];
            a.printTime();
        }
               

    }
    
}
