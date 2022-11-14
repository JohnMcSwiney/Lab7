/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import entities.Role;
import dataaccess.RoleDB;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author BTran
 */
public class RoleService {
   EntityManagerFactory emfROLE = Persistence.createEntityManagerFactory("notesPU");
   EntityManager emROLE = emfROLE.createEntityManager();
    
   
    
    
    public List<Role> getAll() throws Exception {

        Role a = emROLE.find(Role.class, 1);
         
        
//        for(int i = 0; i < 100; i++){
//            try{
//             List<Role> roles = em.(Role.class, i);   
//            } catch Exception ex{
//                
//            }
//        
//        }
        
        return null;
    }
}