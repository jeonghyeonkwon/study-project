package com.jeonghyeon.studyproject.board.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Entity
@Table(name = "T_BOARD")
@Getter
@NoArgsConstructor
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String title;
    private String content;
    private Long viewCount;
    private Boolean isDeleted;

    public Board(Long id, User user, String title, String content, Long viewCount, Boolean isDeleted) {
        this.id = id;
        this.user = user;
        this.title = title;
        this.content = content;
        this.viewCount = viewCount;
        this.isDeleted = isDeleted;
    }

    public static Board of(User user, String title, String content) {
        validate(user, title, content);
        return new Board(0L, user, title, content, 0L, false);
    }

    private static void validate(User user, String title, String content) {
        isNullUser(user);
        isBlank(title);
        isBlank(content);
    }

    private static void isBlank(String inputText) {
        Optional.ofNullable(inputText)
                .filter(text -> !text.isEmpty())
                .orElseThrow(
                        () -> new IllegalArgumentException("값을 넣어주세요")
                );
    }

    private static void isNullUser(User user) {
        Optional.ofNullable(user)
                .orElseThrow(
                        () -> new IllegalArgumentException("로그인 후 사용해 주세요")
                );
    }


}
