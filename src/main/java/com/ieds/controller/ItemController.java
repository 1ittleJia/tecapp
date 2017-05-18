package com.ieds.controller;

import com.ieds.model.ItemInfoEntity;
import com.ieds.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by jia on 2017/5/2.
 */
@Controller
public class ItemController {
    // 自动装配数据库接口，不需要再写原始的Connection来操作数据库
    @Autowired
    ItemRepository itemRepository;

    /**
     * 项目列表页面
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/item/itemList", method = {RequestMethod.GET,RequestMethod.POST})
    public String getItemList(@ModelAttribute("item") ItemInfoEntity item, ModelMap modelMap) {
        List<ItemInfoEntity> itemList = new ArrayList<>();
        Pageable pageable = new PageRequest(1, 10, Sort.Direction.ASC, "id");
        if(item.getItemNm()!=null&&!"".equals(item.getItemNm())){
            itemList = itemRepository.findAllByItemNm(item.getItemNm());
        }else{
            // 查询itemInfo表中所有记录
            itemList = itemRepository.findAll();
        }
        Page<ItemInfoEntity> itemPage = itemRepository.findByAuto(item,pageable);
                // 将所有记录传递给要返回的jsp页面，放在itemList当中
        modelMap.addAttribute("itemPage", itemPage);
        // 返回pages目录下的item/itemList.jsp页面
        return "item/itemList";
    }


    /**
     * get请求，访问添加项目页面
     * @return
     */
    @RequestMapping(value = "/item/add", method = RequestMethod.GET)
    public String addItem() {
        // 转到 item/addItem.jsp页面
        return "/item/addItem";
    }


    /**
     * post请求，处理添加项目请求，并重定向到用户管理页面
     * @param item
     * @return
     */
    @RequestMapping(value = "/item/addP", method = RequestMethod.POST)
    public String addUserPost(@ModelAttribute("item") ItemInfoEntity item) {

        // 注意此处，post请求传递过来的是一个UserEntity对象，里面包含了该用户的信息
        // 通过@ModelAttribute()注解可以获取传递过来的'item'，并创建这个对象

        if(item.getId()==0){
            item.setOperateTime(new Date());
            // 数据库中添加一个项目，并立即刷新缓存
            itemRepository.saveAndFlush(item);
        }else{
            // 更新用户信息
            item.setOperateTime(new Date());
            itemRepository.updateItem(item.getItemNm(), item.getBidId(),
                    item.getOperateTime(), item.getId());
            itemRepository.flush(); // 刷新缓冲区
        }
        // 重定向到项目管理页面，方法为 redirect:url
        return "redirect:/item/itemList";
    }


    /**
     * get请求，处理删除项目请求，并重定向到项目管理页面
     * @param id
     * @return
     */
    @RequestMapping(value = "/item/delete/{id}", method = RequestMethod.GET)
    public String deleteItem(@PathVariable("id") Integer id) {
        // 数据库中删除一个项目，并立即刷新缓存
        itemRepository.delete(id);
        itemRepository.flush();
        // 重定向到项目管理页面，方法为 redirect:url
        return "redirect:/item/itemList";
    }


    /**
     * 更新项目信息页面
     * @param id
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/item/update/{id}", method = RequestMethod.GET)
    public String updateUser(@PathVariable("id") Integer id, ModelMap modelMap) {
        // 找到userId所表示的用户
        ItemInfoEntity itemEntity = itemRepository.findOne(id);
        // 传递给请求页面
        modelMap.addAttribute("item", itemEntity);
        return "/item/addItem";
    }


}
