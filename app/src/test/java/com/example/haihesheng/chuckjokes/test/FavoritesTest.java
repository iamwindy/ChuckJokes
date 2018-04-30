package com.example.haihesheng.chuckjokes.test;

import com.example.haihesheng.chuckjokes.BuildConfig;
import com.example.haihesheng.chuckjokes.model.Joke;
import com.example.haihesheng.chuckjokes.model.JokeWrapper;
import com.example.haihesheng.chuckjokes.network.JokesApiTest;
import com.example.haihesheng.chuckjokes.repository.JokesRepositoryTest;
import com.example.haihesheng.chuckjokes.ui.details.DetailsPresenter;
import com.example.haihesheng.chuckjokes.ui.details.DetailsScreen;
import com.example.haihesheng.chuckjokes.ui.favorites.FavoritesPresenter;
import com.example.haihesheng.chuckjokes.ui.favorites.FavoritesScreen;
import com.example.haihesheng.chuckjokes.utils.RoboElectricDaggerTestRunner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.robolectric.annotation.Config;

import static com.example.haihesheng.chuckjokes.TestHelper.setTestInjector;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Matchers.refEq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by Hai on 2018-04-30.
 */
@RunWith(RoboElectricDaggerTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 26,manifest = Config.NONE)
public class FavoritesTest {
    private FavoritesPresenter favoritesPresenter;
    private FavoritesScreen favoritesScreen;
    private ArgumentCaptor<Joke> argument = ArgumentCaptor.forClass(Joke.class);

    @Before
    public void setup() throws Exception {
        setTestInjector();
        favoritesScreen = mock(FavoritesScreen.class);
        favoritesPresenter = new FavoritesPresenter();
        favoritesPresenter.attachScreen(favoritesScreen);
        JokesApiTest.seedJokes();
        JokesRepositoryTest.seedJokes();
        favoritesPresenter.initialize();
    }

    @Test
    public void testFetchFirstJokeFromDB() {
        Joke joke = JokesRepositoryTest.joke1;
        favoritesPresenter.showNextJoke();
        verify(favoritesScreen).showJoke(argument.capture());
        assertTrue(argument.getValue().equals(joke));
    }

    @Test
    public void testFetchSecondJokeFromDB() {
        Joke joke1 = JokesApiTest.joke1;
        favoritesPresenter.showNextJoke();
        verify(favoritesScreen).showJoke(joke1);

        Joke joke2 = JokesApiTest.joke2;
        favoritesPresenter.showNextJoke();
        verify(favoritesScreen,times(2)).showJoke(argument.capture());
        assertTrue(argument.getValue().equals(joke2));
    }


    @After
    public void tearDown() {
        favoritesPresenter.detachScreen();
    }
}
