package kit.edu.informatik.TaskA;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author uxqcz
 * @version 1.0.0
 */
public class Server {

    private static final int MAX_NUM_OF_USERS = 100;
    private static final int MAX_NUM_OF_CHATS = 20;

    private static int countServer = 0;

    private String serverName;
    private final int serverId;

    private final LocalDateTime creationTime;

    private List<Chat> chatList;
    private List<ServerUser> serverUserList;

    /**
     * Server constructor
     * @param serverName the String for the server name
     * @param creationTime the time and date of creation
     */
    public Server(String serverName, LocalDateTime creationTime) {
        this.serverName = serverName;
        this.creationTime = creationTime;
        this.serverId = countServer++;
        this.serverUserList = new ArrayList<ServerUser>();
        this.chatList = new ArrayList<Chat>();
    }

    /**
     * getter for serverUserList
     * @return serverUserList
     */
    public List<ServerUser> getServerUserList() {
        return serverUserList;
    }

    /**
     * setter for serverUserList
     * @param serverUserList list of server user
     */
    public void setServerUserList(List<ServerUser> serverUserList) {
        this.serverUserList = serverUserList;
    }

    /**
     * getter for chatList
     * @return chatList
     */
    public List<Chat> getChatList() {
        return chatList;
    }

    /**
     * setter for chatList
     * @param chatList list of all chats
     */
    public void setChatList(List<Chat> chatList) {
        this.chatList = chatList;
    }

    /**
     * getter for creationTime
     * @return creationTime as LocalDateTime
     */
    //no need for setter since the creation time doesn't change
    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    /**
     * getter for the serverId
     * @return severId as integer
     */
    //no need for setter since the server id doesn't change
    public int getServerId() {
        return serverId;
    }

    /**
     * getter for serverName
     * @return serverName as String
     */
    public String getServerName() {
        return serverName;
    }

    //no need for setter since the server name doesn't change
    /*public void setServerName(String serverName) {
        this.serverName = serverName;
    }*/

    /**
     * adds a user to serverUserList only if MAX_NUM_OF_USERS is not reached yet
     * @param user the user added to the list
     */
    public void addUser(User user) {
        if (serverUserList.size() < MAX_NUM_OF_USERS) {
            serverUserList.add(new ServerUser(user));
        }
    }

    /**
     * removes a user with a given id from the severUserList
     * @param id the id to remove the user
     */
    public void removeUser(int id) {
        serverUserList.removeIf(serverUser -> serverUser.user.getUserId() == id);
    }

    /**
     * creates and adds a chat to serverUserList and adds all users to the chat
     * @param name of the chat as String
     */
    public void addChat(String name) {
        if (chatList.size() < MAX_NUM_OF_CHATS) {
            Chat chat = new Chat(name);
            chatList.add(chat);
            for (ServerUser su: serverUserList
                 ) {
                chat.addUser(su.user);
            }
        }
    }

    /**
     * removes a chat with a given id
     * @param id as an integer
     */
    public void removeChat(int id) {
        chatList.removeIf(chat ->chat.getChatId() == id);
    }

    /**
     * adds a message to a given chatId
     * @param chadId id of the chat to add the message to
     * @param message the message to be added
     */
    public void commitMessage(int chadId, ChatMessage message) {
        for (Chat chat: chatList
             ) {
            if (chat.getChatId() == chadId) {
                chat.commitMessage(message);
            }
        }
    }

    /**
     * prints all users in a specific format
     */
    public void listUsers() {
        Collections.sort(serverUserList);
        System.out.println("# Users=" + serverUserList.size());
        for (ServerUser su: serverUserList
        ) {
            System.out.println(su.toString());
        }
    }

    /**
     * prints all chats in a specific format
     */
    public void listChats() {
        Collections.sort(chatList);
        System.out.println("# Chats=" + chatList.size());
        for (Chat c:chatList
             ) {
            System.out.println(c.toString());
        }
    }

    /**
     * changes the role of a given user
     * @param userId the id
     * @param newRole the Role
     */
    public void changeUserRole(int userId, Role newRole) {
        for (ServerUser su: serverUserList
             ) {
            if (su.user.getUserId() == userId) {
                su.setRole(newRole);
            }
        }
    }

    @Override
    public String toString() {
        return serverId + ", " + serverName;
    }
}
