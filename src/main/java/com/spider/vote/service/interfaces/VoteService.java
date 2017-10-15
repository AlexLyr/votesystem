package com.spider.vote.service.interfaces;


import com.spider.vote.domain.entity.Vote;
import com.spider.vote.to.UserVoteTo;

import java.time.LocalDate;

public interface VoteService {

    Vote saveVoteUser(UserVoteTo vote);

    Vote saveVoteAdmin(UserVoteTo vote);

    Vote getVoteForUserAndDate(int user_id, LocalDate date);

}
