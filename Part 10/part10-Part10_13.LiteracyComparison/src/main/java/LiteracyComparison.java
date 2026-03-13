
import java.nio.file.Files;
import java.nio.file.Paths;

public class LiteracyComparison {
    
    public static void main(String[] args) {
        String file = "literacy.csv";
        read(file);
    }

    public static void read(String file){

        try{
            Files.lines(Paths.get(file))
                    .map(row -> row.split(","))
                    .filter(parts -> parts.length >= 6)
                    .map(parts -> new LiteracyStat(
                        parts[3].trim(), 
                        Integer.valueOf(parts[4]), 
                        parts[2].replace("(%)", "").trim(), 
                        Double.valueOf(parts[5])))
                    .sorted()
                    .forEach(litStat -> System.out.println(litStat));
        } catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
