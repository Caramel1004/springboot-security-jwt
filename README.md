# springboot-security-jwt
Springboot-Security로 jwt 인증 인가 적용 해보기

### gradle setting
```
dependencies {

	implementation 'org.springframework.boot:spring-boot-starter-web'
	compileOnly 'org.projectlombok:lombok'
	developmentOnly 'org.springframework.boot:spring-boot-devtools'
	annotationProcessor 'org.projectlombok:lombok'

	// junit
	testImplementation 'org.testcontainers:junit-jupiter'

	// jwt
	implementation 'io.jsonwebtoken:jjwt-api:0.12.3'
	runtimeOnly 'io.jsonwebtoken:jjwt-impl:0.12.3'
	runtimeOnly 'io.jsonwebtoken:jjwt-jackson:0.12.3'

	// swagger
	implementation 'org.springdoc:springdoc-openapi-starter-webmvc-ui:2.2.0'
}
```
