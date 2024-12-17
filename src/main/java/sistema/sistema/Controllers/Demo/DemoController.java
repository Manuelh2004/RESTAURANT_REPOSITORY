package sistema.sistema.Controllers.Demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class DemoController {
    
    @PostMapping(value="demo")
    public String welcome(){
        return "Welcome from secure endpoint";
    }
    @GetMapping(value="de")
    public String welcomee(){
        return "Welcome from secure endpoint";
    }
}
