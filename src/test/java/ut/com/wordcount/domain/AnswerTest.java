package ut.com.wordcount.domain;

import com.wordcount.domain.Answer;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AnswerTest {

    public static final int COUNT = 2;
    public static final int UNIQUE_WORD_COUNT = 3;

    @Test
    void theAnswerContainsTheSameValuesAfterFormatting() {
        Answer sut = new Answer(COUNT, UNIQUE_WORD_COUNT);

        assertThat(sut.getFormatted())
                .contains(String.valueOf(COUNT))
                .contains(String.valueOf(UNIQUE_WORD_COUNT));
    }
}