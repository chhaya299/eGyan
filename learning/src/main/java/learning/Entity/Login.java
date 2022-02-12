package learning.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="login")
public class Login {
	    @Id
		private String email;

	    @Override
		public String toString() {
			return "Login [email=" + email + ", password=" + password + ", type=" + type + "]";
		}

		public Login() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Login(String email, String password, String type) {
			super();
			this.email = email;
			this.password = password;
			this.type = type;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		@Column( nullable = false)
		private String password;

	    @Column( nullable = false)
		private String  type;
}
