package jp.co.sss.practice.p06.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.sss.practice.p06.entity.FruitsArea;

public interface FruitsAreaRepository extends JpaRepository<FruitsArea, Integer> {
	List<FruitsArea> findAllByAreaAreaIdOrderByFruitIdAsc(Integer areaId);

}
