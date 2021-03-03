package test3;

public interface XiYiJi {
    void wash();
}

class XiYiJiImpl implements XiYiJi {

    @Override
    public void wash() {
        System.out.println("I can wash.");
    }

    public static void main(String[] args) {
        XiYiJiImpl xiYiJi = new XiYiJiImpl();
        xiYiJi.wash();
        String s = null;
        System.out.println(s);
    }
}
