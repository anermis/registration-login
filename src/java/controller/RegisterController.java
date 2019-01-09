package controller;

import dao.DaUser;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Nah
 */
@Controller
@RequestMapping(value = "RegisterController")
public class RegisterController {

    @Autowired
    private DaUser userDa;

    @RequestMapping(value = "/formMethod.htm", method = RequestMethod.GET)                    //addUserToForm
    public String formMethod(ModelMap model) {
        model.addAttribute("user", new User());
        return "registerForm";
    }

    @RequestMapping(value = "/insertUserMethod.htm", method = RequestMethod.POST)
    public String insertUserMethod(ModelMap model, User user) {
        if (user.getUserPassword1().equals(user.getUserPassword2()) && userDa.insert(user)) {
            model.addAttribute("user", user);
            return "successPage";
        } else {
            return "errorPage";
        }
    }

}
