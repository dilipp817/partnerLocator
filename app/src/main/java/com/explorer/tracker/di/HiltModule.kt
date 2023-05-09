package com.explorer.tracker.di

import com.explorer.tracker.viewmodels.MainViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object HiltModule {

    @Provides
    fun provideMainViewModel(): MainViewModel {
        return MainViewModel()
    }
}