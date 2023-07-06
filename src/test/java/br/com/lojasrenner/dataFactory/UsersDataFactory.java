package br.com.lojasrenner.dataFactory;

import java.io.FileInputStream;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;
import br.com.lojasrenner.pojo.UsersPojo;

public class UsersDataFactory {

    private static UsersPojo createUsers() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        UsersPojo usersPojo = objectMapper.readValue(new FileInputStream("src/main/resources/requestBody/users.json"),
                UsersPojo.class);

        return usersPojo;
    }

    public static UsersPojo createUserSuccessfully() throws IOException {
        UsersPojo createUser = createUsers();
        return createUser;
    }

    public static UsersPojo changeUserSuccessfully() throws IOException {
        UsersPojo changeUser = createUsers();
        changeUser.setName("Ricardo de Souza");
        changeUser.setJob("Developed");
        return changeUser;
    }
}
