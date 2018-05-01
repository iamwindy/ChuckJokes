package com.example.haihesheng.chuckjokes.test;

import com.example.haihesheng.chuckjokes.BuildConfig;
import com.example.haihesheng.chuckjokes.model.Joke;
import com.example.haihesheng.chuckjokes.model.JokeWrapper;
import com.example.haihesheng.chuckjokes.network.JokesApiTest;
import com.example.haihesheng.chuckjokes.repository.JokesRepositoryTest;
import com.example.haihesheng.chuckjokes.ui.details.DetailsPresenter;
import com.example.haihesheng.chuckjokes.ui.details.DetailsScreen;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static com.example.haihesheng.chuckjokes.TestHelper.setTestInjector;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by Hai on 2018-04-30.
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 26)
public class DetailsTestWithDBInitialized {
    private DetailsPresenter detailsPresenter;
    private DetailsScreen detailsScreen;
    private ArgumentCaptor<JokeWrapper> argument = ArgumentCaptor.forClass(JokeWrapper.class);

    @Before
    public void setup() throws Exception {

        setTestInjector();
        detailsScreen = mock(DetailsScreen.class);
        detailsPresenter = new DetailsPresenter();
        detailsPresenter.attachScreen(detailsScreen);

        JokesRepositoryTest.seedJokes();

    }

    @Test
    public void testFetchFirstJokeFoundOnNotEmptyDb() {
        JokesApiTest.seedJokes(JokesApiTest.CategoryTypes.DB);
        detailsPresenter.initialize(JokesApiTest.getStringFromCategory(JokesApiTest.CategoryTypes.DB));
        detailsPresenter.fetchNextJoke();
        JokeWrapper jokeWrapper = new JokeWrapper();
        Joke joke = JokesRepositoryTest.joke1;
        jokeWrapper.setJoke(joke);
        jokeWrapper.setFavorited(true);
        verify(detailsScreen).showJoke(argument.capture());
        assertTrue(argument.getValue().equals(jokeWrapper));
    }

    @Test
    public void testFetchFirstJokeNotFoundOnNotEmptyDb() {
        JokesApiTest.seedJokes(JokesApiTest.CategoryTypes.New);
        detailsPresenter.initialize(JokesApiTest.getStringFromCategory(JokesApiTest.CategoryTypes.New));
        detailsPresenter.fetchNextJoke();
        JokeWrapper jokeWrapper = new JokeWrapper();
        Joke joke = JokesApiTest.newJoke1;
        jokeWrapper.setJoke(joke);
        jokeWrapper.setFavorited(false);
        verify(detailsScreen).showJoke(argument.capture());
        assertTrue(argument.getValue().equals(jokeWrapper));
    }

    @Test
    public void testSaveFirstJokeOnNotEmptyDb() {
        JokesApiTest.seedJokes(JokesApiTest.CategoryTypes.New);
        detailsPresenter.initialize(JokesApiTest.getStringFromCategory(JokesApiTest.CategoryTypes.New));
        detailsPresenter.fetchNextJoke();


        verify(detailsScreen).showJoke(argument.capture());
        JokeWrapper jokeWrapper = new JokeWrapper();
        Joke joke = JokesApiTest.newJoke1;
        jokeWrapper.setJoke(joke);
        jokeWrapper.setFavorited(false);
        assertTrue(argument.getValue().equals(jokeWrapper));

        detailsPresenter.toggleSaveJoke();

        jokeWrapper.setFavorited(true);

        verify(detailsScreen, times(2)).showJoke(argument.capture());
        assertTrue(argument.getValue().equals(jokeWrapper));

    }


    @After
    public void tearDown() {
        detailsPresenter.detachScreen();
    }
}
