package com.spider.vote.web;


import com.spider.vote.domain.entity.*;
import com.spider.vote.service.interfaces.*;
import com.spider.vote.to.UserVoteTo;
import com.spider.vote.utils.ValidationUtil;
import com.spider.vote.utils.VoteUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import org.springframework.http.ResponseEntity;

import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;

import java.net.URI;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import static com.spider.vote.web.AdminRestController.ADMIN_REST_URL;
import static com.spider.vote.utils.datetimeutils.DateTimeFormat.*;


@RestController
@RequestMapping(value = ADMIN_REST_URL)
public class AdminRestController {

    public static final String ADMIN_REST_URL = "rest/admin";
    private static final Logger LOG = LoggerFactory.getLogger(AdminRestController.class);

    @Autowired
    private MealService mealService;

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private UserService userService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private VoteService voteService;

    //restaurants management
    @PostMapping(value = "/restaurants", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Restaurant> saveRestaurant(@Valid @RequestBody Restaurant entity) {
        ValidationUtil.checkNew(entity);

        LOG.info("create {}", entity);
        Restaurant created = restaurantService.saveRestaurant(entity);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(ADMIN_REST_URL + "/{name}")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @DeleteMapping(value = "/restaurants/{id}")
    public ResponseEntity<Restaurant> deleteRestaurant(@PathVariable("id") int id) {
        LOG.info("delete restaurant with name={}", id);
        restaurantService.deleteRestaurantById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/restaurants/by", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Restaurant> getRestaurantByName(@RequestParam("name") String name) {
        LOG.info("get restaurant with name={}", name);
        Restaurant restaurant = restaurantService.getRestaurantByName(name);
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }

    @GetMapping(value = "/restaurants", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Restaurant>> getAllRestaurants() {
        LOG.info("get all restaurants");
        List<Restaurant> restaurants = restaurantService.getAllRestaurants();
        return new ResponseEntity<>(restaurants, HttpStatus.OK);
    }

    //users management
    @PostMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> saveUser(@Valid @RequestBody User entity) {
        ValidationUtil.checkNew(entity);

        LOG.info("save entity {}", entity);
        User created = userService.create(entity);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(ADMIN_REST_URL + "/{name}")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> getAllUsers() {
        LOG.info("get all users");
        List<User> users = userService.getAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping(value = "/users/by", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getByEmail(@RequestParam("email") String email) {
        LOG.info("get user with email {}", email);
        User user = userService.getUserByEmail(email);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @DeleteMapping(value = "/users/{id}")
    public ResponseEntity<User> deleteUserWithId(@PathVariable("id") int id) {
        LOG.info("delete user with name={}", id);
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> updateUser(@Validated @RequestBody User entity) {

        LOG.info("update {}", entity);
        userService.update(entity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //Menu  management
    @PostMapping(value = "/menus", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Menu> saveMenu(@Valid @RequestBody Menu entity) {
        ValidationUtil.checkNew(entity);
        LOG.info("save {}", entity);
        Menu created = menuService.saveMenu(entity);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(ADMIN_REST_URL + "/{name}")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @DeleteMapping(value = "/menus/{id}")
    public ResponseEntity<User> deleteMenu(@PathVariable("id") int id) {
        LOG.info("delete menu with name={}", id);
        menuService.deleteMenuById(id);
        return new ResponseEntity<>(HttpStatus.OK);
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

    //Meal management
    @PostMapping(value = "/meals", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Meal> saveMeal(@Valid @RequestBody Meal entity) {
        ValidationUtil.checkNew(entity);
        LOG.info("save {}", entity);
        Meal created = mealService.saveMeal(entity);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(ADMIN_REST_URL + "/{name}")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @DeleteMapping(value = "/meals/{id}")
    public ResponseEntity<Meal> deleteMeal(@PathVariable("id") int id) {
        LOG.info("delete meal with name={}", id);
        mealService.deleteMeal(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/meals/by/menu_id/{restaurant_name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Meal>> getAllMealsInMenu(@RequestParam("menu_id") int menu_id, @PathVariable("restaurant_name") String name) {
        Restaurant restaurant = restaurantService.getRestaurantByName(name);
        List<Menu> menus = menuService.findMenuByRestaurant(restaurant);
        menus = menus.stream().filter(m -> m.getId() == menu_id).collect(Collectors.toList());
        LOG.info("find all meals in menu");
        List<Meal> meals = mealService.getAllMealInMenu(menus.get(0));
        return new ResponseEntity<>(meals, HttpStatus.OK);
    }

    @PutMapping(value = "/meals", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Meal> updateMeal(@Validated @RequestBody Meal entity) {

        LOG.info("update {}", entity);
        mealService.update(entity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //Vote management
    @PostMapping(value = "/votes", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Vote> saveMeal(@Valid @RequestBody UserVoteTo entity) {
        int userId = AuthorizedUser.id();
        ValidationUtil.checkNew(entity);
        LOG.info("save {}", entity);
        entity.setDateTime(LocalDateTime.now());
        Vote created = voteService.saveVote(entity, userId);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(ADMIN_REST_URL + "/{name}")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @PutMapping(value = "/votes", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Vote> updateVote(@Validated @RequestBody UserVoteTo entity) {
        int userId = AuthorizedUser.id();
        LOG.info("update {}", entity);
        entity.setDateTime(LocalDateTime.now());
        voteService.changeVote(entity, userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/votes", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserVoteTo> getVoteByUserAndDate(@RequestParam("user_id") int user_id, @RequestParam("date") String date) {
        LocalDate localDate = parseLocalDate(date);
        LOG.info("find vote from date {} for user with name {}", date, user_id);
        UserVoteTo vote = voteService.getVoteForUserAndDate(user_id, localDate);
        return new ResponseEntity<>(vote, HttpStatus.OK);
    }

    @GetMapping(value = "/votes/by", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserVoteTo>> getAllVotesFiltered(
            @RequestParam(value = "sort", required = false) String order,
            @RequestParam(value = "date", required = false) String date,
            @RequestParam(value = "restaurantName", required = false) String restaurantName,
            @RequestParam(value = "userId", required = false) Integer userId) {
        if (userId != null) {
            LOG.info("get votes filtered by user");
            return new ResponseEntity<>(VoteUtil.asToList(voteService.getFilteredByUser(userId)), HttpStatus.OK);
        }
        if (restaurantName != null) {
            LOG.info("get votes filtered by restaurant");
            return new ResponseEntity<>(VoteUtil.asToList(voteService.getFilteredByRestaurantName(restaurantName)), HttpStatus.OK);
        }
        if (date != null) {
            LocalDate localDate = parseLocalDate(date);
            LOG.info("get votes filtered by date");
            return new ResponseEntity<>(VoteUtil.asToList(voteService.getFilteredByDate(localDate)), HttpStatus.OK);
        }
        LOG.info("get all votes sorted by date");
        return new ResponseEntity<>(VoteUtil.asToList(voteService.getSortedByDate(order == null ? "" : order)), HttpStatus.OK);
    }
}

