# SwipeLayout
[![Jitpack ](https://img.shields.io/jitpack/v/jitpack/maven-simple.svg)](https://jitpack.io/)
[![license](https://img.shields.io/github/license/mashape/apistatus.svg)](https://github.com/ArmanSar/fileloader/blob/master/LICENSE)

The library what allows you to execute a swipe for the android platform

## Descripton
File Loader - is a library for the android platform. It allows you to download any files without much effort and get the result in the thread you specified.

## Capabilities
- Download any files by their link

## How to use ?

```java
Loader.with(Context)
        .fromUrl("YOUR_URL")
        .load();
```

## Description of methods
**Required**
```
- with(Cntext) - the main method with the context
- addInQueue("YOUR_URL") - add the file to the download queue
- load() - start downloading files
```

**Optional**
```
- to("YOUR_PATH") - the path to which the file will be uploaded
- addInQueue("YOUR_URL") - add file to the download queue
- skipIfFileExist() - the download will be terminated if the file already exists (by default, the file is overwritten)
- abortNextIfError() - interrupt the remaining downloads waiting in the queue, if an error occurred during the download
- makeImmortal() - the files will be downloaded in the foreground. Download does not stop even if it is unloaded from memory
- notification(Notification) - connect your notification, which will be displayed at the time of downloading files
- redownloadAttemptCount(4) - the number of attempts to download the file, in case there was an error
- skipCache() - do not save the file in the device memory
- viewNotificationOnFinish() - do not close the notification after downloading files
- hideDefaultNotification() - hide notification when loading files (not recommended)
- downloadReceiver() - setting DownloadReceiver will allow you to set events to get feedback from the loader
- onStart(OnStart) - the event notifies the start of the download of the next file
- onError(OnError) - the event notifies you when an error occurred while loading the file
- onCompleted(OnCompleted) - the event notifies when the next file is being downloaded
- onProgress(OnProgress) - event to track the progress of the download
- receivedFile(ReceivedFile) - after the download is complete, get the path to the downloaded file
- receivedFileSource(ReceivedFileSource) - after the download is complete, get the source file as a byte array
- enableLogging() - enable logging while downloading files
```

**Additional Methods**
```
loader.cancel() - abort all downloads and delete the underloaded file
loader.unsubscribe - unsubscribe from events (download will not be interrupted)
```

**Note**
```
- if you do not specify to ("YOUR_PATH"), then by default the files will be saved in the application cache - Context.getCacheDir()
- notification(Notification), hideDefaultNotification(), viewNotificationOnFinish() - work only when you set makeImmortal()
- to set the events (onStart, onError, etc.), you must set DownloadReceiver
- if you set the receivedFileSource event, the data will go into this method WITHOUT CONSERVATION on the device
```


## Integration
Add it in your root build.gradle at the end of repositories:
```groovy
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

Add the following dependency to your module's build.gradle:
```groovy
dependencies {
    compile 'com.github.ArmanSar:fileloader:0.1.2'
}
```

## License

```
The MIT License (MIT)

Copyright (c) 2018 Arman

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
