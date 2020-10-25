package eu.unicreditgroup.debugging.aop;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class ControllerTest {

    private final SomeServiceImpl someService;

    @GetMapping("/test/{name}")
    public String tryMe(@PathVariable String name) throws InterruptedException {
       return someService.importantMethod(name);
    }
}
