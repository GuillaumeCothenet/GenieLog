package com.gildedrose;

public class ConjuredItem extends Item {

  private static final int CONJUREDFACTOR = 2;

  public ConjuredItem(Item itemParameter) {
    super(itemParameter.name, itemParameter.sellIn, itemParameter.quality);
  }

  @Override
  public void update() {
    this.updateSellIn();
    this.updateQuality();
  }

  private void updateSellIn() {
    this.sellIn -= SELLIN_DECREASE;
  }

  private void updateQuality() {
    if (this.sellIn < SELLIN_CAP && this.quality > MIN_QUALITY) {
      this.quality -= QUALITY_INCREASE * CONJUREDFACTOR;
    }
    if (this.quality > MIN_QUALITY) {
      this.quality -= QUALITY_INCREASE * CONJUREDFACTOR;
    }
  }
}
