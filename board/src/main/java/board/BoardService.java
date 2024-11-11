package board;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.mapper.BoardMapper;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class BoardService {
	
	@Autowired
	private BoardMapper boardMapper;
	
	// 게시판 조회
	public HashMap<String, Object> selectBoardList(HashMap<String, Object> mapParam) {
		HashMap<String, Object> mapReturn = new HashMap<String, Object>();
		
		try {
			mapReturn.put("result", "성공");
			mapReturn.put("list", boardMapper.selectBoardList(mapParam)); // 게시판 조회
			
		} catch (Exception e) {
			mapReturn.put("result", "실패");
			log.info(e);
		}
		
		return mapReturn;
	}
	
	// 게시판 등록..
	public HashMap<String, Object> insertBoard(HashMap<String, Object> mapParam) {
		HashMap<String, Object> mapReturn = new HashMap<String, Object>();
		
		try {
			if (boardMapper.insertBoard(mapParam) > 0) {
				mapReturn.put("result", "성공");
				mapReturn.put("boardSeq", boardMapper.getMaxBoardSeq()); // 등록된 게시판 순번 가져오기
				
			} else {
				mapReturn.put("result", "실패");
			}
			
		} catch (Exception e) {
			mapReturn.put("result", "실패");
			log.info(e);
		}
		
		return mapReturn;
	}
	
	// 게시판 수정
	public HashMap<String, Object> updateBoard(HashMap<String, Object> mapParam) {
		HashMap<String, Object> mapReturn = new HashMap<String, Object>();
		
		try {
			if (boardMapper.updateBoard(mapParam) > 0) {
				mapReturn.put("result", "성공");
			} else {
				mapReturn.put("result", "실패");
			}
			
		} catch (Exception e) {
			mapReturn.put("result", "실패");
			log.info(e);
		}
		
		return mapReturn;
	}
	
	// 게시판 삭제
	public HashMap<String, Object> deleteBoard(HashMap<String, Object> mapParam) {
		HashMap<String, Object> mapReturn = new HashMap<String, Object>();
		
		try {
			if (boardMapper.deleteBoard(mapParam) > 0) {
				mapReturn.put("result", "성공");
			} else {
				mapReturn.put("result", "실패");
			}
			
		} catch (Exception e) {
			mapReturn.put("result", "실패");
			log.info(e);
		}
		
		return mapReturn;
	}

}
