package api.entities;

public record User(Integer id, String userName, String firstName, String lastName, String email, String password,
                   String phone, Integer userStatus) {
}
