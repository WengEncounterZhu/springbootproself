package com.bos.source.mapper;

import com.bos.source.model.JObLevel;

import java.util.HashMap;
import java.util.List;

public interface JObLevelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(JObLevel record);

    int insertSelective(JObLevel record);

    JObLevel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(JObLevel record);

    int updateByPrimaryKey(JObLevel record);

    Integer deletebatch(Integer[] ids);

    List<JObLevel> findJoblevalByNameAndTitlelevel(HashMap<String, String> map);

    List<JObLevel> findJoblevalByjObLevel(JObLevel jObLevel);
}
