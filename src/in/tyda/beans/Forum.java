package in.tyda.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Forum")
public class Forum {
	
	@Id
	@Column(name = "forumId")
	String forumId;
	
	@Column(name = "description")
	String description;
	
	@Column(name = "createId")
	String createId;
	
	@Column(name = "date")
	String date;

	public String getFourmId() {
		return forumId;
	}

	public void setFourmId(String fourmId) {
		this.forumId = fourmId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreateId() {
		return createId;
	}

	public void setCreateId(String createId) {
		this.createId = createId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
