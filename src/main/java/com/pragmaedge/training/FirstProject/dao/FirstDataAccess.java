package com.pragmaedge.training.FirstProject.dao;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import com.pragmaedge.training.FirstProject.Models.User;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

@Repository
public class FirstDataAccess {
	
	SessionFactory sessionFactory = new Configuration().configure( ).buildSessionFactory();
	Session session = null;
	public User checkUser(String username,String password) {
	//public static void main(String args[])	
    session=sessionFactory.openSession();
	session.beginTransaction();
	@SuppressWarnings("deprecation")
	Criteria criteria = session.createCriteria(User.class);
	criteria.add(Restrictions.and(Restrictions.eq("username", username),Restrictions.eq("password", password)));
    //criteria.add(Restrictions.eq("password", password));

    User user=(User) criteria.uniqueResult();
    //System.out.println(user.getUsername());
    //System.out.println(user.getPassword());
    session.getTransaction().commit();
    session.close();
	 //System.out.println("after "+user.getUsername());
	    //System.out.println(user.getPassword());
	return user;
  }
  public List<User> getUsers()
  {
	  session=sessionFactory.openSession();
	  session.beginTransaction();
	  @SuppressWarnings("deprecation")
	Criteria criteria = session.createCriteria(User.class);
	  @SuppressWarnings("unchecked")
	List<User> users=(List<User>)criteria.list();
	  session.getTransaction().commit();
	  session.close();
	  return users;
  }
  public User getUser(String username) {
	  session=sessionFactory.openSession();
	  session.beginTransaction();
	  @SuppressWarnings("deprecation")
	 Criteria criteria = session.createCriteria(User.class).add(Restrictions.eq("username",username));
	  User user=(User)criteria.uniqueResult();
	  session.getTransaction().commit();
	  session.close();
	  return user;
  }
  @SuppressWarnings("deprecation")
public void postUser(User user)
  {
	  session=sessionFactory.openSession();
	  session.beginTransaction();
     @SuppressWarnings("rawtypes")
	Query q=session.createSQLQuery("insert into user_table values(?,?)");
     q.setString(1, user.getUsername());
     q.setString(2, user.getPassword());
      q.executeUpdate();
      session.getTransaction().commit();
      session.close();
  }
  @SuppressWarnings("deprecation")
public void deleteUser(String username)
  {
	  session=sessionFactory.openSession();
	  session.beginTransaction();
     @SuppressWarnings("rawtypes")
	Query q=session.createSQLQuery("delete from user_table where username=?");
     q.setString(1, username);
      q.executeUpdate();
      session.getTransaction().commit();
      session.close();
  }
  @SuppressWarnings("deprecation")
public void updateUser(User user)
  {
	  session=sessionFactory.openSession();
	  session.beginTransaction();
     @SuppressWarnings("rawtypes")
	Query q=session.createSQLQuery("update user_table set password=? where username=?");
     q.setString(1,user.getPassword());
     q.setString(2, user.getUsername());
      q.executeUpdate();
      session.getTransaction().commit();
      session.close();
  }
  @SuppressWarnings("deprecation")
public User updatUser(User user)
  {
	  session=sessionFactory.openSession();
	  session.beginTransaction();
     @SuppressWarnings("rawtypes")
	Query q=session.createSQLQuery("update user_table set password=? where username=?");
     q.setString(1,user.getPassword());
     q.setString(2, user.getUsername());
      q.executeUpdate();
      session.getTransaction().commit();
      session.close();
      session=sessionFactory.openSession();
	  session.beginTransaction();
      Criteria criteria = session.createCriteria(User.class).add(Restrictions.eq("username",user.getUsername()));
	  User u=(User)criteria.uniqueResult();
      session.getTransaction().commit();
      session.close();
      return u;
  }
}
