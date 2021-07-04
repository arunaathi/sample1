package com.howtodoinjava.rest.model;

public class Post {

    public Post() {

    }

    public Post(int userId, int id,String title,String description) {
        super();
        this.userId=userId;
        this.id=id;
        this.title=title;
        this.description=description;
    }
 
    public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	int userId;  
    int id;  
    String title;  
    String description;  
    @Override
    public String toString() {
        return "Post [userId=" + userId + ", title=" + title + "]";
    }
}
