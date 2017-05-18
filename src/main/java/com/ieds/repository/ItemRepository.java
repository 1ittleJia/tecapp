package com.ieds.repository;

import com.ieds.model.ItemInfoEntity;
import com.ieds.support.CustomRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by jia on 2017/5/2.
 */
@Repository
public interface ItemRepository extends CustomRepository<ItemInfoEntity,Integer> {

    @Modifying      // ˵���÷������޸Ĳ���
    @Transactional  // ˵���÷����������Բ���
    // �����ѯ
    // @Paramע��������ȡ����
    @Query("update ItemInfoEntity i set i.itemNm=:itemNm, i.bidId=:bidId, i.operateTime=:operateTime where i.id=:id")
    public abstract void updateItem(@Param("itemNm") String itemNm, @Param("bidId") String bidId,
                                    @Param("operateTime") Date operateTime, @Param("id") Integer id);

    // �����ѯ
    // @Paramע��������ȡ����
    @Query(value="select * from item_info where item_nm like CONCAT('%',?1,'%')", nativeQuery = true)
    public abstract List<ItemInfoEntity> findAllByItemNm(String itemNm);
}
