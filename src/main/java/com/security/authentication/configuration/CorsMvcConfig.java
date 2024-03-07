package com.security.authentication.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsMvcConfig implements WebMvcConfigurer {

    /*
    * 컨트롤러단에서의 cors 문제도 설정 해야합니다.
    * FrontEnd에서 온 요청을 허용하려면 Cors 허용을 해줘야 합니다.
    * BackEnd로 직접 보내는 요청은 같은 도메인과 포트이므로 따로 설정이 필요없습니다.
    * */
    @Override
    public void addCorsMappings(CorsRegistry corsRegistry) {
        corsRegistry.addMapping("/**")
                .allowedOrigins("http://localhost:3000");
    }
}
