package com.gildedrose;

public class Sulfuras extends Item {

  public Sulfuras(Item itemParameter) {
    super(itemParameter.name, itemParameter.sellIn, itemParameter.quality);
  }

  @Override
  public void update() {
  }
}
