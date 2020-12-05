# Random-Image-Viewer
A simple android app showing random images fetched from https://picsum.photos/.
This app also persist the last fetched image locally.

This app is based on **MVVM with repository** pattern.

```
UI(Activity/Fragment) <-> ViewModel <-> Facility <-> Repository <-> DataSource
```
**DataSource** - provides the data from the internal dataStore.

**Repository** - handles the dataStore and provide abstraction.

**Facility** - provides the business-logic.

**ViewModel** - provides the view related logic.

**UI** - shows and provides the interaction to users.

## Dependencies
- **DataStore**, app preference library. Here used to persist image into device
- **hilt**, dependency injection wrapper library.
- **glide**, image loading library
- **timber**, logger library
- **livedata,viewmodel**, various android jetpack components