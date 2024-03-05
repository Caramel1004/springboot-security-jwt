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

### application.properties
```
# JWT
jwt.secret-key=l4(&:+*kc&uf$<0q5(9(n]cNricB'Yx(1l;YEsKE83l]lCOJrsg,YT\LL4yH7G1K
jwt.prefix=Bearer
jwt.header=Authorization
```

### SecurityConfig
```
package com.szs.task.domain.configration;

import com.szs.task.domain.exception.UnAuthorizationException;
import com.szs.task.domain.service.UserService;
import io.netty.handler.codec.http.HttpMethod;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final AuthUserDetailService authUserDetailService;

    private AuthenticationManager authenticationManager;

    @Value("${jwt.secretKey}")
    private final String secretKey;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        // 폼 로그인 비활성화
        httpSecurity.formLogin(AbstractHttpConfigurer::disable);

        // HTTP 기본 비활성화
        httpSecurity.httpBasic(AbstractHttpConfigurer::disable);

        // csrf 공격 방어 기능 비활성화
        httpSecurity.csrf(AbstractHttpConfigurer::disable);

        // 세션 비활성화 => JWT로 인증
        httpSecurity.sessionManagement(management ->
                management.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        // 인가 설정: 인증이 필요한 요청 등록 authenticated, 인증이 필요없는 요청 등록 permitAll
        httpSecurity.authorizeHttpRequests(req -> req
                .requestMatchers("/**").permitAll()
                .anyRequest().authenticated()
        );

        /*
        * 인증 방식 설정
        *   - 인메모리 방식
        *   - JDBC 방식
        *   - 커스텀 방식
        * 적용: 커스텀 방식
        * */
        httpSecurity.userDetailsService(authUserDetailService);


        /*
         * 필터 설정
         * 1. JWT Request Filter
         *   - JWT 해석
         * 2. JWT Filter(Login)
         *   - @param userId, password
         *   - 토큰 생성
         * */
        httpSecurity.addFilterAt(new JwtAuthenticationFilter(authenticationManager), null)
                .addFilterBefore(null, null);


        return httpSecurity.build();
    }
}

```
