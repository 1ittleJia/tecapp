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
    // �Զ�װ�����ݿ�ӿڣ�����Ҫ��дԭʼ��Connection���������ݿ�
    @Autowired
    ItemRepository itemRepository;

    /**
     * ��Ŀ�б�ҳ��
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
            // ��ѯitemInfo�������м�¼
            itemList = itemRepository.findAll();
        }
        Page<ItemInfoEntity> itemPage = itemRepository.findByAuto(item,pageable);
                // �����м�¼���ݸ�Ҫ���ص�jspҳ�棬����itemList����
        modelMap.addAttribute("itemPage", itemPage);
        // ����pagesĿ¼�µ�item/itemList.jspҳ��
        return "item/itemList";
    }


    /**
     * get���󣬷��������Ŀҳ��
     * @return
     */
    @RequestMapping(value = "/item/add", method = RequestMethod.GET)
    public String addItem() {
        // ת�� item/addItem.jspҳ��
        return "/item/addItem";
    }


    /**
     * post���󣬴��������Ŀ���󣬲��ض����û�����ҳ��
     * @param item
     * @return
     */
    @RequestMapping(value = "/item/addP", method = RequestMethod.POST)
    public String addUserPost(@ModelAttribute("item") ItemInfoEntity item) {

        // ע��˴���post���󴫵ݹ�������һ��UserEntity������������˸��û�����Ϣ
        // ͨ��@ModelAttribute()ע����Ի�ȡ���ݹ�����'item'���������������

        if(item.getId()==0){
            item.setOperateTime(new Date());
            // ���ݿ������һ����Ŀ��������ˢ�»���
            itemRepository.saveAndFlush(item);
        }else{
            // �����û���Ϣ
            item.setOperateTime(new Date());
            itemRepository.updateItem(item.getItemNm(), item.getBidId(),
                    item.getOperateTime(), item.getId());
            itemRepository.flush(); // ˢ�»�����
        }
        // �ض�����Ŀ����ҳ�棬����Ϊ redirect:url
        return "redirect:/item/itemList";
    }


    /**
     * get���󣬴���ɾ����Ŀ���󣬲��ض�����Ŀ����ҳ��
     * @param id
     * @return
     */
    @RequestMapping(value = "/item/delete/{id}", method = RequestMethod.GET)
    public String deleteItem(@PathVariable("id") Integer id) {
        // ���ݿ���ɾ��һ����Ŀ��������ˢ�»���
        itemRepository.delete(id);
        itemRepository.flush();
        // �ض�����Ŀ����ҳ�棬����Ϊ redirect:url
        return "redirect:/item/itemList";
    }


    /**
     * ������Ŀ��Ϣҳ��
     * @param id
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/item/update/{id}", method = RequestMethod.GET)
    public String updateUser(@PathVariable("id") Integer id, ModelMap modelMap) {
        // �ҵ�userId����ʾ���û�
        ItemInfoEntity itemEntity = itemRepository.findOne(id);
        // ���ݸ�����ҳ��
        modelMap.addAttribute("item", itemEntity);
        return "/item/addItem";
    }


}
