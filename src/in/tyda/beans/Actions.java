package in.tyda.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Blog_Actions")
public class Actions {

	@Id
	@Column(name = "ActionId")
	String ActionId;

	@Column(name = "userId")
	String userId;

	@Column(name = "postId")
	String postId;

	@Column(name = "content")
	String content;

	@Column(name = "date_time")
	String date_time;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public String getDate_time() {
		return date_time;
	}

	public void setDate_time(String date_time) {
		this.date_time = date_time;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getActionId() {
		return ActionId;
	}

	public void setActionId(String actionId) {
		ActionId = actionId;
	}

}
