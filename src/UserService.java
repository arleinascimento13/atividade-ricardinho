import java.util.List;

public class UserService implements IUserService<UserModel> {
    private final UserRepository userRepository = new UserRepository();

    @Override
    public void createUser(String name, String email) {
        UserModel user = userRepository.post(new UserModel(name, email));
        System.out.println("user created. ID: " + user.getId());
    }

    @Override
    public void updateUser(UserModel user) {
        UserModel existing = userRepository.getById(user.getId());
        if (existing == null) {
            System.out.println("Erro: Usuário com ID " + user.getId() + " não encontrado.");
            return;
        }
        userRepository.put(user);
        System.out.println("Usuário com ID " + user.getId() + " atualizado.");
    }

    @Override
    public void deleteUser(int id) {
        UserModel existing = userRepository.getById(id);
        if (existing == null) {
            System.out.println("Erro: Usuário com ID " + id + " não encontrado.");
            return;
        }
        userRepository.delete(id);
        System.out.println("Usuário com ID " + id + " deletado.");
    }

    @Override
    public UserModel getUserById(int id) {
        UserModel user = userRepository.getById(id);
        if (user == null) {
            System.out.println("Aviso: Usuário com ID " + id + " não encontrado.");
        }
        return user;
    }

    @Override
    public List<UserModel> getAllUsers() {
        return userRepository.getAll();
    }
}
