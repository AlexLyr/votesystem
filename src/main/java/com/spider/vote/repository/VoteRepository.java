package com.spider.vote.repository;



import com.spider.vote.domain.entity.Vote;
import com.spider.vote.repository.crudrepositories.CrudVoteDataJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import static com.spider.vote.utils.ValidationUtil.*;

import java.time.LocalDate;

@Repository
public class VoteRepository {

    @Autowired
    private CrudVoteDataJpa crudRepository;

    public Vote getVoteForUserAndDate(int user_id, LocalDate date){
       return checkNotFound(crudRepository.getForUserAndDate(user_id,date),"this user_id and date");
    }

    public Vote saveVote(Vote vote){
        Assert.notNull(vote,"vote must be not null");
        return crudRepository.save(vote);
    }
}
