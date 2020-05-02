package book;

import book.model.Book;
import jpa.GenericJpaDao;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.Optional;

public class BookDao extends GenericJpaDao <Book> {

    @Transactional
    public Optional <Book> findByIsbn13 (String isbn13) {
        try {
            return Optional.of(entityManager.createQuery("SELECT b from Book b WHERE b.isbn13 =: isbn13", Book.class)
                    .setParameter("isbn13", isbn13)
                    .getSingleResult());

        }catch (NoResultException e) {
            return Optional.empty();
        }
    }
}