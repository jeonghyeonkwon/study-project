package com.jeonghyeon.studyproject.board.repository;

import com.jeonghyeon.studyproject.board.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
