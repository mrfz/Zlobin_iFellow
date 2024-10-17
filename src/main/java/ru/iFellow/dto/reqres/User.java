package ru.iFellow.dto.reqres;

import lombok.Getter;
import lombok.Setter;

/**
 * Объект пользователя
 * @author Fedor Zlobin
 */
@Getter
@Setter
public class User {

    private String name;
    private String job;
    private String id;
    private String createdAt;

}
