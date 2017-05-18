package com.ieds.controller;

import com.ieds.model.ExpertInfoEntity;
import com.ieds.model.ItemInfoEntity;
import com.ieds.model.PackExtractExpertEntity;
import com.ieds.model.PackInfoEntity;
import com.ieds.model.bo.ExtractBo;
import com.ieds.repository.ExpertRepository;
import com.ieds.repository.ExtractExpertRepository;
import com.ieds.repository.ItemRepository;
import com.ieds.repository.PackRepository;
import com.ieds.util.DateUtils;
import com.ieds.util.ExportExcelUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by jia on 2017/5/7.
 */
@Controller
public class ExtractExpertController {

    //@Autowired
    //sItemRepository itemRepository;

    @Autowired
    PackRepository packRepository;

    @Autowired
    ExpertRepository expertRepository;

    @Autowired
    ExtractExpertRepository extractExpertRepository;

    /**
     * 项目列表页面
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/extract/itemList", method = {RequestMethod.GET,RequestMethod.POST})
    public String getItemList(@ModelAttribute("item") ItemInfoEntity item, ModelMap modelMap) {
        List<ItemInfoEntity> itemList = new ArrayList<>();
        if(item.getItemNm()!=null&&!"".equals(item.getItemNm())){
            //itemList = itemRepository.findAllByItemNm(item.getItemNm());
        }else{
            //itemList = itemRepository.findAll();
        }
        modelMap.addAttribute("itemList", itemList);
        return "extract/itemList";
    }

    /**
     * 标段列表页面
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/extract/packList/{id}", method = RequestMethod.GET)
    public String getPackList(@PathVariable("id") Integer itemId, ModelMap modelMap) {
        List<PackInfoEntity> packList = packRepository.findListById(itemId);
        modelMap.addAttribute("packList", packList);
        modelMap.addAttribute("itemId", itemId);
        return "/extract/packList";
    }

    /**
     * 专家抽取
     * @param extract
     * @return
     */
    @RequestMapping(value = "/extract/expertExtract", method = RequestMethod.POST)
    public String expertExtractPost(@ModelAttribute("extract") ExtractBo extract) {
        List<ExpertInfoEntity> expertList = expertRepository.findListByRand(extract.getExtractClass(),extract.getEvalueNum());
        List<Integer> packIds = new ArrayList<>();
        for(String id:extract.getPackIds().split(",")) {
            packIds.add(Integer.valueOf(id));
        }
        List<PackInfoEntity> packList = packRepository.findListByIds(packIds);
        for(PackInfoEntity pack:packList){
            pack.setEvalueNumReal((pack.getEvalueNumReal()==null?0:pack.getEvalueNumReal())+extract.getEvalueNum());
            pack.setEvalueNumEffect((pack.getEvalueNumEffect()==null?0:pack.getEvalueNumEffect())+extract.getEvalueNum());
            pack.setExtractClass(pack.getExtractClass()+","+extract.getExtractClass());
            pack.setExtractStatue("1");
            for(ExpertInfoEntity expert:expertList){
                PackExtractExpertEntity packExtract = new PackExtractExpertEntity();
                packExtract.setDelFlag("0");
                packExtract.setDelFlagNm("Y");
                packExtract.setExpertId(expert.getId());
                packExtract.setExpertNm(expert.getExpertNm());
                packExtract.setPhone(expert.getPhone());
                packExtract.setPackSeq(pack.getId());
                packExtract.setPackId(pack.getPackId());
                packExtract.setPackNm(pack.getPackNm());
                packExtract.setOperateTime(new Date());
                packExtract.setExtractClass(extract.getExtractClass());
                extractExpertRepository.saveAndFlush(packExtract);
            }
            packRepository.updatePackExtractInfo(pack.getEvalueNumReal(), pack.getEvalueNumEffect(),
                    pack.getExtractClass(),pack.getExtractStatue(),new Date(),pack.getId());
            packRepository.flush();
        }
        return "redirect:/extract/packList/"+extract.getItemId();
    }

