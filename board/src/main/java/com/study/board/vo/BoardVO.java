package com.study.board.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class BoardVO {
//10	
		private int boardId;
		private String title;
		private String text;
		private Date boardDate;
		private int hit;
		private String memberId;
}
