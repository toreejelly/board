package com.study.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.study.board.vo.BoardVO;

@Mapper
public interface BoardMapper {
//7
	
	//목록조회
	public List<BoardVO> getList(); 
//6        자바유틸<리턴값>  함수이름(매개변수.파라미터)	
	
}
