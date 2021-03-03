package demo02;
/*Laptops usually have the ability to use USB devices.
 * During the production, the laptops have reserved the
 * USB interface to insert the USB devices.*/

/*Define a USB interface, having the function of opening
 * and closing, using mouse and keyboard to implement the
 * function*/
public abstract interface USB {
    public abstract void open();

    public abstract void close();
}
