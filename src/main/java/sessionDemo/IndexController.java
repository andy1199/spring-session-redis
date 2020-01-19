package sessionDemo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author andy
 * @description
 * @date 2020/01/17
 */

@Controller
@RequestMapping(value = "index")
public class IndexController
{
    private final Gson gson = new GsonBuilder().setDateFormat("yyyyMMddHHmmss").create();

    @RequestMapping(value = "login")
    public String login(HttpServletRequest request, String username){

        request.getSession().setAttribute("user", gson.toJson(new User(username,"123456")));

        return "login";
    }

    @RequestMapping(value = "index")
    public String index(HttpServletRequest request, Model model){

        User user = gson.fromJson(request.getSession().getAttribute("user").toString(), User.class);

        model.addAttribute("user", user);

        return "index";
    }

}