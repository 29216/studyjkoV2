package app.studyjko.data.user;

import app.studyjko.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void save(UserDto userDto){
        userDto.setCreationTime(LocalDateTime.now());
        userRepository.save(mapDtoToEntity(userDto));
    }

    public UserDto logTheUserIn(String email, String password) {
        Optional<List<UserEntity>> userEntity = userRepository.findByEmail(email);
        if (userEntity.isPresent()) {
            List<UserEntity> users = userEntity.get();
            for (UserEntity user:users) {
                if (password.equals(user.getPassword()))
                    return mapEntityToDto(user);
            }

        }
        return null;

    }

    private UserEntity mapDtoToEntity(UserDto userDto){
        UserEntity user = new UserEntity();
        user.setEmail(userDto.getEmail());
        user.setCreationTime(userDto.getCreationTime());
        user.setName(userDto.getName());
        user.setModificationTime(LocalDateTime.now());
        user.setPassword(userDto.getPassword());
        user.setSystemRole(userDto.getSystemRole());
        user.setPosition(userDto.getPosition());
        user.setSurname(userDto.getSurname());
        return user;
    }

    private UserDto mapEntityToDto(UserEntity userEntity){
        UserDto user = new UserDto();
        user.setEmail(userEntity.getEmail());
        user.setCreationTime(userEntity.getCreationTime());
        user.setName(userEntity.getName());
        user.setModificationTime(LocalDateTime.now());
        user.setPassword(userEntity.getPassword());
        user.setSystemRole(userEntity.getSystemRole());
        user.setPosition(userEntity.getPosition());
        user.setSurname(userEntity.getSurname());
        return user;
    }

}
