package jp.co.sss.practice.p07.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "fruits_shop_items")
@NamedQuery(name = "findNamedQueryByPriceRangeAndType", query = "SELECT f FROM FruitsShopItem f WHERE f.price BETWEEN :min AND :max AND f.type=:type ORDER \n"
		+ "BY f.price,f.itemId ")
public class FruitsShopItem {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fruits_shop_items_gen")
	@SequenceGenerator(name = "fruits_shop_items_gen", sequenceName = "seq_fruits_shop_items", allocationSize = 1)
	private Integer itemId;

	@Column
	private String itemName;

	@Column
	private Integer price;

	@ManyToOne
	@JoinColumn(name = "type_id", referencedColumnName = "typeId")
	private Type type;

	/**
	 * @return itemId
	 */
	public Integer getItemId() {
		return itemId;
	}

	/**
	 * @param itemId セットする itemId
	 */
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	/**
	 * @return itemName
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * @param itemName セットする itemName
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * @return price
	 */
	public Integer getPrice() {
		return price;
	}

	/**
	 * @param price セットする price
	 */
	public void setPrice(Integer price) {
		this.price = price;
	}

	/**
	 * @return type
	 */
	public Type getType() {
		return type;
	}

	/**
	 * @param type セットする type
	 */
	public void setType(Type type) {
		this.type = type;
	}

}
