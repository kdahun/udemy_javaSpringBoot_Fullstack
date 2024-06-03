package com.example.demo.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class HelloWorldConfiguration {
	// Spring Configuration 클래스이다.
	// 여기에서 Spring Bean을 정의할 수 있다.(Spring Bean은 Spring에서 관리하는 것들이다.)
	// Configuration 클래스에서 메서드를 정의하여 Spring Bean을 생성할 수 있다.
	
	// record를 사용하면 게터 세터 생성자 등을 만들 필요가 없다. 모두 자동으로 생성되기 때문
	record Person(String name, int age,Address address) {
		
	}
	
	record Address(String firstLine, String city) {
		
	}
	
	
	
	// 이 메서드가 이 Spring 컨테이너가 관리하는 Bean을 생산함을 나타내는 JAVA 문서임을 확인할 수 있다.
	@Bean // Bean을 호출하는 추가 과정이 필요하다.
	public String name() {
		return "Ranga";
	}
	@Bean
	public int age() {
		return 15;
	}
	
	//
	@Bean
	public Person person() {
		var person = new Person("dahun",24,new Address("Main Street","Utrecht"));
		// 게터 세터 생성자 메서드 사용가능
		
		return person;
	}
	
	// 메서드 호출을 통해 관계를 맺어주는 방식
	@Bean
	public Person person2MethodCall() {
		return new Person(name(),age(),address());
	}
	
	// 매개 변수를 통해 관계를 맺어주는 방식
	@Bean
	public Person person3Parameters(String name, int age, Address address2) {
		//name,age,address2
		return new Person(name,age,address2);
	}
	
	//이러한 에러 발생(이름이 address가 없기 때문에 발생)
	//No qualifying bean of type 'com.example.demo.HelloWorldConfiguration
	//Address' available: expected single matching bean but found 2: address2,address3
	@Bean
	public Person person4Parameters(String name, int age, Address address) {
		//name,age,address2
		return new Person(name,age,address);
	}
	
	@Bean
	public Person person5Qualifier(String name, int age, @Qualifier("address3qualifier") Address address) {
		//name,age,address2
		return new Person(name,age,address);
	}
	
	// 기본 메서드 이름을 사용하는 대신 직접 사용자 지정 이름을 설정할 수 있다.
	@Bean(name = "address2")
	@Primary // 이것은 기본으로 해주는 기능 => address 문제 해결이 된다.
	public Address address() {
		var address = new Address("???","seoul");
		// 게터 세터 생성자 메서드 사용가능
		
		return address;
	}
	
	// 기본 메서드 이름을 사용하는 대신 직접 사용자 지정 이름을 설정할 수 있다.
	@Bean(name = "address3")
	@Qualifier("address3qualifier")
	public Address address3() {
		var address = new Address("???x","xxseoul");
		// 게터 세터 생성자 메서드 사용가능
		
		return address;
	}
	
}
