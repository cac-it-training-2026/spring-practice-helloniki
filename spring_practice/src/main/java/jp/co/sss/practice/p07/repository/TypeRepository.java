package jp.co.sss.practice.p07.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.sss.practice.p07.entity.Type;

public interface TypeRepository extends JpaRepository<Type, Integer> {

	Type findByTypeId(Integer typeId);

}
