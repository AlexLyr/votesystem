package com.spider.vote.utils.exceptions;


import org.springframework.http.HttpStatus;

public class UserVoteTooLateException extends ApplicationException {


    public UserVoteTooLateException(String msg) {
        super(ErrorType.DATA_ERROR, msg, HttpStatus.BAD_REQUEST);
    }
}
