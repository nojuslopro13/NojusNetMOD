package me.nojuslopro.client;

import me.nojuslopro.screen.NukeScreen;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Client implements ModInitializer {

    public static boolean flyEnabled = false;

    public static final Logger LOGGER = LoggerFactory.getLogger(Client.class);

    @Override
    public void onInitialize() {



        KeyBinding keybind = new KeyBinding("key.mymod.send_message", GLFW.GLFW_KEY_M, "key.mymod.category");
        KeyBinding nukeKey = new KeyBinding("key.mymod.nukes", GLFW.GLFW_KEY_RIGHT_ALT, "key.mymod.category");

        KeyBindingHelper.registerKeyBinding(keybind);
        KeyBindingHelper.registerKeyBinding(nukeKey);

        ClientTickEvents.START_CLIENT_TICK.register(client -> {
            try {
                ClientPlayerEntity player = MinecraftClient.getInstance().player;
                if (player != null) {
                    if (keybind.wasPressed()) {
                        MinecraftClient.getInstance().player.sendChatMessage("gg", Text.keybind("gg"));
                    }

                    if (nukeKey.wasPressed()) {
                        MinecraftClient.getInstance().setScreen(new NukeScreen("lol wtf"));
                    }

                }


                if (flyEnabled != false) {
                  //   player.getAbilities().allowFlying = true;

                }
                else {
                 //   player.getAbilities().allowFlying = false;
                }
            } catch (Exception e) {
            }

        });
    }
}
