package demo02;

public class DemoMain {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.powerOn();

        USB usbMouse = new Mouse();
        computer.useDevice(usbMouse);

        USB keyboard = new Keyboard();
        computer.useDevice(keyboard);

        computer.powerOff();
        System.out.println("=================");
    }
}
