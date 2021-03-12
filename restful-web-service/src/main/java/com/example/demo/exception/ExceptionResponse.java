package com.example.demo.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // getter, setter 메소드
@AllArgsConstructor // 모든 필드를 가지고 있는 생성자
@NoArgsConstructor //default , 매개변수가 없는 생성자
public class ExceptionResponse {
	private Date timestamp;
	private String message;
	private String details;
	
}
