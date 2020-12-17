package ut.com.wordcount.domain.handler.individual;

import com.wordcount.domain.handler.individual.WordAverageLengthHandler;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

class WordAverageLengthHandlerTest {

    @Test
    void givenListOfWordsCalculatesTheAverageLength() {
        WordAverageLengthHandler sut = new WordAverageLengthHandler();

        String result = sut.handle(asList("ab", "abc"));

        assertThat(result).contains("2.50");
    }
}