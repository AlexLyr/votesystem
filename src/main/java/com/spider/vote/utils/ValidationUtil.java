package com.spider.vote.utils;

import com.spider.vote.domain.entity.Vote;
import com.spider.vote.to.UserVoteTo;
import com.spider.vote.utils.exceptions.NotFoundException;
import com.spider.vote.utils.exceptions.UserVoteIncorrectDateException;
import com.spider.vote.utils.exceptions.UserVoteTooLateException;
import com.spider.vote.web.HasId;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class ValidationUtil {

    private ValidationUtil() {

    }

    public static void checkNotFoundWithId(boolean found, int id) {
        checkNotFound(found, "id=" + id);
    }

    public static <T> T checkNotFoundWithId(T object, int id) {
        return checkNotFound(object, "id=" + id);
    }

    public static <T> T checkNotFound(T object, String msg) {
        checkNotFound(object != null, msg);
        return object;
    }

    public static void checkNotFound(boolean found, String msg) {
        if (!found) {
            throw new NotFoundException("Not found entity with " + msg);
        }
    }

    public static <T> T checkNotFoundForToday(T object, String msg) {
        if (object == null) {
            throw new NotFoundException(msg);
        }
        return object;
    }

    public static void checkNew(HasId bean) {
        if (!(bean.getId() == null)) {
            throw new IllegalArgumentException(bean + " must be new (id=null)");
        }
    }

    public static void checkIdConsistent(HasId bean, int id) {
//      http://stackoverflow.com/a/32728226/548473
        if ((bean.getId() == null)) {
            bean.setId(id);
        } else if (bean.getId() != id) {
            throw new IllegalArgumentException(bean + " must be with id=" + id);
        }
    }


    public static Throwable getRootCause(Throwable t) {
        Throwable result = t;
        Throwable cause;

        while (null != (cause = result.getCause()) && (result != cause)) {
            result = cause;
        }
        return result;
    }

    public static List<Vote> checkUserVotesFiltered(List<Vote> userVotes, String msg) {
        if (CollectionUtils.isEmpty(userVotes)) {
            throw new NotFoundException(msg);
        }
        return userVotes;
    }

    public static void checkDateConsistent(UserVoteTo userVote) {
        if (userVote.getDateTime().toLocalDate() == null) {
            userVote.setDateTime(LocalDateTime.now());
        } else if (!userVote.getDateTime().toLocalDate().isEqual(LocalDate.now())) {
            throw new UserVoteIncorrectDateException(userVote + " must be with date=" + LocalDate.now());
        }
    }

    public static void checkTimeConsistentForSave(UserVoteTo userVote) {
        if (userVote.getDateTime().toLocalTime() == null) {
            LocalDateTime now = LocalDateTime.now();
            if (now.toLocalTime().isAfter(LocalTime.of(11, 0))) {
                throw new UserVoteTooLateException("It is too late, user vote can't be created");
            }
            userVote.setDateTime(now);;
        }
    }

    public static void checkTimeConsistentForUpdate(UserVoteTo userVote) {
        if (userVote.getDateTime().toLocalTime() == null) {
            userVote.setDateTime(LocalDateTime.now());
        }
        if (userVote.getDateTime().toLocalTime().isAfter(LocalTime.of(11, 0))) {
            throw new UserVoteTooLateException("It is too late, vote can't be changed");
        }
    }

}
