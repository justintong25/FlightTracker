import java.io.IOException;

public class Choice implements State{

    public int choice;

    public Choice(){}

    public Choice(int choice){
        this.choice = choice;
    }

    public int getChoice(){
        return this.choice;
    }

    public void setChoice(int choice){
        this.choice = choice;
    }

    @Override
    public void print() throws IOException{
        System.out.println("Placeholder");
    }
}
