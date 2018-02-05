package com.sfl.repsitory;


import com.sfl.entity.TableCafe;
import com.sfl.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Karlen on 05.02.2018.
 */
public interface TableCafeRepository extends JpaRepository<TableCafe,Long>{


    List<TableCafe> findAllByUserByUserId(User user);
    List<TableCafe> findAllByUserByUserIdId(long id);
    TableCafe findByName(String name);

}
