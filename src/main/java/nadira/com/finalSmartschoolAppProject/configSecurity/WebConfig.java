package nadira.com.finalSmartschoolAppProject.configSecurity;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.Charset;
import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry)
    {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/login/postLogin").setViewName("parent_home");
        registry.addViewController("/login/postLogin").setViewName("student_home");
        //registry.addViewController("/home").setViewName("userhome");
        registry.addViewController("/getParentPage").setViewName("parent_home");
        registry.addViewController("/getStudentPage").setViewName("student_home");
        registry.addViewController("/classTeacher/students").setViewName("students");
        registry.addViewController("/classTeacher/results").setViewName("results");
        registry.addViewController("/classTeacher/parents").setViewName("parents");
        //registry.addViewController("/403").setViewName("403");
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
        converters.add(stringHttpMessageConverter);
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(false);
    }

}

