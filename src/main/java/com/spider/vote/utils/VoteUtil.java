package com.spider.vote.utils;



import com.spider.vote.domain.entity.Vote;
import com.spider.vote.to.UserVoteTo;

import java.util.List;
import java.util.stream.Collectors;

public class VoteUtil {


    public static UserVoteTo createToFromVote(Vote vote){
        return new UserVoteTo(vote.getId(),vote.getDate().atStartOfDay(),vote.getRestaurant(),vote.getUser());
    }

    public static Vote createNewUserVoteFromTo(UserVoteTo userVoteTo) {
        if(userVoteTo.getId()==null) {
            return new Vote(userVoteTo.getUser(), userVoteTo.getChosenRestaurant(), userVoteTo.getDateTime().toLocalDate());
        }
        else return new Vote(userVoteTo.getId(), userVoteTo.getUser(), userVoteTo.getChosenRestaurant(), userVoteTo.getDateTime().toLocalDate());
    }

    public static List<UserVoteTo> asToList(List<Vote> userVoteList) {
        return userVoteList.stream()
                .map(VoteUtil::createToFromVote)
                .collect(Collectors.toList());
    }
}
