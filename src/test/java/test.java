import com.dgut.domain.User;
import com.dgut.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mvc.xml","classpath:application-context.xml"})
public class test {
    @Autowired
    UserService userService;
    @Test
    public void test(){
        //ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:application-context.xml");
        //UserService userService = (UserService) applicationContext.getBean("userService");
        User user = userService.showUserByUsername("aaa");
        userService.orderMask(user);
//        System.out.println(user);
    }
    @Test
    public void compareTime() throws ParseException {
        String time1 = "2020-6-30";
        String time2 = "2020-6-16";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd", Locale.CHINA);
        Date date1 = sdf.parse(time1);
        Date date2 = sdf.parse(time2);
        Date nowdate = new Date();
        System.out.println(date1);
        System.out.println(nowdate);
        System.out.println(date1.before(nowdate));
    }
}
