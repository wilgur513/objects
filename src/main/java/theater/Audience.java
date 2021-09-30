package theater;

public class Audience {
    private Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
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
