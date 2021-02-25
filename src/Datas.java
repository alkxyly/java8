import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Datas {
	public static void main(String[] args) {
		
		LocalDate hoje = LocalDate.now();
		System.out.println(hoje);
		
		LocalDate meuNiver = LocalDate.of(2022, Month.MARCH, 12);
		
		int anos = meuNiver.getYear() - hoje.getYear();
		
		Period periodo = Period.between(hoje, meuNiver);
		LocalDate mais4 = meuNiver.plusYears(4);
		
		System.out.println(mais4);
		
		DateTimeFormatter fomatador = DateTimeFormatter.ofPattern("dd/MM/YYYY");
		
		String valorFormatado = mais4.format(fomatador);
		
		System.out.println(valorFormatado);
		DateTimeFormatter fomatadorHora = DateTimeFormatter.ofPattern("dd/MM/YYYY hh:mm:ss");
		LocalDateTime agora = LocalDateTime.now();
		System.out.println(agora.format(fomatadorHora));
		
		LocalDate transform = agora.toLocalDate();
		System.out.println(transform.format(fomatador));	
	}
}
