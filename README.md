<img src="https://github.com/Serecac/ezlib_preferences/blob/master/ezlib.png" alt="Ezlib" width="128" height="128">

Ezlib Preferences
=======

This library allows to persist data in the SharedPreferences in an easy and direct way.

How to use
-------
Put the .aar file (Ezlib_Preferences_x.y.z.aar) in the folder "Libs" inside the module.

In your project build.gradle. Add the following lines
```
flatDir {
	dirs 'libs'
}
```
```
dependencies {
	implementation(name: 'Ezlib_Preferences_x.y.z', ext: 'aar')
}
```

------------------------------------------------------

There are two ways to access EzlibPreferencesManager:
- Accessing directly using EzlibPreferencesInstance
- Use dagger to inject the dependencies using EzlibPreferencesModule


**EzlibPreferencesInstance**

The instance must be initialized (it is not mandatory). It is recommended to do it at the beginning in the Application class.
```
EzlibPreferencesInstance.init(<context>, <preferences name>);
```

**EzlibPreferencesModule**

The library provides a module that can be injected directly by dagger into your project.
```
@Provides
@Singleton
EzlibPreferencesManager provideEzlibPreferencesManager(Context context, @EzlibPreferencesName String name) {
	return new EzlibPreferencesManager(context, name);
}
```

If you use this implementation it is necessary to give value to the annotations, as shown in the following example:
```
@Provides
@Singleton
@EzlibPreferencesName
String provideEzlibPreferencesName() {
	return <preferences name>;
}
```

Possible type of data to persist
-------
The library allows the following types of data to persist:
* int
* String
* boolean
* long
* float
* Object 

Complex data structures can be saved, converted to JSON to be saved as a String, and then returned in the requested structure format.

To save/recover a value it is necessary to use a tag/key to identify which value you want to save/recover.

Contribution
=======
You are always welcome to contribute and help us mantain the library. 

<img src="https://github.com/Serecac/ezlib_preferences/blob/master/ezlib.png" alt="Ezlib" width="128" height="128">