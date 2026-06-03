package jp.co.sss.practice.p06.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "area")
public class Area {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "area_gen")
	@SequenceGenerator(name = "area_gen", sequenceName = "seq_area", allocationSize = 1)
	private Integer areaId;

	@Column
	private String areaName;

	@Column
	private String detail;

	/**
	 * @return areaId
	 */
	public Integer getAreaId() {
		return areaId;
	}

	/**
	 * @param areaId セットする areaId
	 */
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	/**
	 * @return areaName
	 */
	public String getAreaName() {
		return areaName;
	}

	/**
	 * @param areaName セットする areaName
	 */
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	/**
	 * @return detail
	 */
	public String getDetail() {
		return detail;
	}

	/**
	 * @param detail セットする detail
	 */
	public void setDetail(String detail) {
		this.detail = detail;
	}

}
