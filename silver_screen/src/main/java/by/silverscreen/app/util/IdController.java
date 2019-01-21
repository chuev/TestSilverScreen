package by.silverscreen.app.util;

public class IdController {
    private static Long nextId = 0L;
    public static Long getNextId(){
        nextId++;
        return nextId;
    }
}
