package com.mycomp.controller;

import com.mycomp.enums.Gender;
import com.mycomp.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/another")
public class AnotherController {
    @RequestMapping("/list")  //http://localhost:8080/another/list
    public String mentor(Model model) {

        List<Mentor> mentors = new ArrayList<>();

        Mentor m1 = new Mentor("Cely", "Abc", 30, Gender.FEMALE);
        Mentor m2 = new Mentor("Carl", "Yuan", 25, Gender.MALE);
        mentors.addAll(Arrays.asList(m1, m2));

        mentors.add(new Mentor("Mike", "Smith", 45, Gender.MALE));
        mentors.add(new Mentor("Tom", "Hanks", 65, Gender.MALE));
        mentors.add(new Mentor("Ammy", "Bryan", 25, Gender.FEMALE));

        model.addAttribute("mentors", mentors);

        return "mentor/mentor-list";
    }

}
