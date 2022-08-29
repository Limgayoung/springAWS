package com.springAWS.config.auth;

import com.springAWS.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity //spring security 설정 활성화시켜줌
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .headers().frameOptions().disable() //h2-console 화면 사용 위해 옵션들 disable해줌
                .and()
                    .authorizeRequests()//url 별 권한 관리를 설정하는 옵션의 시작점, 선언되어야 antMatchers 옵션 사용 가능
                    .antMatchers("/", "/css/**", "/images/**",
                        "/js/**", "/h2-console/**").permitAll()
                    .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                //antMatchers : 권한 관리 대상 지정하는 옵션
                //URL, HTTP 메소드별로 관리 가능함
                //permitALL : 전체 열람 권한 줌
                //hasRole(Role.USER.name()) : USER 권한 가진 사람만 가능하게 함
                    .anyRequest().authenticated() //설정된 값 이외 나머지 URL
                .and()
                    .logout().logoutSuccessUrl("/")//로그아웃 기능 대한 여러 설정의 진입점, 성공시 / 주소로 이동
                .and()
                    .oauth2Login() //로그인 기능에 대한 여러 설정 진입점
                        .userInfoEndpoint(). //로그인 성공 이후 사용자 정보 가져올 때 설정 담당
                            userService(customOAuth2UserService); //소셜 로그인 성공 시 후속 조치 진행할 UserService 인터페이스 구현체 등록

    }
}
