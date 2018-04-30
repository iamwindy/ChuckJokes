package com.example.haihesheng.chuckjokes.test;

import com.example.haihesheng.chuckjokes.BuildConfig;
import com.example.haihesheng.chuckjokes.network.JokesApiTest;
import com.example.haihesheng.chuckjokes.ui.main.MainPresenter;
import com.example.haihesheng.chuckjokes.ui.main.MainScreen;
import com.example.haihesheng.chuckjokes.utils.RoboElectricDaggerTestRunner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import static com.example.haihesheng.chuckjokes.TestHelper.setTestInjector;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by Hai on 2018-04-30.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 26)
public class MainTest {

    private MainPresenter mainPresenter;
    private MainScreen mainScreen;


    @Before
    public void setup() throws Exception {
        setTestInjector();
        mainScreen = mock(MainScreen.class);
        mainPresenter = new MainPresenter();
        mainPresenter.attachScreen(mainScreen);
        JokesApiTest.seedCategories();
    }

    @Test
    public void testRefreshCategories() {
        List<String> categories = new ArrayList<String>();
        categories.add("category1");
        categories.add("category2");
        categories.add("category3");
        categories.add("category4");
        categories.add("category5");
        mainPresenter.refreshCategories();
        verify(mainScreen).showJokeCategories(categories);
    }


    @After
    public void tearDown() {
        mainPresenter.detachScreen();
    }

}