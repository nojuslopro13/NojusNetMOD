package me.nojuslopro.client.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.s2c.play.ResourcePackSendS2CPacket;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayNetworkHandler.class)
public abstract class ClientPlayNetworkHandlerMixin implements ClientPlayPacketListener {
    //LOGGER

    @Inject(at = @At("HEAD"), method="onResourcePackSend")
    public void onResourcePackSend(ResourcePackSendS2CPacket packet, CallbackInfo ci) {
        System.out.println("--------------------------------------------");
        System.out.println("");
        System.out.println("LOADING SERVER RESOURCE PACK");
        System.out.println(packet.getURL());
        System.out.println("");
        System.out.println("--------------------------------------------");

        MinecraftClient.getInstance().player.sendMessage(Text.translatable("Found an server resource pack! URL: " + packet.getURL()));
    }
}

