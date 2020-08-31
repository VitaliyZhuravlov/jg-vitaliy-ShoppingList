package com.javaguru.shoppinglist.dto;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class UserDto {

    private Long id;
    @NotNull
    @NotEmpty
    @Length(min = 3, max = 30)
    private String username;

    public UserDto() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return Objects.equals(id, userDto.id) &&
                Objects.equals(username, userDto.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username);
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}
