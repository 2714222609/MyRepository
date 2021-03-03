package demo02;

public class Computer {
    public void powerOn() {
        System.out.println("The power is on.");
    }

    public void powerOff() {
        System.out.println("The power is off.");
    }

    public void useDevice(USB usb) {
        usb.open();
        usb.close();
    }
}
