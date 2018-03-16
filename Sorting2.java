
public class Sorting2 {
	
	class Aluno{
		private String nome;
		private int nota;
		private boolean trocouDeLugar;
		
		public Aluno(String nome, int nota)
		{
			this.nome = nome;
			this.nota = nota;
			this.trocouDeLugar = false;
		}
		public void printAluno()
		{
			System.out.println(this.nome);
		}
		
		
		public boolean ehMaiorQue(Aluno a)
		{
			if(this.nota>a.nota) return true;
			else return false;
		}
		public boolean ehMenorQue(Aluno a)
		{
			if(this.nota<a.nota) return true;
			else return false;
		}
		public boolean ehIgual(Aluno a)
		{
			if(this.nota==a.nota) return true;
			else return false;
		}


	}
	
	class HeapSort
	{
		private Aluno[] alunos;
		
		public HeapSort(Aluno[] alunos)
		{
			this.alunos = alunos;
		}
		
		private Aluno esquerda(int i)
		{
			if(2*i <= alunos.length) return alunos[2*i];
			else return null; //nao tem filho esquerdo
		}
		
		private Aluno direita(int i)
		{
			if(2*i + 1 <= alunos.length) return alunos[2*i+1];
			else return null;//nao tem filho direito
		}
		
		private boolean ehFolha(int i)
		{
			if(esquerda(i) == null && direita(i) == null) return true;
			else return false;
		}
		
		private void swap(Aluno a, Aluno b)
		{
			Aluno aux = a;
			a = b;
			b = aux;
		}
		
		public void heapfy(int i) //metodo de refazer heap
		{
			if(ehFolha(i)) return;
			else
			{
				int maior;
				Aluno esq = esquerda(i);
				Aluno dir = direita(i);
				Aluno pai = alunos[i];
				if(esq!= null)
				{
					if(esq.ehMaiorQue(pai))
						maior = 2*i;
					else maior = i;
				}
				else maior = i;
				if(dir!=null)
				{
					if(dir.ehMaiorQue(alunos[maior]))
						maior = 2*i+1;
				}
				if(maior==i) //Heap nao violado
				{
					return;
				}
				else 
				{
					/*heap violado. Substituir o maior na raiz 
					 * no filho substituido
					*/
					swap(alunos[i], alunos[maior]);
					heapfy(maior);
				}
			}
		}
		public void build()//outOfBoundsException pode ocorrer aqui!!!
		{
			int esq = (int) (Math.floor(alunos.length/2)+1);
			while(esq>=0)
			{
				heapfy(esq);
				esq--;
			}
		}
		public void sort()
		{
			build();
			int i;
			for(i = 0; i<alunos.length; i++)
			{
				swap(alunos[0], alunos[i]);
				heapfy(i+1);
			}
		}
	}
	
	class MergeSort()
	{
		Aluno[] alunos;
		public MergeSort(Aluno[] alunos)
		{
			
		}
	}
	
	public static void main(String[] args)
	{
		System.out.print("Alo mundo");
	}

}
