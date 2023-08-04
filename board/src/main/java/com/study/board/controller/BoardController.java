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
	private BoardService boardService;
	
	//목록 조회
	@GetMapping("/list")
	public String list(Model model) {
		log.info("BoardController list()");
		//log.info("main에 커밋하기");
		//log.info("디포리");
		//log.info("디포리2");
		//log.info("디포리2");
	    //log.info("boardService.getList() : " + boardService.getList());
	    
		model.addAttribute("list", boardService.getList());
	    
		return "list";
    }



}

