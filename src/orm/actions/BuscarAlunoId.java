package orm.actions;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import orm.modelo.Aluno;

public class BuscarAlunoId {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
		EntityManager manager = factory.createEntityManager();
	
		Scanner sc = new Scanner(System.in);
		System.out.print("ID(para busca): ");
		Long id = sc.nextLong();
		
		Aluno t = manager.find(Aluno.class, id);
		System.out.println("\nID: " + t.getId());
		System.out.println("Nome: " + t.getNome());
		System.out.println("Email: " + t.getEmail());
		System.out.println("CPF: " + t.getCpf());
		System.out.println("Data de Nascimento: " + t.getDataNascimento());
		System.out.println("Naturalidade: " + t.getNaturalidade());
		System.out.println("Endereço: " + t.getEndereco());
		
		sc.close();
		manager.close();
    }

}