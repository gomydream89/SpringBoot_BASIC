package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.order.Order;
import hello.core.order.OrderService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }


    @Test
    void createOrder() {
        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        //then
        Assertions.assertThat(member).isEqualTo(memberService.findMember(memberId));

        Assertions.assertThat(Grade.VIP).isEqualTo(member.getGrade());

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order = " + order);
        //Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }
}
