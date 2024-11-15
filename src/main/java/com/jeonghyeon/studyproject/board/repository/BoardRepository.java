package com.jeonghyeon.studyproject.board.repository;

import com.jeonghyeon.studyproject.board.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
}
