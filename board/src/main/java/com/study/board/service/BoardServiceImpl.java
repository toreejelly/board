package com.study.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.board.mapper.BoardMapper;
import com.study.board.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	
	private BoardMapper mapper;	

//목록3	
	//목록조회
	@Override
//	메서드(함수) 선언에만 달 수 있으며, 
//	상위 타입(부모 타입)의 메서드를 재정의했음을 의미한다.
	
	public List<BoardVO> getList(){
// 접근제어자 자바유틸<리턴값> 함수이름(매개변수.파라미터) 		
 	
		return mapper.getList();		
	}
	
//조회4	
//수정5	
	//글 조회
	@Override
	public BoardVO getContent(int boardId) {
		return mapper.getContent(boardId);
	}

//쓰기11	
	//글쓰기
	@Override
	public void contentWrite(BoardVO boardVO) {
		mapper.contentWrite(boardVO);
	}

//쓰기16	
	//최신 글번호
	@Override
	public int boardId() {
		return mapper.boardId();
	}

//삭제6	
	//글 삭제
	@Override
	public void contentDelete(int boardId) {
		mapper.contentDelete(boardId);
	}
	
//수정15
	@Override
	public void contentModify(BoardVO boardVO) {
		mapper.contentModify(boardVO);
	}
}
