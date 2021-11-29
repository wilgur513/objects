package movie;

import java.time.Duration;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class MovieTest {
	@Test
	void calculateMovieFee() throws Exception {
	    Movie avatar = new Movie("아바타",
		    Duration.ofMinutes(120),
		    Money.wons(10000L),
		    new AmountDiscountPolicy(Money.wons(800), new SequenceCondition(1)));

		Screening screening = new Screening(avatar, 1, LocalDateTime.now());

		Reservation reservation = screening.reserve(new Customer(), 2);
		assertThat(reservation.getFee()).isEqualTo(Money.wons(18400.0));
	}

	@Test
	void noneDiscountPolicy() throws Exception {
		Movie starwars = new Movie("스타워즈",
			Duration.ofMinutes(120),
			Money.wons(10000L),
			new NoneDiscountPolicy());

		Screening screening = new Screening(starwars, 1, LocalDateTime.now());

		Reservation reservation = screening.reserve(new Customer(), 2);
		assertThat(reservation.getFee()).isEqualTo(Money.wons(20000.0));
	}
}
