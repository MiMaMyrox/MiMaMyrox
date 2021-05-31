package kit.edu.informatik.TaskA;

/**
 * @author uxqcz
 * @version 1.0.0
 */
public class Status {
    private OnlineStatus onlineStatus;

    /**
     * constructor for the online status
     * @param onlineStatus
     */
    public Status(OnlineStatus onlineStatus) {
        this.onlineStatus = onlineStatus;
    }

    /**
     * getter for online status
     * @return onlineStatus
     */
    public OnlineStatus getOnlineStatus() {
        return onlineStatus;
    }

    /**
     * setter for online status
     * @param onlineStatus
     */
    public void setOnlineStatus(OnlineStatus onlineStatus) {
        this.onlineStatus = onlineStatus;
    }
}
