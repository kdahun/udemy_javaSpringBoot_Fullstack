# Spring 프로젝트를 만들고 IDE로 가져오는 과정

Spring 프로젝트를 만드는 가장 좋은 방법은 start.spring.io를 이용하는 것이다.
https://start.spring.io/ -> spring initializr라는 사이트(프로젝트 이름 정하고 사용할 프레임워크 선택하면 프로젝트 생성

시작하기 위해 구축 툴로 Maven을 사용
- Maven 프로젝트 선택
- 언어는 java
- 스프링 부트는 RC1이 있는 걸로(릴리스 버전이 같은걸로 3.0.0과 3.3.0이랑 릴리스 버전은 같다/SNAPSHOT 버전은 사용하지 말아야 된다 -> SNAPSHOT 버전은 현재 Spring Boot Team이 개발하고 있으며 새로운 것을 배울때 사용할 버전이 아니다.)
-> 이 버전에는 SHAPSHOT, RC1 이나 M1, M2, M3가 없다
- 프로젝트를 만들 때는 그룹 ID와 아티팩트 ID를 부여해야 한다.(그룹 ID와 아티팩트 ID는 패키지 이름 및 클래스 이름과 매우 유사)

![image](https://github.com/kdahun/udemy_javaSpringBoot_Fullstack/assets/101082485/e6c33da4-f017-43e9-bea4-3153553a09c6)

spring 프로젝트를 만들 준비 완료

- 생성을 하면 zip 파일이 다운로드 폴더로 다운로드 된다.

## file > Import > Maven 입력 > Existing Maven Projects
![image](https://github.com/kdahun/udemy_javaSpringBoot_Fullstack/assets/101082485/69f9dae8-4d9c-407d-af4b-7224534c0e0e)

다음으로 프로젝트의 루트 디렉터리를 선택해야한다.

# 프로젝트 목록창이 안보일때
![image](https://github.com/kdahun/udemy_javaSpringBoot_Fullstack/assets/101082485/d5258ebc-1a2f-445c-aa40-45e1dbace11c)

## src/main/java에는 모든 소스 파일 보관
## scr/main/resources에는 모든 설정 파일 보관
## src/text/java에는 테스트 코드를 작성
