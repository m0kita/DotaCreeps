package ru.mokita.dotacreeps.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import ru.mokita.data.network.api.DotaApi
import ru.mokita.data.repository.HeroRepositoryImpl
import ru.mokita.domain.repository.HeroRepository
import ru.mokita.dotacreeps.BuildConfig
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun provideMoshi(): Moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    @Provides
    fun provideRetrofit(moshi: Moshi): Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    @Provides
    @Singleton
    fun provideClient(retrofit: Retrofit): DotaApi = retrofit.create(DotaApi::class.java)

    @Provides
    fun provideHeroRepository(client: DotaApi): HeroRepository = HeroRepositoryImpl(client)
}