package learning.Dao;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import learning.Entity.Login;
@Component
public class LoginDaoImpl implements LoginDao{
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	private HibernateQueryUtility hiber;
	// new instructor registration add data.
	@Transactional
	public void addLogin(Login login) {
		this.hibernateTemplate.save(login);

	}

	// get the single instructor
	public Login getLogin(String email) {
		Login login1 = this.hibernateTemplate.get(Login.class, email);
		return login1;
	}

	public boolean validUser(Login login) {
	 Session session =	this.hiber.getQuery();
	 Query query = session.createQuery("from Login where email =:e  and password=:p and type =:t ",Login.class);
	 query.setParameter("e",login.getEmail());	
	 query.setParameter("p",login.getPassword());
	 query.setParameter("t",login.getType());
	 Object obj =null;
	 try {
		 	obj = query.getSingleResult();
	 	}catch(NoResultException nre) {
	 		return false;
	 	}
	 if(obj==null)
		 	return false;
	   return true;
	}
}
