
enum UserState {
    NEW,
    ACTIVE,
    BLOCKED,
    BANNED
}

public class webUser extends Customer {
    private String login_id;
    private String password;
    private UserState state;

    //Create webuser instance
    public webUser(Account c, String u, String p) {
        login_id = u;
        super.setId(u);
        password = p;
        state = UserState.NEW;
    }

    public void setActive() {
        state = UserState.ACTIVE;
    }

    public void setBlocked() {
        state = UserState.BLOCKED;
    }

    public void setBanned() {
        state = UserState.BANNED;
    }

    public UserState getState() {
        return state;
    }

    public String toString() {
        return "Web User " + login_id + " (State: " + state + ")";
    }
}
