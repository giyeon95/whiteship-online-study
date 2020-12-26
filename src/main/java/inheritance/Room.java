package inheritance;

import java.util.Arrays;
import java.util.List;

public class Room {

    public int price = 100_000;
    public List<String> facilities = Arrays.asList("침대", "드라이기", "이불", "세면용품");

    public int getPrice() {
        return price;
    }

    public List<String> getFacilities() {
        return facilities;
    }

    public void printWarningPoint() {
        System.out.println("기본방의 주의사항은 없습니다.");
    }

    public void accumulatePoint(EventVisitor eventVisitor) {
        System.out.println("기본방은 포인트가 없습니다.");
    }

}

