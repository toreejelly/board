package com.study.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.study.board.service.BoardService;
import com.study.board.vo.BoardVO;

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
	
	//글 조회	
	//list.jsp 의
	//111<a href="/board/${list.boardId}">${list.title}</a> 를 타고 왔음
//222
	@GetMapping("/board/{boardId}")
	public String contentViewForm(Model model, BoardVO boardVO) {
		log.info("BoardController contentViewForm() boardVO");
		log.info("boardVO : " + boardVO);

//							BoardVO안에는 boardId인데 왜 BoardId이지? getter setter 만들어질 때는 자동으로 앞이 대문자가 된다.		
		int boardId = boardVO.getBoardId();
		log.info("boardId : " + boardId);
		
//			이 content는 어디서 사용하는거지? contentViewForm.jsp에서 사용		
		model.addAttribute("content", boardService.getContent(boardId));

//777		
		// return값 jsp이름 (contentViewForm.jsp)
		return "contentViewForm";		
	}
	

	//글쓰기 페이지
	@GetMapping("/contentWriteForm")
	public String contentWriteForm() {
		log.info("BoardController contentWriteForm()");
		
		return "contentWriteForm";
	}
	
//44	
    //글쓰기
    @PostMapping("/contentWrite")											 
    public ResponseEntity<String> contentWrite(@RequestBody BoardVO boardVO) {
    //											바디가 이거라고 알려주는 주석같은 것									    	
    	log.info("BoardController contentWrite()");
    	log.info("boardVO : " + boardVO);

    	//초기화 시킴
		ResponseEntity<String> entity = null;
		
		//try catch는 예외 처리를 위해 사용되는 구문입니다.
		try {
			//55			
			boardService.contentWrite(boardVO);		//글쓰기
			
			//9999
			//alert("작성되었습니다.")를 띄운 후 글작성 내용을 띄우기 위해 필요함
			int boardId = boardService.boardId();	//최신 글번호
			String strBoardId = Integer.toString(boardId);
			log.info("boardId : " + boardId);
			
			
			//success : function(result)로 어케 가는거지?HttpStatus.OK면sucess로 간다
			//strBoardId이 값을 ,success : function(result)의 result가 받는다 
			entity = new ResponseEntity<String>(strBoardId, HttpStatus.OK);
			
		} catch (Exception e) {
			
			//예외상황을 분석하기 위해 사용(메소드의 정보와 예외결과를 화면에 출력함)
			e.printStackTrace();
			//e.getMessage()값을 ,error : function(e)의 e가 받는다
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
         
		return entity;
    } 

//삭제4    
    //글 삭제
    @DeleteMapping("/board/{boardId}")
    public ResponseEntity<String> contentDelete(@RequestBody BoardVO boardVO) {
    	log.info("BoardController contentDelete()");
    	log.info("boardVO : " + boardVO);

		ResponseEntity<String> entity = null;
		int boardId = boardVO.getBoardId();

		////try catch는 예외 처리를 위해 사용되는 구문이다.
		try {
			boardService.contentDelete(boardId);	//글 삭제
			
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
         
		return entity;

    }
    
//수정2    
  //글 수정 페이지
    @GetMapping("/contentModifyForm/{boardId}")
    public String contentModifyForm(Model model, BoardVO boardVO) {
		log.info("BoardController contentModifyForm() boardVO");
		log.info("boardVO : " + boardVO);
	    
		int boardId = boardVO.getBoardId();
		log.info("boardId : " + boardId);
//수정3		
		model.addAttribute("content", boardService.getContent(boardId));
//수정8	    
		return "contentModifyForm";
    }

//수정13    
    //글 수정
    @PutMapping("/board/{boardId}")
    public ResponseEntity<String> contentModify(@RequestBody BoardVO boardVO) {
    	log.info("BoardController contentModify()");
    	log.info("boardVO : " + boardVO);

		ResponseEntity<String> entity = null;

		try {
			boardService.contentModify(boardVO);
			
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
         
		return entity;

    } 

}

