package me.zahchy.supercool.commands;

import me.zahchy.supercool.SuperCool;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

//Take a look at Java naming conventions. They are pinned in #Java on Cortex
public class CoolMessage implements CommandExecutor {

    //variable that holds the instance of your main class
    private final SuperCool plugin;

    public CoolMessage(SuperCool plugin) {
        //"this.plugin" refers to the global variable, whereas "plugin" refers to the arg of the constructor.
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        //since "this.plugin" hold our main instance we can use it to access the config method.
        //Also, because in this method "this.plugin" is the only variable, named "plugin" we don't need to write "this"
        plugin.getConfig().getString("example");






        return false;
    }
}
