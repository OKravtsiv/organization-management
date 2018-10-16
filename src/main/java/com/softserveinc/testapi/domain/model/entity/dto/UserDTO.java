package com.softserveinc.testapi.domain.model.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.softserveinc.testapi.domain.model.UserRights;
import com.softserveinc.testapi.domain.model.entity.User;
import org.springframework.security.core.GrantedAuthority;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserDTO {
    private Long id;
    private String username;
    @JsonIgnore
    private String password;
    private boolean enabled;
    @JsonIgnore
    private Collection<? extends GrantedAuthority> authorities;

    public UserDTO() {
    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.enabled = user.isEnabled();
        this.authorities = user.getAuthorities();
    }

    public static List<UserDTO> mapAll(List<User> users) {
        return users.stream().map(UserDTO::new).collect(Collectors.toList());
    }

    public static User restore(UserDTO userDTO) {
        return new User(userDTO.getUsername(), userDTO.getPassword(), true, Arrays.asList(UserRights.COMMON.getAuthority()));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}
