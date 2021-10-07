package theater;

public class Audience {
    private Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }

    public Long buy(Ticket ticket) {
        if(bag.hasInvitation()) {
            bag.setTicket(ticket);
            return 0L;
        }

        bag.minusAmount(ticket.getFee());
        bag.setTicket(ticket);
        return ticket.getFee();
    }

    public boolean hasTicket() {
        return bag.hasTicket();
    }

    public long getAmount() {
        return bag.getAmount();
    }
}
