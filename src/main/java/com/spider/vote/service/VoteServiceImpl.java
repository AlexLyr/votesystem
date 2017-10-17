package com.spider.vote.service;


import com.spider.vote.domain.entity.Vote;
import com.spider.vote.repository.VoteRepository;
import com.spider.vote.service.interfaces.VoteService;
import com.spider.vote.to.UserVoteTo;
import com.spider.vote.utils.exceptions.UserVoteTooLateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import static com.spider.vote.utils.VoteUtil.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class VoteServiceImpl implements VoteService {
    private static final LocalTime MAX_VOTE_TIME = LocalTime.of(10, 0);

    @Autowired
    private VoteRepository repository;


    @Override
    public Vote saveVote(UserVoteTo voteTo) {
        Assert.notNull(voteTo, "vote must be not null");
        if (voteTo.getDateTime().toLocalTime().isAfter(MAX_VOTE_TIME)) {
            throw new UserVoteTooLateException("the time is after 11 a.m");
        }
        Vote vote = createNewUserVoteFromTo(voteTo);
        return repository.saveVote(vote);
    }

    @Override
    public Vote changeVote(UserVoteTo voteTo) {
        Assert.notNull(voteTo, "vote must be not null");
        if (voteTo.getDateTime().toLocalTime().isAfter(MAX_VOTE_TIME)) {
            throw new UserVoteTooLateException("the time is after 11 a.m");
        }
        Vote vote = createNewUserVoteFromTo(voteTo);
        return repository.saveVote(vote);
    }

    @Override
    public UserVoteTo getVoteForUserAndDate(int user_id, LocalDate date) {
        return createToFromVote(repository.getVoteForUserAndDate(user_id,date));
    }
}
