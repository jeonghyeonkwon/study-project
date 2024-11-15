package com.jeonghyeon.studyproject.board.service;

import com.jeonghyeon.studyproject.board.domain.User;
import com.jeonghyeon.studyproject.board.domain.UserType;
import com.jeonghyeon.studyproject.board.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void crud(){
        User user = User.of("givejeong", "정현", "1234", UserType.USER);
        User save = userRepository.save(user);

        User findUser = userRepository.findById(1L).get();

        assertThat(save).isEqualTo(findUser);

    }

}
