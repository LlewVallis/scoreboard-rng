package io.github.llewvallis.scoreboardrng;

import io.github.llewvallis.commandbuilder.AutoCommand;
import io.github.llewvallis.commandbuilder.CommandContext;
import io.github.llewvallis.commandbuilder.ExecuteCommand;
import io.github.llewvallis.commandbuilder.TopLevelCommand;
import io.github.llewvallis.commandbuilder.arguments.IntegerArgument;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scoreboard.Objective;

import java.util.Random;

@AutoCommand
public class ScoreboardRngCommand extends TopLevelCommand {

    @Override
    public String getName() {
        return "scoreboard-rng";
    }

    @ExecuteCommand
    private void execute(
            CommandContext ctx,
            String scoreboard,
            String slot,
            @IntegerArgument.Arg(min = 1) int upperBound
    ) {
        int randomValue = new Random().nextInt(upperBound);

        Objective objective = Bukkit.getScoreboardManager().getMainScoreboard().getObjective(scoreboard);
        if (objective == null) {
            ctx.getSender().sendMessage(ChatColor.RED + "No such scoreboard");
            return;
        }

        if (slot.isBlank()) {
            ctx.getSender().sendMessage(ChatColor.RED + "Blank slots are not permitted");
            return;
        }

        objective.getScore(slot).setScore(randomValue);
    }
}
