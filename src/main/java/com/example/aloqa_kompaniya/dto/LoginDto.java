package com.example.aloqa_kompaniya.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginDto {
  @NotNull(message = "username is required")
  private String username;
  @NotNull(message = "password is required")
  private String password;
}
