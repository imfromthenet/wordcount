package ut.com.wordcount.domain.handler.collective;

import com.wordcount.domain.handler.Handler;
import com.wordcount.domain.handler.collective.BaseHandler;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

class BaseHandlerTest {

    public static final String PATTERN_CHECKING_ORDER_OF_VALUES = "\\X*4\\X*4\\X*4.25\\X*";

    @Test
    void givenListOfWordsReturnsAnswerWithValuesInCorrectOrder() {
        Handler sut = new BaseHandler();
        String actual = sut.handle(asList("Mary had little lamb".split(" ")));

        assertThat(actual).matches(PATTERN_CHECKING_ORDER_OF_VALUES);
    }

}