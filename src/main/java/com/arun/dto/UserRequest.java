package com.arun.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UserRequest {

	@NotEmpty(message = "user firstName is should not null")
	private String firstName;
	@NotEmpty(message = "user lastName is should not null")
	private String lastName;
	@NotEmpty(message = "user city is should not null")
	private String city;
	@Email(message = "invalid email address")
	private String email;
	@Pattern(regexp = "^\\d{10}$", message = "invalid mobile number")
	private String mobile;
	@NotEmpty(message = "Gender shoild not be null")
	private String gender;
	@Min(18)
	@Max(60)
	private String age;
}
