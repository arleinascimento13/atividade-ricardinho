package repository;

import models.StatusUser;
import models.UserModel;

import java.util.ArrayList;

public class UserRepository implements IRepository<UserModel> {
    ArrayList<UserModel> repository = new ArrayList();

    @Override
    public UserModel post(UserModel userModel) {
        repository.add(userModel);
        return userModel;
    }

    @Override
    public void delete(int id) {
        UserModel user = getById(id);
        if (user != null) {
            user.setStatus(StatusUser.DEACTIVATED);
        }
    }

    @Override
    public void put(UserModel userModel) {
        UserModel existingUser = getById(userModel.getId());
        if (existingUser != null) {
            int index = repository.indexOf(existingUser);
            repository.set(index, userModel);
        }
    }

    @Override
    public UserModel getById(int i) {
        for (UserModel user : repository) {
            if (user.getId() == i) {
                return user;
            }
        }
        return null;
    }

    @Override
    public ArrayList<UserModel> getAll() {
        return repository;
    }
}
