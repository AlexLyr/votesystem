package com.spider.vote.repository;

import com.spider.vote.domain.entity.Menu;
import com.spider.vote.domain.entity.Restaurant;
import com.spider.vote.repository.crudrepositories.CrudMenuDataJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import static com.spider.vote.utils.ValidationUtil.*;

import java.time.LocalDate;
import java.util.List;

@Repository
public class MenuRepository {

    @Autowired
    private CrudMenuDataJpa crudRepository;

    public List<Menu> findMenuByDate(LocalDate date){
       return checkNotFoundForToday(crudRepository.findByDate(date),"not found with date: "+date.toString());
    }

    public List<Menu> findMenuByRestaurant(Restaurant restaurant){
       return checkNotFound(crudRepository.findByRestaurant(restaurant),"this restaurant");
    }

    public Menu saveMenu(Menu menu){
       return crudRepository.save(menu);
    }

    public void deleteMenu(int id){
        checkNotFoundWithId(crudRepository.deleteById(id),id);
    }

    public List<Menu> findAll(){
      return crudRepository.getAllMenus();
    }
}
