package demo.m.repository.di

import dagger.Module
import dagger.Provides
import demo.m.repo_bridge.GetUserRepositoryUseCase
import demo.m.repository.GetUserRepositoryUseCaseImpl
import demo.m.search.repo.Repository
import demo.m.search.repo.RepositoryApi
import demo.m.search.repo.RepositoryImpl
import retrofit2.Retrofit

@Module
class GetUserRepositoryModule {
    @Provides
    fun provideApi(retrofit: Retrofit): RepositoryApi =
        retrofit.create(RepositoryApi::class.java)

    @Provides
    fun providesUserRepository(repositoryApi: RepositoryApi):
            Repository = RepositoryImpl(repositoryApi)

    @Provides
    fun provideGetUserRepositoryUseCase(repsoitory: Repository): GetUserRepositoryUseCase =
        GetUserRepositoryUseCaseImpl(repsoitory)
}