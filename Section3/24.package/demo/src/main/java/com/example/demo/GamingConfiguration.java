package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.game.GameRunner;
import com.example.demo.game.GamingConsole;
import com.example.demo.game.PacMan;

@Configuration
public class GamingConfiguration {

	@Bean
	public GamingConsole game() {
		var game = new PacMan();
		return game;
	}
	
	@Bean
	public GameRunner gameRunner(GamingConsole game) {
		var gameRunner = new GameRunner(game);
		return gameRunner;
	}
	
}
/*
 Spring의 의존성 주입 기능을 사용하여
 GamingConsole 인터페이스의 구현체인 PacMan 객체와 이를 사용하는 GameRunner 객체를
 Spring 컨테이너에 빈으로 등록하고, GameRunner 객체가 PacMan 객체를 의존성으로 주입받아
 사용할 수 있도록 설정한 것이다. 이렇게 함으로써 애플리케이션 컴포넌트 간의
 결합도를 낮추고, 더 유연하고 테스트 가능한 구조를 가지게 된다.
 
GameRunner gameRunner(GamingConsole game) 메소드에서
game 파라미터는 GamingConsole 타입의 빈을 자동으로 주입받는다.
이는 앞서 정의된 game() 메소드에서 반환된 PacMan 객체가 주입된다.
  
 */
 