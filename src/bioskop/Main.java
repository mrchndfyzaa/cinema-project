package bioskop;
public class Main {
    public static void main(String[] args){
        Silver data1 = new Silver(25, 25, 100, "Budi", 123, 5);
        System.out.println(data1);
        Gold data2 = new Gold(25, 25, 95, "Michael", 456, 5, 20);
        System.out.println(data2);
        Diamond data3 = new Diamond(25, 25, 90, "Jackson", 789, 5, 18);
        System.out.println(data3);
    }
}
