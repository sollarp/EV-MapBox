[![Build status](https://build.appcenter.ms/v0.1/apps/d791979b-c1a4-4049-994c-fc77f2a0637c/branches/master/badge)](https://appcenter.ms)

# Ev MapBox 
![image](https://user-images.githubusercontent.com/74240451/232126945-8e388a33-2fee-4e1a-97f7-fcc3de9d22e2.png)

## About
This project is an Android app that uses data from Open Charge Map to display charging points for electric vehicles on a map.
Charging points are being shown based on the current displayed camera position with appropriate distance radius based on a current zoom level of a device.
The app allows to filter POIs, also displays a more detailed information. Navigation to selected charging location using Google map.
The app also contains a handy search bar which allows to enter a postcode and move a camera towards the said destination.

## Key Features
This app uses the latest cutting edge libraries and tools:
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

