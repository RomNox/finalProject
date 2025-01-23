package models;

public class UserData {
    private String email;   // Email пользователя
    private String password; // Пароль пользователя
    private String role;     // Роль пользователя ("admin" или "user")

    // Конструктор
    public UserData(String email, String password, String role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    // Геттеры для доступа к полям
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    // Перегрузка метода toString для удобного отображения объекта
    @Override
    public String toString() {
        return "UserData{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
