package ru.iFellow.steps.reqres;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aeonbits.owner.ConfigCache;
import ru.iFellow.api.reqres.ReqResApi;
import ru.iFellow.dto.reqres.User;
import ru.iFellow.utils.Properties;

import java.io.File;
import java.io.IOException;

import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;

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
}
