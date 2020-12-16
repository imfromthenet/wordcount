package ut.com.wordcount.domain;

import com.wordcount.domain.WordParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Arrays.stream;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static sharedTool.AssertionHelper.assertThrowsNullPointerException;

class WordParserTest {

    private WordParser sut;

    @BeforeEach
    void setUpWordParser() {
        sut = new WordParser();
    }
    @Test
    void addsAllWordsToResult() {
        List<String> actual = sut.parse("word word");

        assertThat(actual).isEqualTo(asList("word", "word"));
    }

    @Test
    void parsesWordsStartingWithAnUppercase() {
        List<String> actual = sut.parse("Word");

        assertThat(actual).isEqualTo(singletonList("Word"));
    }

    @Test
    void parsesUppercaseWords() {
        List<String> actual = sut.parse("WORD");

        assertThat(actual).isEqualTo(singletonList("WORD"));
    }

    @Test
    void returnsEmptyListIfGivenAnEmptyString() {
        List<String> actual = sut.parse("");

        assertThat(actual).isEmpty();
    }

    @Test
    void returnsEmptyListIfGivenASpaceString() {
        List<String> actual = sut.parse(" ");

        assertThat(actual).isEmpty();
    }

    @Test
    void returnsEmptyListWhenInputIsSpecialCharacter() {
        stream("*-+/=!@#$%^&*()_`~?][|\\".split(""))
                .forEach(symbol -> {
                    List<String> actual = sut.parse(symbol);
                    assertThat(actual).isEmpty();
                });
    }

    @Test
    void splitsStringIntoWordsByNonLetter() {
        List<String> actual = sut.parse("word2word_word");

        assertThat(actual).containsSequence(asList("word", "word", "word"));
    }

    @Test
    void treatsHyphenatedWordsAsOne() {
        List<String> actual = sut.parse("word-word");

        assertThat(actual).containsOnly("word-word");
    }

    @Test
    void throwsNullPointerExceptionIfParameterIsNull() {
        assertThrowsNullPointerException(() -> sut.parse(null));
    }

    @ParameterizedTest
    @CsvSource({".", "!", "?", ":", ";"})
    void parsesWordsEndingWithAPunctuationMark(String punctuationMark) {
        List<String> actual = sut.parse("word".concat(punctuationMark));

        assertThat(actual).isEqualTo(singletonList("word"));
    }

}