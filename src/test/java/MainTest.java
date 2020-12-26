import static org.junit.jupiter.api.Assertions.*;

import inheritance.EventVisitor;
import inheritance.EventVisitorImpl;
import inheritance.Room;
import inheritance.TwinRoom;
import inheritance.VIPRoom;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MainTest {

    TwinRoom twinRoom;
    VIPRoom vipRoom;

    @BeforeEach
    void init() {
        twinRoom = new TwinRoom();
        vipRoom = new VIPRoom();
    }

    @Test
    @DisplayName("상속 테스")
    void printInheritance() {
        TwinRoom twinRoom = new TwinRoom();
        VIPRoom vipRoom = new VIPRoom();

        System.out.println("=========" + twinRoom.getClass().getName() + "=========");
        printPrice(twinRoom.price);
        printFacilities(twinRoom.facilities);

        System.out.println("=========" + vipRoom.getClass().getName() + "=========");
        printPrice(vipRoom.price);
        printFacilities(vipRoom.facilities);
    }

    @Test
    @DisplayName("오버라이딩 테스트")
    void printWarningPointTest() {
        TwinRoom twinRoom = new TwinRoom();
        VIPRoom vipRoom = new VIPRoom();

        twinRoom.printWarningPoint();
        vipRoom.printWarningPoint();
    }

    @Test
    @DisplayName("동적 메소드 디스패치 테스트")
    void printWarningPointDynamicTest() {
        Room twinRoom = new TwinRoom();
        Room vipRoom = new VIPRoom();

        twinRoom.printWarningPoint();
        vipRoom.printWarningPoint();
    }

    @Test
    @DisplayName("더블 디스패치 테스트")
    void doubleDispatchTest() {
        EventVisitor eventVisitor = new EventVisitorImpl();
        Room twinRoom = new TwinRoom();
        Room vipRoom = new VIPRoom();

        twinRoom.accumulatePoint(eventVisitor);
        vipRoom.accumulatePoint(eventVisitor);

    }


    public static void printPrice(int price) {
        System.out.println("기본 방의 가격은 " + price + "원 입니다.");
    }

    public static void printFacilities(List<String> facilities) {
        StringBuilder sb = new StringBuilder("방의 포함 물품은 ");
        facilities.forEach(s -> sb.append(s).append(", "));
        sb.replace(sb.length() - 2, sb.length(), "");
        sb.append("입니다.");

        System.out.println(sb.toString());
    }
}