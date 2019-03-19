package aspect;

import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.springframework.core.env.Environment;

import javax.annotation.Resource;

//@Component
//@Plugin(name = "StubAppender", category = "Core",
//        elementType = Appender.ELEMENT_TYPE, printObject = true)
public final class StubAppender extends AbstractAppender {

    String name = "name";

    StubAppender(){
        super("wucan",null,null,true);
    };

    @Resource
    private Environment environment;


    private StubAppender(String name, Filter filter, Layout layout,
                         boolean ignoreExceptions) {
        super(name, filter, layout, ignoreExceptions);
    }

    @PluginFactory
    public static StubAppender createAppender(@PluginAttribute("name") String name,
                                              @PluginAttribute("ignoreExceptions") boolean ignoreExceptions,
                                              @PluginElement("Layout") Layout layout,
                                              @PluginElement("Filters") Filter filter) {
        StubAppender stubAppender = new StubAppender();
        String activeProfile = stubAppender.getEnvironment().getActiveProfiles()[0];
        if (name.equals(activeProfile)) {
            System.out.println("--------activeProfile--------");
            System.out.println("--------activeProfile--------");
            System.out.println("--------activeProfile--------");
            System.out.println("--------activeProfile--------");
            System.out.println("--------activeProfile--------");
            System.out.println("--------activeProfile--------");
            return new StubAppender(name,  filter, layout,ignoreExceptions);
        }
        return null;
    }

    @Override
    public void append(LogEvent logEvent) {
        System.out.println(logEvent);
    }


    public Environment getEnvironment() {
        return environment;
    }
}