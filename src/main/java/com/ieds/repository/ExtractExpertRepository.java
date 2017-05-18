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

    @Modifying      // ˵���÷������޸Ĳ���
    @Transactional  // ˵���÷����������Բ���
    // �����ѯ
    // @Paramע��������ȡ����
    @Query("update PackExtractExpertEntity pee set pee.delFlag='1', pee.delFlagNm='N', pee.reason=:reason, pee.operateTime=:operateTime where pee.id=:id")
    public void updateExtractResult(@Param("reason") String reason, @Param("operateTime") Date operateTime, @Param("id") Integer id);


    // �����ѯ
    // @Paramע��������ȡ����
    @Query("select pee from PackExtractExpertEntity pee where pee.packSeq=?1")
    public List<PackExtractExpertEntity> findListByPackId(@Param("packSeq") Integer packSeq);

    /**
     * ͨ��ID��ȡר���б�
     * @param itemId
     * @return
     */
    @Query(value="select * from pack_extract_expert pee where pee.pack_seq in (select p.id from pack_info p where p.item_id =:itemId) ", nativeQuery = true)
    public List<PackExtractExpertEntity> findListByItemId(@Param("itemId") Integer itemId);

}
