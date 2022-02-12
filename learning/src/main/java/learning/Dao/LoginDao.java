package learning.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import learning.Entity.Instructor;
import learning.Entity.Login;

@Repository
public interface LoginDao {
	
	//  new instructor registration add data.
	@Transactional
	public void addLogin(Login login);
	//get the single instructor
	public Login getLogin(String email);
	
	public boolean validUser(Login login);
}