    /**
     * 标段列表页面
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/extract/packExpertExtractList/{packSeq}.{itemId}", method = RequestMethod.GET)
    public String getPackExpertExtractList(@PathVariable("packSeq") Integer packSeq,@PathVariable("itemId") Integer itemId, ModelMap modelMap) {
        List<PackExtractExpertEntity> packExtractExpertList = extractExpertRepository.findListByPackId(packSeq);
        modelMap.addAttribute("packExtractExpertList", packExtractExpertList);
        modelMap.addAttribute("itemId", itemId);
        modelMap.addAttribute("packSeq", packSeq);
        return "/extract/packExpertExtractList";
    }

    /**
     * 专家抽取
     * @param extract
     * @return
     */
    @RequestMapping(value = "/extract/expertMakeUp", method = RequestMethod.POST)
    public String expertMakeUpPost(@ModelAttribute("extract") ExtractBo extract) {
        List<PackExtractExpertEntity> packExtractExpertList = extractExpertRepository.findListByPackId(extract.getPackSeq());
        List<Integer> expertIdList = new ArrayList<>();
        for(PackExtractExpertEntity expertEntity:packExtractExpertList){
            expertIdList.add(expertEntity.getExpertId());
        }
        List<ExpertInfoEntity> expertList = new ArrayList<>();
        if(expertIdList.size()<1){
            expertList = expertRepository.findListByRand(extract.getExtractClass(),extract.getEvalueNum());
        }else{
            expertList = expertRepository.findListByRand(extract.getExtractClass(),expertIdList,extract.getEvalueNum());
        }
        List<Integer> packIds = new ArrayList<>();
        packIds.add(Integer.valueOf(extract.getPackSeq()));
        List<PackInfoEntity> packList = packRepository.findListByIds(packIds);
        for(PackInfoEntity pack:packList){
            pack.setEvalueNumReal((pack.getEvalueNumReal()==null?0:pack.getEvalueNumReal())+extract.getEvalueNum());
            pack.setEvalueNumEffect((pack.getEvalueNumEffect()==null?0:pack.getEvalueNumEffect())+extract.getEvalueNum());
            pack.setExtractClass(pack.getExtractClass()+","+extract.getExtractClass());
            pack.setExtractStatue("1");
            for(ExpertInfoEntity expert:expertList){
                PackExtractExpertEntity packExtract = new PackExtractExpertEntity();
                packExtract.setDelFlag("0");
                packExtract.setDelFlagNm("Y");
                packExtract.setExpertId(expert.getId());
                packExtract.setExpertNm(expert.getExpertNm());
                packExtract.setPhone(expert.getPhone());
                packExtract.setPackSeq(pack.getId());
                packExtract.setPackId(pack.getPackId());
                packExtract.setPackNm(pack.getPackNm());
                packExtract.setOperateTime(new Date());
                packExtract.setExtractClass(extract.getExtractClass());
                extractExpertRepository.saveAndFlush(packExtract);
            }
            packRepository.updatePackExtractInfo(pack.getEvalueNumReal(),pack.getEvalueNumEffect(),
                    pack.getExtractClass(),pack.getExtractStatue(),new Date(),pack.getId());
            packRepository.flush();
        }
        return "redirect:/extract/packExpertExtractList/"+extract.getPackSeq()+"."+extract.getItemId();
    }

    /**
     * 设置取消原因
     * @param extract
     * @return
     */
    @RequestMapping(value = "/extract/cancelExtract", method = RequestMethod.POST)
    public String cancelExtract(@ModelAttribute("extract") ExtractBo extract) {
        extractExpertRepository.updateExtractResult(extract.getReason(), new Date(), extract.getExtractExpertId());
        packRepository.updatePackEvalueNumEffect(new Date(),extract.getPackSeq());
        return "redirect:/extract/packExpertExtractList/"+extract.getPackSeq()+"."+extract.getItemId();
    }

    /**
     * 描述：通过ietmId导出抽取到的专家列表
     * @param response
     * @throws Exception
     */
    @RequestMapping(value="/extract/exportExcel",method=RequestMethod.POST)
    public  String  exportExcel(@ModelAttribute("extract") ExtractBo extract,HttpServletRequest request,HttpServletResponse response) throws Exception {
        List<PackExtractExpertEntity> peeList = extractExpertRepository.findListByItemId(extract.getItemId());
        OutputStream os = null;
        Workbook wb = null;    //工作薄
        try {
            //模拟数据库取值
            //导出Excel文件数据
            ExportExcelUtil util = new ExportExcelUtil();
            String sheetName="sheet1";
            File file =util.getExcelDemoFile("/template/extractExpertTemp.xlsx");
            wb = util.writeNewExcel(file, sheetName,peeList);
            String fileName= DateUtils.dateToString1(new Date(),"yyyy-MM-dd")+".xlsx";
            String agent = request.getHeader("User-Agent").toLowerCase();
            String name;
            if(agent.indexOf("msie") > 0 || agent.indexOf("trident") > 0){
                name = URLEncoder.encode(fileName, "UTF-8");
            } else {
                name = new String(fileName.getBytes("UTF-8"), "iso8859-1");
            }
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-disposition", "attachment;filename="+name );
            os = response.getOutputStream();
            wb.write(os);
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            os.flush();
            os.close();
            wb.close();
        }
        return null;
    }



}
