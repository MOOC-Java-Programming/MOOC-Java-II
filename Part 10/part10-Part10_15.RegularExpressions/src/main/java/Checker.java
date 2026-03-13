

public class Checker {
    public boolean isDayOfWeek(String string){
        String regex = "mon|tue|wed|thu|fri|sat|sun";

        return string.matches(regex);
    }

    public boolean allVowels(String string){
        String regex = "^[aeiou]{1,}$";

        return string.matches(regex);
    }

    public boolean timeOfDay(String string){
        String regex = "([01][0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]";

        return string.matches(regex);
    }
}
