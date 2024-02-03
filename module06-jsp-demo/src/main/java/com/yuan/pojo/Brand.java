package com.yuan.pojo;

/**
 * @className: Brand
 * @package: com.yuan.pojo
 * @description:
 * @author: liyuan
 * @create: 2024/02/03 10:15
 * @version: 1.0
 */

/**
 * brand javabean
 */

public class Brand {
	// id
	private Integer id;
	// メーカー
	private String brandName;
	// 企業名称
	private String companyName;
	// ランキング
	private Integer ordered;
	// 紹介
	private String description;
	// 状態：0：禁用  1：启用
	private Integer status;


	public Brand() {
	}

	public Brand(Integer id, String brandName, String companyName, String description) {
		this.id = id;
		this.brandName = brandName;
		this.companyName = companyName;
		this.description = description;
	}

	public Brand(Integer id, String brandName, String companyName, Integer ordered, String description, Integer status) {
		this.id = id;
		this.brandName = brandName;
		this.companyName = companyName;
		this.ordered = ordered;
		this.description = description;
		this.status = status;
	}

	// getId  ${brand.id}   Id   getId
	public Integer getId() {
		System.out.println("getId...");
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Integer getOrdered() {
		return ordered;
	}

	public void setOrdered(Integer ordered) {
		this.ordered = ordered;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Brand{" +
				"id=" + id +
				", brandName='" + brandName + '\'' +
				", companyName='" + companyName + '\'' +
				", ordered=" + ordered +
				", description='" + description + '\'' +
				", status=" + status +
				'}';
	}
}
