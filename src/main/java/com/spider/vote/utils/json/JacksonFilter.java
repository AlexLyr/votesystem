package com.spider.vote.utils.json;


import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.PropertyWriter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.spider.vote.domain.entity.Role;
import org.springframework.security.core.context.SecurityContextHolder;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class JacksonFilter {
    @Retention(value = RetentionPolicy.RUNTIME)
    public static @interface Admin {
    }

    public static class AdminPropertyFilter extends SimpleBeanPropertyFilter {

        @Override
        protected boolean include(BeanPropertyWriter writer) {
            return true;
        }

        @Override
        protected boolean include(PropertyWriter writer) {
            if (writer instanceof BeanPropertyWriter) {
                if (SecurityContextHolder.getContext().getAuthentication().getAuthorities().contains(Role.ROLE_ADMIN))
                {
                    return true;
                }
                else {
                    return ((BeanPropertyWriter) writer).getAnnotation(Admin.class) == null;
                }
            }
            return true;
        }
    }
}
