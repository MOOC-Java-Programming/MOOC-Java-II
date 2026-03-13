import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Hand implements Comparable<Hand>{
    private ArrayList<Card> cards;

    public Hand(){
        this.cards = new ArrayList<>();
    }

    public void add(Card card){
        cards.add(card);
    }

    public void print(){
        cards.stream().forEach(c -> System.out.println(c));
    }

    public void sort(){
        Collections.sort(cards);
    }

    public int sumOfValues(){
        return cards.stream().mapToInt(c -> c.getValue()).sum();
    }

    @Override
    public int compareTo(Hand compared){
        return this.sumOfValues() - compared.sumOfValues();
    }

    public void sortBySuit(){
        Collections.sort(this.cards, new BySuitInValueOrder());
    }
}
