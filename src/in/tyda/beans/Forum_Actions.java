package in.tyda.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Forum_Actions")
public class Forum_Actions {
	
	@Id
	@Column(name = "forumId")
	String forumId;
	
	@Column(name = "userId")
	String userId;
	
	@Column(name = "postId")
	String postId;
	
	@Column(name = "parent")
	String parent;
	
	@Column(name = "date")
	String date;

	public String getForumId() {
		return forumId;
	}

	public void setForumId(String forumId) {
		this.forumId = forumId;
	}

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

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
