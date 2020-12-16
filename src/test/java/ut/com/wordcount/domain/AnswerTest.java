package ut.com.wordcount.domain;

import com.wordcount.domain.Answer;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

class AnswerTest {

    @Test
    void theAnswerContainsTheSameValuesAfterFormatting() {
        Answer sut = new Answer(asList("first", "second"));

        assertThat(sut.getFormatted())
                .contains("2")
                .contains("2")
                .contains("5.50");
    }
}