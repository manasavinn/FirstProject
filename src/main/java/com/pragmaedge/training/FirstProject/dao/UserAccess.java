package com.pragmaedge.training.FirstProject.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import com.pragmaedge.training.FirstProject.Models.UserData;

@Repository
public class UserAccess {
	Session session = null;
	SessionFactory sessionFactory = new Configuration().configure( ).buildSessionFactory();
	@SuppressWarnings("deprecation")
	public void postUser(UserData user) {
		session = new FirstDataAccess().sessionFactory.openSession();
		session.beginTransaction();
		@SuppressWarnings("rawtypes")
		Query q = session.createSQLQuery("insert into userdata values(?,?,?,?,?,?,?,?,?)");
		q.setString(1, user.getUserId());
		q.setString(2, user.getEmail());
		q.setString(3, user.getFirstName());
		q.setString(4, user.getLastName());
		q.setString(5, user.getMiddleName());
		q.setString(6, user.getPassword());
		q.setString(8, user.getRole());
		q.setString(7, user.getPhone());
		q.setString(9, user.getStatus());
		q.executeUpdate();
		session.getTransaction().commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<UserData> getUsers() throws Exception {
		session = new FirstDataAccess().sessionFactory.openSession();
		// Session session=sessionFactory.openSession();
		session.beginTransaction();
		@SuppressWarnings("rawtypes")
		Query q = session.createSQLQuery("select * from userdata");
		List<UserData> users = q.list();
		session.close();
		return users;
		

	}

	@SuppressWarnings({ "deprecation", "rawtypes", "unchecked" })
	public List<UserData> searchUsers(String userid, String role, String firstName, String lastName, String status)
			throws Exception {
		session = new FirstDataAccess().sessionFactory.openSession();
		session.beginTransaction();
		List<UserData> users = null;
		if (!(firstName.equals("")) || !(lastName.equals("")) || !(userid.equals(""))) {
			Query q = session.createSQLQuery("select * from userdata where firstname=? or lastName=? or userid=?");
			q.setString(1, firstName);
			q.setString(2, lastName);
			q.setString(3, userid);
			users = q.list();

		} else {
			Query q = session.createSQLQuery("select * from userdata where role=? or status=?");
			q.setString(1, role);
			q.setString(2, status);
			users = q.list();

		}
		session.close();
		return users;
	}
	@SuppressWarnings("deprecation")
	public UserData updateUser(UserData user)throws Exception {
		session = new FirstDataAccess().sessionFactory.openSession();
		// Session session=sessionFactory.openSession();
		session.beginTransaction();
		@SuppressWarnings("rawtypes")
	    Query q = session.createSQLQuery("update userdata set email=?,firstname=?,lastname=?,middlename=?,password=?,phone=?,role=?,status=? where userid=?");
		q.setString(1, user.getEmail());
		q.setString(2, user.getFirstName());
		q.setString(3, user.getLastName());
		q.setString(4, user.getMiddleName());
		q.setString(5, user.getPassword());
		
		q.setString(6, user.getPhone());
		q.setString(7, user.getRole());
		q.setString(8, user.getStatus());
		q.setString(9, user.getUserId());
		q.executeUpdate();
		session.close();
		UserData u=getUser(user.getUserId());
		
		return u;

	}
	@SuppressWarnings("deprecation")
	public UserData getUser(String userId)throws Exception  {
		session = new FirstDataAccess().sessionFactory.openSession();
		// Session session=sessionFactory.openSession();
		  session.beginTransaction();
		 Criteria criteria = session.createCriteria(UserData.class).add(Restrictions.eq("userId",userId));
		  UserData user=(UserData)criteria.uniqueResult();
		  session.getTransaction().commit();
		  session.close();
		  return user;
 }
	@SuppressWarnings({ "rawtypes", "deprecation" })
	public void deleteUser(String userId)throws Exception  {
		session = new FirstDataAccess().sessionFactory.openSession();
		// Session session=sessionFactory.openSession();
		  session.beginTransaction();
		  String hql = "delete from userdata where userid=?";
		  Query q=session.createSQLQuery(hql);
		  q.setString(1, userId);
		  q.executeUpdate();
		  session.getTransaction().commit();
		  session.close();
 }
}
