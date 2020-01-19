package sessionDemo;

import org.springframework.stereotype.Controller;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author andy
 * @description
 * @date 2019/12/02 19:18
 */
@Controller
public class RedisController
{
    @Resource
    private RedisTemplate redisTemplate;

    @RequestMapping("/testSet")
    public String test()
    {
        //redisTemplate.boundValueOps("first").set("hello world");

        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set("first","hello world");
        return "OK";
    }

    @RequestMapping("/testGet")
    public String testGet()
    {
        //String result= String.valueOf(redisTemplate.boundValueOps("first").get());

        ValueOperations valueOperations = redisTemplate.opsForValue();
        return (String) valueOperations.get("first");
    }

    @RequestMapping("/testFolderSet")
    public String testFolder()
    {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set("Folder:first","hello world");

        redisTemplate.boundValueOps("Folder2:first").set("hello world");

        //redisTemplate.boundHashOps("namehash").put("country1","中国");
        return "OK";
    }

    @RequestMapping("/testDelete")
    public String testDelete()
    {
        //ValueOperations valueOperations = redisTemplate.opsForValue();
        //valueOperations.set("Folder.first","hello world");

        redisTemplate.delete("first");
        return "test";
    }

    @RequestMapping(value = "/session")
    public String session(HttpSession session, String value)
    {
        session.setAttribute("test", value);
        return "session";
    }

    @RequestMapping(value = "/getSession")
    public String getSession(HttpSession session)
    {
        return (String) session.getAttribute("test");
    }

    @RequestMapping(value = "/removeSession")
    public String removeSession(HttpSession session)
    {
        session.removeAttribute("test");
        return "ok";
    }

    @RequestMapping(value = "/string")
    public String string(HttpSession session)
    {
        String test = "abcdefg\r\ncdefg";
        return test;
    }
}
