package com.project.spring.controller;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.project.spring.dto.Authority;
import com.project.spring.dto.BoardDto;
import com.project.spring.dto.Member;
import com.project.spring.dto.SecurityMember;
import com.project.spring.service.BoardService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class BoardController {
	private BoardService boardService;
	 
	//기본 페이지 게시판 리스트를 불러온다.
	@GetMapping("/")
	public ModelAndView list() throws Exception{
		System.out.println("test");
		ModelAndView boardModel= new ModelAndView("list");
		List<BoardDto> boardList = boardService.getBoardlist(0);
		
		//리스트 확인
		for (BoardDto boardDto : boardList) {
			System.out.println("타이틀: "+boardDto.getTitle());
		}
		boardModel.addObject("boardList",boardList);
		
		//세션 확인
		boardModel = sessionCheck(boardModel);
		
		return boardModel;
	}
	
	@GetMapping("/{pageNum}")
	public ModelAndView pageList(@PathVariable("pageNum") int pageNum) throws Exception{
		ModelAndView boardModel= new ModelAndView("list");
		List<BoardDto> boardList = boardService.getBoardlist(pageNum-1);
		
		//리스트 확인
		for (BoardDto boardDto : boardList) {
			System.out.println("타이틀: "+boardDto.getTitle());
		}
		boardModel.addObject("boardList",boardList);
		
		//세션 확인
		boardModel = sessionCheck(boardModel);
		
		return boardModel;
	}

    @GetMapping("/post")
    public String write() {
        return "/board/write";
    }

    @PostMapping("/post")
    public String write(BoardDto boardDto) {
    	//jpa를 이용하여 게시판 작성
    	//게시판 작성이 완료되면 메인페이지로 이동
        boardService.savePost(boardDto);
        
        return "redirect:/";
    }
    
    @GetMapping("/login")
   	public String login() {
   		return "login";
   	}
    
    //상세페이지 불러오기
    @GetMapping("/post/{no}")
    public String detail(@PathVariable("no") Long no, Model model) {
        BoardDto boardDTO = boardService.getPost(no);

        model.addAttribute("boardDto", boardDTO);
        return "/board/detail";
    }
    
    //수정 페이지 
    @GetMapping("/post/edit/{no}")
    public String edit(@PathVariable("no") Long no, Model model) {
        BoardDto boardDTO = boardService.getPost(no);

        model.addAttribute("boardDto", boardDTO);
        return "/board/update";
    }
    
    //수정 
    @PostMapping("/post/edit/{no}")
    public String update(BoardDto boardDTO) {
        boardService.savePost(boardDTO);

        return "redirect:/";
    }
    
    //삭제 
    @PostMapping("/post/{no}")
    public String delete(@PathVariable("no") Long no) {
    	
        boardService.deletePost(no);
        return "redirect:/";
    }
    
    //검색
    @PostMapping("/board/search")
    public ModelAndView search(String keyword){
        
        
        ModelAndView boardModel= new ModelAndView("list");
        List<BoardDto> boardDtoList = boardService.searchPosts(keyword);
		for (BoardDto boardDto : boardDtoList) {
			System.out.println(boardDto.getCreatedDate()+boardDto.getContent());
		}
		boardModel.addObject("boardList",boardDtoList);
		return boardModel;
    }
    
    public ModelAndView sessionCheck(ModelAndView modelAndView) {
    	Object obj  = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(obj instanceof String) {
			//익명의 사용자 받은 그래로 리턴
			return modelAndView;
		}
		else {
			//로그인 후 사용자 아이디 사용자의 이름을 추가하여 리턴
			SecurityMember securityMember = (SecurityMember)obj;
			System.out.println(securityMember.getUsername());
			modelAndView.addObject("username",securityMember.getUsername());
			return modelAndView;
		}
		
    }
}
