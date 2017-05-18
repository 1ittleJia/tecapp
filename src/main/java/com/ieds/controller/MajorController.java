package com.ieds.controller;

import com.ieds.model.MajorInfoEntity;
import com.ieds.repository.MajorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by jia on 2017/5/4.
 */
@Controller
public class MajorController {
    @Autowired
    MajorRepository majorRepository;

    /**
     * 专家专业页面
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/major/majorPage", method = RequestMethod.GET)
    public String toMajorPage(ModelMap modelMap) {
        List<MajorInfoEntity> majorList = majorRepository.findAll();
        modelMap.addAttribute("majorList", majorList);
        return "major/majorPage";
    }

    /**
     * 专家专业列表页面
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/major/majorList", method = RequestMethod.GET)
    public String getMajorList(ModelMap modelMap) {
        List<MajorInfoEntity> majorList = majorRepository.findAll();
        modelMap.addAttribute("majorList", majorList);
        return "major/majorList";
    }

    /**
     * 通过ID查询专业列表
     * @param id
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/major/majorListById/{id}", method = RequestMethod.GET)
    public String getMajorListById(@PathVariable("id") Integer id, ModelMap modelMap) {
        List<MajorInfoEntity> majorList = majorRepository.findListById(id);
        modelMap.addAttribute("majorList", majorList);
        return "major/majorList";
    }

}
