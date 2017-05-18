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
     * ����б�ҳ��
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
     * ��ת��������ҳ��
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
     * ��ӱ��
     * @param pack
     * @return
     */
    @RequestMapping(value = "/pack/addPack", method = RequestMethod.POST)
    public String addExpertPost(@ModelAttribute("pack") PackInfoEntity pack) {
        if(pack.getId()==0){
            pack.setOperateTime(new Date());
            packRepository.saveAndFlush(pack);
        }else{
            // �����û���Ϣ
            pack.setOperateTime(new Date());
            packRepository.flush();
        }
        return "redirect:/pack/packList/"+pack.getItemId();
    }

    /**
     * ɾ�����
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
