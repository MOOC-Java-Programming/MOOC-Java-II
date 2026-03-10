public class Cat extends Animal implements NoiseCapable{
    public Cat(String name){
        super(name);
    }

    public Cat(){
        super("Cat");
    }
    
    public void purr(){
        System.out.println(name + " purrs");
    }

    @Override
    public void makeNoise(){
        purr();
    }
}
