package board.mapper;

import java.util.HashMap; 

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import board.BoardDTO;

@Mapper
public interface BoardMapper {

	public List<BoardDTO> selectBoardList(HashMap<String, Object> mapParam) throws Exception; // 게시판 조회
	public int getMaxBoardSeq() throws Exception; // 가장 큰 BOARD_SEQ를 가져오는 SELECT 쿼리
	public int insertBoard(HashMap<String, Object> mapParam) throws Exception; // 게시판 등록
	public int updateBoard(HashMap<String, Object> mapParam) throws Exception; // 게시판 수정
	public int deleteBoard(HashMap<String, Object> mapParam) throws Exception; // 게시판 삭제

}
