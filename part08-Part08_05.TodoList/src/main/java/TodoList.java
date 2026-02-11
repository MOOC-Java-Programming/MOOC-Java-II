import java.util.ArrayList;

public class TodoList {
    
    private ArrayList<String> taskList;

    public TodoList(){
        taskList = new ArrayList<>();
    }

    public void add(String task){
        taskList.add(task);
    }

    public void print(){
        for(int i = 0; i < taskList.size(); i++){
            System.out.println((i+1) + ": " + taskList.get(i));
        }
    }

    public void remove(int number){
        taskList.remove(number -1);
    }
}
