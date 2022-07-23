package org.lactusplugins.mc.httprequests;

import org.bukkit.plugin.java.JavaPlugin;
import org.lactusplugins.mc.httprequests.command.HTTPRequestsCommand;

public final class HTTPRequests extends JavaPlugin {

    private static HTTPRequests instance;

    @Override
    public void onEnable() {
        instance = this;
        new HTTPRequestsCommand();
    }

    public static HTTPRequests getInstance() {
        return instance;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
