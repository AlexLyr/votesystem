package com.spider.vote.service.interfaces;


import com.spider.vote.domain.entity.Vote;
import com.spider.vote.to.UserVoteTo;

import java.time.LocalDate;

public interface VoteService {


    Vote saveVote(UserVoteTo vote);

    UserVoteTo getVoteForUserAndDate(int user_id, LocalDate date);

    Vote changeVote(UserVoteTo vote);

}
