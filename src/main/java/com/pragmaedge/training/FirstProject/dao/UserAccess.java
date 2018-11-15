package com.pragmaedge.training.FirstProject.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import com.pragmaedge.training.FirstProject.Models.UserData;

@Repository
public class UserAccess {
	Session session = null;

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
		return users;

	}

	@SuppressWarnings({ "deprecation", "rawtypes", "unchecked" })
	public List<UserData> searchUsers(String userid, String role, String firstName, String lastName, String status)
			throws Exception {
		session = new FirstDataAccess().sessionFactory.openSession();
		session.beginTransaction();
		List<UserData> users = null;
		if (firstName != null || lastName != null || userid != null) {
			Query q = session.createSQLQuery("select * from userdata where firstname=? or lastName=? or userid=?");
			q.setString(1, firstName);
			q.setString(2, lastName);
			q.setString(3, userid);
			users = q.list();

		} else {
			Query q = session.createSQLQuery("select * from userdata where status=? or role=?");
			q.setString(2, role);
			q.setString(1, status);
			users = q.list();

		}
		return users;
	}
}
