package kit.edu.informatik.TaskA;

import java.time.LocalDateTime;

/**
 * @author uxqcz
 * @version 1.0.0
 */
public class ChatMessage implements Comparable<ChatMessage> {
    private final String content;
    private final User author;
    private final LocalDateTime localDateTime;

    /**
     * Constructor for ChatMessage
     * @param content String
     * @param user User
     * @param localDateTime date and time
     */
    public ChatMessage(String content, User user, LocalDateTime localDateTime) {
        this.content = content;
        this.author = user;
        this.localDateTime = localDateTime;
    }

    /**
     * getter for the content
     * @return content as String
     */
    //no setter needed since the content doesn't change
    public String getContent() {
        return content;
    }

    /**
     * returns the author of the chat message as a User
     * @return author as user
     */
    //no setter needed since the author doesn't change
    public User getAuthor() {
        return author;
    }

    /**
     * getter for localDateTime
     * @return the date and time
     */
    //no setter needed since the date and time doesn't change
    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    @Override
    public String toString() {
        return this.author.getUserName() + "[" + this.localDateTime.toString() + "]:" + this.content;
    }

    @Override
    public int compareTo(ChatMessage message) {
        return (this.localDateTime).compareTo(message.getLocalDateTime());
    }
}
