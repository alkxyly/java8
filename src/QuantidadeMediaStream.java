import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class QuantidadeMediaStream {

	public static void main(String[] args) {
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Python", 10));
		cursos.add(new Curso("JavaScript", 60));
		cursos.add(new Curso("Java 8", 10));
		cursos.add(new Curso("C", 10));
		
		cursos.stream()
			  .mapToInt(curso -> curso.getAlunos())
			  .average().ifPresentOrElse(System.out::println, ()-> System.out.print("Não Existe valor"));
		
		List<Curso> cursosStream = cursos.stream()
				   .filter(c -> c.getAlunos() > 50).collect(Collectors.toList());
		
		cursosStream.forEach(curso -> System.out.println(curso.getNome()));
		
	}
	
	
	static class Curso {
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
}
