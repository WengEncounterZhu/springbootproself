package com.bos.source.service;

import com.bos.source.mapper.MenuMapper;
import com.bos.source.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {
    @Autowired
    MenuMapper menuMapper;

    public List<Menu> getMenusByHrId(Integer id) {
        System.out.println("MenuService:"+id);
        return menuMapper.getMenusByHrId(id);
    }
}
