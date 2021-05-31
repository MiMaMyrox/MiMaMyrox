package kit.edu.informatik.TaskA;

/**
 * @author uxqcz
 * @version 1.0.0
 */
public class User {
    private static int countUser = 0;
    private String userName;
    private String statusMessage;
    private final int userId;
    private Status status;

    /**
     * constructor for user
     * @param userName
     */
    public User(String userName) {
        this.userName = userName;
        this.userId = countUser++;
        this.statusMessage = "";
        this.status = new Status(OnlineStatus.OFFLINE);
    }

    /**
     * getter for the status
     * @return status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * setter for status
     * @param status
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * getter for user id
     * @return userId as integer
     */
    //the user Id doesn't change so no setter needed
    public int getUserId() {
        return userId;
    }

    /**
     * getter for username
     * @return userName
     */
    public String getUserName() {
        return userName;
    }

    //not needed as long as the change userName feature isn't needed
    /*public void setUserName(String userName) {
        this.userName = userName;
    }*/

    /**
     * getter for status message
     * @return status message
     */
    public String getStatusMessage() {
        return statusMessage;
    }

    /**
     * setter for status message
     * @param statusMessage
     */
    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    /**
     * getter for online status
     * @return online status
     */
    public OnlineStatus getOnlineStatus() {
        return status.getOnlineStatus();
    }

    /**
     * setter for online status
     * @param onlineStatus
     */
    public void setOnlineStatus(OnlineStatus onlineStatus) {
        this.status.setOnlineStatus(onlineStatus);
    }

    /**
     * changes the updateStatusMessage
     * @param message
     */
    public void updateStatusMessage(String message) {
        setStatusMessage(message);
    }

    @Override
    public String toString() {
        return "[" + this.status.getOnlineStatus().name() + "]"
                + this.userName
                + "(" + this.userId + ")"
                + ":" + this.statusMessage;
    }
}
