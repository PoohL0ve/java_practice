public class Time {
    public static void americaTime(String d, String m, int h, int dt) {
        System.out.printf("American Time: %s, %s %dth %dpm\n", d, m, dt, h);
    }

    public static void main(String[] args) {
        americaTime("Monday", "June", 5, 12);
        europeanTime("Monday", "June", 5, 12);
    }

    public static void europeanTime(String d, String m, int h, int dt) {
        int evening = h + 12;
        System.out.printf("European Time: %s %dth, %s %dpm", d, dt, m, evening);
    }
}
