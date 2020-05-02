package POJO_CLASSES;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class avl_books {
	
	private String title;
	@Id
	private String id;
	public avl_books(String title, String id) {
		super();
		this.title = title;
		this.id = id;
	}
	public avl_books() {
		super();
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
