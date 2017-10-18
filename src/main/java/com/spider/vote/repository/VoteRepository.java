package com.spider.vote.repository;


import com.spider.vote.domain.entity.Vote;
import com.spider.vote.repository.crudrepositories.CrudVoteDataJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import static com.spider.vote.utils.ValidationUtil.*;

import java.time.LocalDate;
import java.util.List;

@Repository
public class VoteRepository {

    @Autowired
    private CrudVoteDataJpa crudRepository;

    public Vote getVoteForUserAndDate(int user_id, LocalDate date) {
        return checkNotFound(crudRepository.getForUserAndDate(user_id, date), "this user_id and date");
    }

    public Vote saveVote(Vote vote) {
        Assert.notNull(vote, "vote must be not null");
        return crudRepository.save(vote);
    }

    public List<Vote> getFilteredByUser(int userId) {
        return crudRepository.getByUserId(userId);
    }

    public List<Vote> getFilteredByRestaurantName(String name) {
        return crudRepository.getFilteredByRestaurantName(name);
    }

    public List<Vote> getFilteredByDate(LocalDate date) {
        return crudRepository.getFilteredByDate(date);
    }

    public List<Vote> getForToday() {
        return crudRepository.getFilteredByDate(LocalDate.now());
    }

    public List<Vote> getSortedByDate(String order) {
        if (order.toLowerCase().equals("asc")) {
            return crudRepository.getSortedByDateAsc();
        } else return crudRepository.getSortedByDateDesc();
    }

    public Vote getForUserToday(int user_id) {
        return crudRepository.getAllByDateAndUser_Id(LocalDate.now(), user_id);
    }
}
