package com.xzsd.pc.carousel.controller;


import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.AuthUtils;
import com.xzsd.pc.carousel.entity.CarouselInfo;
import com.xzsd.pc.carousel.service.CarouselService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author hechusheng
 * @Descritption增删查改Carousel
 * @Date 2020-03-30
 */
@RestController
@RequestMapping("/carousel")
public class CarouselController {
    private static final Logger logger = LoggerFactory.getLogger(CarouselController.class);

    @Resource
    private CarouselService carouselService;

    /**
     * demo 新增轮播图
     * @param carouselInfo
     * @return AppResponse
     * @author hechusheng
     * @Date 2020-03-30
     */
    @PostMapping("addCarousel")
    public AppResponse addCarousel(CarouselInfo carouselInfo){
        try{
            //获取用户编号
            String userCode = AuthUtils.getCurrentUserId();
            carouselInfo.setCreateUser(userCode);
            carouselInfo.setUpdateUser(userCode);
            return carouselService.addCarousel(carouselInfo);
        }catch (Exception e){
            logger.error("轮播图新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 选择查询商品列表（分页）
     * @param carouselInfo
     * @return
     */
    @RequestMapping(value = "listComCarouselByPage")
    public AppResponse listComCarousel(CarouselInfo carouselInfo) {
        try {
            return carouselService.listComCarousel(carouselInfo);
        } catch (Exception e) {
            logger.error("查询商品列表失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除轮播图
     * @param caroCode
     * @return
     */
    @PostMapping("deleteCarousel")
    public AppResponse deleteUser(String caroCode) {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            return carouselService.deleteCarousel(caroCode,userId);
        } catch (Exception e) {
            logger.error("轮播图删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    @PostMapping("updateCaroStatus")
    public AppResponse updateCaroStatus(String caroCode,String caroStatus) {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            return carouselService.updateCaroStatus(caroCode,userId,caroStatus);
        } catch (Exception e) {
            logger.error("轮播图更新错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    @RequestMapping(value = "listCarouselByPage")
    public AppResponse listCarousel(CarouselInfo carouselInfo) {
        try {
            return carouselService.listCarousel(carouselInfo);
        } catch (Exception e) {
            logger.error("查询轮播图列表失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
