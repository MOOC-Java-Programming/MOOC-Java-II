public class Hideout<T> {
    private T hiddenObject;

    public void putIntoHideout(T toHide){
        this.hiddenObject = toHide;
    }

    public T takeFromHideout(){
        T takenObejct = hiddenObject;
        hiddenObject = null;
        return takenObejct;
    }

    public boolean isInHideout(){
        return hiddenObject != null;
    }
}
