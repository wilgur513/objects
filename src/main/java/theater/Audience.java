package theater;

public class Audience {
    private Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }

    public Long buy(Ticket ticket) {
        return bag.hold(ticket);
    }

    public boolean hasTicket() {
        return bag.hasTicket();
    }

    public long getAmount() {
        return bag.getAmount();
    }
}
