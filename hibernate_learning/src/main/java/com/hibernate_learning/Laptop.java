package com.hibernate_learning;

import jakarta.persistence.Embeddable;

@Embeddable 
public class Laptop {
  public String brand;
  public int ram;
  public String processor;
  public String getBrand() {
    return brand;
  }
  public void setBrand(String brand) {
    this.brand = brand;
  }
  public int getRam() {
    return ram;
  }
  public void setRam(int ram) {
    this.ram = ram;
  }
  public String getProcessor() {
    return processor;
  }
  public void setProcessor(String processor) {
    this.processor = processor;
  }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Laptop{");
        sb.append("brand=").append(brand);
        sb.append(", ram=").append(ram);
        sb.append(", processor=").append(processor);
        sb.append('}');
        return sb.toString();
    }

  
  
}
