package ru.iFellow.steps.reqres;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Затем;
import io.cucumber.java.ru.Тогда;
import org.aeonbits.owner.ConfigCache;
import ru.iFellow.dto.reqres.User;
import ru.iFellow.utils.Properties;

import java.io.IOException;

public class ReqResCucumberSteps {

    private final ReqResSteps reqResSteps = new ReqResSteps();

    private final Properties props = ConfigCache.getOrCreate(Properties.class);

    User user = new User();
    User createdUser = new User();


    @Дано("Создается новый пользователь из файла")
    public void createNewUserFromFile() throws IOException {
        this.user = reqResSteps.createUserFromFileStep(props.reqresJsonPath());
    }


    @Затем("Обновляем имя и работу пользователя")
    public void updateUser() {
        this.user = reqResSteps.updateUserStep(this.user, props.reqresUserName(), props.reqresUserJob());
    }


    @Тогда("Отправляем запрос на создание пользователя")
    public void sendPostRequest() {
        this.createdUser = reqResSteps.postUser(this.user);
    }

    @Затем("Проверяем имя и работу созданного пользователя")
    public void checkCreatedUser() {
        reqResSteps.checkUserName(this.createdUser.getName(), this.user.getName());
        reqResSteps.checkUserJob(this.createdUser.getJob(), this.user.getJob());
    }
}
