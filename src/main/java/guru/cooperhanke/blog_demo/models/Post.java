package guru.cooperhanke.blog_demo.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "posts")
public class Post {

    @GeneratedValue @Id
    private long id;

    @Column(name="title", nullable = false)
    private String title;

    @Column(name="body", nullable = false, columnDefinition = "TEXT")
    private String body;

    @Column(name="created_on", nullable = false)
    private Date createdOn = new Date();

    @OneToOne
    private User user;

    public Post() { }

    public Post(long id, String title, String body, User user, Date createdOn) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.user = user;
        this.createdOn = createdOn;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }
}
