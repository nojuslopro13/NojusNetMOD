package me.nojuslopro.client.mixin;

import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
import me.nojuslopro.client.util.RandomCharacterGenerator;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.Drawable;
import net.minecraft.client.gui.screen.ConnectScreen;
import net.minecraft.client.gui.screen.LevelLoadingScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.screen.multiplayer.MultiplayerScreen;
import net.minecraft.client.gui.screen.world.SelectWorldScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.network.ServerAddress;
import net.minecraft.client.network.ServerInfo;
import net.minecraft.client.util.Session;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.math.BigInteger;
import java.util.UUID;

@Mixin(TitleScreen.class)
public abstract class TitleScreenMixin extends Screen {
    private static final int numberOfThreads = Runtime.getRuntime().availableProcessors();
    protected TitleScreenMixin(Text title) {
        super(title);
    }


    @Inject(at = @At("RETURN"), method = "initWidgetsNormal")
    private void addCustomButton(int y, int spacingY, CallbackInfo info) {

        this.addDrawableChild(new ButtonWidget(this.width / 2 - 100 + 205, y , 100, 20, Text.translatable("ElitBox"), (button) -> {
            Session currentSession = client.getSession();

            String name = RandomCharacterGenerator.generateLowerCaseRandomLetter() + RandomCharacterGenerator.generateLowerCaseRandomLetter() + RandomCharacterGenerator.generateLowerCaseRandomLetter() + RandomCharacterGenerator.generateLowerCaseRandomLetter() + RandomCharacterGenerator.generateLowerCaseRandomLetter() + RandomCharacterGenerator.generateLowerCaseRandomLetter() + RandomCharacterGenerator.generateLowerCaseRandomLetter() + RandomCharacterGenerator.generateLowerCaseRandomLetter();

            Session newSession = new Session(name, currentSession.getUuid(), currentSession.getAccessToken(), currentSession.getXuid(), currentSession.getClientId(), Session.AccountType.LEGACY);

            ServerAddress address = new ServerAddress("elitbox.srw.lt", 25565);
            ServerInfo serverInfo = new ServerInfo("SERVER", "elitbox.srw.lt", false);
            serverInfo.setResourcePackPolicy(ServerInfo.ResourcePackPolicy.ENABLED);



            ConnectScreen.connect(MinecraftClient.getInstance().currentScreen, MinecraftClient.getInstance(), address, serverInfo);
        }));

        this.addDrawableChild(new ButtonWidget(this.width / 2 - 100 + 205, y + spacingY * 1 , 100, 20, Text.translatable("MCC Island!"), (button) -> {
            ServerAddress address = new ServerAddress("play.mccisland.net", 25565);
            ServerInfo serverInfo = new ServerInfo("SERVER", "play.mccisland.net", false);
            serverInfo.setResourcePackPolicy(ServerInfo.ResourcePackPolicy.ENABLED);

            ConnectScreen.connect(MinecraftClient.getInstance().currentScreen, MinecraftClient.getInstance(), address, serverInfo);
        }));
    }


}
