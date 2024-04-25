package com.example.projectPostApi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Post {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	
	private String content;
	
	private String description;
	
	@NotBlank(message =" Le post doit avoir un titre")
    @Size(min = 3,message = "Le titre doit être plus grand que 3")
	private String title;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Post(Long id, String content, String description,
			@NotBlank(message = " Le post doit avoir un titre") @Size(min = 3, message = "Le titre doit être plus grand que 3") String title) {
		super();
		this.id = id;
		this.content = content;
		this.description = description;
		this.title = title;
	}

	@Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", description='" + description + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
	

	
}
