package com.spider.vote.web;


import com.spider.vote.domain.entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Objects;

public class AuthorizedUser extends org.springframework.security.core.userdetails.User
 {

    private static final long serialVersionUID = 1L;

    private User user;

    public AuthorizedUser(User user) {
        super(user.getEmail(), user.getPassword(), true, true, true, true, user.getRoles());
        this.user = user;
    }

    public static AuthorizedUser  safeGet() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null) {
            return null;
        }
        Object principal = auth.getPrincipal();
        return (principal instanceof AuthorizedUser) ? (AuthorizedUser) principal : null;
    }

    public static AuthorizedUser get() {
        AuthorizedUser user = safeGet();
        Objects.requireNonNull(user, "No authorized user found");
        return user;
    }

    public int getId() {
        return user.getId();
    }

    public static int id() {
        return get().user.getId();
    }

    @Override
    public String toString() {
        return "AuthorizedUser{" +
                "user=" + user +
                '}';
    }
}

