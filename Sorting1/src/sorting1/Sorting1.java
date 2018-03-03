/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting1;

/**
 *
 * @author pegai
 */


//<editor-fold defaultstate="collapsed" desc="InsertionSort">

class InsertionSort
{
    private int[] array;
    
    public InsertionSort(int[] array) {
        this.array = array;
    }
    
    public int[] getArray() {
        return array;
    }
    
    public void setArray(int[] array) {
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
            while ( j>0 && this.array[j]<this.array[j-1] )
            {
                //troca os elemenos de posicao
                int temp = this.array[j];
                this.array[j] = this.array[j-1];
                this.array[j-1] = temp;
                //continua iterando ate achar a posicao correta
                j--;
            }
        }
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
        int temp;
        //primeiro elemento esta ordenado. (suposicao)
        for(i = 1; i< this.array.length; i++)
        {
            temp = this.array[i];
            j = i-1;
            while ( j>=0 && this.array[j]>temp )
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
    private int[] array;
    
    public SelectionSort(int[] array) {
        this.array = array;
    }
    
    public int[] getArray() {
        return array;
    }
    
    public void setArray(int[] array) {
        this.array = array;
    }
    
    /**
     * retorna o indice do menor valor do vetor
     */
    private int __min(int unsortedStart)
    {
        int min = unsortedStart;
        for (int i = unsortedStart+1; i < this.array.length; i++) {
            if(this.array[i]<this.array[min])min =i;
        }
        return min;
    }
    
    /**
     * Algoritmo instavel
     */
    public void sort()
    {
        int min;
        int temp;
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
        int temp;
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
    private int[] array;
    
    public BubbleSort(int[] array) {
        this.array = array;
    }
    
    public int[] getArray() {
        return array;
    }
    
    public void setArray(int[] array) {
        this.array = array;
    }
    
       
    /**
     *Algoritmo estavel
     */
    public void sort()
    {
        for(int j  = 0; j<this.array.length; j++){
            for (int i = 1; i < this.array.length-j; i++) {
                if(this.array[i-1]>this.array[i])
                {
                    int temp = this.array[i-1];
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
                if(this.array[i-1]>this.array[i])
                {
                    int temp = this.array[i-1];
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
        int[] a = new int[]{9,1,8,2,2,3,7,3,6,4,5};
        int[] b = new int[]{9,1,8,2,2,3,7,3,6,4,5};
        BubbleSort is = new BubbleSort(a);
        is.sort();
        a = is.getArray();
        for (int i = 0; i < a.length; i++) {
            int j = a[i];
            System.out.print(j+ " ");
        }
        is.setArray(b);
        is.sortOptimized();
        System.out.println();
        b = is.getArray();
        for (int i = 0; i < b.length; i++) {
            int j = a[i];
            System.out.print(j+ " ");
        }
    }
    
}
