package in.tyda.controller;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import in.tyda.beans.User_Profile;

@Controller
public class Home_Controller {

	@RequestMapping("/")
	public String hello() {
		return "index";
	}
	
	@RequestMapping("/desh")
	public String desh() {
		return "deshboard";
	}

	@RequestMapping("/blog")
	public String blog(Model model) {
		return "blog";
	}
	
	@RequestMapping("/Add_blog")
	public String Add_blog(Model model) {
		return "Add_blog";
	}
	
	@RequestMapping("/view_friends")
	public String view_Friends(Model model) {
		return "view_friends";
	}

	
}
