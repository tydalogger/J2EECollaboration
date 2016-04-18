package in.tyda.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User_Profile_Meta")
public class User_Profile_Meta {
	
	@Id
	@Column(name = "userId")
	String userId;
	
	@Column(name = "websocket")
	String websocket;
	
	public String getUserID() {
		return userId;
	}
	
	public void setUserID(String userID) {
		this.userId = userID;
	}
	
	public String getWebsocket() {
		return websocket;
	}
	
	public void setWebsocket(String websocket) {
		this.websocket = websocket;
	}
	

}
