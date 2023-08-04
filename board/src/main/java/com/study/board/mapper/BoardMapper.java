package com.study.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.study.board.vo.BoardVO;

@Mapper
public interface BoardMapper {

	public List<BoardVO> getList(); 
	
}
