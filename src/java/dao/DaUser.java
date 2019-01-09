package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import model.User;
import utilities.BCrypt;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Nah
 */
@Repository
public class DaUser {

    //injected db connection
    @PersistenceContext
    private EntityManager em;               // despacher-servlet.xml      <property name="entityManagerFactory" ref="em" />     <--- em  

    //using transactional is a way to let spring start and commit/rollback transaction 
    @Transactional
    public boolean insert(User user) {
        try {
            Query query = em.createNativeQuery("SELECT * FROM User  WHERE user_name ='" + user.getUserName() + "'", User.class);
            List<User> testList = query.getResultList();
            User checking = testList.get(0);
            return false;

        } catch (IndexOutOfBoundsException ioobe) {
            String hashedPassword = BCrypt.hashpw(user.getUserPassword1(), BCrypt.gensalt());
            user.setUserPassword1(hashedPassword);
            user.setUserPassword2(hashedPassword);
            em.persist(user);
            return true;
        }

      

    }

    @Transactional
    public boolean login(String username, String password) {
        try {
            Query query = em.createNativeQuery("SELECT * FROM User  WHERE user_name ='" + username + "'", User.class);
            List<User> testList = query.getResultList();
            User checking = testList.get(0);

        } catch (IndexOutOfBoundsException ioobe) {
            return false;
        }
        Query query = em.createNativeQuery("SELECT * FROM User  WHERE user_name ='" + username + "'", User.class);
        List<User> userList = query.getResultList();
        User checked = userList.get(0);
        if (BCrypt.checkpw(password, checked.getUserPassword1())) {
            return true;
        } else {
            return false;
        }
    }

}
