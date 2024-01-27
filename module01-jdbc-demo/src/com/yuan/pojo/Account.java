package com.yuan.pojo;

/**
 * @className: Account
 * @package: com.yuan.pojo
 * @description:
 * @author: liyuan
 * @create: 2024/01/27 1:43
 * @version: 1.0
 */
public class Account {
  private int id;
  private String name;
  private double money;

  public Account() {}

  public Account(int id, String name, double money) {
    this.id = id;
    this.name = name;
    this.money = money;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getMoney() {
    return money;
  }

  public void setMoney(double money) {
    this.money = money;
  }

  @Override
  public String toString() {
    return "Account{" + "id=" + id + ", name='" + name + '\'' + ", money=" + money + '}';
  }
}
