package app.com.milico.di

import app.com.milico.BuildConfig
import app.com.milico.data.remote.IApiService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.disposables.CompositeDisposable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val netModules  = module {
    single{ provideGson() }

    single { provideOkHttpBuilder(get())}

    single{provideLoggingInterceptor()}

    single (override=true){provideApiService(get())}

    single(override = true){ provideRetrofit(get(),get())}

    single{ provideCompositeDisposable()}

}


fun provideOkHttpBuilder(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
    val builder = OkHttpClient.Builder()
    builder.connectTimeout(30, TimeUnit.SECONDS)
    builder.readTimeout(1, TimeUnit.MINUTES)
    builder.writeTimeout(2, TimeUnit.MINUTES)
   // builder.authenticator(tokenAuthenticator)
    builder.addInterceptor(httpLoggingInterceptor)
    return builder.build()
}



fun provideLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()


fun provideApiService(retrofit: Retrofit): IApiService = retrofit.create(IApiService::class.java)

fun provideGson(): Gson = GsonBuilder()
        .setPrettyPrinting()
        .create()

fun provideCompositeDisposable(): CompositeDisposable {
    return CompositeDisposable()
}








