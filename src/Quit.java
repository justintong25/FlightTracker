public class Quit extends Choice{

    public Quit(int choice){
        super(choice);
    }

    public int getQuit(){
        return choice;
    }

    public void print(){
        System.out.println("Quitting");
    }
}
