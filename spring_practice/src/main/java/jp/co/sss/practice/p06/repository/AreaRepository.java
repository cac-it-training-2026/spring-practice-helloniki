package jp.co.sss.practice.p06.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.sss.practice.p06.entity.Area;

public interface AreaRepository extends JpaRepository<Area, Integer> {

	List<Area> findAllByOrderByAreaIdAsc();

	List<Area> findAllByAreaId(Integer areaId);

	Area findByAreaId(Integer areaId);
}
