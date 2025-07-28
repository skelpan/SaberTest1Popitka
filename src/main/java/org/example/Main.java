package org.example;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.example.npc.ListenerNPC;
import org.example.npc.NPCManager;
import org.example.npc.NPCSaberTest;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main extends JavaPlugin {
    private NPCManager npcManager;

    @Override
    public void onEnable() {
        npcManager = new NPCManager();
        getServer().getPluginManager().registerEvents(new ListenerNPC(npcManager), this);

        // Задержка для гарантированной загрузки мира
        Bukkit.getScheduler().scheduleSyncDelayedTask(this, () -> {
            Location npcLoc = new Location(
                    Bukkit.getWorld("world"),
                    100.5,
                    70.0,
                    200.5,
                    180f,
                    0f
            );

            NPCSaberTest npc = npcManager.createNPC(
                    NPCSaberTest.class,
                    "§6Торговец",
                    npcLoc
            );

            if (npc != null) {
                getLogger().info("NPC успешно создан на " + npcLoc);
            } else {
                getLogger().severe("Не удалось создать NPC! Смотрите логи выше.");
            }
        }, 20L); // 1 секунда задержки
    }
}