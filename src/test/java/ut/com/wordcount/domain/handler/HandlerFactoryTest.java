package ut.com.wordcount.domain.handler;

import com.wordcount.domain.handler.Handler;
import com.wordcount.domain.handler.HandlerFactory;
import com.wordcount.domain.handler.collective.BaseHandler;
import com.wordcount.domain.handler.collective.BaseHandlerWithIndex;
import org.junit.jupiter.api.Test;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;

class HandlerFactoryTest {

    @Test
    void buildsCorrectHandlerGivenIndexFlag() {
        Handler handler = HandlerFactory.construct(singletonList("-index"));
        assertThat(handler).isExactlyInstanceOf(BaseHandlerWithIndex.class);
    }

    @Test
    void buildsBaseHandlerGivenNoIndexFlag() {
        Handler handler = HandlerFactory.construct(emptyList());
        assertThat(handler).isExactlyInstanceOf(BaseHandler.class);
    }
}