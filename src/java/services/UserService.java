/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.*;
import dataaccess.UserDB;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author BTran
 */
public class UserService {
//    EntityManagerFactory emf = Persistence.createEntityManagerFactory("notesPU");
//    EntityManager em = emf.createEntityManager();
//    
//    User a = em.find(Role), em);
    
    public List<User> getAll() throws Exception {
        UserDB userDB = new UserDB();
        
        List<User> users = userDB.getAll();
//        EntityManagerFactory emf2 = Persistence.createEntityManagerFactory("notesPU");
//        EntityManager em2 = emf2.createEntityManager();
//    
//         User a = em2.find(User.class, 1);
//         System.out.println(a.toString());
//        
//        List<User> users = userDB.getAll();
        return users;
    }
    public User get(String email) throws Exception {
        UserDB userDB = new UserDB();
        User user = userDB.get(email);
        return user;
    }
    
    public void insert(String email, boolean activity, String first_name, String last_name, String password, Role role) throws Exception{
        UserDB userDB = new UserDB();
        userDB.insert(email, activity, first_name, last_name, password, role);
        
    }
    
    public void update(String email, boolean activity, String first_name, String last_name, String password, Role role) throws Exception{
        UserDB userDB = new UserDB();
        User user = userDB.get(email);
        user.setFirstName(first_name);
        user.setLastName(last_name);
        user.setRole(role);
        
        userDB.update(user);
    }
    
    public void delete(String email) throws Exception{
        UserDB userDB = new UserDB();
        User user = userDB.get(email);
        userDB.delete(user);
    }
}






