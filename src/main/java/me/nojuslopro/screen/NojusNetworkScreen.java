package me.nojuslopro.screen;

import me.nojuslopro.client.Client;
import net.minecraft.client.gui.Drawable;
import net.minecraft.client.gui.screen.ConnectScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.LiteralTextContent;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableTextContent;

import java.awt.*;

public class NojusNetworkScreen extends Screen {


    public NojusNetworkScreen(String title) {
        super(Text.literal("Nojus Network"));
    }


    @Override
    protected void init() {

        this.addDrawableChild(new ButtonWidget(this.width / 2 - 100, this.height / 6 + 20, 200, 20, Text.translatable("Fly Hacks: OFF"), (button -> {
                if (Client.flyEnabled == false) {
                     Client.flyEnabled = true;

                     button.setMessage(Text.translatable("Fly Hacks: ON"));

                    Client.LOGGER.info("Fly hacks are turned on!");

                }
                else if (Client.flyEnabled == true) {
                    button.setMessage(Text.translatable("Fly Hacks: OFF"));
                    Client.LOGGER.info("Fly hacks are turned off!");
                    Client.flyEnabled = false;
                }
        })));
    }
}
