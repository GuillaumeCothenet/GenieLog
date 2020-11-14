package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class GildedRoseTest {

  private static final String AGEDBRIE = "Aged Brie";
  private static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
  private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
  private static final String NORMALITEM = "Normal item";
  private static final String CONJURED = "Conjured item";

  @Test
  void foo() {
    final Item[] items = new Item[] {new Item(NORMALITEM, 0, 0)};
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.getFirstItem().name, is(NORMALITEM));
  }

  //Test global
  @Test
  void toStringTest() {
    final Item[] items = new Item[] {new Item(NORMALITEM, 0, 0)};
    final GildedRose app = new GildedRose(items);
    assertThat(app.getFirstItem().toString(), is(NORMALITEM + ", 0, 0"));
  }


  //Tests normal items
  @Test
  void testSellInDecrementBy1() {
    final Item[] items = new Item[] {new Item(NORMALITEM, 5, 9)};
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.getFirstItem().sellIn, is(4));
  }

  @Test
  void testQualityDecrementBy1() {
    final Item[] items = new Item[] {new Item(NORMALITEM, 5, 9)};
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.getFirstItem().quality, is(8));
  }

  @Test
  void testNonNegativeQuality() {
    final Item[] items = new Item[] {new Item(NORMALITEM, 5, 0)};
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.getFirstItem().quality, is(0));
  }

  @Test
  void testQualityDegradationX2WhenSellInNegative() {
    final Item[] items = new Item[] {new Item(NORMALITEM, -3, 9)};
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.getFirstItem().quality, is(7));
  }



  //Tests Aged Brie items
  @Test
  void testAgedBrieSellInDecrementBy1() {
    final Item[] items = new Item[] {new Item(AGEDBRIE, 5, 9)};
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.getFirstItem().sellIn, is(4));
  }

  @Test
  void testAgedBrieQualityIncreaseBy1() {
    final Item[] items = new Item[] {new Item(AGEDBRIE, 5, 9)};
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.getFirstItem().quality, is(10));
  }

  @Test
  void testAgedBrieQualityWhenSellInNeg() {
    final Item[] items = new Item[] {new Item(AGEDBRIE, -1, 10)};
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.getFirstItem().quality, is(12));
  }

  @Test
  void testAgedBrieQualityEqual50SellInPositive() {
    final Item[] items = new Item[] {new Item(AGEDBRIE, 5, 50)};
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.getFirstItem().quality, is(50));
  }

  @Test
  void testAgedBrieQualityEqual50SellInNegative() {
    final Item[] items = new Item[] {new Item(AGEDBRIE, -6, 50)};
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.getFirstItem().quality, is(50));
  }




  //Tests Sulfuras items
  @Test
  void testSulfurasConstantQuality() {
    final Item[] items = new Item[] {new Item(SULFURAS, 0, 80)};
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.getFirstItem().quality, is(80));
  }

  @Test
  void testSulfurasConstantSellInPositive() {
    final Item[] items = new Item[] {new Item(SULFURAS, 2, 80)};
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.getFirstItem().sellIn, is(2));
  }

  @Test
  void testSulfurasConstantSellInNegative() {
    final Item[] items = new Item[] {new Item(SULFURAS, -1, 80)};
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.getFirstItem().sellIn, is(-1));
  }



  //Tests backstage items
  @Test
  void testBackstageSellInDecrementBy1() {
    final Item[] items = new Item[] {new Item(BACKSTAGE, 5, 9)};
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.getFirstItem().sellIn, is(4));
  }

  @Test
  void testBackstageQualityIncreaseBy1WhenSellInGreaterThan10() {
    final Item[] items = new Item[] {new Item(BACKSTAGE, 15, 6)};
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.getFirstItem().quality, is(7));
  }

  @Test
  void testBackstageQualityWhenSellInBetween10And5() {
    final Item[] items = new Item[] {new Item(BACKSTAGE, 9, 6)};
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.getFirstItem().quality, is(8));
  }

  @Test
  void testBackstageQualityWhenSellInBetween10And5AndQuality50() {
    final Item[] items = new Item[] {new Item(BACKSTAGE, 9, 50)};
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.getFirstItem().quality, is(50));
  }

  @Test
  void testBackstageQualityWhenSellInLowerThan5() {
    final Item[] items = new Item[] {new Item(BACKSTAGE, 4, 6)};
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.getFirstItem().quality, is(9));
  }

  @Test
  void testBackstageQualityWhenSellInLowerThan5AndQuality50() {
    final Item[] items = new Item[] {new Item(BACKSTAGE, 4, 50)};
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.getFirstItem().quality, is(50));
  }

  @Test
  void testBackstageQualityWhenSellInNegative() {
    final Item[] items = new Item[] {new Item(BACKSTAGE, -1, 6)};
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.getFirstItem().quality, is(0));
  }

  @Test
  void testBackstageQualityEqual50() {
    final Item[] items = new Item[] {new Item(BACKSTAGE, 3, 50)};
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.getFirstItem().quality, is(50));
  }


  //Tests Conjured item
  @Test
  void testConjuredSellInDecrementBy1() {
    final Item[] items = new Item[] {new Item(CONJURED, 5, 9)};
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.getFirstItem().sellIn, is(4));
  }

  @Test
  void testConjuredQualityDecrementBy2() {
    final Item[] items = new Item[] {new Item(CONJURED, 5, 9)};
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.getFirstItem().quality, is(7));
  }

  @Test
  void testConjuredNonNegativeQuality() {
    final Item[] items = new Item[] {new Item(CONJURED, 5, 0)};
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.getFirstItem().quality, is(0));
  }

  @Test
  void testConjuredQualityDegradationX2WhenSellInNegative() {
    final Item[] items = new Item[] {new Item(CONJURED, -3, 9)};
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.getFirstItem().quality, is(5));
  }
}
