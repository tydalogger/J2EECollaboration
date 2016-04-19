package in.tyda.controller;

import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import in.tyda.beans.Blog_Post;
import in.tyda.beans.User_Profile;
import in.tyda.model.Blog_Add;
import in.tyda.model.Login;
import oracle.net.aso.r;

@Controller
public class Blog_Controller {

	@RequestMapping(value = "/add_blog_fun", method = RequestMethod.POST, headers = { "Content-type=application/json" })
	public @ResponseBody String add_blog_fun(@RequestBody String name) throws ParseException {

		JSONParser parser = new JSONParser();

		JSONObject object = (JSONObject) parser.parse(name);

		JSONObject responseJSON = new JSONObject();
		System.out.println(object);
		String createId = object.get("createId").toString();
		String title = object.get("title").toString();
		String content = object.get("content").toString();

		SessionFactory sc1 = new AnnotationConfiguration().configure().buildSessionFactory();
		Session sc = sc1.openSession();

		Date date = new Date();

		Random random = new Random();
		String blogId = "blog" + random.nextInt(99999);
		Transaction tx = null;
		try {
			tx = sc.beginTransaction();
			Blog_Post newblog = new Blog_Post();
			newblog.setCreateId(createId);
			newblog.setTitle(title);
			newblog.setContent(content);
			newblog.setDate_time(date.toString());
			newblog.setBlogId(blogId);
			sc.save(newblog);
			tx.commit();
			responseJSON.put("result", "Successfully Added Blog id: " + blogId);
			return responseJSON.toString();
		} catch (Exception e) {

			responseJSON.put("result", "Error in Adding Blog");
			e.printStackTrace();
			return responseJSON.toString();
		}

	}

	@RequestMapping(value = "/get_user_Blogs", method = RequestMethod.POST, headers = { "Content-type=application/json" })
	public @ResponseBody String get_user_Blogs(@RequestBody String name) throws ParseException {

		JSONParser parser = new JSONParser();

		JSONObject object = (JSONObject) parser.parse(name);

		JSONObject responseJSON = new JSONObject();
		System.out.println(object);
		String createId = object.get("createId").toString();
		
		return name;
	}

}
