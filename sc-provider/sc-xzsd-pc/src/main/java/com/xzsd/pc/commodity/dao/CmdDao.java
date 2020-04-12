package com.xzsd.pc.commodity.dao;


import com.xzsd.pc.commodity.entity.CmdInfo;
import com.xzsd.pc.commoditySort.entity.CmdSortInfo;
import com.xzsd.pc.commoditySort.entity.FirstClassSort;
import com.xzsd.pc.commoditySort.entity.SecondClassSort;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.access.method.P;

import java.util.List;

@Mapper
public interface CmdDao {

    /**
     * 统计商品数量
     * @param cmdInfo 商品信息
     * @return
     */
    int countCommodity(CmdInfo cmdInfo);

    /**
     * 新增商品
     * @param cmdInfo 商品信息
     * @return
     */
    int addCommodity(CmdInfo cmdInfo);

    /**
     * 获取所有商品信息
     * @param cmdInfo 商品信息
     * @return 所有商品信息
     */
    List<CmdInfo> listCommodity(CmdInfo cmdInfo);

    /**
     * 修改商品信息
     * @param cmdInfo 商品信息
     * @return 修改结果
     */
    int updateCommodityByCode(CmdInfo cmdInfo);

    /**
     * 删除商品
     * @param listCode
     * @param userId
     * @return
     */
    int deleteCommodity(@Param("listCode") List<String> listCode, @Param("userId") String userId);

    /**
     * 查询商品
     * @param comCode
     * @return
     */
    CmdInfo findCommodityByCode(@Param("comCode") String comCode);

    /**
     * 修改商品上架/下架信息
     * @param listCode
     * @param userId
     * @param comStatus
     * @return
     */
    int updateComStatus(@Param("listCode") List<String> listCode, @Param("userId") String userId, @Param("comStatus") String comStatus);

    /**
     * 一级分类查询
     * @return 所有商品信息
     */
    List<FirstClassSort> listFirstClass();

    /**
     * 二级分类查询
     * @param firstSortCode
     * @return 所有商品信息
     */
    List<SecondClassSort> listSecondClass(String firstSortCode);
}
