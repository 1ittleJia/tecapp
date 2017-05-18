package com.ieds.repository;

import com.ieds.model.PackInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
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
public interface PackRepository extends JpaRepository<PackInfoEntity, Integer> {

    // 定义查询
    // @Param注解用于提取参数
    @Query("select p from PackInfoEntity p where p.itemId=?1")
    public List<PackInfoEntity> findListById(@Param("itemId") Integer itemId);


    @Query("select p from PackInfoEntity p where p.id in(:packIds)")
    List<PackInfoEntity> findListByIds(@Param("packIds") List<Integer> packIds);

    @Modifying      // 说明该方法是修改操作
    @Transactional  // 说明该方法是事务性操作
    @Query("update PackInfoEntity p set p.evalueNumReal=?1,p.evalueNumEffect=?2, p.extractClass=?3, p.extractStatue=?4, p.operateTime=?5 where p.id=?6")
    void updatePackExtractInfo(Integer evalueNumReal, Integer evalueNumEffect, String extractClass, String extractStatue, Date operateTime, int id);


    @Modifying
    @Transactional
    @Query("update PackInfoEntity p set p.evalueNumEffect=(p.evalueNumEffect-1), p.operateTime=?1 where p.id=?2")
    void updatePackEvalueNumEffect(Date operateTime, int id);
}
