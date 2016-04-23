package in.tyda.controller;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import in.tyda.beans.Actions;
import in.tyda.beans.Blog_Post;
import oracle.net.aso.a;

@Controller
public class Blog_Controller {

	@SuppressWarnings("unchecked")
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

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/get_user_Blogs", method = RequestMethod.POST, headers = {
			"Content-type=application/json" })
	public @ResponseBody String get_user_Blogs(@RequestBody String name) throws ParseException {

		JSONParser parser = new JSONParser();

		JSONObject object = (JSONObject) parser.parse(name);

		JSONArray responseArray = new JSONArray();

		System.out.println(object);
		String createId = object.get("createId").toString();

		SessionFactory sc1 = new AnnotationConfiguration().configure().buildSessionFactory();
		Session sc = sc1.openSession();

		Query query = sc.createQuery("from Blog_Post where createId = :cid");
		query.setParameter("cid", createId);
		List<Blog_Post> list = query.list();
		Iterator<Blog_Post> iterator = list.iterator();

		while (iterator.hasNext()) {
			Blog_Post blog_Post = iterator.next();
			JSONObject responseJSON = new JSONObject();
			responseJSON.put("title", blog_Post.getTitle());
			responseJSON.put("content", blog_Post.getContent());
			responseJSON.put("date_time", blog_Post.getDate_time());
			responseJSON.put("blogId", blog_Post.getBlogId());
			responseJSON.put("createId", blog_Post.getCreateId());

			Query query2 = sc.createQuery("from Actions where postId= :pid");
			query2.setParameter("pid", blog_Post.getBlogId());
			List<Actions> list2 = query2.list();
			Iterator<Actions> iterator2 = list2.iterator();

			JSONArray array = new JSONArray();

			while (iterator2.hasNext()) {
				Actions actions = iterator2.next();
				JSONObject object2 = new JSONObject();

				object2.put("actionId", actions.getActionId());
				object2.put("content", actions.getContent());
				object2.put("userId", actions.getUserId());
				object2.put("date", actions.getDate_time());

				System.out.println(object2.toString());

				array.add(object2);

			}
			responseJSON.put("actions", array);
			responseArray.add(responseJSON);
		}

		return responseArray.toString();
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/get_particular_blog", method = RequestMethod.POST, headers = {
			"Content-type=application/json" })
	public @ResponseBody String get_particular_blog(@RequestBody String name) throws ParseException {
		
		
		return name;
	}

}
