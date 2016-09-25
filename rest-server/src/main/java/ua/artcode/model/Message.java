package ua.artcode.model;

import java.time.LocalDateTime;

/**
 * Created by serhii on 9/25/16.
 */
public class Message {

    private String title;
    private String body;
    private String time;

    public Message(String title, String body) {
        this.title = title;
        this.body = body;
        LocalDateTime now = LocalDateTime.now();
        time = String.format("%s/%s/%s %s:%s",
                now.getYear(), now.getMonth(), now.getDayOfMonth(),
                now.getHour(), now.getMinute());
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Message{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", time=" + time +
                '}';
    }
}
