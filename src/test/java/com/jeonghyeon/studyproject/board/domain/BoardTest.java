package com.jeonghyeon.studyproject.board.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class BoardTest {
    User user;

    @BeforeEach
    void inti() {
        user = User.of("givejeong", "정현", "1234", UserType.USER);
    }

    @Test
    void create() {
        Board create = Board.of(user, "제목", "내용");


        assertAll(
                () -> assertThat(create.getTitle()).isEqualTo("제목"),
                () -> assertThat(create.getContent()).isEqualTo("내용")
        );
    }

    @DisplayName("빈값이면 예외 발생")
    @Test
    void create_exception() {
        assertAll(
                () -> assertThatThrownBy(() -> Board.of(null, "제목", "내용")).isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> Board.of(user, "", "내용")).isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> Board.of(user, null, "내용")).isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> Board.of(user, "제목", "")).isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> Board.of(user, "제목", null)).isInstanceOf(IllegalArgumentException.class)
        );

    }
}
