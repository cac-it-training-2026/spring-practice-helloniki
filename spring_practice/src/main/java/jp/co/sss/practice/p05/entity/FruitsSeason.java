package jp.co.sss.practice.p05.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "fruits_season")

public class FruitsSeason {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fruits_season_gen")
	@SequenceGenerator(name = "fruits_season_gen", sequenceName = "seq_fruits_season", allocationSize = 1)

	private Integer fruitId;

	@Column
	private String fruitName;

	@Column
	private Integer seasonMonth;

	/**
	 * @return id
	 */
	public Integer getFruitId() {
		return fruitId;
	}

	/**
	 * @param id セットする id
	 */
	public void setFruitId(Integer fruitId) {
		this.fruitId = fruitId;
	}

	/**
	 * @return fruitName
	 */
	public String getFruitName() {
		return fruitName;
	}

	/**
	 * @param fruitName セットする fruitName
	 */
	public void setFruitName(String fruitName) {
		this.fruitName = fruitName;
	}

	/**
	 * @return seasonMonth
	 */
	public Integer getSeasonMonth() {
		return seasonMonth;
	}

	/**
	 * @param seasonMonth セットする seasonMonth
	 */
	public void setSeasonMonth(Integer seasonMonth) {
		this.seasonMonth = seasonMonth;
	}

}
