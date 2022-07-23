package org.lactusplugins.mc.httprequests.command;

import com.google.common.collect.Lists;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.lactusplugins.mc.httprequests.HTTPRequests;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;

public class HTTPRequestsCommand extends AbstractCommand {

    private static HttpURLConnection conn;
    public HTTPRequestsCommand() {
        super("httprequests");
    }

    @Override
    public void execute(CommandSender sender, String label, String[] args) {
        if (args.length == 0) {
            sender.sendMessage("This plugin can send HTTP requests directly from minecraft chat. To reload the plugin, use the command" + " /" + label + " reload.");
            return;
        }

        if (args[0].equalsIgnoreCase("reload")) {
            if (!sender.hasPermission( "httprequests.reload" )) {
                sender.sendMessage(ChatColor.RED + "You don`t have permisson.");
                return;
            }
            HTTPRequests.getInstance().reloadConfig();
            sender.sendMessage("Plugin HTTPRequests reloaded.");
            return;
        }

        if (args[0].equalsIgnoreCase("request")) {
            if (!sender.hasPermission( "httprequests.request" )) {
                sender.sendMessage(ChatColor.RED + "You don`t have permisson.");
                return;
            }
            try {
                String method = args[1];
                String req = args[2];
                try {
                    URL url = new URL(req);
                    conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod(method.toUpperCase());
                    int responseCode = conn.getResponseCode();
                    sender.sendMessage("Response code: " + responseCode);
                } catch (ProtocolException e) {
                    throw new RuntimeException(e);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                return;
            } catch (RuntimeException e) {
                sender.sendMessage("Error command" + ": /" + label + " request <Method> <URL>");
                return;
            }
        }
        sender.sendMessage(ChatColor.RED + "Unknown command:" + " /" + label + args[0]);
    }

    @Override
    public List<String> complete(CommandSender sender, String[] args) {
        if (args.length == 1) return Lists.newArrayList("reload", "request");
        return Lists.newArrayList();
    }
}
