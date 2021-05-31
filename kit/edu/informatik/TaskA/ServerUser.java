package kit.edu.informatik.TaskA;

/**
 * @author uxqcz
 * @version 1.0.0
 */
public class ServerUser implements Comparable<ServerUser> {
    /**
     * the user that joined the server
     */
    public final User user;
    private Role role;
    private Status serverStatus;

    /**
     * the constructor of ServerUser
     * @param user
     */
    ServerUser(User user) {
        this.user = user;
        this.role = Role.USER;
        this.serverStatus = user.getStatus();
    }

    /**
     * getter for the role on the server
     * @return role as Role
     */
    public Role getRole() {
        return role;
    }

    /**
     * setter for the role on the server
     * @param role the role
     */
    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * getter for server status
     * @return serverStatus
     */
    public Status getServerStatus() {
        return serverStatus;
    }

    /**
     * setter for server status
     * @param newServerStatus
     */
    public void setServerStatus(Status newServerStatus) {
        this.serverStatus = newServerStatus;
    }

    @Override
    public String toString() {
        return "[" + this.serverStatus.getOnlineStatus().name() + "," + this.role.name() + "]"
                + this.user.getUserName() + "(" + this.user.getUserId() + ")"
                + ": " + this.user.getStatusMessage();
    }

    @Override
    public int compareTo(ServerUser serverUser) {
        return this.user.getUserId() - serverUser.user.getUserId();
    }
}
