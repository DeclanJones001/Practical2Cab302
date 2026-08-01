import java.util.ArrayList;
import java.util.Objects;

public class AuthenticationService implements IAuthenticationService {
    private ArrayList<User> users;

    AuthenticationService(ArrayList<User> users) {
        this.users = users;
    }

    @Override
    public User signUp(String username, String password) {
        for (User user : users) {
            if (Objects.equals(username, user.getUsername()))
                return null;
        }

        User newUser = new User(username + "123", password);
        users.add(newUser);
        return newUser;
    }

    @Override
    public User logIn(String username, String password) {
        for (User user : users) {
            if (Objects.equals(username, user.getUsername()) &&
                    Objects.equals(password, user.getPassword()))
                return user;
        }
        return null;
    }
}