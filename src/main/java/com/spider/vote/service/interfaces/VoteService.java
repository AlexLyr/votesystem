package com.spider.vote.service.interfaces;


import com.spider.vote.domain.entity.Vote;
import com.spider.vote.to.UserVoteTo;
import com.spider.vote.utils.exceptions.NotFoundException;
import com.spider.vote.utils.exceptions.UserVoteForThisDayAlreadyExistsException;

import java.time.LocalDate;
import java.util.List;

public interface VoteService {


    Vote saveVote(UserVoteTo vote,int userId);

    UserVoteTo getVoteForUserAndDate(int user_id, LocalDate date);

    Vote changeVote(UserVoteTo vote,int userId);

    List<Vote> getFilteredByUser(int userId) throws NotFoundException;

    List<Vote> getFilteredByDate(LocalDate date);

    List<Vote> getFilteredByRestaurantName(String name);

    List<Vote> getForToday();

    List<Vote> getSortedByDate(String order);

    void checkIfUserVoteForTodayAlreadyExists(int userId) throws UserVoteForThisDayAlreadyExistsException;

    Vote getForUserToday(int user_id);
}
