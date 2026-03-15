import java.util.ArrayList;

public class HashMap<K, V>{
    private ArrayList<Pair<K, V>>[] buckets;
    private int size;

    public HashMap(){
        this.buckets = new ArrayList[32];
        this.size = 0;
    }

    private int getIndex(K key){
        int hashValue = Math.abs(key.hashCode());
        return hashValue % buckets.length;
    }

    private int getIndexOfKeyInBucket(ArrayList<Pair<K, V>> bucketList, K key){
        for(int i = 0; i < bucketList.size(); i++){
            if(bucketList.get(i).getKey().equals(key)){
                return i;
            }
        }
        return -1;
    }

    public V get(K key){
        int arrayIndex = getIndex(key);
        ArrayList<Pair<K, V>> bucketList = buckets[arrayIndex];

        if(bucketList == null){
            return null;
        }

        int indexInList = getIndexOfKeyInBucket(bucketList, key);

        if(indexInList < 0){
            return null;
        }

        return bucketList.get(indexInList).getValue();
    }

    public void add(K key, V value){
        int arrayIndex = getIndex(key);

        if(buckets[arrayIndex] == null){
            buckets[arrayIndex] = new ArrayList<>();
        }

        ArrayList<Pair<K, V>> bucketList = buckets[arrayIndex];
        int indexInList = getIndexOfKeyInBucket(bucketList, key);

        if(indexInList < 0){
            bucketList.add(new Pair<K, V>(key, value));
            size++;
        } else {
            bucketList.get(indexInList).setValue(value);
        }
        
        if(1.0 * size / buckets.length > 0.75){
            grow();
        }
    }

    private void grow(){
        ArrayList<Pair<K, V>>[] newBuckets = new ArrayList[buckets.length * 2];

        for(int i = 0; i < buckets.length; i++){
            if(buckets[i] != null){
                copy(newBuckets, i);
            }
        }

        buckets = newBuckets;
    }

    private void copy(ArrayList<Pair<K, V>>[] newBuckets, int fromIdx){
        ArrayList<Pair<K, V>> bucketList = buckets[fromIdx];

        for (Pair<K,V> pair : bucketList) {
            int hashValue = Math.abs(pair.getKey().hashCode());
            int newIndex = hashValue % newBuckets.length;

            if(newBuckets[newIndex] == null){
                newBuckets[newIndex] = new ArrayList<>();
            }
            newBuckets[newIndex].add(pair);
        }
    }

    public V remove(K key){
        int arrayIndex = getIndex(key);
        ArrayList<Pair<K, V>> bucketList = buckets[arrayIndex];

        if(bucketList == null){
            return null;
        }

        int indexInList = getIndexOfKeyInBucket(bucketList, key);

        if(indexInList < 0){
            return null;
        }

        Pair<K, V> pairToRemove = bucketList.get(indexInList);
        bucketList.remove(pairToRemove);
        size--;
        return pairToRemove.getValue();
    }
}