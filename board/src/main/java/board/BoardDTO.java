package board;

import lombok.Data;

@Data
public class BoardDTO {

	private int boardSeq; // 게시판 순번          
	private String title; // 제목     
	private String content; // 내용      
	private String userNm; // 작성자	 	      
	private String regDt; // 등록일                
	
}
