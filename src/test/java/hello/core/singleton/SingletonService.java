package hello.core.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonService {
    // 1. static
    private static final SingletonService instance = new SingletonService();

    // 2. public
    public static SingletonService getInstance() {
        return instance;
    }

    // 3. private 생성자
    private SingletonService() {

    }
    public void logic() {
        System.out.println("싱글톤 객체 호출");
    }

    @Test
    @DisplayName("싱글턴 패턴을 이용한 객체 ")
    public void singletonServiceTest() {
//private으로 생성자를 막아두었다. 컴파일 오류가 발생한다.
//new SingletonService();
//1. 조회: 호출할 때 마다 같은 객체를 반환
        SingletonService singletonService1 = SingletonService.getInstance();
//2. 조회: 호출할 때 마다 같은 객체를 반환
        SingletonService singletonService2 = SingletonService.getInstance();
//참조값이 같은 것을 확인
        System.out.println("singletonService1 = " + singletonService1);
        System.out.println("singletonService2 = " + singletonService2);
// singletonService1 == singletonService2
        assertThat(singletonService1).isSameAs(singletonService2);
        singletonService1.logic();
    }
}
