package com.hibernate_learning;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name="own_items")
public class Items {
  public String owner_name;
  @Column (name="age")
  @Id 
  public int owner_age;
  public Laptop laptop;
  public String getOwner_name() {
    return owner_name;
  }
  public void setOwner_name(String owner_name) {
    this.owner_name = owner_name;
  }
  public int getOwner_age() {
    return owner_age;
  }
  public void setOwner_age(int owner_age) {
    this.owner_age = owner_age;
  }
  public Laptop getLaptop() {
    return laptop;
  }
  public void setLaptop(Laptop laptop) {
    this.laptop = laptop;
  }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Items{");
        sb.append("owner_name=").append(owner_name);
        sb.append(", owner_age=").append(owner_age);
        sb.append(", laptop=").append(laptop);
        sb.append('}');
        return sb.toString();
    }
}
