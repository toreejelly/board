package com.study.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.study.board.service.BoardService;


import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller 
public class BoardController {
	
	
	@Autowired
//  다른곳에 것을 사용할 때	
	private BoardService boardService;
//2	접근제어자 여기클래스에 접근(대문자로 작성), 변수명(소문자로 작성)BordController에서 이 이름으로 사용하겠다
//  private : 같은클래스에서만 접근 가능
//  public 	: 모든클래스에서만 접근 가능	

	//목록 조회
	@GetMapping("/list")
	public String list(Model model) {
//		   리턴값=string 함수이름=list(Model : 데이터를 담는 그릇 역할)
		
		log.info("BoardController list()");
		//log.info("main에 커밋하기");
		//log.info("디포리");
		//log.info("디포리2");
		//log.info("디포리2");
	    //log.info("boardService.getList() : " + boardService.getList());
	    
		model.addAttribute("list", boardService.getList());
//1					        이름(key), 값(value)
//		  addAttribute(String name, Object value)
//		  : value 객체를 name 이름으로 추가해줌	 
		
		return "list";
    }



}

