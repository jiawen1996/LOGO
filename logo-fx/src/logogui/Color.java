package logogui;

import java.util.*;


public enum Color {
    Noir(255, 255, 255, 0),
    Rouge(255, 59, 48, 1),
    VERT(76, 217, 100, 2),
    JAUNE(255, 255, 0, 3),
    BLEU(0, 0, 255, 4),
    VIOLET(238, 130, 238, 5),
    BLEUCLAIR(173, 216, 230, 6),
    BLANC(0, 0, 0, 7);

    private final int r;
    private final int g;
    private final int b;
    private final int colorCode;

    private Color(final int r, final int g, final int b, final int colorCode) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.colorCode = colorCode;

    }

    static Map<Integer, Color> mapOfColord = new HashMap<>();

    static {
        Map<Integer, Color> colors = new HashMap<Integer, Color>();
        for (Color color : Color.values()) {
            colors.put(color.colorCode, color);
        }
        mapOfColord = Collections.unmodifiableMap(colors);
    }

    public static Color getColor(Integer key) {
        return mapOfColord.get(key);
    }

    public int getR() {
        return r;
    }

    public int getG() {
        return g;
    }

    public int getB() {
        return b;
    }

}
