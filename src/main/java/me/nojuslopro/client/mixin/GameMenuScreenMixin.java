package me.nojuslopro.client.mixin;

import com.mojang.authlib.minecraft.MinecraftSessionService;
import me.nojuslopro.client.Client;
import me.nojuslopro.client.client.ClientClient;
import me.nojuslopro.screen.NojusNetworkScreen;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.GameMenuScreen;
import net.minecraft.client.gui.screen.LevelLoadingScreen;
import net.minecraft.client.gui.screen.OpenToLanScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.multiplayer.MultiplayerScreen;
import net.minecraft.client.gui.screen.multiplayer.MultiplayerWarningScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.util.Session;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameMenuScreen.class)
public abstract class GameMenuScreenMixin extends Screen {

    protected GameMenuScreenMixin(Text title) {
        super(title);
    }


    @Inject(at = @At("TAIL"), method = "initWidgets")
    private void initWidgets(CallbackInfo callbackInfo) {
        this.addDrawableChild(new ButtonWidget(10,10,90,20, Text.translatable("Unload!"), (button) -> {
               this.client.setScreen(new NojusNetworkScreen("Lol"));
        }));

        this.addDrawableChild(new ButtonWidget(this.width / 2 + 3, this.height / 4 - 24 - 16, 100, 20, Text.translatable("Multiplayer"), (button) -> {
            Screen screen = this.client.options.skipMultiplayerWarning ? new MultiplayerScreen(this) : new MultiplayerWarningScreen(this);
            this.client.setScreen((Screen)screen);
        }));
        this.addDrawableChild(new ButtonWidget(this.width / 2 - 102, this.height / 4 - 24 - 16, 100, 20, Text.translatable("Quit"), (button) -> {
            this.client.scheduleStop();
        }));
    }
}


