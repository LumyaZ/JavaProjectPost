package com.example.projectPostApi.entity;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.Comments;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
	
	@NotBlank(message =" Le post doit avoir un content")
	private String content;
	
	@NotBlank(message =" Le post doit avoir un description")
	private String description;
	
	@NotBlank(message =" Le post doit avoir un titre")
    @Size(min = 3,message = "Le titre doit être plus grand que 3")
	private String title;
	
	@JsonIgnore
    @OneToMany(mappedBy = "post",fetch = FetchType.LAZY)
    private Set<Comments> comments = new HashSet<>();

	public Set<Comments> getComments() {
		return comments;
	}

	public void setComments(Set<Comments> comments) {
		this.comments = comments;
	}

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
			@NotBlank(message = " Le post doit avoir un titre") @Size(min = 3, message = "Le titre doit être plus grand que 3") String title,
			Set<Comments> comments) {
		super();
		this.id = id;
		this.content = content;
		this.description = description;
		this.title = title;
		this.comments = comments;
	}

	@Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", description='" + description + '\'' +
                ", title='" + title + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
	

	
}
