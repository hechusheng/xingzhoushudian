package com.xzsd.pc.commodity.service;



import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.commodity.dao.CmdDao;
import com.xzsd.pc.commodity.entity.CmdInfo;
import com.xzsd.pc.commoditySort.entity.CmdSortInfo;
import com.xzsd.pc.commoditySort.entity.FirstClassSort;
import com.xzsd.pc.commoditySort.entity.SecondClassSort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @DescriptionDemo 实现类
 * @Author hechusheng
 * @Date 2020-03-24
 */
@Service
public class CmdService {
    @Resource
    private CmdDao cmdDao;
//    @Autowired
//    private RedisOperator redisOperator;
//    @Autowired
//    private JmsMessagingTemplate jmsMessagingTemplate;
//    @Autowired
//    private Queue queue;

    /**
     * demo 新增商品
     * @param cmdInfo
     * @return
     * @Author hechusheng
     * @Date 2020-03-27
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addCommodity(CmdInfo cmdInfo){
        //校验商品是否存在
        int countCommodity = cmdDao.countCommodity(cmdInfo);
        if(0 != countCommodity){
            return AppResponse.bizError("商品已存在，请重新输入！");
        }
        cmdInfo.setComCode(StringUtil.getCommonCode(2));
        cmdInfo.setIsDelete(0);
        //新增商品
        int count = cmdDao.addCommodity(cmdInfo);
        if(0 == count) {
            return AppResponse.bizError("新增失败，请重试");
        }

//        MQ发送消息
//        try{
//            jmsMessagingTemplate.convertAndSend(queue,cmdInfo);
//            System.out.println("消息发送成功");
//        }catch (Exception e){
//            e.printStackTrace();
//        }

        return AppResponse.success("新增成功！");
    }

    /**
     * demo 查询商品列表（分页）
     * @param cmdInfo
     * @return
     * @Author hechusheng
     * @Date 2020-03-27
     */
    public AppResponse listCommodity(CmdInfo cmdInfo) {
        PageHelper.startPage(cmdInfo.getPageNum(),cmdInfo.getPageSize());
        List<CmdInfo> cmdInfoList = cmdDao.listCommodity(cmdInfo);
        // 包装Page对象
        PageInfo<CmdInfo> pageData = new PageInfo<CmdInfo>(cmdInfoList);

        return AppResponse.success("查询成功！",pageData);
    }

    /**
     * demo 修改商品
     * @param cmdInfo
     * @return
     * @Author hechusheng
     * @Date 2020-03-27
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateCommodityByCode (CmdInfo cmdInfo) {
        //校验商品是否存在
        int countCommodity = cmdDao.countCommodity(cmdInfo);
        if(0 != countCommodity){
            return AppResponse.bizError("商品已存在，请重新输入！");
        }

        //修改商品
        int count = cmdDao.updateCommodityByCode(cmdInfo);
        if(0 == count){
            return AppResponse.bizError("修改失败，请重试");
        }

        return AppResponse.success("修改成功！");
    }

    /**
     * 删除商品
     * @param comCode
     * @param userId
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteCommodity(String comCode,String userId) {
        List<String> listCode = Arrays.asList(comCode.split(","));
        AppResponse appResponse = AppResponse.success("删除成功！");
        // 删除用户
        int count = cmdDao.deleteCommodity(listCode,userId);
        if(0 == count) {
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        return appResponse;
    }

    /**
     * 查询商品详情
     * @param comCode
     * @return
     * @Author hechusheng
     * @Date 2020-03-27
     */
    public AppResponse findCommodityByCode (String comCode) {
        CmdInfo cmdInfo = cmdDao.findCommodityByCode(comCode);
        return AppResponse.success("查询成功",cmdInfo);
    }

    /**
     * demo 修改商品上架/下架
     * @param comCode
     * @param userId
     * @return
     * @Author hechusheng
     * @Date 2020-03-27
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateComStatus (String comCode,String userId,String comStatus) {
        List<String> listCode = Arrays.asList(comCode.split(","));
        AppResponse appResponse = AppResponse.success("商品状态修改成功！");
        //修改商品
        int count = cmdDao.updateComStatus(listCode,userId,comStatus);
        if(0 == count){
            appResponse = AppResponse.bizError("商品状态修改失败，请重试！");
        }
        return appResponse;
    }

    /**
     * 一级分类下拉查询
     * @return
     * @Author hechusheng
     * @Date 2020-03-27
     */
    public AppResponse listFirstClass () {
        List<FirstClassSort> firstClassList = cmdDao.listFirstClass();
        return AppResponse.success("一级分类查询成功",firstClassList);
    }

    /**
     * 二级分类下拉查询
     * @return
     * @Author hechusheng
     * @Date 2020-03-27
     */
    public AppResponse listSecondClass (String firstSortCode) {
        List<SecondClassSort> secondClassList = cmdDao.listSecondClass(firstSortCode);
        return AppResponse.success("二级分类查询成功",secondClassList);
    }
}
//    public AppResponse listCommodity(CmdInfo cmdInfo,String key) {
//
//        if (redisOperator.hasKey(key)) {
//            String result = redisOperator.get(key);
//            PageInfo pageInfo = JsonUtils.fromJson(result,PageInfo.class);
//            return AppResponse.success("返回redis成功！",pageInfo);
//        }else {
//            PageHelper.startPage(cmdInfo.getPageNum(),cmdInfo.getPageSize());
//            List<CmdInfo> cmdInfoList = cmdDao.listCommodity(cmdInfo);
//            // 包装Page对象
//            PageInfo<CmdInfo> pageData = new PageInfo<CmdInfo>(cmdInfoList);
//            //存入redis
//            redisOperator.set(key, JSON.toJSONString(pageData),300);
//            return AppResponse.success("查询成功！",pageData);
//        }
//    }


