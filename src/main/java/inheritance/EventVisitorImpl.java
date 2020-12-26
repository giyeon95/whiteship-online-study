package inheritance;

public class EventVisitorImpl implements EventVisitor {


    @Override
    public void accumulatePoint(TwinRoom twinRoom) {
        System.out.println(
            twinRoom.getClass().getName() + " 예약 포인트" + (double) twinRoom.price / 100.0 + "지급");
    }

    @Override
    public void accumulatePoint(VIPRoom vipRoom) {
        System.out.println(
            vipRoom.getClass().getName() + " 예약 포인트" + (double) vipRoom.price / 100.0 + "지급");
    }
}
