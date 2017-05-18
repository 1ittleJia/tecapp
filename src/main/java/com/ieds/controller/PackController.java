package com.ieds.controller;

import com.ieds.model.PackInfoEntity;
import com.ieds.repository.PackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;
import java.util.List;

/**
 * Created by jia on 2017/5/4.
 */
@Controller
public class PackController {
    @Autowired
    PackRepository packRepository;


    /**
     * 标段列表页面
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/pack/packList/{id}", method = RequestMethod.GET)
    public String getPackList(@PathVariable("id") Integer itemId,ModelMap modelMap) {
        List<PackInfoEntity> packList = packRepository.findListById(itemId);
        modelMap.addAttribute("packList", packList);
        modelMap.addAttribute("itemId", itemId);
        return "/pack/packList";
    }

    /**
     * 跳转到标段添加页面
     * @param itemId
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/pack/add/{id}", method = RequestMethod.GET)
    public String addPack(@PathVariable("id") Integer itemId,ModelMap modelMap) {
        PackInfoEntity pack = new PackInfoEntity();
        pack.setItemId(itemId);
        modelMap.addAttribute("pack", pack);
        return "/pack/addPack";
    }

    /**
     * 添加标段
     * @param pack
     * @return
     */
    @RequestMapping(value = "/pack/addPack", method = RequestMethod.POST)
    public String addExpertPost(@ModelAttribute("pack") PackInfoEntity pack) {
        if(pack.getId()==0){
            pack.setOperateTime(new Date());
            packRepository.saveAndFlush(pack);
        }else{
            // 更新用户信息
            pack.setOperateTime(new Date());
            packRepository.flush();
        }
        return "redirect:/pack/packList/"+pack.getItemId();
    }

    /**
     * 删除标段
     * @param id
     * @param itemId
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/pack/delete/{id}.{itemId}", method = RequestMethod.GET)
    public String delPack(@PathVariable("id") Integer id,@PathVariable("itemId") Integer itemId,ModelMap modelMap) {
        packRepository.delete(id);
        packRepository.flush();
        return "redirect:/pack/packList/"+itemId;
    }

}
