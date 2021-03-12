package com.example.demo.helloworld;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //getter, setter , toString , 생성자 자동 생성 
@AllArgsConstructor // 생성자 자동 생성
@NoArgsConstructor

public class HelloWorldBean {
	private String message;

}
