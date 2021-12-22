package com.example.demo.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GREETINGS")
public class Greeting {
	@Id
	private long id;
	private String message;

	public Greeting(long ld) {
		id = 0;
		message = "";
	}
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getContent() {
        return message;
    }
    public void setContent(String content) {
        this.message = content;
    }
    public Greeting(long id, String content) {
        this.id = id;
        this.message = content;
    }
}
