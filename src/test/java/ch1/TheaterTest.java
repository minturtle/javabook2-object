package ch1;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class TheaterTest {

    private Audience audience;
    private Bag bag;

    private Invitation invitation;
    private Ticket ticket1;
    private Ticket ticket2;

    private TicketOffice ticketOffice;
    private TicketSeller ticketSeller;

    private Theater theater;

    @BeforeEach
    void setUp() {
        bag = new Bag();
        audience = new Audience(bag);

        invitation = new Invitation();
        ticket1 = new Ticket(1000);
        ticket2 = new Ticket(1000);

        ticketOffice = new TicketOffice(0, ticket1, ticket2);
        ticketSeller = new TicketSeller(ticketOffice);
        theater = new Theater(ticketSeller);
    }

    @Test
    @DisplayName("enter test-티켓 소유")
    void t1() throws Exception {
        //given
        setBagAndAudience(0, ticket1, null);
        //when
        theater.enter(audience);
        //then
    }

    @Test
    @DisplayName("enter test- 초대권 소유")
    void t2() throws Exception {
        setBagAndAudience(0, null, invitation);
        //given
        bag = new Bag(null, invitation, 0);
        //when
        theater.enter(audience);
        //then
    }

    @Test
    @DisplayName("들어갈 수 있는 돈 소유")
    void t3() throws Exception {
        setBagAndAudience(1500, null, null);
        //given
        bag = new Bag(null, null, 1500);
        //when
        theater.enter(audience);
        //then
    }

    @Test
    @DisplayName("아무것도 없는 경우")
    void t4() throws Exception {
        //given
        //when
        ThrowableAssert.ThrowingCallable func = ()->theater.enter(audience);
        //then

        assertThatThrownBy(func).isInstanceOf(Theater.CanNotEnter.class);
    }

    private void setBagAndAudience(int mon, Ticket tic, Invitation inv){
        audience = new Audience(new Bag(tic, inv, mon));
    }
}