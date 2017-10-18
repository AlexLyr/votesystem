package com.spider.vote.repository;


import com.spider.vote.domain.entity.Vote;
import com.spider.vote.service.interfaces.VoteService;
import com.spider.vote.utils.exceptions.UserVoteTooLateException;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static com.spider.vote.repository.testdata.UserTestData.ADMIN_ID;
import static com.spider.vote.repository.testdata.UserTestData.USER_ID;
import static com.spider.vote.repository.testdata.VoteTestData.VOTE_TO_ADMIN;
import static com.spider.vote.repository.testdata.VoteTestData.VOTE_TO_ADMIN_UPD;
import static com.spider.vote.repository.testdata.VoteTestData.VOTE_TO_ADMIN_UPD_LATE;
import static com.spider.vote.utils.VoteUtil.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class VoteServiceTest extends AbstractTestClass{

    @Autowired
    private VoteService service;

    @Test
    public void testChangeVote(){
        service.saveVote(VOTE_TO_ADMIN,ADMIN_ID);
        service.saveVote(VOTE_TO_ADMIN_UPD,ADMIN_ID);
        Vote vote=createNewUserVoteFromTo(service.getVoteForUserAndDate(ADMIN_ID,LocalDate.of(2017,10,23)));
        System.out.println(vote);
    }

    @Test
    public void testSaveAndGetForUserAndDate(){
        service.saveVote(VOTE_TO_ADMIN,ADMIN_ID);
        Vote vote=createNewUserVoteFromTo(service.getVoteForUserAndDate(ADMIN_ID,LocalDate.of(2017,10,23)));
        System.out.println(vote);
    }

    @Test
    public void testTooLate(){
        service.saveVote(VOTE_TO_ADMIN,ADMIN_ID);
        thrown.expect(UserVoteTooLateException.class);
        service.saveVote(VOTE_TO_ADMIN_UPD_LATE,ADMIN_ID);

    }





}
