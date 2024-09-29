package winlyps.rainForever

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.weather.WeatherChangeEvent
import org.bukkit.plugin.java.JavaPlugin

class WeatherChangeListener(private val plugin: JavaPlugin) : Listener {

    @EventHandler
    fun onWeatherChange(event: WeatherChangeEvent) {
        // Check if the weather is not rainy
        if (!event.toWeatherState()) {
            // Set the weather back to rainy
            event.world.setStorm(true)
            event.world.setThundering(false)
            event.world.weatherDuration = Integer.MAX_VALUE

        }
    }
}