import java.util.List;

public interface IUserService<UserModel> {
    void createUser(String i, String o);
    void updateUser(UserModel user);
    void deleteUser(int id);
    UserModel getUserById(int id);
    List<UserModel> getAllUsers();
}
