package org.example.npc;

import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class ListenerNPC implements Listener {

  private final NPCManager npcManager;

  public ListenerNPC(NPCManager npcManager) {
    this.npcManager = npcManager;
  }

  @EventHandler
  public void onPlayerInteractEntity(PlayerInteractEntityEvent event) {
    npcManager.getNPCs().values().stream()
        .filter(npc -> npc.getEntity() != null)
        .filter(npc -> npc.getEntity().equals(event.getRightClicked()))
        .findFirst()
        .ifPresent(npc -> {
          event.setCancelled(true);
          if (npc instanceof AbstractNPC) {
            ((AbstractNPC) npc).onInteract(event.getPlayer());
          }
        });
  }
}



