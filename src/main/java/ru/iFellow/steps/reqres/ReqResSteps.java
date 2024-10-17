package ru.iFellow.steps.reqres;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Step;
import ru.iFellow.api.reqres.ReqResApi;
import ru.iFellow.dto.reqres.User;

import java.io.File;
import java.io.IOException;

import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReqResSteps {

    private final ReqResApi API = new ReqResApi();
    private final ObjectMapper objectMapper = new ObjectMapper();

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

    @Step("Проверяем имя пользователя созданного пользователя")
    public void checkUserName(String firstUserName, String secondUserName) {
        assertEquals(firstUserName, secondUserName);
    }

    @Step("Проверяем работу пользователя созданного пользователя")
    public void checkUserJob(String firstUserJob, String secondUserJob) {
        assertEquals(firstUserJob, secondUserJob);
    }

}
