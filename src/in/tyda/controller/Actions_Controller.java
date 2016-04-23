package in.tyda.controller;

import java.util.Date;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import in.tyda.beans.Actions;

@Controller
public class Actions_Controller {

	@RequestMapping(value = "/add_action_con", method = RequestMethod.POST, headers = { "Content-type=application/json" })
	public @ResponseBody String add_action(@RequestBody String name) throws ParseException {

		JSONParser parser = new JSONParser();

		JSONObject object = (JSONObject) parser.parse(name);
		System.out.println(object);

		JSONObject responseJSON = new JSONObject();

		String userId = object.get("userId").toString();
		String postId = object.get("postId").toString();
		String content = object.get("content").toString();

		Date date = new Date();

		Random random = new Random();

		SessionFactory sc1 = new AnnotationConfiguration().configure().buildSessionFactory();
		Session sc = sc1.openSession();
		Transaction tx = null;
		try {
			tx = sc.beginTransaction();
			Actions actions = new Actions();

			actions.setActionId("action" + random.nextInt(999999));
			actions.setContent(content);
			actions.setUserId(userId);
			actions.setPostId(postId);
			actions.setDate_time(date.toString());
			sc.save(actions);
			tx.commit();

			responseJSON.put("result", "Successfully added");

		} catch (Exception e) {
			responseJSON.put("result", "Error in Addind added");
			e.printStackTrace();
		}

		return responseJSON.toString();
	}

}
