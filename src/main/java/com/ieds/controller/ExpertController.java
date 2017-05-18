package com.ieds.controller;

import com.ieds.model.ExpertInfoEntity;
import com.ieds.repository.ExpertRepository;
import com.ieds.util.ImportExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by jia on 2017/5/2.
 */
@Controller
public class ExpertController {
    @Autowired
    ExpertRepository expertRepository;

    /**
     * 专家列表
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/expert/expertList", method = {RequestMethod.GET,RequestMethod.POST})
    public String getExpertList(@ModelAttribute("expert") ExpertInfoEntity expert, ModelMap modelMap) {
        List<ExpertInfoEntity> expertList = new ArrayList<>();
        boolean expNm = (expert.getExpertNm()!=null&&!"".equals(expert.getExpertNm()));
        boolean extClass = expert.getExtractClass()!=null;
        if(!expNm&&extClass){
            expertList = expertRepository.findAllByKeyName(expert.getExtractClass());
        }else if(expNm&&extClass){
            expertList = expertRepository.findAllByNmAndClass(expert.getExpertNm(),expert.getExtractClass());
        }else{
            expertList = expertRepository.findAll();
        }
        modelMap.addAttribute("expertList", expertList);
        return "/expert/expertList";
    }

    /**
     * 跳转到添加页面
     * @return
     */
    @RequestMapping(value = "/expert/add", method = RequestMethod.GET)
    public String addExpert() {
        return "/expert/addExpert";
    }

    /**
     * post请求，处理添加用户请求，并重定向到用户管理页面
     * @param expert
     * @return
     */
    @RequestMapping(value = "/expert/addExpert", method = RequestMethod.POST)
    public String addExpertPost(@ModelAttribute("expert") ExpertInfoEntity expert) {
        if(expert.getId()==0){
            expert.setOperateTime(new Date());
            expertRepository.saveAndFlush(expert);
        }else{
            // 更新用户信息
            expert.setOperateTime(new Date());
            expertRepository.flush(); // 刷新缓冲区
        }
        return "redirect:/expert/expertList";
    }

    /**
     * 跳转到导入页面
     * @return
     */
    @RequestMapping(value = "/expert/importExcel", method = RequestMethod.GET)
    public String toImportExpert() {
        return "/expert/importExcel";
    }


    /**
     * 描述：通过传统方式form表单提交方式导入excel文件
     * @param request
     * @throws Exception
     */
    @RequestMapping(value="/expert/uploadExcel",method={RequestMethod.GET,RequestMethod.POST})
    public  String  uploadExcel(HttpServletRequest request) throws Exception {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        System.out.println("通过传统方式form表单提交方式导入excel文件！");

        InputStream in =null;
        List<List<Object>> listob = null;
        MultipartFile file = multipartRequest.getFile("upfile");
        if(file.isEmpty()){
            throw new Exception("文件不存在！");
        }
        in = file.getInputStream();
        listob = new ImportExcelUtil().getBankListByExcel(in,file.getOriginalFilename());
        in.close();
        List<ExpertInfoEntity> expertList = new ArrayList<ExpertInfoEntity>();
        String expNm = "";
        for (int i = 0; i < listob.size(); i++) {
            List<Object> lo = listob.get(i);
            List<ExpertInfoEntity> expList = expertRepository.findListByIdentCard(String.valueOf(lo.get(3)));
            if(expList.size()>0){
                expNm += String.valueOf(lo.get(1));
            }else {
                ExpertInfoEntity vo = new ExpertInfoEntity();
                vo.setExpertNm(String.valueOf(lo.get(1)));
                vo.setSex(String.valueOf(lo.get(2)));
                vo.setIdentCard(String.valueOf(lo.get(3)));
                vo.setWorkUnit(String.valueOf(lo.get(4)));
                vo.setDepartment(String.valueOf(lo.get(5)));
                vo.setPosition(String.valueOf(lo.get(6)));
                vo.setWorkTime(String.valueOf(lo.get(7)));
                vo.setPhone(String.valueOf(lo.get(8)));
                vo.setJobTitle(String.valueOf(lo.get(9)));
                vo.setEvaluationSpecialist1(String.valueOf(lo.get(10)));
                vo.setEvaluationSpecialist2(String.valueOf(lo.get(11)));
                vo.setEvaluationSpecialist3(String.valueOf(lo.get(12)));
                vo.setEvaluationSpecialist4(String.valueOf(lo.get(13)));
                vo.setExtractClass(String.valueOf(lo.get(14)));
                //vo.setMajorPerformance(String.valueOf(lo.get(14)));
                vo.setOperateTime(new Date());
                expertRepository.saveAndFlush(vo);
                expertList.add(vo);
            }
        }
        //System.out.println("=============="+expNm+"==============");
        return "redirect:/expert/expertList";
    }


    /**
     * get请求，处理删除专家请求，并重定向到专家管理页面
     * @param id
     * @return
     */
    @RequestMapping(value = "/expert/delete/{id}", method = RequestMethod.GET)
    public String deleteExpert(@PathVariable("id") Integer id) {
        expertRepository.delete(id);
        expertRepository.flush();
        return "redirect:/expert/expertList";
    }


    /**
     * get请求，处理展示专家信息请求，并跳转到详情页面
     * @param id
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/expert/view/{id}", method = RequestMethod.GET)
    public String viewExpert(@PathVariable("id") Integer id, ModelMap modelMap) {
        ExpertInfoEntity expertEntity = expertRepository.findOne(id);
        modelMap.addAttribute("expert", expertEntity);
        return "/expert/viewExpert";
    }

    /**
     * get请求，处理展示专家信息请求，并跳转到详情页面
     * @param id
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/expert/editExpert/{id}", method = RequestMethod.GET)
    public String editExpert(@PathVariable("id") Integer id, ModelMap modelMap) {
        ExpertInfoEntity expertEntity = expertRepository.findOne(id);
        modelMap.addAttribute("expert", expertEntity);
        return "/expert/editExpert";
    }

}
