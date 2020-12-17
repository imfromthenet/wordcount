package ut.com.wordcount.domain.handler;

import com.wordcount.domain.handler.Handler;
import com.wordcount.domain.handler.HandlerFactory;
import com.wordcount.domain.handler.collective.BaseHandler;
import com.wordcount.domain.handler.collective.BaseHandlerWithIndex;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HandlerFactoryTest {

    @Test
    void buildsCorrectHandlerGivenIndexFlag() {
        Handler handler = HandlerFactory.construct(new String[]{"-index"});
        assertThat(handler).isExactlyInstanceOf(BaseHandlerWithIndex.class);
    }

    @Test
    void buildsBaseHandlerGivenNoIndexFlag() {
        Handler handler = HandlerFactory.construct(new String[]{});
        assertThat(handler).isExactlyInstanceOf(BaseHandler.class);
    }
}