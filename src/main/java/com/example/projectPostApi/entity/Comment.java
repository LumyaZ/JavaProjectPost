package com.example.projectPostApi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String body;
	
	@NotBlank(message = "L'email ne peut être vide")
    @Email(message = "Un email valide" )
    @Pattern(regexp = ".*\\.com$", message = "L'email doit se terminer par .com")
	private String email;
	
	private String name;
	
	@ManyToOne
    @JoinColumn(name = "post_id")
	private Post post;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public Comment(Long id, String body,
			@NotBlank(message = "L'email ne peut être vide") @Email(message = "Un email valide") @Pattern(regexp = ".*\\.com$", message = "L'email doit se terminer par .com") String email,
			String name, Post post) {
		super();
		this.id = id;
		this.body = body;
		this.email = email;
		this.name = name;
		this.post = post;
	}
	
	@Override
    public String toString() {
        return "Commentaire{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", body='" + body + '\'' +
                ", nom='" + name + '\'' +
                ", post=" + post +
                '}';
    }
}
