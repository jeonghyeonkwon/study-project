package com.jeonghyeon.studyproject.board.domain;

public class User {
    private Long id;
    private String userId;
    private String userName;
    private String password;
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
}
