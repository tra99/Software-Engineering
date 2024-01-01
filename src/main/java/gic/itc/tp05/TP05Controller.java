package gic.itc.tp05;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import models.FormData;


import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TP05Controller {
    @GetMapping("/")
    public String welcome() {

        return "welcome";
    }


    @GetMapping("/TP05/task2")
    public String task2() {   
        return "task2";
    }
    @GetMapping("/TP05/task3")
    public String task3() {  
        return "task3";
    }
    @GetMapping("/TP05/task4")
    public String task4() {   
        return "task4";
    }
    @GetMapping("/TP05/task5")
    public String task5() {  
        return "task5";
    }
    @PostMapping("/submit-form")
    public String goTask5(@ModelAttribute FormData formData){

        String name = formData.getName();
        String password = formData.getPassword();

        if(name.equals("hok sochetra")){
            if (password.equals("123456")) {
                return this.task5();
            }else{
                return "task2";
            }
        }else{
            return "task2";
        }

    }
}
