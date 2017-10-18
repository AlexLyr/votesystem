package com.spider.vote.repository.testdata;

import com.spider.vote.domain.entity.Role;
import com.spider.vote.domain.entity.User;
import com.spider.vote.utils.json.JsonUtil;


import static com.spider.vote.domain.base.BaseEntity.START_SEQ;


public class UserTestData {

    public static final int USER_ID = START_SEQ;
    public static final int ADMIN_ID = START_SEQ + 1;

    public static final User USER = new User(USER_ID, "User", "user@yandex.ru", "user", Role.ROLE_USER);
    public static final User ADMIN = new User(ADMIN_ID, "Admin", "admin@gmail.com", "admin", Role.ROLE_ADMIN);
    public static User newUser=new User(null, "New User", "new_user@yandex.ru", "newuser", Role.ROLE_USER);
    public static final User UPDATED_USER=new User(USER_ID, "updatedUser", "updateduser@yandex.ru", "updateduser", Role.ROLE_USER);
    public static final String NEW_USER_JSON= JsonUtil.writeValue(newUser);
    public static final String UPD_USER_JSON= JsonUtil.writeValue(UPDATED_USER);

}
