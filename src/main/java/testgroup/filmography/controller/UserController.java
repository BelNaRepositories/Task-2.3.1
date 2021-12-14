package testgroup.filmography.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import testgroup.filmography.model.User;
import testgroup.filmography.service.UserService;

@Controller
@RequestMapping("/")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping({"", "user"})
    public String getUsers(Model model, @ModelAttribute("flashMessage") String flashAttribute) {
        model.addAttribute("user", userService.getAllUsers());
        return "user-list";
    }
    @GetMapping(value = "/user-create")
    public String createUsersFrom(User user) {
        return "user-create";
    }

    @PostMapping (value = "/user-create")
    public String createUsers(User user) {
        userService.saveUser(user);
        return "redirect:/user";
    }

    @GetMapping("user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userService.delete(id);
        return "redirect:/user";
    }

    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model){
        User user = userService.readUser(id);
        model.addAttribute("user", user);
        return "user-update";
    }

    @PostMapping("/user-update")
    public String updateUser(User user){
        userService.update(user);
        return "redirect:/user";
    }
}

