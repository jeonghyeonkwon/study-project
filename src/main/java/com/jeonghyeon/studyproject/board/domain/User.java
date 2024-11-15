package com.jeonghyeon.studyproject.board.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Entity
@Table(name = "T_USER")
@Getter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    private String userId;
    private String userName;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserType userType;

    private User(Long id, String userId, String userName, String password, UserType userType) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.userType = userType;
    }

    public static User of(String userId, String userName, String password, UserType userType) {
        return new User(0L, userId, userName, password, userType);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
