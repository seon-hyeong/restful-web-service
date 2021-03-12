package com.example.demo.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// 예외 처리 
// HTTP Status Code 
// 2XX -> OK
// 4XX -> Client
// 5XX -> Server 
// 1xx : 전송 프로토콜 수준의 정보 교환
// 2xx : 클라어인트 요청이 성공적으로 수행됨
// 3xx : 클라이언트는 요청을 완료하기 위해 추가적인 행동을 취해야 함
// 4xx : 클라이언트의 잘못된 요청
// 5xx : 서버쪽 오류로 인한 상태코드
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
	public UserNotFoundException(String message) {
		super(message);
	}
}
