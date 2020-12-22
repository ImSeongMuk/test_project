package com.project.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.spring.domain.entity.BoardEntity;
import com.project.spring.dto.BoardDto;
import com.project.spring.repository.BoardRepository;

import lombok.AllArgsConstructor;

//board에 대한 service
@AllArgsConstructor
@Service
public class BoardService {
	private BoardRepository boardRepository;
	
	//게시판 불러오기
	@Transactional
    public List<BoardDto> getBoardlist(int pageNum) {
		
		PageRequest pageRequest = PageRequest.of(pageNum,10);
		Page<BoardEntity> boardEntities = boardRepository.findAll(pageRequest);
        //List<BoardEntity> boardEntities = boardRepository.findAll();
        List<BoardDto> boardDtoList = new ArrayList<>();

        for ( BoardEntity boardEntity : boardEntities) {
            BoardDto boardDTO = BoardDto.builder()
                    .id(boardEntity.getId())
                    .title(boardEntity.getTitle())
                    .content(boardEntity.getContent())
                    .writer(boardEntity.getWriter())
                    .createdDate(boardEntity.getCreatedDate())
                    .build();

            boardDtoList.add(boardDTO);
        }
        //게시판 리스트
        return boardDtoList;
    }
	
	//게시판 저장
    @Transactional
    public Long savePost(BoardDto boardDto) {
        return boardRepository.save(boardDto.toEntity()).getId();
    }
    
    //게시판 상세 내용
    @Transactional
    public BoardDto getPost(Long id) {
        Optional<BoardEntity> boardEntityWrapper = boardRepository.findById(id);
        BoardEntity boardEntity = boardEntityWrapper.get();

        BoardDto boardDTO = BoardDto.builder()
                .id(boardEntity.getId())
                .title(boardEntity.getTitle())
                .content(boardEntity.getContent())
                .writer(boardEntity.getWriter())
                .createdDate(boardEntity.getCreatedDate())
                .build();
        //선택한 게시판 상세 내용
        return boardDTO;
    }
    //게시판 삭제 
    @Transactional
    public void deletePost(Long id) {
        boardRepository.deleteById(id);
    }
    
    //게시판 검색
    @Transactional
    public List<BoardDto> searchPosts(String keyword) {
        List<BoardEntity> boardEntities = boardRepository.findByTitleContaining(keyword);
        List<BoardDto> boardDtoList = new ArrayList<>();
        //검색결과가 없을 경우
        if (boardEntities.isEmpty()) return boardDtoList;

        for (BoardEntity boardEntity : boardEntities) {
            boardDtoList.add(this.convertEntityToDto(boardEntity));
        }

        return boardDtoList;
    }

    private BoardDto convertEntityToDto(BoardEntity boardEntity) {
        return BoardDto.builder()
                .id(boardEntity.getId())
                .title(boardEntity.getTitle())
                .content(boardEntity.getContent())
                .writer(boardEntity.getWriter())
                .createdDate(boardEntity.getCreatedDate())
                .build();
    }
}
