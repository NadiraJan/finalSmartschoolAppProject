package nadira.com.finalSmartschoolAppProject.configSecurity;

import nadira.com.finalSmartschoolAppProject.services.interfaces.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    @Lazy
    private StudentService userService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests().antMatchers(




                        "/register**",
                        "/h2-console/**",
                        "/js/**",
                        "/css/**",
                        "/images/**",
                        "/login/**",
                        "/students/**",
                        "/results/**",
                        "/parents/**",
                        "/contact/**",
                        "/timetable/**",
                        "/getParentPage",
                        "/getStudentPage",
                        "/getClassTeacherPage").permitAll()

                .antMatchers("/")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .invalidateHttpSession(true)

                .invalidateHttpSession(true)
                .clearAuthentication(true)

                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout")
                .permitAll();

        http.csrf().disable();
        http.headers().frameOptions().disable();


  }

    PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl tokenRepositoryImpl = new JdbcTokenRepositoryImpl();
        tokenRepositoryImpl.setDataSource(dataSource);
        return tokenRepositoryImpl;
    }    }




     /*auth.inMemoryAuthentication()
                .withUser("student")
                .password("pass")
                .roles("USER")
                .and()
                .withUser("parent")
                .password("pass")
                .roles("USER")
                .and()
                .withUser("classTeacher")
                .password("pass")
                .roles("ADMIN");



    }
    @Override
    protected void configure(HttpSecurity http) throws Exception{

        http.authorizeRequests()
        .antMatchers("/classTeacher").hasRole("ADMIN")
        .antMatchers("/students").hasRole("ADMIN")
        .antMatchers("/results").hasRole("ADMIN")
        .antMatchers("/parents").hasRole("ADMIN")
        .antMatchers("/user").hasAnyRole("USER","ADMIN")
        .antMatchers("/").permitAll()
        .and().formLogin();


        }

    @Bean
    public PasswordEncoder encoder(){
        return NoOpPasswordEncoder.getInstance();
    }


}*/

