package com.example.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.game.GameRunner;
import com.example.demo.game.MarioGame;
import com.example.demo.game.PacMan;
import com.example.demo.game.SuperContraGame;
import com.example.demo.game.GamingConsole;

public class App03GamingSpringBeans {

	public static void main(String[] args) {
	
		try(var context = new AnnotationConfigApplicationContext(GamingConfiguration.class)){
			context.getBean(GamingConsole.class).up();
			context.getBean(GameRunner.class).run();
		}
		
		
	}

}


// 1. 설정 파일 GamingConfiguration을 만듬 - configuration
// 2. GamingConfiguration에서 GamingConfiguration에서 GamingConsole game()정의 - Bean
// (활용하고 있는 게임은 PacmanGame)
// 3. AnnotationConfigApplicationContext를 사용하는 Spring 컨텍스트로 실행
// 리소스 누출 컨텍스트가 닫히지 않았다고 주의가 생김
// => try(var context = new AnnotationConfigApplicationContext(GamingConfiguration.class)){
//		context.getBean(GamingConsole.class).up();
// 		}