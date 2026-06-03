package jp.co.sss.practice.p07.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.sss.practice.p07.entity.FruitsShopItem;

public interface FruitsShopItemRepository extends JpaRepository<FruitsShopItem, Integer> {

}
