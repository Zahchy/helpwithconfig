package me.zahchy.supercool;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class SuperCool extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        System.out.println(ChatColor.DARK_GREEN + "[SuperCool] has been enabled");
    }
    

    /*I did these here because this was the only way I knew how to access the config.
    If you could give me an example of putting these commands into seperate classes (in the commands package) that would be amazing!
    Thank you so much I truly appreciate it!
    I made the commands package with coolmessage in it so if you could like do a message from the config in that class that would be exactly what im trying to do with
    all these other commands i made down here!
     */



    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        //reloadcommand
        if(command.getName().equalsIgnoreCase("screload")){
            Player player = (Player) sender;
            if(player.hasPermission("sc.reload")){
                reloadConfig();
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("reloadmessage")));
            }else{
                player.sendMessage(ChatColor.RED + "You do not have permission to execute this command!");
            }

        }

        //messagecommand
        if(command.getName().equalsIgnoreCase("message")){
            Player player = (Player) sender;
            if(getConfig().getBoolean("message")){
                if(player.hasPermission("sc.message")){
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', (getConfig().getString("messagecommand"))));
                }else{
                    player.sendMessage(ChatColor.RED + "You do not have permission to execute this command!");
                }

            }
        }


        //yeetuscommand
        if(command.getName().equalsIgnoreCase("yeetus")){
            Player player = (Player) sender;
            if(getConfig().getBoolean("yeetus")){
                if(player.hasPermission("sc.yeetus")){
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("yeetusmessage")));
                }else{
                    player.sendMessage(ChatColor.RED + "You do not have permission to execute this command!");
                }

            }else
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("yeetusmessageiffalse")));

        }

        return false;
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println(ChatColor.DARK_GREEN + "[SuperCool] has been disabled");
    }
}
