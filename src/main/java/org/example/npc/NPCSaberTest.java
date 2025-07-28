package org.example.npc;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Villager;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import static org.bukkit.Bukkit.getName;

public abstract class  NPCSaberTest extends AbstractNPC {
    public NPCSaberTest(String name, Location location) {
        super(name, location);
    }

    @Override
    public void spawn(Location location) {
        try {
            World world = location.getWorld();
            if (world == null) throw new IllegalStateException("Мир не загружен!");

            Villager villager = (Villager) world.spawnEntity(location, EntityType.VILLAGER);
            villager.setCustomName(getName());
            villager.setAI(false);
            villager.setInvulnerable(true);
            villager.setCollidable(false);
            villager.addPotionEffect(new PotionEffect(
                    PotionEffectType.DAMAGE_RESISTANCE,
                    Integer.MAX_VALUE,
                    5,
                    true,
                    false
            ));
            this.setEntity(villager);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
