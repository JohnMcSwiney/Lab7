package dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import entities.*;
import javax.persistence.*;

/**
 *
 * @author Alex Tompkins - 821984
 */
public class UserDB {

    public List<User> getAll() throws Exception {
        EntityManagerFactory emFactory = DBUtil.getEmFactory();
        EntityManager em = emFactory.createEntityManager();
        
        return em.createNamedQuery("User.findAll", User.class).getResultList();
        }
    

   public User get(String email) throws Exception {
      EntityManagerFactory emFactory = DBUtil.getEmFactory();
        EntityManager em = emFactory.createEntityManager();
        
        try {
            User user = em.find(User.class, email);
            return user;
    }
        finally{
            em.close();
        }
        
    }
   
   public void insert(String email, boolean active, String first_name, String last_name, String password, Role role){
        EntityManagerFactory emFactory = DBUtil.getEmFactory();
        EntityManager em = emFactory.createEntityManager();
        User user = new User(email, active, first_name, last_name, password, role);
        EntityTransaction ett = em.getTransaction();
        try {
           ett.begin();
           em.merge(user);
           ett.commit();
           
        } catch (Exception ex) {
            ett.rollback();
            
        } finally {
            em.close();
        }
   }
   
   public void update(User user){
       EntityManagerFactory emFactory = DBUtil.getEmFactory();
       EntityManager em = emFactory.createEntityManager();
       EntityTransaction ett = em.getTransaction();
        
        try{
            ett.begin();
            em.merge(user);
            ett.commit();
        } catch (Exception ex) {
            ett.rollback();
        } finally {
            em.close();
        }
   }
   
   public void delete(User user){
       EntityManagerFactory emFactory = DBUtil.getEmFactory();
       EntityManager em = emFactory.createEntityManager();
       EntityTransaction ett = em.getTransaction();
        
        try{
            ett.begin();
            em.remove(em.merge(user));
            ett.commit();
        } catch (Exception ex) {
            ett.rollback();
        } finally {
            em.close();
        }
       
   }

}

//    public void update(User user) throws Exception {
//        ConnectionPool pool = ConnectionPool.getInstance();
//        Connection connection = pool.getConnection();
//        PreparedStatement statement = null;
//        String sql = "UPDATE user SET active=?, first_name=?, last_name=?, password=?, role=? WHERE email=?";
//        try {
//            statement = connection.prepareStatement(sql);
//            statement.setBoolean(1, user.getActive());
//            statement.setString(2, user.getFirstName());
//            statement.setString(3, user.getLastName());
//            statement.setString(4, user.getPassword());
//            statement.setInt(5, user.getRole().getId());
//            statement.setString(6, user.getEmail());
//            statement.executeUpdate();
//        } finally {
//            DBUtil.closePreparedStatement(statement);
//            pool.freeConnection(connection);
//        }
//    }
//
//    public void delete(User user) throws Exception {
//        ConnectionPool pool = ConnectionPool.getInstance();
//        Connection connection = pool.getConnection();
//        PreparedStatement statement = null;
//        String sql = "DELETE FROM user WHERE email=?";
//        try {
//            statement = connection.prepareStatement(sql);
//            statement.setString(1, user.getEmail());
//            statement.executeUpdate();
//        } finally {
//            DBUtil.closePreparedStatement(statement);
//            pool.freeConnection(connection);

