package ru.social.network.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Общая информация о пользователях.
 *
 * @author Irina Ilina
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails {

  private static final long serialVersionUID = 1L;

  private Long id;

  private String firstName;

  private String lastName;

  private String login;

  private Date birthDate;

  private String email;

  private String password;

  private Gender gender;

  private String hobby;

  private String city;

  private ERole role;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of(new SimpleGrantedAuthority(role.name()));
  }

  @Override
  public String getUsername() {
    return login;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
