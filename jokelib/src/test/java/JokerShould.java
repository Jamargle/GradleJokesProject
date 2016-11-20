import com.jmlb0003.jokes.gradlejokesproject.Joker;

import org.junit.Test;

public class JokerShould {

    @Test
    public void test() {
        Joker joker = new Joker();
        assert joker.getJoke().length() != 0;
    }

}
