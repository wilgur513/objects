package theater;

public class TicketSeller {
    private TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    public void sellTo(Audience audience) {
        if(audience.getBag().hasInvitation()) {
            Ticket ticket = getTicketOffice().getTicket();
            audience.getBag().setTicket(ticket);
        } else {
            Ticket ticket = getTicketOffice().getTicket();
            audience.getBag().minusAmount(ticket.getFee());
            getTicketOffice().plusAmount(ticket.getFee());
            audience.getBag().setTicket(ticket);
        }
    }

    private TicketOffice getTicketOffice() {
        return ticketOffice;
    }

    public long getAmount() {
        return ticketOffice.getAmount();
    }
}
