package com.spider.vote.web;

import com.spider.vote.domain.entity.Menu;
import com.spider.vote.domain.entity.Restaurant;
import com.spider.vote.domain.entity.Vote;
import com.spider.vote.service.interfaces.MenuService;
import com.spider.vote.service.interfaces.RestaurantService;
import com.spider.vote.service.interfaces.VoteService;
import com.spider.vote.to.UserVoteTo;
import com.spider.vote.utils.ValidationUtil;
import com.spider.vote.utils.VoteUtil;
import com.spider.vote.utils.exceptions.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static com.spider.vote.utils.datetimeutils.DateTimeFormat.parseLocalDate;

@RestController
@RequestMapping(value = UserRestController.REST_URL)
public class UserRestController {

    private static final Logger LOG = LoggerFactory.getLogger(UserRestController.class);

    static final String REST_URL = "rest/profile";

    @Autowired
    private VoteService voteService;

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private MenuService menuService;

    @PostMapping(value = "/vote", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Vote> save(@Valid @RequestBody UserVoteTo entity) {
        ValidationUtil.checkNew(entity);
        ValidationUtil.checkDateConsistent(entity);
        ValidationUtil.checkTimeConsistentForSave(entity);

        int userId = AuthorizedUser.id();
        voteService.checkIfUserVoteForTodayAlreadyExists(userId);
        LOG.info("save {}", entity);
        Vote created = voteService.saveVote(entity,userId);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{name}")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @PutMapping(value = "/vote", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Vote> update(@Valid @RequestBody UserVoteTo entity) throws NotFoundException {
        int userId = AuthorizedUser.id();

        Vote userVote = voteService.getForUserToday(userId);
        ValidationUtil.checkDateConsistent(entity);
        ValidationUtil.checkTimeConsistentForUpdate(entity);
        ValidationUtil.checkIdConsistent(entity, userVote.getId());
        entity.setDateTime(LocalDateTime.now());
        LOG.info("update {}", entity);
        voteService.changeVote(entity,userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/vote", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserVoteTo> getTodaysVote() throws NotFoundException {
        int userId = AuthorizedUser.id();
        LOG.info("get today's user vote for user with id={}", userId);
        Vote userVote = voteService.getForUserToday(userId);

        return new ResponseEntity<>(VoteUtil.createToFromVote(userVote), HttpStatus.OK);
    }

    @GetMapping(value = "/restaurants", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Restaurant>> getAllRestaurants() {
        int userId = AuthorizedUser.id();
        LOG.info("getAll restaurants for user with id={}", userId);
        return new ResponseEntity<>(restaurantService.getAllRestaurants(), HttpStatus.OK);
    }

    @GetMapping(value = "/menus/by/restaurant")
    public ResponseEntity<List<Menu>> findMenusByRestaurant(@RequestParam("name") String name) {
        LOG.info("find menus from restaurant {}", name);
        Restaurant restaurant = restaurantService.getRestaurantByName(name);
        List<Menu> menus = menuService.findMenuByRestaurant(restaurant);
        return new ResponseEntity<>(menus, HttpStatus.OK);
    }

    @GetMapping(value = "/menus/by/date")
    public ResponseEntity<List<Menu>> getMenuByDate(@RequestParam(value = "date") String date) {
        LocalDate localDate = parseLocalDate(date);
        LOG.info("find menus from date {}", localDate);
        List<Menu> menus = menuService.findMenuByDate(localDate);
        return new ResponseEntity<>(menus, HttpStatus.OK);
    }

    @GetMapping(value = "/menus")
    public ResponseEntity<List<Menu>> getAllMenus() {
        LOG.info("find all menus");
        List<Menu> menus = menuService.getAllMenu();
        return new ResponseEntity<>(menus, HttpStatus.OK);
    }

    @GetMapping(value = "/restaurants/by", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Restaurant> getRestaurantByName(@RequestParam("name") String name) {
        LOG.info("get restaurant with name={}", name);
        Restaurant restaurant = restaurantService.getRestaurantByName(name);
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }



}
