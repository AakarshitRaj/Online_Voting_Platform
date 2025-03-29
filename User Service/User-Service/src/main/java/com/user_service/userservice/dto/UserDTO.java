package com.user_service.userservice.dto;
import com.user_service.userservice.model.User.Role;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;//For getter ,setter,constructor

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	@NotBlank(message="Name is required")
	@Size(min=3,max=50,message="Name must be between 3 and 50 characters")
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    @Column(unique = true)
	private String email;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters")
//    @JsonIgnore
	private String password;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private Role role;
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
}
