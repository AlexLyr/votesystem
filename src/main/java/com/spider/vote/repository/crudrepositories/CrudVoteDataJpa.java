package com.spider.vote.repository.crudrepositories;


import com.spider.vote.domain.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Transactional(readOnly = true)
public interface CrudVoteDataJpa extends JpaRepository<Vote, Integer> {

    @Query("SELECT v FROM Vote v WHERE v.user.id=:userId AND v.date=:date")
    Vote getForUserAndDate(@Param("userId") int userId, @Param("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date);

    @Transactional
    Vote save(Vote user);

    @Query("SELECT v FROM Vote v LEFT JOIN FETCH v.user as users WHERE v.user.id=:userId")
    List<Vote> getByUserId(@Param("userId") int userId);

    @Query("select v from Vote v LEFT JOIN FETCH v.user as users left join fetch v.restaurant as restaurants WHERE v.restaurant.name=:name")
    List<Vote> getFilteredByRestaurantName(@Param("name") String name);

    @Query("SELECT v FROM Vote v LEFT JOIN FETCH v.user as users LEFT JOIN FETCH v.restaurant AS restaurants WHERE v.date=:date")
    List<Vote> getFilteredByDate(@Param("date") LocalDate date);

    @Query("SELECT v FROM Vote v LEFT JOIN FETCH v.user as users LEFT JOIN FETCH v.restaurant AS restaurants ORDER BY v.date ASC")
    List<Vote> getSortedByDateAsc();

    @Query("SELECT v FROM Vote v LEFT JOIN FETCH v.user as users LEFT JOIN FETCH v.restaurant AS restaurants ORDER BY v.date DESC ")
    List<Vote> getSortedByDateDesc();

    Vote getAllByDateAndUser_Id(LocalDate date, int user_id);

}
