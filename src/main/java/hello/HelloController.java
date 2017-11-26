package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
public class HelloController {

    String name;

    @Autowired
    Config config;

    @Autowired
    public HelloController(MyClass myClass){
        name  = myClass.getName();
    }
    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot! by " + name +"\n" + config.getServers()
                .stream().collect(Collectors.joining(",")) ;
    }
}
