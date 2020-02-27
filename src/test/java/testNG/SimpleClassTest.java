package testNG;


import com.zc.testNG.SimpleClass;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Description:
 *
 * @author Corey Zhang
 * @create 2020-02-11 16:19
 */
public class SimpleClassTest {

    private SimpleClass simpleClass;

    @Test(groups= {"PlanA"})
    public void fastTest(){
        SimpleClass simpleClass = new SimpleClass();
        simpleClass.setName("abc");
        Assert.assertEquals("abc",simpleClass.getName());
    }

    @Test(groups= {"PlanB"})
    public void fastTestB(){
        String str = "abc";
        Assert.assertEquals("abc",str);
    }
}
