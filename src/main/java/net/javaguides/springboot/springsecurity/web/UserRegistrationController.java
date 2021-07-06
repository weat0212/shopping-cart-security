package net.javaguides.springboot.springsecurity.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.javaguides.springboot.springsecurity.model.User;
import net.javaguides.springboot.springsecurity.service.UserService;
import net.javaguides.springboot.springsecurity.web.dto.UserRegistrationDto;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") @Valid UserRegistrationDto userDto,
                                      BindingResult result){

        User existing = userService.findByEmail(userDto.getEmail());
        if (existing != null){
            result.rejectValue("email", null, "There is already an account registered with that email");
        }

        if (!StringUtils.hasLength(userDto.getFirstName())) {
            result.rejectValue("firstName", null, "First Name blank not filled");
        }

        if (!StringUtils.hasLength(userDto.getLastName())) {
            result.rejectValue("lastName", null, "Last Name blank not filled");
        }

        if (userDto.getEmail() == null || !userDto.getEmail().equals(userDto.getConfirmEmail())) {
            result.rejectValue("confirmEmail", null, "Email Error!");
        }

        if (userDto.getPassword() == null || !userDto.getPassword().equals(userDto.getConfirmPassword())) {
            result.rejectValue("confirmPassword", null, "Password Error!");
        }

        if (!userDto.getTerms()) {result.rejectValue("confirmPassword", null, "");}

        if (result.hasErrors()){
            return "registration";
        } else {
            userService.save(userDto);
            return "redirect:/registration?success";
        }
    }

}
