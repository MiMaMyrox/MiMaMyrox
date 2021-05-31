package kit.edu.informatik.TaskA;

import java.time.LocalDateTime;

/**
 * @author uxqcz
 * @version 1.0.0
 */
public class ChatPlatform {
    /**
     * the main method
     * @param args
     */
    public static void main(String[] args) {
        Server teaPot = new Server("TeaPot", LocalDateTime.of(2020, 1, 1, 12, 0));
        for (int i = 0; i < 33; i++) {
            new User("Sid");
        }
        User tommy = new User("Tommy");

        teaPot.addUser(tommy);

        tommy.setOnlineStatus(OnlineStatus.ONLINE);

        teaPot.changeUserRole(tommy.getUserId(), Role.ADMIN);

        teaPot.listUsers();

        tommy.setStatusMessage("Ich bin jetzt bereit!");

        teaPot.addChat("General");

        User bobby = new User("Bobby");

        teaPot.addUser(bobby);

        teaPot.commitMessage(0, new ChatMessage("Hallo ich bin Bobby", bobby, LocalDateTime.of(2020, 1, 1, 13, 0)));
        teaPot.commitMessage(0, new ChatMessage("Hallo ich bin Tommy", tommy, LocalDateTime.of(2020, 1, 1, 14, 0)));
        teaPot.listChats();
        teaPot.getChatList().get(0).listMessages();
        teaPot.changeUserRole(bobby.getUserId(), Role.MODERATOR);
        teaPot.listUsers();
        teaPot.removeUser(bobby.getUserId());
    }
}
