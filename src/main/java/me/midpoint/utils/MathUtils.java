package me.midpoint.utils;

public class MathUtils {
    public static double clamp(double value, double min, double max) {
        return Math.max(min, Math.min(max, value));
    }
    
    public static float randomFloat(float min, float max) {
        return (float) (Math.random() * (max - min) + min);
    }
}
