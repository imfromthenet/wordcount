package ut.com.wordcount.domain;

import com.wordcount.domain.StopWords;
import org.junit.jupiter.api.Test;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;

class StopWordsTest {

    @Test
    void tellsIfAWordIsInStopWords() {
        StopWords sut = getStopWordsContainingOnly("a");

        assertThat(sut.filter(singletonList("a"))).isEmpty();
    }

    @Test
    void tellsIfAWordIsNotInStopWords() {
        StopWords sut = getStopWordsContainingOnly("a");

        assertThat(sut.filter(singletonList("b"))).isEqualTo(singletonList("b"));
    }

    private StopWords getStopWordsContainingOnly(String stopword) {
        return new StopWords(stopword);
    }
}