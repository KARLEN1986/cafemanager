package com.sfl.service;

import com.sfl.entity.TableCafe;
import com.sfl.entity.User;
import com.sfl.repsitory.TableCafeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Created by Karlen on 05.02.2018.
 */
@Service
public class TableCafeService {
    @Autowired
    private TableCafeRepository tableCafeRepository;


    public void addTableCafe(TableCafe tableCafe) {
        tableCafeRepository.save(tableCafe);
    }

    public List<TableCafe> getTableCafeList() {
        return tableCafeRepository.findAll();
    }

    public List<TableCafe> getFreeTableCafeList() {
        return tableCafeRepository.findAllByUserByUserId(null);

    }

    public void updateTableCafe(TableCafe tableCafe) {
        tableCafeRepository.save(tableCafe);

    }

    public List<TableCafe> getTableCafeByUser(User user) {
        return tableCafeRepository.findAllByUserByUserId(user);
    }

    public List<TableCafe> getTableCafeByUserId(long id) {
        return tableCafeRepository.findAllByUserByUserIdId(id);
    }

    public TableCafe getTableCafebynName(String name) {
        return tableCafeRepository.findByName(name);
    }
    public TableCafe getTableCafeById(long id){
        return tableCafeRepository.findOne(id);
    }



}
