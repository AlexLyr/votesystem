package com.spider.vote.utils.exceptions;

import org.springframework.http.HttpStatus;

public class UserVoteIncorrectDateException extends ApplicationException {

    public UserVoteIncorrectDateException(String msg) {
        super(ErrorType.DATA_ERROR, msg, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
