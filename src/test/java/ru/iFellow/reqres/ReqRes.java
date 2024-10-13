package ru.iFellow.reqres;

import org.aeonbits.owner.ConfigCache;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.iFellow.api.reqres.ReqResApi;
import ru.iFellow.dto.reqres.User;
import ru.iFellow.steps.reqres.ReqResSteps;
import ru.iFellow.utils.Properties;

import java.io.IOException;

import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;



public class ReqRes {

    Properties props  = ConfigCache.getOrCreate(Properties.class);
    private final ReqResSteps steps = new ReqResSteps();
    private final ReqResApi api = new ReqResApi();


    @Test
    @DisplayName("Проверка пост запроса создания пользователя")
    public void postUserTest() {
        User newUser = new User();
        newUser.setName(props.reqresUserName());
        newUser.setJob(props.reqresUserJob());

                api.postUser(newUser)
                        .statusCode(anyOf(is(200), is(201)))
                        .body("name", is(props.reqresUserName()))
                        .body("job", is(props.reqresUserJob()))
                ;
    }

    @Test
    @DisplayName("Проверка создания пользователя из файла")
    public void createUserFromFileTest() throws IOException {
        User newUser = steps.createUserFromFile(props.reqresJsonPath());
        assertEquals(newUser.getName(), props.reqresUserName());
        assertEquals(newUser.getJob(), props.reqresUserJob());
    }
}
