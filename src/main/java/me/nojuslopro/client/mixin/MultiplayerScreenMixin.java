package me.nojuslopro.client.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.AddServerScreen;
import net.minecraft.client.gui.screen.ConnectScreen;
import net.minecraft.client.gui.screen.DisconnectedScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.multiplayer.MultiplayerScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.network.ServerAddress;
import net.minecraft.client.network.ServerInfo;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(MultiplayerScreen.class)
public abstract class MultiplayerScreenMixin extends Screen {
    protected MultiplayerScreenMixin(Text title) {
        super(title);
    }

    @Inject(at = @At("RETURN"), method = "init")
    private void addCustomButtons(CallbackInfo ci) {
        this.addDrawableChild(new ButtonWidget(this.width / 2 + 108 + 50, this.height - 52, 100, 20, Text.translatable("Local Server"), (button) -> {
            ServerAddress address = new ServerAddress("localhost", 25565);
            ServerInfo serverInfo = new ServerInfo("Local Server", "localhost", true);
            serverInfo.setResourcePackPolicy(ServerInfo.ResourcePackPolicy.ENABLED);

            ConnectScreen.connect(MinecraftClient.getInstance().currentScreen, MinecraftClient.getInstance(), address, serverInfo);
        }));

    }

}
