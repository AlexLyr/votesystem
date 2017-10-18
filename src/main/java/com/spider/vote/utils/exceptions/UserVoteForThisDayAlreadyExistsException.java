package com.spider.vote.utils.exceptions;

public class UserVoteForThisDayAlreadyExistsException extends RuntimeException {
    public UserVoteForThisDayAlreadyExistsException(String message) {
        super(message);
    }
}
