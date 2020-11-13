package io.github.llewvallis.scoreboardrng;

import io.github.llewvallis.commandbuilder.AutoCommandBuilder;
import org.bukkit.plugin.java.JavaPlugin;

public class ScoreboardRngPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        new AutoCommandBuilder(this)
                .jarSource(getFile(), "^io.github.llewvallis.scoreboardrng.")
                .register();
    }
}
