package guru.springframework.config;

import guru.springframework.beans.FakeDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
//@PropertySource("classpath:datasource.properties")
public class PropertyConfig {

    @Autowired
    Environment environment;

    @Value("${rev1.username}")
    String user;

    @Value("${rev1.password}")
    String password;

    @Value("${rev1.url}")
    String  url;

    @Bean
    //@DependsOn(value = { "PropertySourcesPlaceholderConfigurer"})
    public FakeDataSource fakeDataSource(){
        FakeDataSource fds = new FakeDataSource();
        fds.setUrl(environment.getProperty("PATH"));
        fds.setPassword(password);
        fds.setUser(user);
        return fds;
    }

//    @Bean("PropertySourcesPlaceholderConfigurer")
//    public static PropertySourcesPlaceholderConfigurer properties(){
//        return new PropertySourcesPlaceholderConfigurer();
//    }
}
