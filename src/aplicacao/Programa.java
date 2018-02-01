package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		// save();
		// findAll();
		remove();
	}

	public static void save() {
		Pessoa pessoa1 = new Pessoa(null, "Italo", "italo@gmail.com");
		Pessoa pessoa2 = new Pessoa(null, "Gercina", "gercina@gmail.com");

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		// Save
		em.persist(pessoa1);
		em.persist(pessoa2);
		em.getTransaction().commit();

		em.close();
		emf.close();
	}

	public static void findAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();

		Pessoa pessoa = em.find(Pessoa.class, 2);
		System.out.println(pessoa);

		em.close();
		emf.close();
	}

	public static void remove() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Pessoa pessoa = em.find(Pessoa.class, 1);
		em.remove(pessoa);

		em.getTransaction().commit();
		em.close();
		emf.close();
	}

}
