package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Post {

    static DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    private LocalDateTime moment;
    private String title;
    private String content;
    private Integer likes;

    private List<Comment> comments = new ArrayList<>();

    public Post(LocalDateTime moment, String title, String content, Integer likes) {
        this.moment = moment;
        this.title = title;
        this.content = content;
        this.likes = likes;
    }

    public LocalDateTime getMoment() {
        return moment;
    }

    public void setMoment(LocalDateTime moment) {
        this.moment = moment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void addComments (Comment comment) {
        comments.add(comment);
    }

    public void removeComments (Comment comment) {
        comments.remove(comment);
    }

    @Override
    public String toString () {
        StringBuilder sb = new StringBuilder();
        sb.append(getTitle() + "\n");
        sb.append(getLikes() + " Likes - " + dtf1.format(getMoment()) + "\n");
        sb.append(getContent() + "\n");
        sb.append("Comments: \n");
        for (Comment c : comments) {
            sb.append(c.getText() + "\n");
        }
        return sb.toString();
    }
}
