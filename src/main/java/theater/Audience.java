package theater;

public class Audience {
    private Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }

    public Long buy(Ticket ticket) {
        if(getBag().hasInvitation()) {
            getBag().setTicket(ticket);
            return 0L;
        }

        getBag().minusAmount(ticket.getFee());
        getBag().setTicket(ticket);
        return ticket.getFee();
    }

    public boolean hasTicket() {
        return bag.hasTicket();
    }

    public long getAmount() {
        return bag.getAmount();
    }

    public Bag getBag() {
        return bag;
    }
}
