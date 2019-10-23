package com.rb.domainproject.projectname.modele;

public class Event {
	
	private Integer Id;
	private String Name;
	private String HttpLink;
	
	public Event (int id, String name, String link) {
		Id = id;
		Name = name;
		HttpLink = link;
	}
	public Event (String name, String link) {
		Id = null;
		Name = name;
		HttpLink = link;
	}

	public Integer getId() {
		return Id;
	}
	public String getName() {
		return Name;
	}
	public String getHttpLink() {
		return HttpLink;
	}
}
