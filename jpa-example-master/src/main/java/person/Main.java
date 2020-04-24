package person;
import com.github.javafaker.Faker;
import lombok.extern.log4j.Log4j2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.ZoneId;
import java.util.Scanner;


public class Main
{
    public static Faker fak = new Faker();

    public static Person randomPerson() {
        Person person = Person.builder()
                .name(fak.name().fullName())
                .dob(fak.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate())
                .gender(fak.options().option(Person.Gender.class))
                .address(makeAddress())
                .email(fak.internet().emailAddress())
                .profession(fak.company().profession())
                .build();
        return person;
    }

    public static Address makeAddress()
    {
        Address address = Address.builder()
                .country(fak.address().country())
                .state(fak.address().state())
                .city(fak.address().city())
                .streetAddress(fak.address().streetAddress())
                .zip(fak.address().zipCode())
                .build();
        return address;
    }

    public static void main(String[] args) {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-example");
    EntityManager em = emf.createEntityManager();

    Scanner scanner = new Scanner(System.in);
    int people = scanner.nextInt();

    try {
        em.getTransaction().begin();
        for (int i = 0; i < people; i++) {
            em.persist(randomPerson());
        }
        em.getTransaction().commit();
        em.createQuery("SELECT p FROM Person p ORDER BY p.id", Person.class).getResultList().forEach(System.out::println);
    } finally {
        em.close();
    }

}

}
