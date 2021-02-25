import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Curso {
	private String nome;
	private int alunos;

	public Curso(String nome, int alunos) {
		this.nome = nome;
		this.alunos = alunos;
	}

	public String getNome() {
		return nome;
	}

	public int getAlunos() {
		return alunos;
	}

}

public class Streams{
	public static void main(String[] args) {
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));
		
		//Comparando por quantidade de alunos
		cursos.sort(Comparator.comparing(Curso::getAlunos));
		//cursos.forEach(c -> System.out.println(c.getNome()));
		
		int soma = cursos.stream()
			.filter(c -> c.getAlunos() >= 100)
			.mapToInt(c -> c.getAlunos())
			.sum();
		
//		System.out.println(soma);
		
		//Obtendo os cursos com quantidade de alunos maiores que 50
		cursos.stream()
			.filter(curso -> curso.getAlunos() > 50)
			.forEach(curso -> System.out.println(curso.getAlunos()));
		
		//Transformando em uma stream de String
		Stream<String> sString = cursos.stream().map(Curso::getNome);
		sString.forEach(System.out::println);
		
		//Optional
		
		cursos.stream()
			.filter(curso  -> curso.getAlunos() >= 100)
			.findAny()
		    .ifPresent(c -> System.out.println(c.getNome()));

		//Obtendo list a partir de um stream
		List<Curso> cursosFiltrados = cursos.stream()
		.filter(curso -> curso.getAlunos() > 50)
		.collect(Collectors.toList());
		
		System.out.println(cursosFiltrados.size());
		
	}
}
