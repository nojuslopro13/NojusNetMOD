package me.nojuslopro.screen;

import me.nojuslopro.client.Client;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;

public class NukeScreen extends Screen {


    public NukeScreen(String title) {
        super(Text.literal("Nojus Network"));
    }


    @Override
    protected void init() {

        this.addDrawableChild(new ButtonWidget(this.width / 2 - 100, this.height / 6 + 20, 200, 20, Text.translatable("Bomb: greenodes"), (button -> {
        })));

    }

    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);

        super.render(matrices, mouseX, mouseY, delta);
    }

}
