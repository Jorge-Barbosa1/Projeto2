package org.example.proj2webapp.Controllers;

import org.example.proj2webapp.Services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigInteger;

@Controller
public class RegisterController {

    @GetMapping("/registerPage")
    public String registerPage() {
        return "register";
    }

    @PostMapping("/register")
    public String processRegister(@RequestParam String name, @RequestParam String username, @RequestParam BigInteger phone,
                                  @RequestParam String email, @RequestParam String password, @RequestParam String confirmPassword, Model model) {
        if (!password.equals(confirmPassword)) {
            model.addAttribute("error", "As palavras-passe não coincidem.");
            return "redirect:/Register.html";
        }

        UserService userService = new UserService();
        boolean registered = userService.register(name, username, phone, email, password);

        if (registered) {
            return "redirect:/loginPage";
        } else {
            model.addAttribute("error", "Nome de utilizador ou e-mail já existem.");
            return "redirect:/Register.html";
        }
    }
}
