package com.example.application.global.data.remote.location

import com.example.application.global.data.remote.location.model.UserLocation

class LocationRepository(private val locationService: LocationService) {

    suspend fun fetchCurrentLocation(): UserLocation? {
        return locationService.getCurrentLocation()
    }
}
