package inheritance;

public interface EventVisitor {

    void accumulatePoint(TwinRoom twinRoom);

    void accumulatePoint(VIPRoom vipRoom);
}
