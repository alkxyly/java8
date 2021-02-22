import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class OrdenaStrings {
	/**
	 * Aula  01 - Curso Alura - 
	 * Tire Proveiro de novos recursos
	 * do Java 8
	 * Default Methods
	 * Estratégia para evolução de interfaces
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> palavras = new ArrayList<String>();
		palavras.add("alura online");
		palavras.add("foca");
		palavras.add("editora casa do código");
		
		Collections.sort(palavras);
//		System.out.println(palavras);
		
		Comparator<String> comparador = new ComparadorPorTamanho();
		//Collections.sort(palavras, comparador);
		palavras.sort(comparador);
//		System.out.println(palavras);
		
		for (String p : palavras) {
//			System.out.println(p);
		}
		
		Consumer<String> consumidor = null;
		
//		palavras.forEach(new ImprimeMinhaLinha());
		
		//Exercicio  1.03
		List<String> palavras2 = new ArrayList<>();
		palavras2.add("alura online");
		palavras2.add("casa do código");
		palavras2.add("caelum");

		//Ordenacao com lamydas
		palavras2.forEach((String t) -> {
				System.out.println(t);
			}
		);
		palavras2.sort((String o1, String o2) ->  Integer.compare(o1.length(), o2.length()));
		System.out.println(palavras2);
		
		
		//Exercicio reescrevendo a implementação abaixo	
		new Thread(new Runnable() {

		    @Override
		    public void run() {
		        System.out.println("Executando um Runnable");
		    }

		}).start();
		
		new Thread(() -> System.out.println("Executando um Run")).start();
	}

	static class ImprimeMinhaLinha implements Consumer<String> {

		@Override
		public void accept(String t) {
			System.out.println(t);

		}

	}

	static class ComparadorPorTamanho implements Comparator<String> {

		@Override
		public int compare(String o1, String o2) {
			if (o1.length() < o2.length())
				return -1;
			else if (o1.length() > o2.length())
				return -1;
			else
				return 0;
		}

	}
}
