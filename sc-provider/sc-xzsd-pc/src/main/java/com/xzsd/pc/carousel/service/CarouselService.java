package com.xzsd.pc.carousel.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.carousel.dao.CarouselDao;
import com.xzsd.pc.carousel.entity.CarouselInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @DescriptionDemo 实现类
 * @Author hechusheng
 * @Date 2020-03-30
 */
@Service
public class CarouselService {
    @Resource
    private CarouselDao carouselDao;

    /**
     * 新增轮播图
     * @param carouselInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addCarousel (CarouselInfo carouselInfo){
        int countCarousel =  carouselDao.countCarousel(carouselInfo);
        if(0 != countCarousel) {
            return AppResponse.bizError("该轮播图已存在");
        }
        carouselInfo.setCaroCode(StringUtil.getCommonCode(2));
        carouselInfo.setIsDelete(0);
        int count = carouselDao.addCarousel(carouselInfo);
        if(0 == count) {
            return AppResponse.bizError("新增轮播图失败，请重试");
        }
        return AppResponse.success("新增成功");
    }

    /**
     * 选择商品列表(分页)查询
     * @param carouselInfo
     * @return
     */
    public AppResponse listComCarousel (CarouselInfo carouselInfo) {
        List<CarouselInfo> comCarouselList = carouselDao.listComCarousel(carouselInfo);
        return AppResponse.success("查询成功！",comCarouselList);
    }

    /**
     * 删除轮播图
     * @param caroCode
     * @param userId
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteCarousel(String caroCode,String userId) {
        List<String> listCode = Arrays.asList(caroCode.split(","));
        AppResponse appResponse = AppResponse.success("删除成功！");
        // 删除用户
        int count = carouselDao.deleteCarousel(listCode,userId);
        if(0 == count) {
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        return appResponse;
    }

    /**
     * 轮播图状态修改（0启用 1禁用）
     * @param caroCode
     * @param caroStatus
     * @return
     */
    public AppResponse updateCaroStatus(String caroCode,String userId, String caroStatus) {
        List<String> listCode = Arrays.asList(caroCode.split(","));
        AppResponse appResponse = AppResponse.success("更新成功!");

        //更新状态
        int count = carouselDao.updateCaroStatus(listCode,userId,caroStatus);
        if(0 == count) {
            appResponse = AppResponse.bizError("更新失败！请重试");
        }

        return appResponse;
    }

    /**
     * 轮播图分页查询
     * @param carouselInfo
     * @return
     */
    public AppResponse listCarousel(CarouselInfo carouselInfo) {
        List<CarouselInfo> carouselInfoList = carouselDao.listCarousel(carouselInfo);
        return AppResponse.success("查询成功！",carouselInfo);
    }
}
