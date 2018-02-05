package com.sfl.repsitory;


import com.sfl.entity.Reserv;
import com.sfl.entity.TableCafe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Karlen on 05.02.2018.
 */
public interface ReservRepository extends JpaRepository<Reserv,Long> {

    List<Reserv> findReservsByTableByTableId(TableCafe tableCafe);

}
