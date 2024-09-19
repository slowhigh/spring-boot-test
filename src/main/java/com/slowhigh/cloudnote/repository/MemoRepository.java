package com.slowhigh.cloudnote.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.slowhigh.cloudnote.entity.MemoEntity;

@Repository
public interface MemoRepository extends JpaRepository<MemoEntity, Long> {

    // Query 작성 방법 - 1
    @Query("SELECT count(m) > 0 FROM #{#entityName} m WHERE m.title = :title")
    boolean existsByTitle(@Param("title") String title);

    @Query("SELECT count(m) > 0 FROM #{#entityName} m WHERE m.title = :title and m.id != :id")
    boolean existsByTitleAndIdNot(@Param("title") String title, @Param("id") long id);

    // Query 작성 방법 - 2
    // boolean existsByTitle(String title);

    // boolean existsByTitleAndIdNot(String title, Long id);

    // Query 작성 방법 - 3
    // @Query("SELECT count(m) > 0 FROM #{#entityName} m WHERE m." +
    // MemoEntity.TITLE + " = :title")
    // boolean existsByTitle(@Param("title") String title);

    // @Query("SELECT count(m) > 0 FROM #{#entityName} m WHERE m." +
    // MemoEntity.TITLE + " = :title and m." + MemoEntity.ID + " != :id")
    // boolean existsByTitleAndIdNot(@Param("title") String title, @Param("id") long
    // id);
}
