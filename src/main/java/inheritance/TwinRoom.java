package inheritance;

public class TwinRoom extends Room {
    public int price = super.price + 50000;

    @Override
    public void printWarningPoint() {
        System.out.println("유리가 매우 약하니 깨지않게 주의하세요.");
    }

    @Override
    public void accumulatePoint(EventVisitor eventVisitor) {
        eventVisitor.accumulatePoint(this);
    }

    @Override
    protected void abstractPoint() {

    }
}
