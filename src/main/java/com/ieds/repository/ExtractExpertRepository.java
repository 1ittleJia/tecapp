package com.ieds.repository;

import com.ieds.model.PackExtractExpertEntity;
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
public interface ExtractExpertRepository extends JpaRepository<PackExtractExpertEntity, Integer> {

    @Modifying      // 说明该方法是修改操作
    @Transactional  // 说明该方法是事务性操作
    // 定义查询
    // @Param注解用于提取参数
    @Query("update PackExtractExpertEntity pee set pee.delFlag='1', pee.delFlagNm='N', pee.reason=:reason, pee.operateTime=:operateTime where pee.id=:id")
    public void updateExtractResult(@Param("reason") String reason, @Param("operateTime") Date operateTime, @Param("id") Integer id);


    // 定义查询
    // @Param注解用于提取参数
    @Query("select pee from PackExtractExpertEntity pee where pee.packSeq=?1")
    public List<PackExtractExpertEntity> findListByPackId(@Param("packSeq") Integer packSeq);

    /**
     * 通过ID获取专家列表
     * @param itemId
     * @return
     */
    @Query(value="select * from pack_extract_expert pee where pee.pack_seq in (select p.id from pack_info p where p.item_id =:itemId) ", nativeQuery = true)
    public List<PackExtractExpertEntity> findListByItemId(@Param("itemId") Integer itemId);

}
