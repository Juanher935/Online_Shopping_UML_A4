
enum UserState {
    NEW,
    ACTIVE,
    BLOCKED,
    BANNED
}

public class webUser {
    ID login_id;
    String password;
    UserState state;
}
