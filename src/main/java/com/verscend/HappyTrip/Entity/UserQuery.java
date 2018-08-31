package com.verscend.HappyTrip.Entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "UserQuery")
public class UserQuery {
			@Id
			@GeneratedValue(strategy = GenerationType.AUTO)
			@Column(name = "id")
			private int id;
			
			@Column(name = "name")
			private String name;
			
			@Column(name = "subject")
			private String subject;
			
			@Column(name = "email")
			private String email;
			
			@Column(name = "message")
			private String message;
			
			public UserQuery() {
				
			}
			
			public UserQuery(int id, String name, String email, String message,String subject) {
				super();
				this.id = id;
				this.name = name;
				this.email = email;
				this.message = message;
				this.subject = subject;
			}

			public int getId() {
				return id;
			}
			public void setId(int id) {
				this.id = id;
			}
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
			public String getEmail() {
				return email;
			}
			public void setEmail(String email) {
				this.email = email;
			}
			public String getMessage() {
				return message;
			}
			public void setMessage(String message) {
				this.message = message;
			}

			public String getSubject() {
				return subject;
			}

			public void setSubject(String subject) {
				this.subject = subject;
			}
			
		} 
		 


