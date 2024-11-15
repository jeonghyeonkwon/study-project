package com.jeonghyeon.studyproject.board.domain;

import org.junit.jupiter.api.Test;

public class UserTest {
    @Test
    void create(){
        User user = User.of("givejeong", "정현", "1234", UserType.USER);


    }
}
