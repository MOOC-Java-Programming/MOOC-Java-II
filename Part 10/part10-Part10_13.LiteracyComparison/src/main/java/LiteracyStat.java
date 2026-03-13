public class LiteracyStat implements Comparable<LiteracyStat>{

    private String gender;
    private String country;
    private int year;
    private double literacyPercent;

    public LiteracyStat(String country, int year, String gender, double literacyPercent){
        this.country = country;
        this.year = year;
        this.gender = gender;
        this.literacyPercent = literacyPercent;
    }

    public double getLiteracyPercent(){
        return literacyPercent;
    }

    @Override
    public String toString(){
        return country + " (" + year + "), " + gender + ", " + literacyPercent;
    }

    @Override
    public int compareTo(LiteracyStat compared){
        if(this.literacyPercent == compared.getLiteracyPercent()) return 0;
        if(this.literacyPercent > compared.getLiteracyPercent()) return 1;
        return -1;
    } 
}
