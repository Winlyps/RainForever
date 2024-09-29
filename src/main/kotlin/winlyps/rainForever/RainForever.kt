package winlyps.rainForever

import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.scheduler.BukkitRunnable

class RainForever : JavaPlugin() {

    override fun onEnable() {
        // Register the event listener
        server.pluginManager.registerEvents(WeatherChangeListener(this), this)

        // Start a task to periodically ensure rain
        object : BukkitRunnable() {
            override fun run() {
                server.worlds.forEach { world ->
                    if (!world.hasStorm()) {
                        world.setStorm(true)
                        world.weatherDuration = Integer.MAX_VALUE
                    }
                    if (world.isThundering) {
                        world.setThundering(false)
                        world.thunderDuration = 0
                    }
                }
            }
        }.runTaskTimer(this, 0L, 20L * 60L) // Check every minute

        logger.info("SnowForever plugin has been enabled!")
    }

    override fun onDisable() {
        logger.info("SnowForever plugin has been disabled!")
    }
}