package org.example.npc;

import org.bukkit.entity.Entity;
import org.bukkit.Location;
import org.bukkit.entity.AnimalTamer;
import org.bukkit.entity.Entity;
public interface NpcService {

void spawn (Location location);
void despawn();
void setName(String name);
    void setEntity(Entity entity);
    Entity getEntity();
}
