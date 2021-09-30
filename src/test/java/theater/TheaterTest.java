package theater;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TheaterTest {
    static final long AUDIENCE_AMOUNT = 1000L;
    static final long TICKET_OFFICE_AMOUNT = 2000L;
    static final long TICKET_FEE = 100L;

    Bag bag;
    Audience audience;
    TicktetOffice ticketOffice;
    TicketSeller ticketSeller;
    Theater theater;

    @BeforeEach
    public void setUp() throws Exception {
        bag = new Bag(new Invitation(), AUDIENCE_AMOUNT);
        audience = new Audience(bag);
        ticketOffice = new TicktetOffice(TICKET_OFFICE_AMOUNT, new Ticket(TICKET_FEE));
        ticketSeller = new TicketSeller(ticketOffice);
        theater = new Theater(ticketSeller);
    }

    @Test
    public void enterAudienceWhoHasInvitation() {
        // act
        theater.enter(audience);

        // assert
        assertThat(audience.hasTicket()).isTrue();
        assertThat(audience.getAmount()).isEqualTo(audienceAmount);
        assertThat(teater.getAmount()).isEqualTo(ticketOfficeAmount);
    }

    @Test
    public void enterAudienceWhoNotHasInvitation() {
        // act
        theater.enter(audience);

        // assert
        assertThat(audience.hasTicket()).isTrue();
        assertThat(audience.getAmount()).isEqualTo(audienceAmount - ticketFee);
        assertThat(teater.getAmount()).isEqualTo(ticketOfficeAmount + ticketFee);
    }
}
