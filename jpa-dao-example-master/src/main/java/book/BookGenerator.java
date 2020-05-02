package book;


import book.model.Book;
import com.github.javafaker.Faker;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;

public class BookGenerator {

    static Faker faker = new Faker(new Locale("en"));

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");


    public static Book createBook() {
        Date date=faker.date().birthday();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Book book = Book.builder()
                .isbn13(faker.code().isbn13())
                .author(faker.book().author())
                .title(faker.book().title())
                .format(faker.options().option(Book.Format.class))
                .publisher(faker.book().publisher())
                .publicationDate(localDate)
                .pages(faker.number().numberBetween(10, 7000))
                .available(faker.bool().bool())
                .build();
        return book;
    }

}