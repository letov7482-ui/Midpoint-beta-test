package me.midpoint.utils;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;

import java.awt.*;

public class RenderUtils {
    public static void drawText(Vec3d pos, String text, Color color) {
        // Упрощенная версия. Для работы требуется MatrixStack
        // В реальном проекте нужно передавать MatrixStack из рендера
        MinecraftClient client = MinecraftClient.getInstance();
        TextRenderer renderer = client.textRenderer;
        MatrixStack stack = new MatrixStack();
        stack.translate(pos.x, pos.y, pos.z);
        // Полная реализация требует 20+ строк
    }

    public static void drawBox(Box box, Color color) {
        // Рендер бокса (ESP)
        // В реальном проекте используйте WorldRenderer
    }
}
