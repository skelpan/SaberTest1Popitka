package org.example.npc;

import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class NPCManager {
    private final Map<UUID, NpcService> npcs = new HashMap<>();

    public <T extends NpcService> T createNPC(Class<T> npcClass, String name, Location location) {
        try {
            T npc =Constructor.newIn
            npc.spawn(location);
            npcs.put(UUID.randomUUID(), npc);
            return npc;
        } catch (Exception e) {
            Bukkit.getLogger().severe("Ошибка при создании NPC: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public Map<UUID, NpcService> getNPCs() {
        return new HashMap<>(npcs);
    }
}


