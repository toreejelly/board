package com.study.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.study.board.vo.BoardVO;

@Mapper
public interface BoardMapper {


//목록4	
	//목록조회
	public List<BoardVO> getList(); 
//        자바유틸<리턴값>  함수이름(매개변수.파라미터)	

//조회5
//수정6	
	//글 조회
	public BoardVO getContent(int boardId);

//쓰기12	
	//글 작성 
	public void contentWrite(BoardVO boardVO);

//쓰기17	
	//최신 글번호
	public int boardId();

//삭제7	
	//글 삭제 
	public void contentDelete(int boardId);
	
//수정16
	//글 수정
	public void contentModify(BoardVO boardVO);
	
}
