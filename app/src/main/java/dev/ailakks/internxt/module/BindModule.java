package dev.ailakks.internxt.module;

import com.beatstreaming.core.MainActivity;
import com.beatstreaming.core.pages.HomePage;
import com.beatstreaming.core.pages.Pages;
import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import dev.ailakks.internxt.AppMainActivity;

@Module
@InstallIn(SingletonComponent.class)
public class BindModule {
    @Provides
    @Singleton
    public Class<? extends HomePage> provideHomePage() {
        return AppHomePage.class;
    }

    @Provides
    @Singleton
    public Pages[] providePages() {
        return AppPages.values();
    }

    @Provides
    @Singleton
    public Class<? extends MainActivity> provideMainActivity() {
        return AppMainActivity.class;
    }
}