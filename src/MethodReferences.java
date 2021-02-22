import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MethodReferences {

	public static void main(String[] args) {
		List<String> palavras = new ArrayList<String>();
		palavras.add("alura online");
		palavras.add("FOCA");
		palavras.add("editora casa do código");
//		Opcao 1 
		palavras.sort(Comparator.comparing(s -> s.length()));
		
//		//Opcao 2
		palavras.sort(Comparator.comparing(String::length));
		
		//Opcao 1 Consumers
		palavras.forEach(s -> System.out.println(s));
		
		//Opcao 2 Consumers
		palavras.forEach(System.out::println);
		
		
		palavras.sort((s1, s2) -> {
		    return Integer.compare(s1.length(), s2.length()); 
		});
		
		
		//Outro método de comparacao
		palavras.sort(String.CASE_INSENSITIVE_ORDER);
		
	}

}
