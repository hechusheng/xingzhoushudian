package com.xzsd.pc.commoditySort.dao;


import com.xzsd.pc.commoditySort.entity.CmdSortInfo;
import com.xzsd.pc.commoditySort.entity.FirstClassSort;
import com.xzsd.pc.commoditySort.entity.SecondClassSort;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 ** @ClassName CmdSortDao
 * @Description Demo
 * @Author hechusheng
 * @Date 2020-03-27
 */
@Mapper
public interface CmdSortDao {

    /**
     * 统计商品分类数量
     * @param cmdSortInfo
     * @return
     */
    int countSortName(CmdSortInfo cmdSortInfo);

    /**
     * 新增商品分类
     * @param cmdSortInfo
     * @return
     */
    int addCommoditySort(CmdSortInfo cmdSortInfo);

    /**
     * 查询分类
     * @param sortCode
     * @return
     */
    CmdSortInfo findSortByCode(String sortCode);

    /**
     * 修改分类
     * @param cmdSortInfo 分类信息
     * @return 修改结果
     */
    int updateSort(CmdSortInfo cmdSortInfo);

    /**
     * 获取所有商品分类信息
     * @return 所有商品分类信息
     */
    List<FirstClassSort> listSorts();

    /**
     * 查询一级分类下是否有二级分类
     * @param sortCode
     * @return
     */
    int countChildSort (String sortCode);
    /**
     *
     * @param sortCode
     * @return
     */
    int deleteSort (@Param("sortCode") String sortCode,@Param("userId") String userId);
}
