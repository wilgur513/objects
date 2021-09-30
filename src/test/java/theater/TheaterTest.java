package theater;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TheaterTest {
    static final long AUDIENCE_AMOUNT = 1000L;
    static final long TICKET_OFFICE_AMOUNT = 2000L;
    static final long TICKET_FEE = 100L;
    static final Invitation INVITATION = new Invitation();

    TicketOffice ticketOffice;
    TicketSeller ticketSeller;
    Theater theater;

    @BeforeEach
    public void setUp() throws Exception {
        ticketOffice = new TicketOffice(TICKET_OFFICE_AMOUNT, new Ticket(TICKET_FEE));
        ticketSeller = new TicketSeller(ticketOffice);
        theater = new Theater(ticketSeller);
    }

    @Test
    public void enterAudienceWhoHasInvitation() {
        //arrange
        Bag bag = new Bag(INVITATION, AUDIENCE_AMOUNT);
        Audience audience = new Audience(bag);

        // act
        theater.enter(audience);

        // assert
        assertThat(audience.hasTicket()).isTrue();
        assertThat(audience.getAmount()).isEqualTo(AUDIENCE_AMOUNT);
        assertThat(theater.getAmount()).isEqualTo(TICKET_OFFICE_AMOUNT);
    }

    @Test
    public void enterAudienceWhoNotHasInvitation() {
        //arrange
        Bag bag = new Bag(AUDIENCE_AMOUNT);
        Audience audience = new Audience(bag);

        // act
        theater.enter(audience);

        // assert
        assertThat(audience.hasTicket()).isTrue();
        assertThat(audience.getAmount()).isEqualTo(AUDIENCE_AMOUNT - TICKET_FEE);
        assertThat(theater.getAmount()).isEqualTo(TICKET_OFFICE_AMOUNT + TICKET_FEE);
    }
}
