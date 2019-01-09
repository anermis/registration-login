package controller;

import dao.DaUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Nah
 */
@Controller
@RequestMapping(value = "LoginController")
public class LoginController {

    @Autowired
    private DaUser userDa;

    @RequestMapping(value = "/formMethod.htm", method = RequestMethod.GET)
    public String formMethod1() {
        return "loginForm";
    }

    @RequestMapping(value = "/verificationMethod.htm", method = RequestMethod.GET)
    public String verificationMethod(@RequestParam("usernameInput") String username, @RequestParam("passwordInput") String password, ModelMap model) {
        boolean successfulLogin = false;
        
        successfulLogin = userDa.login(username, password);        
        if (successfulLogin) {
            return "successPage";
        } else {
            return "errorPage";
        }

    }

}
