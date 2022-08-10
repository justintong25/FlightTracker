import java.util.ArrayList;

public class ShowAll extends Choice{

    public ShowAll(int choice) {
        super(choice);
    }

    public int getChoice(){
        return choice;
    }

    @Override
    public void print(){
        Tracker filemanager = new Tracker();
        ArrayList<Flight> result = filemanager.getValues();
        for(Flight d : result){
            System.out.println(d + " ");
        }
    }
    
}
