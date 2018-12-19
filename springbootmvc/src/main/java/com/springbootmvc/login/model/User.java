package com.springbootmvc.login.model;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Set;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import lombok.*;

@Entity
@Table(name="users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="user_id")
	private int id;
	
	@Column(name="email")
	@Email(message="Lütfen geçerli bir mail adresi giriniz!")
	@NotEmpty(message="Lütfen bir mail adresi giriniz!")
	private String email;
	
	@Column(name="password")
	@Length(min=5,message="Şifreniz en az 5 karakterden oluşmalıdır!")
	@NotEmpty(message="Lütfen bir mail adresi giriniz!")
	private String password;
	
	@Column(name="name")
	@NotEmpty(message="Lütfen adınızı giriniz!")
	private String name;
	
	@Column(name="surname")
	@NotEmpty(message="Lütfen soyadınızı giriniz")
	private String lastName;
	
	@Column(name="active")
	private int active;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="user_role",joinColumns=@JoinColumn(name="user_id"),inverseJoinColumns = @JoinColumn(name="role_id"))
	private Set<Role> role;
}
