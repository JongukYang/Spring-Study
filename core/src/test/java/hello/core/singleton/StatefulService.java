package hello.core.singleton;

public class StatefulService {

    /**
     * 싱글톤 설계 오류 코드
     * 클라이언트가 객체에 값을 집어넣어 값이 변경되는 케이스 발생
     */
//    private int price; // 상태를 유지하는 필드
//
//    public void order(String name, int price) {
//        System.out.println("name = " + name + " price = " + price);
//        this.price = price; // 여기가 문제!
//    }
//    public int getPrice() {
//        return price;
//    }

    /**
     * 싱글톤 방식으로 설계
     */
    public int order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        return price;
    }


}
