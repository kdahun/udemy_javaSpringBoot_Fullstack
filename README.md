- [Section 3]
  - [27.  Primary와 Qualifier - 어떤 Spring 어노테이션을 사용할까요?](#27primary와-qualifier---어떤-spring-어노테이션을-사용할까요)
  - [28. Spring Framework 알아보기 - 의존성 주입의 다양한 유형](#28-spring-framework-알아보기---의존성-주입의-다양한-유형)
  - [29. Java Spring Framework - 중요한 용어 이해하기]()


# 27.Primary와 Qualifier - 어떤 Spring 어노테이션을 사용할까요?
```
@Component @Primary
class QuickSort implement SortingAlgorithm{}

@Component
class BubbleSort implement SortingAlgorithm{}

@Component @Qualifier("RadixSortQualifier")
class RadixSort implement SortingAlgorithm{}

@Component
class ComplexAlgorithm
  @Autowired
  private SortingAlgorithm algorithm;

@Component
class AnotherComplexAlgorithm
  @Autowired @Qualifier("RadixSortQualifier")
  private SortingAlgorithm iWantToUseRadixSortOnly;

```
### Primary는 여러 후보가 자격이 있는 경우, Bean에게 우선권을 주는 것을 말한다.
### Qualifier의 경우, 특정 Bean이 자동 와이어링되어야 한다. 

ComplexAlgorithm에서는 @Autowired만 사용하고 있다. 한정자는 전혀 적용되지 않았다.
(@Autowired만 사용한다면 가장 적합한 SortingAlgorithm을 달라고 요청하는 것이다.)

반면 AnotherComplexAlgorithm은 특정 SortingAlgorithm만을 사용하고 싶을 때 사용한다.

```
Autowired란?
필요한 의존 객체의 타입에 해당하는 빈을 찾아 주입한다
- 생성자
- Setter
- 필드
위의 3가지의 경우에 Autowired를 사용할 수 있다. 그리고 Autowired는 기본값이 true이기 때문에 의존성 주입을 할 대상을 찾지 못한다면 애플리케이션 구동에 실패한다.
```

# 28. Spring Framework 알아보기 - 의존성 주입의 다양한 유형
#### 의존성 주입의 유형
- 생성자 기반 주입(Constructor-based)
- 수정자 기반 주입(Setter-based)
- 필드 기반 주입(Field)

```
@Component // 각 클래스에 관한 Bean을 생성하기 위해 붙여줌
class YourBusinessClass{
	
}

@Component
class Dependency1{
	
}

@Component
class Dependency2{
	
}

@Configuration
@ComponentScan
public class DepInjectionLauncherApplication {
	public static void main(String[] args) {
	
		try(var context = 
				new AnnotationConfigApplicationContext
				(DepInjectionLauncherApplication.class)){
			Arrays.stream(context.getBeanDefinitionNames())
			.forEach(System.out::println);
			
		}
	}

}
```
![image](https://github.com/kdahun/udemy_javaSpringBoot_Fullstack/assets/101082485/80ad77be-58f2-4729-8e57-8ce0a20ae299)

Bean이 특정 클래스 집합에 대해 성성이 된 것을 확인할 수 있다.
Spring Context를 실행하고 있기 때문(Spring Context는 AnnotationApplicationContext 클래스의 인스턴스인 context 변수에 있다. 이 컨텍스트는 애플리케이션의 구성 클래스를 기반으로 빈(bean) 정의를 로드하고 관리한다.)

@Configuration은 Spring 프레임 워크에서 설정 클래스를 정의할 때 사용한다.(이 애미테이션은 해당 클래스가 하나 이상의 @Bean 메서드를 가지고 있으며, 이 메서드들이 Spring IoC 컨테이너에 의해 관리되는 빈을 정의한다는 것을 나타낸다)
1. bean 정의 : 하나 이상의 @bean 메서드를 정의할 수 있다. 이 메서드들은 빈을 생성하고 초기화하는 데 사용한다.
2. 구성 클래스 : 애플리케이션의 전역 설정을 포함할 수 있으며, 이는 XML 기반 설정 파일을 자바 클래스로 대체한다.
3. 컴포넌트 스캔 활성화 : @configuration 클래스는 종종 @componentScan과 함께 사용되어 지정된 패키지에서 컴포넌트를 자동으로 스캔하고 등록할 수 있다.
4. 프로필 관리 : 특정 환경 또는 프로필에 따라 다른 빈 정의를 제공할 수 있다.

@ComponentScan은 자동으로 현재 패키지를 스캔하는 역할
@CoponentScan("스캔하고 싶은 패키지") 생략하면 현재 패키지

@Component를 적용시키면 Spring은 자동으로 우리에게 Bean을 생성해준다.

```
@Component // 각 클래스에 관한 Bean을 생성하기 위해 붙여줌
class YourBusinessClass{
	
	//자동 와이어링을 하려면 Spring 프레임워크에게 요청해야한다.
	@Autowired
	Dependency1 dependency1;
	
	@Autowired
	Dependency2 dependency2;
	
	public String toString() {
		return "Using "+dependency1+" and "+dependency2;
	}
}

@Component
class Dependency1{
	
}

@Component
class Dependency2{
	
}

@Configuration
@ComponentScan
public class DepInjectionLauncherApplication {
	public static void main(String[] args) {
	
		try(var context = 
				new AnnotationConfigApplicationContext
				(DepInjectionLauncherApplication.class)){
			Arrays.stream(context.getBeanDefinitionNames())
			.forEach(System.out::println);
			
			System.out.println(context.getBean(YourBusinessClass.class));
			
		}
	}
}
```

![image](https://github.com/kdahun/udemy_javaSpringBoot_Fullstack/assets/101082485/fc32ceed-97e1-4f0c-8a3d-9e50cc2e4c9d)

Dependency1과 Dependency2가 자동 와이어링 된 모습
지금 여기에서 사용하고 있는 것을 필드 주입으로 생성자(constructor)나 수정자(setter)가 없다.
의존성은 reflection을 사용하여 주입이 되었다?
필드에서 자동 와이어링을 하자마자 Spring이 자동으로 필드 주입을 했다.


지원되는 2개의 주입 유형(setter injection, getter injection)
```
@Component // 각 클래스에 관한 Bean을 생성하기 위해 붙여줌
class YourBusinessClass{
	
	Dependency1 dependency1;
	Dependency2 dependency2;
	
	//자동 와이어링을 하려면 Spring 프레임워크에게 요청해야한다.
	@Autowired
	public void setDependency1(Dependency1 dependency1) {
		System.out.println("Setter Injection - setDependency1 ");
		this.dependency1 = dependency1;
	}
	
	@Autowired
	public void setDependency2(Dependency2 dependency2) {
		System.out.println("Setter Injection - setDependency2 ");
		this.dependency2 = dependency2;
	}

	public String toString() {
		return "Using "+dependency1+" and "+dependency2;
	}
}

@Component
class Dependency1{
	
}

@Component
class Dependency2{
	
}

@Configuration
@ComponentScan
public class DepInjectionLauncherApplication {
	public static void main(String[] args) {
	
		try(var context = 
				new AnnotationConfigApplicationContext
				(DepInjectionLauncherApplication.class)){
			Arrays.stream(context.getBeanDefinitionNames())
			.forEach(System.out::println);
			
			System.out.println(context.getBean(YourBusinessClass.class));
			
		}
	}
}
```
![image](https://github.com/kdahun/udemy_javaSpringBoot_Fullstack/assets/101082485/3ad0f27e-cfa5-4576-943a-db239e3e59e5)

여기에서 setter 주입을 사용하고 있다는 사실을 알 수 있다

```
public YourBusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
		super();
		System.out.println("Constructor Injection - YourBusinessClass ");
		this.dependency1 = dependency1;
		this.dependency2 = dependency2;
	}
```
![image](https://github.com/kdahun/udemy_javaSpringBoot_Fullstack/assets/101082485/cceb0e35-7f09-41a8-a414-ec9852682501)

@Autowired를 생략해도 의존성이 적절하게 자동 와이어링 된것을 확인할 수 있다.

### Spring 팀은 생성자 기반 주입을 추천한다.
why? 모든 초기화가 하나의 메소드에서 발생하기 때문 초기화가 완료되면 Bean을 사용할 준비가 된 것이다.


# 29. Java Spring Framework - 중요한 용어 이해하기
- @Component를 클래스에 추가하는 경우, 클래스의 인스턴스는 Spring 프레임워크가 관리하게 된다. @Component를 추가할 때마다 특정 클래스가 ComponentScan에 있다면 해당 클래스의 인스턴스, 즉 Spring Bean이 생성되고 Spring 프레임워크에 의해 관리된다.

- Dependency(의존성) : 예를 들면 MarioGame은 GameRunner의 의존성이다.

- Component Scan : Spring은 컴포넌트의 위치를 파악해야 하는데, 이것이 검색 위치를 알려준다.

- Dependency Injection(의존성 주입) : 

애플리케이션을 실행하면 Spring 프레임워크는 무엇을 할까?
가장 먼저 컴포넌트 스캔을 수행한다. 
컴포넌트의 의존성이 무엇인지 식별하고 모두 와이어링하게 된다.
이 전체 프로세스를 의존성 주입이라고 한다.
Bean과 의존성을 식별하고 모두 와이어링 하는 작업을 가리킨다.
(IOC, 즉 제어 반전 






