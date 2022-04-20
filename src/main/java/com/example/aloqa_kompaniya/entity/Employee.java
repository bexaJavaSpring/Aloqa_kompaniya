package com.example.aloqa_kompaniya.entity;

import com.example.aloqa_kompaniya.entity.enums.PermissionEnum;
import com.example.aloqa_kompaniya.entity.enums.Provider;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Employee implements UserDetails {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String fullName;
    @Column(nullable = false,unique = true)
    private String username;
    @Column(nullable = false)
    private String password;
    @Email
    private String email;
    private String phone;
    @Column(updatable = false, nullable = false)
    private Timestamp createdAt;
    private String emailCode;
    @Column(nullable = false)
    private Timestamp updateAt;
    @ManyToMany
    private Set<Role> roles;
    @ManyToOne
    private Company company;
    @Enumerated(EnumType.STRING)
    private Provider provider;
    private boolean active;
    public Employee(String fullName, Set<Role> roles, String username, String password, boolean enabled) {
        this.fullName = fullName;
        this.roles = roles;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }

    private boolean accountNonExpired=true;
    private boolean accountNonLocked=true;
    private boolean credentialsNonExpired=true;
    private boolean enabled=true;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        for (Role role : this.roles) {
            Set<PermissionEnum> permissionEnumSet1 = role.getPermissionEnumSet();
            for (PermissionEnum permissionEnum : permissionEnumSet1) {
                grantedAuthorities.add(new SimpleGrantedAuthority(permissionEnum.name()));
            }
        }
        System.out.println(grantedAuthorities);
        return grantedAuthorities;
    }
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }



}
