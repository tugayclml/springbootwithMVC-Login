package com.springbootmvc.login.model;

import java.io.Serializable;

import javax.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name="role")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Role implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="role_id")
	private int id;
	
	@Column(name="role")
	private String role;
}
