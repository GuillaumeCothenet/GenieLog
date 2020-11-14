package com.gildedrose;

public class Backstage extends Item {

  private static final int SELLIN_BACKSTAGE_CAP1 = 10;
  private static final int SELLIN_BACKSTAGE_CAP2 = 5;

  public Backstage(Item itemParameter) {
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

    checkQualityLowerThanCAP(SELLIN_BACKSTAGE_CAP1);

    checkQualityLowerThanCAP(SELLIN_BACKSTAGE_CAP2);

    if (!isQualityMax()) {
      this.quality += QUALITY_INCREASE;
    }

    if (this.sellIn <= SELLIN_CAP) {
      this.quality = MIN_QUALITY;
    }
  }

  private void checkQualityLowerThanCAP(int cap) {
    if (this.sellIn <= cap && !isQualityMax()) {
      this.quality += QUALITY_INCREASE;
    }
  }

  private boolean isQualityMax() {
    return this.quality == MAX_QUALITY;
  }
}
