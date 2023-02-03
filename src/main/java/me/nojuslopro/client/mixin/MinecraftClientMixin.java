package me.nojuslopro.client.mixin;

import me.nojuslopro.client.Client;
import me.nojuslopro.screen.ModWelcomeScreen;
import me.nojuslopro.screen.NukeScreen;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public abstract class MinecraftClientMixin {
    @Shadow public abstract void setScreen(@Nullable Screen screen);

    @Inject(at = @At("HEAD"), method = "run")
    private void run(CallbackInfo ci) {

        Client.LOGGER.info("Loading welcome screen!");

        setScreen(new ModWelcomeScreen(Text.translatable("Welcome Screen")));

        Client.LOGGER.info("Welcome screen finished loading! Applying!");
    }

}
