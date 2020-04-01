package com.sdw.mapper;

import com.sdw.entity.Msg;
import com.sdw.query.MsgQueryObject;

import java.util.List;

public interface MsgMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Msg record);

    Msg selectByPrimaryKey(Long id);

    List<Msg> selectAll();

    int updateByPrimaryKey(Msg record);
    //高级查询加分页
    Long queryEorPageCount(MsgQueryObject qo);

    List<Msg> queryForPage(MsgQueryObject qo);
//      <!--查询这篇文章下面有多少评论-->
    List<Msg> allMsg(Msg msg);
    List<Msg> allMessageMsg(Msg msg);

}