package com.spider.vote.utils;


import com.spider.vote.domain.entity.Vote;
import com.spider.vote.to.UserVoteTo;

public class VoteUtil {
    public static UserVoteTo asToForAdmin(Vote userVote) {
        return new UserVoteTo(userVote.getId(), userVote.getDate(), userVote.getTime(), userVote.getRestaurant().getId(), userVote.getUser().getId());
    }
    public static UserVoteTo asToForUser(Vote userVote) {
        return new UserVoteTo(userVote.getId(), userVote.getDate(), userVote.getTime(), userVote.getRestaurant().getId(), null);
    }

    public static Vote createNewUserVoteFromTo(UserVoteTo userVoteTo) {
        return null;
    }
}
