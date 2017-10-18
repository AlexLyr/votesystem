package com.spider.vote.repository.testdata;


import com.spider.vote.domain.entity.Vote;
import com.spider.vote.to.UserVoteTo;
import com.spider.vote.utils.json.JsonUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static com.spider.vote.repository.testdata.RestaurantTestData.RESTAURANT_102;
import static com.spider.vote.repository.testdata.RestaurantTestData.RESTAURANT_103;
import static com.spider.vote.repository.testdata.RestaurantTestData.RESTAURANT_104;
import static com.spider.vote.repository.testdata.UserTestData.ADMIN;
import static com.spider.vote.repository.testdata.UserTestData.USER;

public class VoteTestData {

    public static final Vote VOTE_USER=new Vote(USER,RESTAURANT_102, LocalDate.of(2017,10,23));
    public static final UserVoteTo VOTE_TO_USER=new UserVoteTo( LocalDateTime.of(2017,10,23,7,0),RESTAURANT_103,USER);
    public static final UserVoteTo VOTE_TO_ADMIN=new UserVoteTo( LocalDateTime.of(2017,10,23,8,0),RESTAURANT_103,ADMIN);
    public static final UserVoteTo VOTE_TO_ADMIN_UPD=new UserVoteTo( 123,LocalDateTime.of(2017,10,23,9,0),RESTAURANT_104,ADMIN);
    public static final UserVoteTo VOTE_TO_ADMIN_UPD_LATE=new UserVoteTo( 123,LocalDateTime.of(2017,10,23,11,0),RESTAURANT_104,ADMIN);
    public static final String JSON_VOTE_USER = JsonUtil.writeValue(VOTE_TO_USER);
    public static final String JSON_VOTE_ADMIN= JsonUtil.writeValue(VOTE_TO_ADMIN);
    public static final String JSON_VOTE_ADMIN_UPD= JsonUtil.writeValue(VOTE_TO_ADMIN_UPD);
    public static final String JSON_VOTE_ADMIN_UPD_LATE= JsonUtil.writeValue(VOTE_TO_ADMIN_UPD_LATE);
}
