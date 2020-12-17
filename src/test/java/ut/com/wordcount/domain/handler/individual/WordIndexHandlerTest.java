package ut.com.wordcount.domain.handler.individual;

import com.wordcount.domain.handler.individual.WordIndexHandler;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

class WordIndexHandlerTest {

    @Test
    void givenListOfWordsPreparesAnIndexWhereWordsStartingWithLowercaseLetterComeFirst() {
        WordIndexHandler sut = new WordIndexHandler();

        String actual = sut.handle(asList("ALL", "Ball", "bALL", "all"));

        assertThat(actual).matches("\\X*(all)\\X*(bALL)\\X*(ALL)\\X*(Ball)\\X*");
    }
}