package aspect;


import org.springframework.stereotype.Component;

import javax.annotation.Resource;


//@TestConfiguration
//@Component
public class A implements AA{
    public A() {
        System.out.println(this);
    }

    @Resource
    BB b;
    //@Resource()


//    public Integer print() {
//        System.out.println("I'm AAAAAA"+b.getClass());
//        return 1;
//    }
}
