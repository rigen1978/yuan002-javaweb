package com.yuan.pojo;

/**
 * @className: Brand
 * @package: com.yuan.pojo
 * @description:
 * @author: liyuan
 * @create: 2024/01/28 1:06
 * @version: 1.0
 */
public class Brand {
  // id キー
  private Integer id;
  // メーカー名称
  private String brandName;
  // 企業名称
  private String companyName;
  // ordered
  private Integer ordered;
  // インフォメーション
  private String description;
  // 状態：0：禁止  1：起動
  private Integer status;

  public Integer getId() {
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
    return "Brand{"
        + "id="
        + id
        + ", brandName='"
        + brandName
        + '\''
        + ", companyName='"
        + companyName
        + '\''
        + ", ordered="
        + ordered
        + ", description='"
        + description
        + '\''
        + ", status="
        + status
        + '}';
  }
}
