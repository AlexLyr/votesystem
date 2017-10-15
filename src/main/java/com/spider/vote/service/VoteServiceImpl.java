package com.spider.vote.service;


import com.spider.vote.domain.entity.Vote;
import com.spider.vote.repository.VoteRepository;
import com.spider.vote.service.interfaces.VoteService;
import com.spider.vote.to.UserVoteTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static com.spider.vote.utils.VoteUtil.*;

import java.time.LocalDate;

@Service
public class VoteServiceImpl implements VoteService {

    @Autowired
    private VoteRepository repository;


    @Override
    public Vote saveVoteUser(UserVoteTo voteTo) {
        return null;
    }

    @Override
    public Vote saveVoteAdmin(UserVoteTo vote) {
        return null;
    }

    @Override
    public Vote getVoteForUserAndDate(int user_id, LocalDate date) {
        return null;
    }
}
