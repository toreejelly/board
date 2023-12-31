package com.study.board.service;

import java.util.List;

import com.study.board.vo.BoardVO;

public interface BoardService {
//    interface / implements(interface의 상세버전)

//목록2	
	//목록 조회
	public List<BoardVO> getList();
//	접근제어자 자바유틸<리턴값>	 함수이름(매개변수.파라미터)		
//	접근제어자 리턴값         함수
//			리턴값 없을 경우 void 

//조회3
//수정4
	//글 조회
//							형을 꼭 적어줘야하는가? 무조건 적어줘야함(제네릭<T> 공부)	
	public BoardVO getContent(int boardId);

//쓰기10	
	//글쓰기
	//boardService.contentWrite(boardVO);이케 오는데 왜 (BoardVO boardVO)이렇게 오는거지?
	//함수 선언할 때에는 어디것인지 표시해주는거고 사용할때는 표시해 줄 필요 없고 변수 맞게만 작성하면 된다
	public void contentWrite(BoardVO boardVO);
	
//쓰기15	
	//최신 글번호
	public int boardId();
	
//수정14
	//글 수정
	public void contentModify(BoardVO boardVO);

//삭제5	
	//글 삭제
	public void contentDelete(int boardId);

}