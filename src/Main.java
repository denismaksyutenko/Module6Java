
public class Main {
    public static void main(String[] args) {
        Main q = new Main();
        q.methodA();
    }
    public void methodA(){
        methodB();
    }
    public void methodB(){
        System.out.println("Hello World!");

    }
}