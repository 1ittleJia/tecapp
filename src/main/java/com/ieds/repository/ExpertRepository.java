package com.ieds.repository;

import com.ieds.model.ExpertInfoEntity;
import org.hibernate.SessionFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by jia on 2017/5/2.
 */
@Repository
public interface ExpertRepository extends JpaRepository<ExpertInfoEntity, Integer> {


    @Query("select e from ExpertInfoEntity e where e.identCard=?1")
    public List<ExpertInfoEntity> findListByIdentCard(@Param("identCard") String identCard);

    /**
     * 抽取专家，通过专家类别、抽取数量过滤数据
     * @param extractClass
     * @param limit
     * @return
     */
    @Query(value="select * from expert_info where extract_class=:extractClass order by RAND() limit :limit ", nativeQuery = true)
    public List<ExpertInfoEntity> findListByRand(@Param("extractClass")String extractClass,@Param("limit") Integer limit);

    /**
     * 抽取专家，通过专家类别、已抽取专家ID、抽取数量过滤数据
     * @param extractClass
     * @param expertIds
     * @param limit
     * @return
     */
    @Query(value="select * from expert_info where extract_class=:extractClass and id not in(:expertIds) order by RAND() limit :limit ", nativeQuery = true)
    public List<ExpertInfoEntity> findListByRand(@Param("extractClass") String extractClass, @Param("expertIds") List<Integer> expertIds, @Param("limit") Integer limit);


    // 定义查询
    // @Param注解用于提取参数
    @Query(value="select * from expert_info where extract_class like CONCAT('%',?1,'%')", nativeQuery = true)
    public List<ExpertInfoEntity> findAllByKeyName(String keyValue);

    // 定义查询
    // @Param注解用于提取参数
    @Query(value="select * from expert_info where expert_nm like CONCAT('%',?1,'%') and extract_class like CONCAT('%',?2,'%') ", nativeQuery = true)
    public List<ExpertInfoEntity> findAllByNmAndClass(String expertNm, String extractClass);
}
