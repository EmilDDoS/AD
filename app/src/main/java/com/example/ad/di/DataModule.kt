package com.example.ad.di

import android.content.Context
import androidx.room.Room
import com.example.ad.data.database.Mapper
import com.example.ad.data.database.db.AppDataBase
import com.example.ad.data.localData.LocalVideo
import dagger.Module
import dagger.Provides

private const val NAME_DB = "minitv.db"

@Module
class DataModule {

    @Provides
    fun provideLocalVideo(
        context: Context
    ): LocalVideo = LocalVideo(context)

    @Provides
    fun provideMapper(): Mapper = Mapper()

    @Provides
    fun provideDataBase(
        app: Context
    ): AppDataBase = Room.databaseBuilder(
        app,
        AppDataBase::class.java,
        NAME_DB
    )
        .build()
}