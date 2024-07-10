package org.example.proj2webapp.Controllers;

import org.example.proj2webapp.DTO.UserDTO;
import org.example.proj2webapp.Services.AuthenticationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigInteger;

@Controller
public class LoginController {

    private final AuthenticationService authenticationService;

    public LoginController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @GetMapping("/loginPage")
    public String loginPage() {
        return "redirect:/Login.html";
    }

    @PostMapping("/logger")
    public String processLogin(@RequestParam String username, @RequestParam String password, Model model) {
        if (authenticationService.authenticate(username, password)) {
            return "redirect:/Home.html";
        } else {
            model.addAttribute("error", "Nome de usuário ou senha inválidos.");
            return "redirect:/Login.html";
        }
    }
}