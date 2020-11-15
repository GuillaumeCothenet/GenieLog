package com.gildedrose;
import java.util.ArrayList;

public class GildedRose {

  private final ArrayList<Item> realItems;

  public GildedRose(Item[] items) {
    if (items == null) {
      throw new IllegalArgumentException("Argument cannot be null !");
    }
    this.realItems = new ArrayList<Item>();
    for (Item itemSelected: items) {
      this.realItems.add(getRealItem(itemSelected));
    }
  }

  public Item getFirstItem() {
    return this.realItems.get(0);
  }

  public void updateQuality() {
    for (Item itemSelected: this.realItems) {
      itemSelected.update();
    }
  }

  private Item getRealItem(Item itemParameter) {
    final ItemFactory factory = new ItemFactory(itemParameter);
    return factory.createItem(itemParameter);
  }
}

