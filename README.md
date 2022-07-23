# HTTPRequests
Simple HTTP Requests in Minecraft Server<br>
### Command:<br>
``
/httprequests reload
``<br>
``
/httprequests request <Method> <URL>
``
### Avaible method:
GET, POST

### Permssions:
httprequests.reload
httprequests.request

## Instructions for running on versions <1.15:
### If you have downloaded the plugin:
1) Open plugin with archiver
2) Open the plugin.yml file in the editor
3) Change api-version to your version (for example, version 1.12.2, then change to 1.12)
### If you are compiling a plugin:
1) Cross the path src/main/resources/plugin.yml
2) Change api-version to your version (for example, version 1.12.2, then change to 1.12)
3) Building the plugin
## Compilation
1) Clone the repo
2) Run gradle wrapper on the command line ./gradlew jar
3) Get the artifact from build/libs/HTTPRequests-<version>.jar
