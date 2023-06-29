package orm.actions;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import orm.modelo.Aluno;

public class AtualizarAluno {

	public static void main(String[] args) {
		Aluno aluno = new Aluno();
		
		try (Scanner input = new Scanner(System.in)) {
			System.out.print("ID(para mudanças): ");
			
			Long id = input.nextLong();
			input.nextLine();
			System.out.print("Nome: ");
			String nome = input.nextLine();
			System.out.print("Email: ");
			String email = input.nextLine();
			System.out.print("CPF: ");
			String cpf = input.nextLine();
			System.out.print("Data de Nascimento: ");
			String dataNascimento = input.nextLine();
			System.out.print("Naturalidade: ");
			String naturalidade = input.nextLine();
			System.out.print("Endereço: ");
			String endereco = input.nextLine();
			
			aluno.setId(id);
			aluno.setNome(nome);
			aluno.setEmail(email);
			aluno.setCpf(cpf);
			aluno.setDataNascimento(dataNascimento);
			aluno.setNaturalidade(naturalidade);
			aluno.setEndereco(endereco);
		}
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		manager.merge(aluno);
		manager.getTransaction().commit();
		
		System.out.println("Aluno Atualizado, ID: " + aluno.getId());	
		
		manager.close();
		factory.close();

	}

}