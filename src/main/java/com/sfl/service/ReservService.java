package com.sfl.service;

import com.sfl.entity.Reserv;
import com.sfl.entity.TableCafe;
import com.sfl.repsitory.ReservRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Karlen on 05.02.2018.
 */
@Service
public class ReservService {
    @Autowired
    private ReservRepository reservRepository;


    public List<Reserv> getReservListbyTableCafe(TableCafe tableCafe) {

        return reservRepository.findReservsByTableByTableId(tableCafe);
    }



}
