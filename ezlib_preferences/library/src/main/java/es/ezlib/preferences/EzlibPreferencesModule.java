package es.ezlib.preferences;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class EzlibPreferencesModule {

    @Provides
    @Singleton
    EzlibPreferencesManager provideEzlibPreferencesManager(Context context, @EzlibPreferencesName String name) {
        return new EzlibPreferencesManager(context, name);
    }
}
