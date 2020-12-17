package ut.com.wordcount.domain.handler.collective;

import com.wordcount.domain.handler.Handler;
import com.wordcount.domain.handler.collective.BaseHandlerWithIndex;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

class BaseHandlerWithIndexTest {

    private static final String PATTERN_CHECKING_ORDER_OF_VALUES = "\\X*4\\X*4\\X*4.25\\X*had\\X*lamb\\X*little\\X*Mary\\X*";

    @Test
    void givenListOfWordsReturnsAnswerWithValuesInCorrectOrder() {
        Handler sut = new BaseHandlerWithIndex();
        String actual = sut.handle(asList("Mary had little lamb".split(" ")));

        assertThat(actual).matches(PATTERN_CHECKING_ORDER_OF_VALUES);
    }

}