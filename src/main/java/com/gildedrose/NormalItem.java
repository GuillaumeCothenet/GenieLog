package com.gildedrose;

public class NormalItem extends Item {

  public NormalItem(Item itemParameter) {
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
      this.quality -= QUALITY_INCREASE;
    }
    if (this.quality > MIN_QUALITY) {
      this.quality -= QUALITY_INCREASE;
    }
  }
}
