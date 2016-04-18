package in.tyda.controller;

import java.util.HashMap;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import in.tyda.beans.Friend_Request;
import in.tyda.beans.Friends;
import in.tyda.beans.User_Profile;
import oracle.net.aso.r;

@Controller
public class Friend_Controller {

	@RequestMapping(value = "/people_search", method = RequestMethod.POST, headers = {
			"Content-type=application/json" })
	public @ResponseBody String getFirend(@RequestBody String name) throws ParseException {
		JSONParser parser = new JSONParser();

		JSONObject object = (JSONObject) parser.parse(name);

		String search_friend = object.get("name").toString();

		SessionFactory sc1 = new AnnotationConfiguration().configure().buildSessionFactory();
		Session sc = sc1.openSession();

		Query query = sc.createQuery("from User_Profile where name like :name ");
		query.setParameter("name", "%" + search_friend + "%");
		List<User_Profile> list = query.list();
		Iterator<User_Profile> itr = list.iterator();

		JSONArray array = new JSONArray();
		while (itr.hasNext()) {
			User_Profile user_Profile = itr.next();
			JSONObject jsonObject = new JSONObject();

			jsonObject.put("name", user_Profile.getName());
			jsonObject.put("email", user_Profile.getEmail());
			jsonObject.put("userId", user_Profile.getUserId());

			array.add(jsonObject);
		}

		System.out.println(array);

		return array.toString();

	}

	@RequestMapping(value = "/friend_request", method = RequestMethod.POST, headers = {
			"Content-type=application/json" })
	public @ResponseBody String sendFRequest(@RequestBody String name) throws ParseException {
		JSONParser parser = new JSONParser();

		JSONObject object = (JSONObject) parser.parse(name);

		String senderId = object.get("senderId").toString();
		String targerId = object.get("targerId").toString();

		JSONObject responsejson = new JSONObject();

		System.out.println(senderId + " " + targerId);

		SessionFactory sc1 = new AnnotationConfiguration().configure().buildSessionFactory();
		Session sc = sc1.openSession();

		Query query3 = sc.createQuery("from Friends where userId= :uid AND friendId= :fid");
		query3.setParameter("uid", targerId);
		query3.setParameter("fid", senderId);

		List<Friend_Request> list3 = query3.list();
		Iterator<Friend_Request> itr3 = list3.iterator();

		if (itr3.hasNext()) {

			Query query = sc.createQuery("from Friends where userId= :uid AND friendId= :fid");
			query.setParameter("uid", senderId);
			query.setParameter("fid", targerId);

			List<Friend_Request> list = query.list();
			Iterator<Friend_Request> itr = list.iterator();
			if (itr.hasNext()) {

				Query query2 = sc.createQuery("from Friend_Request where senderId= :sid AND targetId= :tid");
				query2.setParameter("sid", senderId);
				query2.setParameter("tid", targerId);

				List<Friend_Request> list2 = query2.list();
				Iterator<Friend_Request> itr2 = list2.iterator();

				Random random = new Random();

				if (!itr2.hasNext()) {

					Transaction tx = null;
					try {
						tx = sc.beginTransaction();
						Friend_Request friend_Request = new Friend_Request();
						friend_Request.setFrId("frequest" + random.nextInt(99999));
						friend_Request.setSenderId(senderId);
						friend_Request.setTargetId(targerId);
						friend_Request.setStatus(false);
						friend_Request.setAction("0");

						sc.save(friend_Request);
						tx.commit();

						responsejson.put("result", "Request Send " + targerId);
						return responsejson.toString();

					} catch (Exception e) {
						e.printStackTrace();
						responsejson.put("result", "Error in Sending Friend Request " + targerId);
						return responsejson.toString();
					}
				} else {
					responsejson.put("result", "Already Send Request " + targerId);
					return responsejson.toString();
				}
			} else {
				responsejson.put("result", "Already Friends " + targerId);
				return responsejson.toString();
			}

		} else {
			responsejson.put("result", "Already Friends " + targerId);
			return responsejson.toString();
		}
	}

	@RequestMapping(value = "/friend_request_status", method = RequestMethod.POST, headers = {
			"Content-type=application/json" })
	public @ResponseBody String sendFRequestStatus(@RequestBody String name) throws ParseException {

		JSONParser parser = new JSONParser();

		JSONObject object = (JSONObject) parser.parse(name);

		System.out.println(name);

		Random random = new Random();

		String senderId = object.get("senderId").toString();
		String targerId = object.get("targerId").toString();
		String frId = object.get("frId").toString();
		String action = object.get("action").toString();

		System.out.println(senderId + " " + targerId + " " + frId + " " + action);

		JSONObject responsejson = new JSONObject();

		SessionFactory sc1 = new AnnotationConfiguration().configure().buildSessionFactory();
		Session sc = sc1.openSession();
		Transaction tx = null;
		try {
			tx = sc.beginTransaction();
			Query query = sc.createQuery("DELETE from Friend_Request where frId= :frid");
			query.setParameter("frid", frId);
			query.executeUpdate();

			if (action.equals("1")) {

				Friends f1 = new Friends();
				Friends f2 = new Friends();

				f1.setfId("friend" + random.nextInt(999999));
				f1.setFriendId(targerId);
				f1.setUserId(senderId);

				f2.setfId("friend" + random.nextInt(999999));
				f2.setFriendId(senderId);
				f2.setUserId(targerId);

				sc.save(f1);
				sc.save(f2);
				tx.commit();
				responsejson.put("result", "Successfully Accepted " + senderId);
				return responsejson.toString();

			} else {
				tx.commit();
				responsejson.put("result", "Successfully Rejected " + senderId);
				return responsejson.toString();
			}

		} catch (Exception e) {
			responsejson.put("result", "Caught Error while " + senderId);
			e.printStackTrace();
			return responsejson.toString();
		}

	}
}