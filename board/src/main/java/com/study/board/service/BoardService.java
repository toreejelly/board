package com.study.board.service;

import java.util.List;

import com.study.board.vo.BoardVO;

public interface BoardService {
//4    interface / implements(interface의 상세버전)
	
	//목록 조회
	public List<BoardVO> getList();
//3	접근제어자 자바유틸<리턴값>	 함수이름(매개변수.파라미터)		
//	접근제어자 리턴값         함수
//			리턴값 없을 경우 void 
	
	//글 조회
//							형을 꼭 적어줘야하는가?	
	public BoardVO getContent(int boardId);

	//글쓰기
	public void contentWrite(BoardVO boardVO);

	//최신 글번호
	public int boardId();

	//글 수정
	//public void contentModify(BoardVO boardVO);

	//글 삭제
	//public void contentDelete(int boardId);

}