package com.gildedrose;
import java.util.Map;
import java.util.HashMap;

public class ItemFactory {

  private final transient Map<String, Item> typeClass;
  private final static String REGEX = "[A-Za-z0-9 ]*[C|c]onjured[A-Za-z0-9 ]*";

  public ItemFactory(Item itemParameter) {
    if (itemParameter == null) {
      throw new IllegalArgumentException("Argument cannot be null !");
    }
    this.typeClass = new HashMap<String, Item>();
    this.typeClass.put("Aged Brie", new AgedBrie(itemParameter));
    this.typeClass.put("Sulfuras, Hand of Ragnaros", new Sulfuras(itemParameter));
    this.typeClass.put("Backstage passes to a TAFKAL80ETC concert", new Backstage(itemParameter));
    this.typeClass.put("Conjured", new ConjuredItem(itemParameter));
  }

  public Item createItem(Item itemParameter) {
    if (isConjured(itemParameter)) {
      return typeClass.get("Conjured");
    }
    if (!isNormal(itemParameter)) {
      return typeClass.get(itemParameter.name);
    }
    return new NormalItem(itemParameter);
  }

  private boolean isNormal(Item itemParameter) {
    return !typeClass.containsKey(itemParameter.name);
  }

  private boolean isConjured(Item itemParameter) {
    return itemParameter.name.matches(REGEX);
  }
}
