# Ev MapBox

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
