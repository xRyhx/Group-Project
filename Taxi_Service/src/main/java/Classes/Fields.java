package Classes;

import java.io.Serializable;
import java.util.Date;

abstract public class Fields implements Serializable {

	private static final long SerialVersioniD = 1L;
	protected int id;
	protected String name;
	protected Date dateCreated;
	
	public Fields() {
		this(0,"");
	}
	public Fields(int id, String name) {
		this.id = id;
		this.name = name;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	@Override
	public String toString() {
		return "Fields [id=" + id + ", name=" + name + ", dateCreated=" + dateCreated + "]";
	}
	
	
	
	
}
