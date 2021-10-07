package theater;

public class Bag {
    private Long amount;
    private Invitation invitation;
    private Ticket ticket;

    public Bag(Invitation invitation, Long amount) {
        this.invitation = invitation;
        this.amount = amount;
    }

    public Bag(long amount) {
        this(null, amount);
    }

    public Long hold(Ticket ticket) {
        if(hasInvitation()) {
            setTicket(ticket);
            return 0L;
        }

        setTicket(ticket);
        minusAmount(ticket.getFee());
        return ticket.getFee();
    }

    public boolean hasTicket() {
        return ticket != null;
    }

    public long getAmount() {
        return amount;
    }

    private boolean hasInvitation() {
        return invitation != null;
    }

    private void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    private void minusAmount(Long amount) {
        this.amount -= amount;
    }
}
