package my.crm.controller;

import my.crm.entity.*;
import my.crm.model.*;
import my.crm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by 2540p on 21.02.2017.
 */
@Controller
public class SpringController {

    @Autowired
    private UserService userService;

    private Action action = new Action();

    @RequestMapping("/login")
    public String getLoginPage() {
        return "loginMyCRM";
    }

//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public String getLoginPostPage(@RequestParam("login") String login, @RequestParam("password") String password, HttpServletRequest req, Model model) {
//        HttpSession session = req.getSession(true);
//        if (action.login(login, password)) {
//            session.setAttribute("loggedIn", true);
//            return "login";
//        } else {
//            session.setAttribute("loggedIn", false);
//            model.addAttribute("error", "Incorrect Username or Password");
//            return "login";
//        }
//    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String getRegistrationPage(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @RequestMapping(value = "/save-account", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") User user) {
        //TODO: нужно ли проверять?
//        if (action.checkLogin(login)) {
//            if (action.checkEmail(email)) {
        userService.createNewUser(user);
//                model.addAttribute("registrationSuccess", "Your registration has been successful!");
        return "redirect:/login";
//            } else {
//                model.addAttribute("registrationError", "Email is already in use");
//                return "registration";
//            }
//        } else {
//            model.addAttribute("registrationError", "Login is already in use");
//            return "registration";
//        }
    }

    @RequestMapping("/test-admin")
    public String getAdministratorPage() {
        return "Admin";
    }

    @RequestMapping("/error")
    public String getErrorPage() {
        return "errorPage";
    }


    @RequestMapping("/companies")
    public String getCompaniesPage(Model model) {
        List<Company> companies = action.companies();
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

//    @RequestMapping("/logout")
//    public String logout(Model model, HttpServletRequest req) {
//        HttpSession session = req.getSession();
//        session.setAttribute("loggedIn", false);
//        return "login";
//    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        return "redirect:/login";
    }

    @RequestMapping("/add-company")
    public String getAddCompanyPage() {
        return "addCompany";
    }

    @RequestMapping(value = "/save-company", method = RequestMethod.POST)
    public String addCompany(@RequestParam("name") String companyName,
                             @RequestParam("address") String companyAddress,
                             @RequestParam("website") String companyWebsite,
                             @RequestParam("phoneNumber") String companyPhoneNumber,
                             @RequestParam("email") String companyEmail,
                             @RequestParam("contactType") String contactType) {

        action.addCompany(companyName, companyAddress, companyWebsite, companyPhoneNumber, companyEmail, contactType);
        return "redirect:/companies";
    }

    @RequestMapping("/add-contact")
    public String getAddContactPage(Model model) {
        List<Company> companies = action.companies();
        model.addAttribute("companies", companies);
        return "addContactPerson";
    }


    // TODO: patern builder
    @RequestMapping(value = "/save-contact", method = RequestMethod.POST)
    public String addContact(@RequestParam("contactName") String contactName,
                             @RequestParam("position") String conactPosition,
                             @RequestParam("phoneNumber") String conactPhoneNumber,
                             @RequestParam("email") String conactEmail,
                             @RequestParam("company") String companyId) {

                action.addContact(contactName, conactPosition, conactPhoneNumber, conactEmail, companyId);
        return "redirect:/persons";
    }

    @RequestMapping("/add-deal")
    public String getAddDealPage() {
        return "addDealing";
    }

    @RequestMapping("/add-task")
    public String getAddTaskPage() {
        return "addTask";
    }

}
