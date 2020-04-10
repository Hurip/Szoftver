package user;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

import java.time.LocalDate;

import static user.User.Gender.MALE;

public class Main
{

    public static void main(String[] args)
    {

        Jdbi jdbi = Jdbi.create("jdbc:h2:mem:test");
        jdbi.installPlugin(new SqlObjectPlugin());

        try (Handle handle = jdbi.open())
        {

            UserDao dao = handle.attach(UserDao.class);
            dao.createTable();

            User user = User.builder()
                    .id(10L)
                    .username("setien")
                    .password("jelszo")
                    .name("Setien90")
                    .email("setien@valami.com")
                    .gender(MALE)
                    .dob(LocalDate.parse("2020-04-10"))
                    .enabled(true)
                    .build();

            dao.insert(user);

            System.out.println(dao.findById(user.getId()));
            System.out.println(dao.findByUsername(user.getUsername()));

            dao.list().stream().forEach(System.out::println);

            dao.delete(user);
        }
    }
}