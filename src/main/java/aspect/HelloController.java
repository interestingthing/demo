package aspect;

import io.swagger.annotations.*;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;

//@RestController
//@Api("HelloController|接口文档！")
public class HelloController {


    @Resource
    Environment environment;

    @Resource
    A a;


    @GetMapping("/index/{id}")
    @ApiOperation(value = "根据用户编号获取用户姓名", notes = "test: 仅1和2有正确返回")
    @ApiImplicitParam(paramType = "path", name = "id", value = "用户编号", required = true, dataType = "Integer")
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input", response = Integer.class),
            @ApiResponse(code = 201, message = "Error input", response = Integer.class)
    })
    public String hello(@PathVariable Integer id) {


        System.out.println(a);
        System.out.println("--------------------------------");
        System.out.println("--------------------------------");
        System.out.println(Arrays.toString(environment.getActiveProfiles()));
        System.out.println("spring.profiles.active" + environment.getProperty("spring.profiles.active"));
        System.out.println("server.port" + environment.getProperty("server.port"));
        return "Hello Profile" + id;
    }
}
