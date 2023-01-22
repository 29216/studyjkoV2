package app.studyjko.data.user;

import app.studyjko.Utils.ConversionUtil;
import app.studyjko.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void save(UserDto userDto) {
        userRepository.save(mapDtoToEntity(userDto));
    }

    public UserDto logTheUserIn(String email, String password) {
        Optional<List<UserEntity>> userEntity = userRepository.findByEmail(email);
        if (userEntity.isPresent()) {
            List<UserEntity> users = userEntity.get();
            for (UserEntity user : users) {
                if (password.equals(user.getPassword()))
                    return mapEntityToDto(user);
            }

        }
        return null;

    }

    public boolean userExists(String email, String password) {
        Optional<List<UserEntity>> userEntities = userRepository.findByEmail(email);
        if (userEntities.isPresent()) {
            List<UserEntity> users = userEntities.get();
            return users.stream().anyMatch(user -> password.equals(user.getPassword()));
        }
        return false;
    }

    public UserEntity mapDtoToEntity(UserDto userDto) {
        return (UserEntity) ConversionUtil.mapObject(userDto, UserEntity.class);
    }

    public UserDto mapEntityToDto(UserEntity userEntity) {
        return (UserDto) ConversionUtil.mapObject(userEntity, UserDto.class);
    }

}
