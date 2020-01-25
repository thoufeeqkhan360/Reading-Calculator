# Reading-Calculator
Reading Calculator is a dependency for calculating the time taken for read text contents.


## Gradle Dependency
Add it in your root `build.gradle` at the end of repositories:

```
allprojects {
	repositories {
		...
		maven { url "https://jitpack.io" }
	}
}
```
Add the dependency to your add module `build.gradle` file:

```
dependencies {
	compile ''
}

```


## Usage
To calculate the reading time taken for read contents for example,

```
String time = new ReadingMeter().withWordCount(WORD_COUNT)
                .setSpeed(ReadingMeter.READ_SPEED_AVERAGE)
                .setSecondsEnable(false)
                .inString();

```


## Options
Options using for the ReadingMeter.

Options | Parameter | Descriptions
--------------------- | ------------- | --------------------------
withReadingContent    | String  | If the calculation need to done with the text contents use this option.
withWordCount		  | int     | If the calculation need to done with the words count use this option.
withWordCount		  | long    | If the calculation need to done with the words count use this option.
setSpeed              |         | Choose the reading speed for calculation. The Options used are ```ReadingMeter.READ_SPEED_SLOW```, ```ReadingMeter.READ_SPEED_AVERAGE``` and ```ReadingMeter.READ_SPEED_FAST```
setSecondsEnable      | boolean | Enable if need to show sconds also.
inMilliSeconds        |         | Get the calculated result in Millisecond.
inString              |         | Get the calculated result in String.



## License
```
Copyright 2020 Zemikolon Solutions

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```