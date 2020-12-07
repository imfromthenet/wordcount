package ut.com.wordcount.domain;

import com.wordcount.domain.StopWords;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StopWordsTest {

    @Test
    void tellsIfAWordIsInStopWords() {
        StopWords sut = getStopWordsContainingOnly("a");

        assertThat(sut.contain("a")).isTrue();
    }

    @Test
    void tellsIfAWordIsNotInStopWords() {
        StopWords sut = getStopWordsContainingOnly("a");

        assertThat(sut.contain("b")).isFalse();
    }

    private StopWords getStopWordsContainingOnly(String stopword) {
        return new StopWords(stopword);
    }
}