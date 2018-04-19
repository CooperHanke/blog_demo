package guru.cooperhanke.blog_demo.controllers;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post {

    @GeneratedValue @Id
    private long id;

    @Column(name="title", nullable = false)
    private String title;

    @Column(name="body", nullable = false)
    private String body;

    public Post() { }

    public Post(long id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public long getId() { return id; }

    public void setId(Long id) { this.id = id; }
}
