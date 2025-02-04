package dev.ailakks.internxt.page;

import androidx.fragment.app.Fragment;

import com.beatstreaming.core.pages.Pages;

import lombok.Getter;

@Getter
public enum AppPages implements Pages {
    HOME(0, new AppHomePage());

    private final int layout;
    private final Fragment fragment;

    AppPages(int layout, Fragment fragment) {
        this.layout = layout;
        this.fragment = fragment;
    }
}
