package in.tyda.controller;

import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import in.tyda.beans.Blog_Post;
import in.tyda.beans.User_Profile;
import in.tyda.model.Blog_Add;
import in.tyda.model.Login;
import oracle.net.aso.r;

@Controller
public class Blog_Controller {

	@RequestMapping(value = "/blog_add", method = RequestMethod.POST)
	public String login(Blog_Add blog, Model model) {
		String title = blog.getTitle();
		String content = blog.getContent();
		String createId = blog.getCreaterId();

		Date date = new Date();

		SessionFactory sc1 = new AnnotationConfiguration().configure().buildSessionFactory();
		Session sc = sc1.openSession();

		Random random = new Random();

		Transaction tx = null;
		try {
			tx = sc.beginTransaction();
			Blog_Post newblog = new Blog_Post();
			newblog.setCreateId(createId);
			newblog.setContent(content);
			newblog.setDate(date.toString());
			newblog.setBlogId("blog" + random.nextInt(99999));
			sc.save(newblog);
			tx.commit();
		} catch (Exception e) {
			model.addAttribute("msg", "Error in Adding Blog");
			return "blog";
		}

		model.addAttribute("msg", "Successfully Added Blog");
		return "blog";
	}

}
