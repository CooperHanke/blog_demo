package guru.cooperhanke.blog_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class BlogDemoApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(BlogDemoApplication.class, args);
    }

    protected SpringApplicationBuilder configure(SpringApplicationBuilder app) {
        return app.sources(BlogDemoApplication.class);
    }

    @Configuration
    public class DefaultView extends WebMvcConfigurerAdapter {

        @Override
        public void addViewControllers( ViewControllerRegistry registry ) {
            registry.addViewController( "/" ).setViewName( "forward:/posts" );
            registry.setOrder( Ordered.HIGHEST_PRECEDENCE );
            super.addViewControllers( registry );
        }
    }
}
