package com.ieds.repository;

import com.ieds.model.MajorInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jia on 2017/5/4.
 */
@Repository
public interface MajorRepository extends JpaRepository<MajorInfoEntity, Integer> {

    // 定义查询
    // @Param注解用于提取参数
    @Query("select m from MajorInfoEntity m where m.id=?1")
    public List<MajorInfoEntity> findListById(@Param("id") Integer id);
}
