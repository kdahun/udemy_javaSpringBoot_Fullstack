package com.example.demo.helloworld;

import java.util.Arrays;

import org.springframework.boot.autoconfigure.web.reactive.HttpHandlerAutoConfiguration.AnnotationConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.game.GameRunner;
import com.example.demo.game.MarioGame;
import com.example.demo.game.PacMan;
import com.example.demo.game.SuperContraGame;
import com.example.demo.helloworld.HelloWorldConfiguration.Address;

public class App02HelloWorldSpring {

	public static void main(String[] args) {
		// 1: Spring Context 실행
		
				// JVM 내에 Spring 컨텍스트를 만들려 하며 AnnotationConfigApplicationContext를 만드는 데 설정 클래스를 사용한다.
				// 생성한 설정 파일을 사용하여 새 인스턴스를 생성
				// 변수 컨텍스트는 새 AnnotationConfigApplicationContext와 비슷하고 HelloWorldConfiguration을
				// 설정 파일을 사용해 Spring 컨텍스트를 실행할 수 있게 되었다.
		// 여기에서 만들려 하는 건 Spring 컨텍스트이다.
		
		try(var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)){
			// 2: Spring이 관리하도록 할 것을 설정 
			// HelloWorldConfiguration - @Configuration
			// name 함수 - @Bean
			
			// 3: Spring이 관리하는 Bean을 검색
			// 컨텍스트가 getBean이고 컨텍스트에서 값을 가져올 수 있는 다양한 방법이 있다.
			// 1) 이름을 사용한다.
			System.out.println(context.getBean("name"));
			
			System.out.println(context.getBean("age"));
			
			System.out.println(context.getBean("person"));
			
			System.out.println(context.getBean("person2MethodCall"));
			
			System.out.println(context.getBean("person3Parameters"));
			
			System.out.println(context.getBean("address2"));
			
			System.out.println(context.getBean("person5Qualifier"));
			
			// 2) 클래스 사용
			//System.out.println(context.getBean(Address.class));
			 // 컨텍스트를 사용해 객체 가져오기
			
			// .forEach를 사용해 이 스트림에 있는 모든 요소에 대해 print
//			Arrays.stream(context.getBeanDefinitionNames())
//			.forEach(System.out::println);// 메서드 참조
//			
		}				
	}

}
