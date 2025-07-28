package org.example.npc;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.NPC;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class NPCManager {
  private final Map<UUID, NpcService> npcs = new HashMap<>();

  public <T extends NpcService> T createNPC(Class<T> npcClass, String name, Location location) {
    try {
      T npc = npcClass.getConstructor(String.class, Location.class).newInstance(name, location);
      npc.spawn(location);
      npcs.put(UUID.randomUUID(), npc);
      return npc;
    } catch (Exception e) {
      e.printStackTrace();
      return null; // или бросьте исключение
    }
  }

  public Map<UUID, NpcService> getNPCs() {
    return new HashMap<>(npcs);
  }
}

