package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.util.List;

@RequestMapping
@Controller
public class UsersController {
    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(value = "/")
    public String printTable(Model model) {
        List<User> myUser = userService.getAll();
        model.addAttribute("users", myUser);
        return "index";
    }

    @GetMapping(value = "/user")
    public String getUser(Model model, @RequestParam("id") Long id) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "user";
    }

    @GetMapping(value = "/form")
    public String showForm() {
        return "form";
    }

    @GetMapping(value = "/updateForm")
    public String showUpdateForm(Model model, @RequestParam("id") Long id) {
        User user = userService.getUserById(id);
        model.addAttribute("findUser", user);
        return "updateForm";
    }

    @PatchMapping(value = "/update")
    public String update(@ModelAttribute("upUser") User user) {
        userService.updateUser(user);
        return "redirect:/";
    }

    @GetMapping(value = "/new")
    public String addUserForm(Model model) {
        User user = new User();
        model.addAttribute("newUser", user);
        return "addForm";
    }

    @PostMapping(value = "/add")
    public String addUser(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/";
    }

    @DeleteMapping("/delete")
    public String remove(Model model, @RequestParam("id") Long id) {
        userService.removeUserById(id);
        return "redirect:/";
    }

}