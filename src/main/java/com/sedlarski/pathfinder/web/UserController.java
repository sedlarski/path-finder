package com.sedlarski.pathfinder.web;

import com.sedlarski.pathfinder.model.binding.UserLoginBM;
import com.sedlarski.pathfinder.model.binding.UserRegisterBM;
import com.sedlarski.pathfinder.model.service.UserServiceModel;
import com.sedlarski.pathfinder.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @ModelAttribute
    public UserRegisterBM userRegisterBM() {
        return new UserRegisterBM();
    }

    @ModelAttribute
    public UserLoginBM userLoginBM(){
        return new UserLoginBM();
    }

    @GetMapping("/register")
    public String registerGet(Model model) {
        return "register";
    }

    @PostMapping("/register")
    public String registerPost(@Valid UserRegisterBM userRegisterBM,
                               BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors() || !userRegisterBM.getPassword().equals(userRegisterBM.getConfirmPassword())) {
            redirectAttributes.addFlashAttribute("userRegisterBM", userRegisterBM);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBM", bindingResult);
            return "redirect:register";
        }
        userService.registerUser(modelMapper.map(userRegisterBM, UserServiceModel.class));
        return "redirect:login";
    }

    @GetMapping("/logout")
    public String logout() {
        userService.logout();
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("isExists", true);
        return "login";
    }
}
