# react-native-datefactory
Get date from location

### Install Module Android

* Step 1 - Update Gradle Settings
```shell
// file: android/settings.gradle
...
include ':react-native-datefactory'
project(':react-native-datefactory').projectDir = new File(rootProject.projectDir,
'../node_modules/react-native-datefactory/src/android')
```

* Step 2 - Update app Gradle Build
```shell
// file: android/app/build.gradle
...
dependencies {
    ...
    compile project(':react-native-datefactory')
}
```

* Step 3 - Register React Package (0.18+):
```java
  import br.com.cnp.DateFactoryPackage;
  
  public class MainActivity extends ReactActivity {
      @Override
      protected List<ReactPackage> getPackages() {
        return Arrays.<ReactPackage>asList(
          new DateFactoryPackage(),               // register here
          new MainReactPackage());
      }
  }
```

### Install React-Native
```shell
npm install react-native-datefactory --save
```

### Use React-Native
```javascript
var DateFactory = required('react-native-datefactory');

DateFactory.now().then(function(data) {
    console.log(data);
}).catch(function(err) {
    console.log(err);
});
```

