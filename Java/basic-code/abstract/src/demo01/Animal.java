package demo01;

/*When the objects of a class are different, they
 * may have different methods, at this time, we need
 * to define the abstract class.*/
/*We can't immediately new an abstract class, and we must
 * use a subclass to extend it, and overwrite all the
 * abstract method in parent class, then new a
 * subclass.*/
public abstract class Animal {
    //This is an abstract method
    public abstract void eat();

    //This is a normal member method
    public void normalMethod() {
    }
}
