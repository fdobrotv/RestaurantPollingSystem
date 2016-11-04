package com.fdobrotv.rps.models.repositories;

import com.fdobrotv.rps.models.Menu;
import com.fdobrotv.rps.models.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.annotation.Secured;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

/**
 * Spring Data JPA repository for the Menu entity.
 */
public interface MenuRepository extends JpaRepository<Menu, Integer> {
    @RestResource(path = "by-date")
    @Transactional(readOnly = true)
    @Query("SELECT m FROM Menu m WHERE m.date=:date")
    List<Menu> findByDate(@Param("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date);

    @RestResource(path = "by-restaurant")
    @Transactional(readOnly = true)
    @Query("SELECT m FROM Menu m WHERE m.restaurant=:restaurant")
    List<Menu> findByRestaurant(@Param("restaurant") Restaurant restaurant);

    @Override
    @Secured("ROLE_ADMIN")
    Menu save(Menu entity);

    @Override
    @Secured("ROLE_ADMIN")
    void delete(Integer id);
}
