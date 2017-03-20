package my.crm.controller;

import my.crm.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by 2540p on 21.02.2017.
 */
@Controller
public class SpringController extends HttpServlet {

    //TODO: singleton:
    private Action action = new Action();


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginPage() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String getLoginPostPage(@RequestParam("login") String login, @RequestParam("password") String password, HttpServletRequest req, Model model) {
        HttpSession session = req.getSession(true);
        if (action.login(login, password)) {
            session.setAttribute("loggedIn", true);
            return "login";
        } else {
            session.setAttribute("loggedIn", false);
            model.addAttribute("error", "Incorrect Username or Password");
            return "login";
        }
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String getRegistrationPage(){return "registration";}

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String getRegistrationPostPage(@RequestParam("login") String login, @RequestParam("password") String password, @RequestParam("email") String email, Model model) {
        String registration = action.register(login, password, email);
        if (registration.equals("Your registration has been successful!")) {
            model.addAttribute("registration", registration);
            return "login";
        }else {
            model.addAttribute("registration", registration);
            return "registration";
        }
    }

    @RequestMapping("/companies")
    public String getCompaniesPage(Model model) {
        List<Companies> companies = action.companies();
        model.addAttribute("companies", companies);
        return "companies";
    }

    @RequestMapping("/dealings")
    public String getDealingsPage(Model model) {
        List<Dealings> dealings = action.dealings();
        model.addAttribute("dealings", dealings);
        return "dealings";
    }

    @RequestMapping("/persons")
    public String getPersonsPage(Model model) {
        List<ContactPerson> persons = action.persons();
        model.addAttribute("persons", persons);
        return "persons";
    }

    @RequestMapping("/tasks")
    public String getTasksPage(Model model) {
        List<Tasks> tasks = action.tasks();
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    @RequestMapping("/logout")
    public String logout(Model model, HttpServletRequest req) {
        HttpSession session = req.getSession();
        session.setAttribute("loggedIn", false);
        return "login";
    }

}
