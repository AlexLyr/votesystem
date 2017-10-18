package com.spider.vote.service;


import com.spider.vote.domain.entity.Vote;
import com.spider.vote.repository.UserRepository;
import com.spider.vote.repository.VoteRepository;
import com.spider.vote.service.interfaces.VoteService;
import com.spider.vote.to.UserVoteTo;
import com.spider.vote.utils.exceptions.NotFoundException;
import com.spider.vote.utils.exceptions.UserVoteForThisDayAlreadyExistsException;
import com.spider.vote.utils.exceptions.UserVoteTooLateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import static com.spider.vote.utils.ValidationUtil.checkNotFoundForToday;
import static com.spider.vote.utils.ValidationUtil.checkUserVotesFiltered;
import static com.spider.vote.utils.VoteUtil.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class VoteServiceImpl implements VoteService {
    private static final LocalTime MAX_VOTE_TIME = LocalTime.of(10, 0);

    @Autowired
    private VoteRepository repository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Vote saveVote(UserVoteTo voteTo,int user_id) {
        Assert.notNull(voteTo, "vote must be not null");
        if (voteTo.getDateTime().toLocalTime().isAfter(MAX_VOTE_TIME)) {
            throw new UserVoteTooLateException("the time is after 11 a.m");
        }
        Vote vote = createNewUserVoteFromTo(voteTo);
        vote.setUser(userRepository.getUserById(user_id));
        return repository.saveVote(vote);
    }

    @Override
    public Vote changeVote(UserVoteTo voteTo, int user_id) {
        Assert.notNull(voteTo, "vote must be not null");
        if (voteTo.getDateTime().toLocalTime().isAfter(MAX_VOTE_TIME)) {
            throw new UserVoteTooLateException("the time is after 11 a.m");
        }
        Vote vote = createNewUserVoteFromTo(voteTo);
        if(vote.getUser().getId()!=user_id){
            throw  new NotFoundException("access denied");
        }
        return repository.saveVote(vote);
    }

    @Override
    public UserVoteTo getVoteForUserAndDate(int user_id, LocalDate date) {
        return createToFromVote(repository.getVoteForUserAndDate(user_id, date));
    }

    @Override
    public List<Vote> getFilteredByUser(int userId) throws NotFoundException {
        return checkUserVotesFiltered(repository.getFilteredByUser(userId),
                "Not found user votes for user with id=" + userId);
    }

    @Override
    public List<Vote> getFilteredByDate(LocalDate date) {
        return checkUserVotesFiltered(repository.getFilteredByDate(date),
                "Not found votes for date " + date);
    }

    @Override
    public List<Vote> getFilteredByRestaurantName(String name) {
        return checkUserVotesFiltered(repository.getFilteredByRestaurantName(name),
                "Not found user votes for restaurant with name=" + name);
    }

    @Override
    public List<Vote> getForToday() {
        return checkNotFoundForToday(repository.getForToday(),
                "There is no vote for today");
    }

    @Override
    public List<Vote> getSortedByDate(String order) {
        return repository.getSortedByDate(order);
    }

    @Override
    public void checkIfUserVoteForTodayAlreadyExists(int userId) throws UserVoteForThisDayAlreadyExistsException {
        Vote userVoteFromDB = repository.getForUserToday(userId);
        if (userVoteFromDB != null) {
            throw new UserVoteForThisDayAlreadyExistsException("user vote for user with id=" + userId + " for today already exists");
        }
    }

    public Vote getForUserToday(int user_id) {
        return repository.getForUserToday(user_id);
    }

}
