public class Student extends Person{
    private int numCredits;
    public Student(String name, String address){
        super(name, address);
        this.numCredits = 0;
    }

    public void study(){
        this.numCredits++;
    }

    public int credits(){
        return numCredits;
    }

    @Override
    public String toString(){
        return super.toString() + "\n  Study credits " + numCredits;
    }
}
