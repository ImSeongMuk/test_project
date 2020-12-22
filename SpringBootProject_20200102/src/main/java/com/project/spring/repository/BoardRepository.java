package com.project.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.spring.domain.entity.BoardEntity;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
	List<BoardEntity> findByTitleContaining(String keyword);
	
}
