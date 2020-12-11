package ut.com.wordcount.domain;

import com.wordcount.domain.StopWords;
import com.wordcount.domain.WordParser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Arrays.stream;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static sharedTool.AssertionHelper.assertThrowsNullPointerException;

class WordParserTest {

    @Test
    void addsAllWordsToResult() {
        WordParser sut = setUpWordParser();

        List<String> actual = sut.parse("word word");

        assertThat(actual).isEqualTo(asList("word", "word"));
    }

    @Test
    void parsesWordsStartingWithAnUppercase() {
        WordParser sut = setUpWordParser();

        List<String> actual = sut.parse("Word");

        assertThat(actual).isEqualTo(singletonList("Word"));
    }

    @Test
    void parsesUppercaseWords() {
        WordParser sut = setUpWordParser();

        List<String> actual = sut.parse("WORD");

        assertThat(actual).isEqualTo(singletonList("WORD"));
    }

    @Test
    void returnsEmptyListIfGivenAnEmptyString() {
        WordParser sut = setUpWordParser();

        List<String> actual = sut.parse("");

        assertThat(actual).isEmpty();
    }

    @Test
    void returnsEmptyListIfGivenASpaceString() {
        WordParser sut = setUpWordParser();

        List<String> actual = sut.parse(" ");

        assertThat(actual).isEmpty();
    }

    @Test
    void returnsZeroWhenInputIsSpecialCharacter() {
        WordParser sut = setUpWordParser();

        stream("*-+/=!@#$%^&*()_`~?][|\\".split(""))
                .forEach(symbol -> {
                    List<String> actual = sut.parse(symbol);
                    assertThat(actual).isEmpty();
                });
    }

    @Test
    void splitsStringIntoWordsByNonLetter() {
        WordParser sut = setUpWordParser();

        List<String> actual = sut.parse("word2word-word_word");

        assertThat(actual).containsSequence(asList("word", "word", "word", "word"));
    }

    @Test
    void throwsNullPointerExceptionIfParameterIsNull() {
        WordParser sut = setUpWordParser();

        assertThrowsNullPointerException(() -> sut.parse(null));
    }

    @ParameterizedTest
    @CsvSource({".", "!", "?", ":", ";"})
    void parsesWordsEndingWithAPunctuationMark(String punctuationMark) {
        WordParser sut = setUpWordParser();

        List<String> actual = sut.parse("word".concat(punctuationMark));

        assertThat(actual).isEqualTo(singletonList("word"));
    }

    @Test
    void filtersOutStopWords() {
        WordParser sut = setUpWordParser();

        List<String> actual = sut.parse("word a");

        assertThat(actual).isEqualTo(singletonList("word"));
    }

    private WordParser setUpWordParser() {
        return new WordParser(getStopWordsMock());
    }

    private StopWords getStopWordsMock() {
        StopWords stopWordsMock = mock(StopWords.class);
        when(stopWordsMock.contain("a")).thenReturn(true);
        return stopWordsMock;
    }
}