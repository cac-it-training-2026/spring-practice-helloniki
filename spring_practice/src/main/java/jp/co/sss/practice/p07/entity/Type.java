package jp.co.sss.practice.p07.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "type")
public class Type {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "type_gen")
	@SequenceGenerator(name = "type_gen", sequenceName = "seq_type", allocationSize = 1)
	private Integer typeId;

	@Column
	private String typeName;

	/**
	 * @return typeId
	 */
	public Integer getTypeId() {
		return typeId;
	}

	/**
	 * @param typeId セットする typeId
	 */
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	/**
	 * @return typeName
	 */
	public String getTypeName() {
		return typeName;
	}

	/**
	 * @param typeName セットする typeName
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

}
