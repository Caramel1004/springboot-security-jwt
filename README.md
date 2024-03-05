### Spring Security란?


### Spring Security 특징
1. 기본적으로 모든 리소스를 보호합니다.
2. 폼 기반 인증이 기본적으로 사용 설정되는 인증 방식입니다.
3. 로그인하면 세션 ID가 생성되고 세션ID는 쿠키에 저장됩니다.

### Spring Security 폼 기반 인증의 아이디 패스워드 설정
- application.properties 파일로 이동합니다.
- 아래와 같이 원하는 name과 password를 환경설정 합니다.
```
spring.security.user.name=admin
spring.security.user.password=auth
```
