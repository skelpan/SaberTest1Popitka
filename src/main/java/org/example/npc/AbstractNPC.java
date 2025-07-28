package org.example.npc;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

@FieldDefaults(level = AccessLevel.PROTECTED)
public abstract class AbstractNPC implements NpcService {

  String name;
  Entity entity;
  Location location;
  @Getter
  Inventory inventory;

  public AbstractNPC(String name, Location location) {
    this.name = name;
    this.location = location;
    this.inventory = Bukkit.createInventory(e, 9, name + "'s Inventory");
  }

  @Override
  public void spawn(Location location) {
    this.location = location;
  }

  @Override
  public void despawn() {
    if (entity != null && !entity.isDead()) entity.remove();
  }

  @Override
  public void setName(String name) {
    this.name = name;
    if (entity != null) entity.setCustomName(name);
  }

  @Override
  public void setEntity(Entity entity) {
    this.entity = entity;
  }

  @Override
  public Entity getEntity() {
    return entity;
  }

  public void onInteract(Player player) {
    player.openInventory(inventory);
  }


}


