package ru.iFellow.steps.reqres;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigCache;
import ru.iFellow.api.reqres.ReqResApi;
import ru.iFellow.dto.reqres.User;
import ru.iFellow.utils.Properties;

import java.io.File;
import java.io.IOException;

import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReqResSteps {

    private final ReqResApi API = new ReqResApi();
    private final ObjectMapper objectMapper = new ObjectMapper();

    private final Properties props = ConfigCache.getOrCreate(Properties.class);


    public User createUserFromFile(String path) throws IOException {

        File jsonFile = new File(path);
        User user = objectMapper.readValue(jsonFile, User.class);
        user.setName(props.reqresUserName());
        user.setJob(props.reqresUserJob());
    return    API.postUser(user)
                .statusCode(anyOf(is(200), is(201)))
                .extract()
                .body()
        .as(User.class);
    }

    @Step("Создаем пользователя из файла {path}")
    public User createUserFromFileStep(String path) throws IOException {
        File jsonFile = new File(path);
        return objectMapper.readValue(jsonFile, User.class);
    }

    @Step("Обновляем имя и работу пользователя ")
    public User updateUserStep(User user, String name, String job) {
        user.setName(name);
        user.setJob(job);
        return user;
    }


    public User postUser(User user) {
        return API.postUser(user)
                .statusCode(anyOf(is(200), is(201)))
                .extract()
                .body()
                .as(User.class);
    }

    @Step("Проверяем имя пользователя {firstUser}")
    public void checkUserName(User firstUser, User secondUser) {
        assertEquals(firstUser.getName(), secondUser.getName());
    }

    @Step("Проверяем работу пользователя {firstUser}")
    public void checkUserJob(User firstUser, User secondUser) {
        assertEquals(firstUser.getJob(), secondUser.getJob());
    }

}
