package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;


public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner input = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Departamento: ");
		String nomeDepartamento = input.nextLine();
		
		System.out.print("Nome: ");
		String nome = input.nextLine();
		
		System.out.print("Nível: ");
		String nivel = input.nextLine();
		
		System.out.print("Salário base: ");
		Double salario = input.nextDouble();
		
		
		Worker funcionario = new Worker(nome, WorkerLevel.valueOf(nivel), salario, new Department(nomeDepartamento));
		
		System.out.print("Quantos são os contratos? ");
		int numContratos = input.nextInt();
		
		for(int i = 0; i<numContratos; i++) {
			input.nextLine();
			
			System.out.printf("%nDADOS DO CONTRATO #%d: %nData (DD/MM/YYYY): ", i+1);
			Date data = sdf.parse(input.next());
			
			System.out.print("Valor por hora: ");
			double valorPorHora = input.nextDouble();
			
			System.out.print("Duração (em horas): ");
			int horas = input.nextInt();
			
			HourContract contrato = new HourContract(data, valorPorHora, horas);
			funcionario.addContract(contrato);
		}
		
		System.out.println();
		
		System.out.print("Entre com mês e ano pra calcular a renda (MM/YYYY): ");
		String mesEAno = input.next();
		
		int mes = Integer.parseInt(mesEAno.substring(0, 2));
		int ano = Integer.parseInt(mesEAno.substring(3));
		
		System.out.print("\nNome: " + funcionario.getName());
		System.out.print("\nDepartamento: " + funcionario.getDepartment().getName());
		System.out.print("\nRenda para " + mesEAno + ": " + String.format("%.2f", funcionario.income(ano, mes)));
		
		input.close();
		
		
		
	}

}
