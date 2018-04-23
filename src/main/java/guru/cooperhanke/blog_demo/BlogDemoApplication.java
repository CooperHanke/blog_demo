package guru.cooperhanke.blog_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class BlogDemoApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(BlogDemoApplication.class, args);
    }

    protected SpringApplicationBuilder configure(SpringApplicationBuilder app) {
        return app.sources(BlogDemoApplication.class);
    }
}
