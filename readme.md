# Multi Module Example App
Once your application codebase is big, and your team scales well. It becomes harder to add or update new features, build time increases exponentially, refactoring takes a lot of time.

# App Module

The **App** module should be used for integration feature and providing dependency to feature modules.

## Feature Modules

Small, Independent and Effective feature modules. Every feature module will be having a feature bridge module which will only include interface and its implementation would be provided my respective feature module. So if feature1 module wants to navigate to feature2 it will include feature2 bridge module and get its implementation through dependency injection.
