public class CD implements Packable{
    private String artist;
    private String CDName;
    private int pubYear;
    private double CDWeight;

    public CD(String artist, String CDName, int pubYear){
        this.artist = artist;
        this.CDName = CDName;
        this.pubYear = pubYear;
        CDWeight = 0.1;
    }

    @Override
    public String toString(){
        return artist + ": " + CDName + " (" + pubYear + ")";
    }

    @Override
    public double weight(){
        return CDWeight;
    }
}
