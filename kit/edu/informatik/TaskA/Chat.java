package kit.edu.informatik.TaskA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author uxqcz
 * @version 1.0.0
 */

public class Chat implements Comparable<Chat> {
    private static final int MAX_NUM_OF_USER = 100;
    private static final int MAX_NUM_OF_MESSAGE = 1000;

    private static int countChat = 0;

    private String chatName;

    private final int chatId;

    private List<ChatMessage> messageList;

    private List<User> userList;

    /**
     * constructor for chat
     * @param chatName String value that is the name of the chat
     */

    public Chat(String chatName) {
        this.chatId = countChat++;
        this.chatName = chatName;
        this.messageList = new ArrayList<ChatMessage>();
        this.userList = new ArrayList<User>();
    }

    /**
     * getter for messageList
     * @return messageList
     */
    public List<ChatMessage> getMessageList() {
        return messageList;
    }

    /**
     * setter for messageList
     * @param messageList Sets messageList
     */
    public void setMessageList(List<ChatMessage> messageList) {
        this.messageList = messageList;
    }

    /**
     * getter for userList
     * @return userList
     */
    public List<User> getUserList() {
        return userList;
    }

    /**
     * setter for userList
     * @param userList
     */
    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    /**
     * getter for chatId
     * @return chatId
     */
    //no need for setter since the id doesn't change
    public int getChatId() {
        return chatId;
    }

    /**
     * getter for chatName
     * @return chatName
     */
    //no need for setter since the feature change chat name is no required
    public String getChatName() {
        return chatName;
    }

    /*public void setChatName(String chatName) {
        this.chatName = chatName;
    }*/

    /**
     * adds a user to userList
     * @param user a User to be added
     */
    public void addUser(User user) {
        if (userList.size() < MAX_NUM_OF_USER) {
            userList.add(user);
        }
    }

    /**
     * removes a user by a userId
     * @param userId an int
     */
    public void removeUser(int userId) {
        userList.removeIf(user -> user.getUserId() == userId);
    }

    /**
     * adds a message to messageList, if the messages reach MAX_NUM_OF_MESSAGES the oldest messages is deleted
     * @param message the ChatMessage to be added
     */
    public void commitMessage(ChatMessage message) {
        if (messageList.size() < MAX_NUM_OF_MESSAGE) {
            messageList.add(message);
        } else if (messageList.size() == MAX_NUM_OF_MESSAGE) {
            messageList.remove(0);
            messageList.add(message);
        }
    }

    /**
     * clears messageList of all content
     */
    public void clearChat() {
        messageList.clear();
    }

    /**
     * prints all messages in a specific format
     */
    public void listMessages() {
        Collections.sort(messageList);
        for (ChatMessage m: messageList
             ) {
            System.out.println(m.toString());
        }
    }

    @Override
    public String toString() {
        return this.chatId + ", " + this.chatName;
    }

    @Override
    public int compareTo(Chat other) {
        return this.chatId - other.getChatId();
    }
}
