package com.bos.source.service;

import com.bos.source.mapper.JObLevelMapper;
import com.bos.source.model.JObLevel;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class JobService {

    @Autowired
    JObLevelMapper jObLevelMapper;

    public  Integer deletebatch(@Param("ids") Integer[] ids) {
        return  jObLevelMapper.deletebatch(ids);
    }


    public Integer add(JObLevel jObLevel) {
        return jObLevelMapper.insert(jObLevel);
    }

    public List<JObLevel> findJoblevalByNameAndTitlelevel(String name, String titlelevel) {

        HashMap<String, String> map = new HashMap<>();
        map.put("name" ,name);
        map.put("titlelevel",titlelevel);
        return jObLevelMapper.findJoblevalByNameAndTitlelevel(map);
    }

    public List<JObLevel> findJoblevalByjObLevel(JObLevel jObLevel) {
        System.out.println("jObLevelMapper:"+jObLevel);
        return jObLevelMapper.findJoblevalByjObLevel(jObLevel);
    }
}
