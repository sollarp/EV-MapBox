[![Build status](https://build.appcenter.ms/v0.1/apps/d791979b-c1a4-4049-994c-fc77f2a0637c/branches/master/badge)](https://appcenter.ms)

# Ev MapBox 
![image](https://user-images.githubusercontent.com/74240451/232126945-8e388a33-2fee-4e1a-97f7-fcc3de9d22e2.png) <a href="https://play.google.com/store/apps/details?id=com.soldevcode.evmapbox" target="_blank">
<img src="https://play.google.com/intl/en_us/badges/images/generic/en-play-badge.png" alt="Get it on Google Play" height="100"/></a>

## About
This Android application displays electric vehicle charging points on a map by utilizing data from Open Charge Map. The charging points are displayed according to the camera position and the zoom level of the device. The app provides POI filtering and detailed information for each charging location, and enables navigation to the selected charging location using Google Maps. Additionally, the app includes a search bar that allows users to enter any keyword to find charging points using a search algorithm and move the camera to the specified destination..

## Key Features
This app uses the latest libraries and tools:
- 100% written in Kotlin;
- Kotlin Coroutines for asynchronous programming;
- Dagger-Hilt for dependency injection.
- Flow
- Room for local data base.

Other features:
- MVVM architecture;
- Clean Architecture;
- Google Maps Android SDK;
- Retrofit2 for consuming RESTful Apis;
- LiveData, MediatorLiveData
- JUnit4, Mockito-Kotlin.

## Current Screens:
![Screenshot from 2023-04-12 20-47-33](https://user-images.githubusercontent.com/74240451/232127635-a2997202-0df1-4a41-869c-d45b900c016d.png)
![Screenshot from 2023-04-12 20-48-10](https://user-images.githubusercontent.com/74240451/232127648-7f43d3e5-0594-429c-8af8-23c779c86bdb.png)
![Screenshot from 2023-04-12 20-48-28](https://user-images.githubusercontent.com/74240451/232127655-05c40e3a-10a1-41dd-bdbf-216cf77dccbb.png)
## Video:
[Screencast from 12-04-23 20:44:24.webm](https://user-images.githubusercontent.com/74240451/231569784-f28be571-41ce-4b08-ae26-cffa62463d44.webm)
## Video of Play Store:
[Screen Recording 2024-10-13 at 08.31.36.webm](https://github.com/user-attachments/assets/b431f7f4-c6f1-49d7-a211-5a2c93806e4b)

## Development setup
In order to clone and be able to run the code you will need to supply API Keys for the Google Maps SDK and Open Charge Map API:
- [Open Charge Map instructions](https://openchargemap.org/site/develop/api)

After you've acquired API keys you should set them within the `local.properties` file in your project folder as follows:
```
openChargeMapKey=< Open Charge Map Api key goes here >
```

## APIs used
- [Google Map Api] for Map presentation;
- [Open Charge Map Api] for Ev Charging Points ;

## License
```
Ev Mapbox
Copyright (C) 2022  Peter Szollar

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or 
any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
```

