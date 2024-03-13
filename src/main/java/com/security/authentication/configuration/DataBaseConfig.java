package com.security.authentication.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

import javax.sql.DataSource;


@Configuration
public class DataBaseConfig {
    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION)
                .build();
    }

    /**
     * UserDetailsManager extends UserDetailsService
     * UserDetailsManager는 UserDetailsService interface를 상속받은 interface 입니다.
     * */
    @Bean
    UserDetailsManager users(DataSource dataSource) {
        SpringSecurityConfig securityConfig = new SpringSecurityConfig();
        UserDetails user = User
                .withUsername("user")
                .password("test")
                .passwordEncoder(str -> securityConfig.passwordEncoder().encode(str))
                .roles("USER")
                .build();
        UserDetails admin = User
                .withUsername("admin")
                .password("test")
                .passwordEncoder(str -> securityConfig.passwordEncoder().encode(str))
                .roles("USER", "ADMIN")
                .build();
        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
        users.createUser(user);
        users.createUser(admin);
        return users;
    }
}
