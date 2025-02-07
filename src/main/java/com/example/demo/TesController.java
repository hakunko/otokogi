package com.example.demo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class TesController {
	@Autowired
	private Userdepo userdepo;
	
	@Autowired
	private otokogidepo otokogidepo;
	
	@Autowired
	private Userservice serve;
	
	@GetMapping("/")
	public String con() {
		return "NewFile";
	}
	
	@PostMapping("/sign")
	public String sign(@RequestParam String name,@RequestParam String pass) {
		User user=new User();
		user.setName(name);
		user.setPass(serve.hash(pass));
		userdepo.save(user);
		return "NewFile";
	}
	
	@PostMapping("/log")
	public String log(@RequestParam String name,@RequestParam String pass,Model model) {
		User user=userdepo.findByName(name);
		if(user!=null&&serve.verify(pass, user.getPass())) {
			model.addAttribute("name", name);
			return "homepage";
		}
		return "redirect:/?error";
	}
	
    @GetMapping("/signin")
    public String signUp() {
        return "signin"; 
    }
    
    @GetMapping("/otoko")
    public String otoko(Model model,@RequestParam String name){
    	model.addAttribute("name", name);
    	return "home";
    }
    
    @GetMapping("/home")
    public String home(Model model,@RequestParam String name){
    	model.addAttribute("name", name);
    	return "homepage";
    }
    
    @PostMapping("/otoko2")
    public String otoko2(Model model,@RequestParam String name){
    	model.addAttribute("name", name);
    	return "homepage";
    }
    
    @PostMapping("/save")
    public String save( @RequestParam Long month, 
    		@RequestParam Long day, 
            @RequestParam String win, 
            @RequestParam Long price,
            @RequestParam Long year,
            @RequestParam String name,
            Model model) {
    	Otokogi otoko=new Otokogi();
    	if(win.equals("負け")) {
    		price=price*-1;
    	}
    	otoko.setDay(day);
    	otoko.setYear(year);
    	otoko.setMonth(month);
    	otoko.setPrice(price);
    	otoko.setWin(win);
    	otoko.setName(name);
    	otokogidepo.save(otoko);
        model.addAttribute("name", name);
    	return "home";
    }
    
    @GetMapping("/calendar-data")
    @ResponseBody
    public List<Otokogi> getCalendarData(@RequestParam int month,@RequestParam String name) {
        int currentYear = LocalDate.now().getYear();
        return otokogidepo.findByYearAndMonthAndName(currentYear, month,name);
    }
    
    @PostMapping("/del")
    public String del() {
    	otokogidepo.deleteAll();
    	return "home";
    }
    
    @GetMapping("/graph-data")
    @ResponseBody
    public List<Otokogi> graph(@RequestParam int year) {
        return otokogidepo.findByYear(year);
    }

   
}
