package me.nojuslopro.screen;

import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;

import java.util.Objects;

public class ModWelcomeScreen extends Screen {

    private final Text welcome = Text.translatable("-_-");
    public ModWelcomeScreen(Text title) {
        super(title);
    }

    protected void init() {

        this.addDrawableChild(new ButtonWidget(this.width / 2 - 76, this.height / 4 + 48 + 12, 80, 20, Text.translatable("Continue!"), (button -> {
            this.client.setScreen(new TitleScreen(true));
        })));
    }

    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);

        drawCenteredText(matrices, this.textRenderer, this.welcome, this.width / 2, 20, 16777215);

        super.render(matrices, mouseX, mouseY, delta);
    }

}
