package app.studyjko;

import app.studyjko.data.user.UserDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.EnumMap;

@ToString
public final class UserSession {

    private static UserSession instance;

    @Getter
    @Setter
    private UserDto userDto;

    @Getter
    private final EnumMap<ParamKey, String> parameters = new EnumMap<>(ParamKey.class);

    private UserSession(UserDto userDto) {
        this.userDto = userDto;
    }

    public static void createSession(UserDto userDto){
        instance = new UserSession(userDto);
    }

    public static UserSession getInstance() throws RuntimeException {
        if(instance == null) {
            throw new RuntimeException("Sesja użytkownika została niezainicjalizowana");
        }
        return instance;
    }

    public void cleanUserSession() {
        userDto = null;
    }

}