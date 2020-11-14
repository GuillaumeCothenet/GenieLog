package com.gildedrose;

public class Item {

  protected static final int MIN_QUALITY = 0;
  protected static final int MAX_QUALITY = 50;
  protected static final int QUALITY_DECREASE = 1;
  protected static final int QUALITY_INCREASE = 1;
  protected static final int SELLIN_CAP = 0;
  protected static final int SELLIN_DECREASE = 1;

  public String name;

  public int sellIn;

  public int quality;

  public Item(String name, int sellIn, int quality) {
    this.name = name;
    this.sellIn = sellIn;
    this.quality = quality;
  }

  public void update() {
  }

  @Override
  public String toString() {
    return this.name + ", " + this.sellIn + ", " + this.quality;
  }
}
