package board;

import java.util.HashMap;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardsevice;
	
	@GetMapping("/")
	public String boardList () {
		// 게시판 목록
		return "boardList";
	}
	
	@PostMapping("/board")
	public String board (Model model, @RequestParam HashMap<String, Object> mapParam) {
		// 게시판 목록
		model.addAttribute("boardSeq", mapParam.get("boardSeq"));
		return "board";
	}
	
	@PostMapping("/selectBoardList")
	public @ResponseBody HashMap<String, Object> selectBoradList (@RequestBody HashMap<String, Object> mapParam) {
		// 게시판 조회.
		return boardsevice.selectBoardList(mapParam);
	}
	 
	@PostMapping("/insertBoard")
	public @ResponseBody HashMap<String, Object> insertBoard (@RequestBody HashMap<String, Object> mapParam) {
		// 게시판 등록
		return boardsevice.insertBoard(mapParam);
	}
	
	@PostMapping("/updateBoard")
	public @ResponseBody HashMap<String, Object> updateBoard (@RequestBody HashMap<String, Object> mapParam) {
		// 게시판 수정
		return boardsevice.updateBoard(mapParam);
	}
	
	@PostMapping("/deleteBoard")
	public @ResponseBody HashMap<String, Object> deleteBoard (@RequestBody HashMap<String, Object> mapParam) {
		// 게시판 삭제
		return boardsevice.deleteBoard(mapParam);
	}
	
}
