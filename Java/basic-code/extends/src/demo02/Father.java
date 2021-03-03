package demo02;

public class Father extends GrandFather {
    private String work;
    int num = 2;

    public Father(int age, String name, String work) {
        super(age, name);
        this.work = work;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    @Override
    public void show() {
        System.out.println("I am the father, I like playing soccer.");
        System.out.println("My father's num is " + super.num);
        System.out.println("My num is " + this.num);

    }

}
