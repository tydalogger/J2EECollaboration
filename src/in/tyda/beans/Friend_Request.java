package in.tyda.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Friend_Request")
public class Friend_Request {

	@Id
	@Column(name = "frId")
	String frId;

	@Column(name = "senderId")
	String senderId;

	@Column(name = "targetId")
	String targetId;

	@Column(name = "status")
	boolean status;

	@Column(name = "action")
	String action;

	public String getSenderId() {
		return senderId;
	}

	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}

	public String getTargetId() {
		return targetId;
	}

	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getFrId() {
		return frId;
	}

	public void setFrId(String frId) {
		this.frId = frId;
	}

}
