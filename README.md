### 사용된 기술 스택
>- 개발 언어: java 17
>- 프레임워크: springboot 3.2.3
>- DB: H2
>- 유틸: JPA
>- 단위 테스트: junit5
>- 빌드 환경: gradle
>- 작업 툴: intellij

<br>

### Reference docs
> Spring Security 공식 참고 문서 <br>
>[https://docs.spring.io/spring-security/reference/index.html](https://docs.spring.io/spring-security/reference/index.html)<br><br>
> Spring Security 적용 코드 <br>
>[https://docs.spring.io/spring-security/reference/servlet/authentication/index.html](https://docs.spring.io/spring-security/reference/servlet/authentication/index.html)

<br>

### Spring Security란?
[영어]
#### *Spring Security is a powerful and highly customizable authentication and access-control framework.*
- It is the de-facto standard for securing Spring-based applications.
- Spring Security is a framework that focuses on providing both authentication and authorization to Java applications. 
- Like all Spring projects, the real power of Spring Security is found in how easily it can be extended to meet custom requirements.
<br>

[한국어]
#### *Spring Security는 강력하고 사용자 정의가 가능한 인증 및 액세스 제어 프레임워크입니다.* <br>
- Spring 기반 애플리케이션 보안을 위한 사실상의 표준입니다.<br>
- Spring Security는 Java 애플리케이션에 인증과 권한 부여를 모두 제공하는 데 중점을 둔 프레임워크입니다. <br>
- 모든 Spring 프로젝트와 마찬가지로 Spring Security의 진정한 힘은 사용자 정의 요구 사항을 충족하기 위해 얼마나 쉽게 확장할 수 있는지에 있습니다.

> 출처: Spring Security 공식 문서 <br>
>[https://spring.io/projects/spring-security#overview](https://spring.io/projects/spring-security#overview)
<br>

### Spring Security 특징
1. 기본적으로 모든 리소스를 보호합니다.
2. 폼 기반 인증이 기본적으로 사용 설정되는 인증 방식입니다.
3. 로그인하면 세션 ID가 생성되고 세션ID는 쿠키에 저장됩니다.

### Spring Security 폼 기반 인증의 아이디 패스워드 설정
- 매번 서버가 실행될때 마다 동적인 패스워드를 제공합니다.
  <br>편의를 위해 정적인 패스워드를 제공하려면 환경 설정이 필요합니다.
- application.properties 파일로 이동합니다.
- 아래와 같이 원하는 name과 password를 환경설정 합니다.
```
spring.security.user.name=admin
spring.security.user.password=auth
```
