package in.tyda.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import in.tyda.beans.Friend_Request;
import in.tyda.beans.Friends;
import in.tyda.beans.User_Profile;
import in.tyda.model.Login;
import in.tyda.model.Registation;

@Controller
public class Login_Controller {

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Login login, Model model) {

		String userId = login.getUserId();
		String password = login.getPassword();
		System.out.println(userId + " " + password);

		SessionFactory sc1 = new AnnotationConfiguration().configure().buildSessionFactory();
		Session sc = sc1.openSession();
		Transaction tx = null;

		String DBuserId = null;
		String DBpassword = null;
		String DBname = null;
		String DBProfileURL = null;
		String DBskill = null;

		JSONObject json = new JSONObject();

		Query query = sc.createQuery("from User_Profile where userId= :id");
		query.setParameter("id", userId);

		List<User_Profile> list = query.list();
		Iterator<User_Profile> itr = list.iterator();
		if (itr.hasNext()) {
			User_Profile obj = itr.next();
			DBpassword = obj.getPassword();

			json.put("name", obj.getName());
			json.put("userId", obj.getUserId());
			json.put("email", obj.getEmail());

		}

		if ((password.equals(DBpassword))) {

			ArrayList<String> friends = new ArrayList<String>();

			Query query2 = sc.createQuery("from Friend_Request where targetId= :tid AND action= 0");
			query2.setParameter("tid", userId);

			List<Friend_Request> list2 = query2.list();
			Iterator<Friend_Request> itr2 = list2.iterator();
			JSONArray array = new JSONArray();
			while (itr2.hasNext()) {
				Friend_Request obj = itr2.next();
				JSONObject tempjson = new JSONObject();
				tempjson.put("frId", obj.getFrId());
				tempjson.put("senderId", obj.getSenderId());
				array.add(tempjson);
			}

			json.put("frinedrequests", array);

			String data = json.toString().replace("\"", "'");
			model.addAttribute("data", data);

			System.out.println(data);

			return "deshboard";
		} else {
			System.out.println("Incorrect Password");
			model.addAttribute("error", "Incorrect Password");

			return "index";
		}

	}

	@RequestMapping(value = "/registation", method = RequestMethod.POST)
	public String registation(Registation registation) throws IOException {

		String userId = registation.getUserId();
		String email = registation.getEmail();
		String password = registation.getPassword();
		String name = registation.getName();
		String profilepic = registation.getProfilepicUrl();

		SessionFactory sc1 = new AnnotationConfiguration().configure().buildSessionFactory();
		Session sc = sc1.openSession();
		Transaction tx = null;
		try {
			tx = sc.beginTransaction();
			User_Profile profile = new User_Profile();
			profile.setEmail(email);
			profile.setUserId(userId);
			profile.setName(name);
			profile.setPassword(password);
			profile.setProfilepic(profilepic);

			sc.save(profile);
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}

}
