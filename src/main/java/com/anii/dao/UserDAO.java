
package com.anii.dao;

import com.anii.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.anii.util.HibernateUtil;
import java.util.List;

public class UserDAO {
    public User login(String email, String password) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        User user = (User) session.createQuery("FROM User WHERE email = :email AND password = :password")
                .setParameter("email", email)
                .setParameter("password", password)
                .uniqueResult();
        session.close();
        return user;
    }
}
