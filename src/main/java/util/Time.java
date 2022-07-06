package util;

public class Time {
    public static float timeStarted = System.nanoTime(); // Time of the application start

    public static float getTime() {
        return (float) (( System.nanoTime() - timeStarted ) * 1E-9);
    }
}
