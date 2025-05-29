package models;

import java.util.UUID;

public class UserModel {
    private final int id;
    private String name;
    private String email;
    private StatusUser status;

    public UserModel(String name, String email) {
        this.id = generateRandomId();
        this.name = name;
        this.email = email;
        this.status = StatusUser.ACTIVE;
    }

    public UserModel() {
        this.id = generateRandomId();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public StatusUser getStatus() {
        return status;
    }

    public void setStatus(StatusUser status) {
        this.status = status;
    }

    private int generateRandomId() {
        String uuid = UUID.randomUUID().toString();
        String numericUuid = uuid.replaceAll("[^0-9]", "");
        String idString = numericUuid.substring(0, 5); // 12 dígitos
        return Integer.parseInt(idString);
    }
}
