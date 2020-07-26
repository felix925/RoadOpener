package jp.making.felix.roadopener.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import jp.making.felix.roadopener.data.DataBase.DataBase
import javax.inject.Inject

@Module
@InstallIn(ApplicationComponent::class)
class DatabaseModule {
    @Provides
    fun provideDatabase(
        @ApplicationContext appContext: Context
    ): DataBase = Room.databaseBuilder(
        appContext,
        DataBase::class.java,
        "LocalDB.db"
    ).build()

    @Provides
    fun provideRoadDao(dataBase: DataBase) = dataBase.roadDao()
    @Provides
    fun providePathDao(dataBase: DataBase) = dataBase.pathDao()
}