package com.project.store.repositories;

import com.project.store.entities.BikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BikeRepository extends JpaRepository<BikeEntity, Integer> {

     @Query(value="select * from bikes where brand like %?1%", nativeQuery = true)
     List<BikeEntity> findByKeyword(@Param("keyword") String keyword);


     @Query(value="select * from bikes where category_id=1", nativeQuery = true)
     List<BikeEntity> findByMenBikes(@Param("keyword") String keyword);

     @Query(value="select * from bikes where category_id=2", nativeQuery = true)
     List<BikeEntity> findByLadiesBikes(@Param("keyword") String keyword);

     @Query(value="select * from bikes where category_id=3", nativeQuery = true)
     List<BikeEntity> findByChildrenBikes(@Param("keyword") String keyword);

     @Query(value="select * from bikes where category_id=4", nativeQuery = true)
     List<BikeEntity> findByElectricBikes(@Param("keyword") String keyword);

     @Query(value="select * from bikes where category_id=5", nativeQuery = true)
     List<BikeEntity> findBySportBikes(@Param("keyword") String keyword);

}
