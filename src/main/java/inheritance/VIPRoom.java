package inheritance;

public class VIPRoom extends Room {
    public int price = super.price + 100000;

    @Override
    public void printWarningPoint() {
        System.out.println("화장실 타일이 미끄러우니 조심하세요.");
    }

    @Override
    public void accumulatePoint(EventVisitor eventVisitor) {
        eventVisitor.accumulatePoint(this);
    }
}
