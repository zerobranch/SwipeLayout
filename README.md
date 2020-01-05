# SwipeLayout
[![](https://jitpack.io/v/zerobranch/SwipeLayout.svg)](https://jitpack.io/#zerobranch/SwipeLayout) [![license](https://img.shields.io/github/license/mashape/apistatus.svg)](https://github.com/zerobranch/SwipeLayout/blob/master/LICENSE) [![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-SwipeLayout-green.svg?style=flat)](https://android-arsenal.com/details/1/7215)

SwipeLayout is a project for the android platform, providing the opportunity to perform swipe for any layout, in the specified direction.

### Choose language
[English](https://github.com/zerobranch/SwipeLayout/blob/master/README.md) 

[Русский](https://github.com/zerobranch/SwipeLayout/blob/master/RUSSIAN_README.md)

## Description
SwipeLayout is just a 'Custom ViewGroup', extended from FrameLayout, which provides easy and fast to use the 'swipe to dismiss' function, without using the ItemTouchHelper, for any layout.

## Download
Download the sample [APK](https://github.com/zerobranch/SwipeLayout/releases/download/1.3.0/SwipeLayout_app.apk) and try it out!

## Screenshots
<img src="/screenshots/left.gif" alt="left.gif" title="left.gif" width="180" height="340" /> <img src="/screenshots/right.gif" alt="right.gif" title="right.gif" width="180" height="340" /> <img src="/screenshots/horizontal.gif" alt="horizontal.gif" title="horizontal.gif" width="180" height="340" />

## Features
- Executing the swipe to the left
- Executing the swipe to the right
- Executing the swipe and left and right
- Using any your layouts
- Four modes of swipe, which can be combined with each other

## Integration
**Option 1**
Copy the attrs.xml file to the src/res/values folder and the SwipeLayout.java file to the source code folder of your project from the [gist](https://gist.github.com/zerobranch/64359efd499ed38f6996390e79a5eadc) and to use.

**Option 2**

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
    implementation 'com.github.zerobranch:SwipeLayout:1.3.1'
}
```

## How to use ?
Example of use. Swipe to the left
```xml
<com.zerobranch.layout.SwipeLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:id="@+id/swipe_layout"
    android:layout_width="match_parent"
    android:layout_height="90dp"
    app:draggedItem="@id/drag_item"
    app:rightItem="@id/right_view"
    app:swipeDirection="left">

    <ImageView
        android:id="@+id/right_view"
        android:layout_width="90dp"
        android:layout_height="match_parent"
        android:layout_gravity="end"
        android:background="#ff5722"
        android:gravity="center"
        android:paddingEnd="24dp"
        android:paddingStart="24dp"
        android:src="@drawable/ic_delete"/>
  
    <TextView  
        android:id="@+id/drag_item"  
        android:layout_width="match_parent"  
        android:layout_height="match_parent"  
        android:background="#eeeeee"  
        android:gravity="center_vertical"  
        android:paddingEnd="10dp"  
        android:paddingStart="20dp"  
        android:textSize="20sp"/>

</com.zerobranch.layout.SwipeLayout>
```
```
Above is an example of a layout. For the correct operation of the swipe it is necessary to add <mobile.sarproj.com.swipelayout.SwipeLayout in your layout in which you need to specify the following parameters:
- app:draggedItem="@id/drag_item", where drag_item is the id of the element to be dragged
- app:rightItem="@id/right_view", where right_view is the id of the element that will remain on the right with the swipe to the left (if you use swipe to the right, you must specify app: leftItem).
- app:swipeDirection="left" - direction of a swipe
  - app:swipeDirection="left" - swipe to the left
  - app:swipeDirection="right" - swipe to the right
  - app:swipeDirection="left|right" - swipe left and right
```

## Description of parameters
**Required**
```
- app:draggedItem="@id/drag_item" - where drag_item is the id of the element to be dragged
- app:rightItem="@id/right_view" - where right_view - id of the element that will remain on the right with the swipe to the left
- app:leftItem="@id/left_view" - where left_view - id of the element that will remain on the left with the swipe to the right
- app:swipeDirection="left" - direction of a swipe
  - app:swipeDirection="left" - swipe to the left
  - app:swipeDirection="right" - swipe to the right
  - app:swipeDirection="left|right" - swipe left and right
```

**Optional**
```
- app:isFreeDragAfterOpen="false|true" - allows the main view to move after its opening
- app:isFreeHorizontalDrag="false|true" - allows you to move the main view in the opposite direction to the swipe
- app:isContinuousSwipe="false|true" - allows you to execute the swipe to the end of the screen
- app:isTogether="false|true" - the secondary view will move along with the main view
- app:autoMovingSensitivity="1000" - sensitivity of automatic closing of the main view
- app:rightDragViewPadding="0dp" - the right bounding border of the swipe for the main view
- app:leftDragViewPadding="0dp" - the left bounding border of the swipe for the main view
- app:isEnabledSwipe="false|true" - allows you to disable the swipe
```

**Control from the code**
```
SwipeLayout.close() - cancel swipe, return the main view to its original state
SwipeLayout.openLeft() - execute swipe to the right
SwipeLayout.openRight() - execute swipe to the left
SwipeLayout.openRightCompletely() - execute swipe to the right to the end of the screen 
SwipeLayout.openLeftCompletely() - execute swipe to the left to the end of the screen 
SwipeLayout.close(false) - cancel swipe, return the main view to its original state without animation
SwipeLayout.openLeft(false) - execute swipe to the right without animation
SwipeLayout.openRight(false) - execute swipe to the left without animation
SwipeLayout.openRightCompletely(false) - execute swipe to the right to the end of the screen without animation
SwipeLayout.openLeftCompletely(false) - execute swipe to the left to the end of the screen without animation
SwipeLayout.isClosed() - is the main view in the default state
SwipeLayout.isMoving() - is the main view in the moving
SwipeLayout.setEnabledSwipe(false) - allows you to disable the swipe
SwipeLayout.enableTouchForViewGroup(ViewGroup) - enable touch for ViewGroup
```
**Callback**
```java
SwipeLayout.setOnActionsListener(new SwipeLayout.SwipeActionsListener() {
    @Override
    public void onOpen(int direction, boolean isContinuous) {
        if (direction == SwipeLayout.RIGHT) {
            // was executed swipe to the right
        } else if (direction == SwipeLayout.LEFT) {
            // was executed swipe to the left
        }
    }

    @Override  
    public void onClose() {  
        // the main view has returned to the default state
    }
});
```

**Note**
```
- the isContinuousSwipe flag works in two modes, with a secondary view (app:leftItem, app:rightItem) and without it
- if you use both swipe left and right (app:swipeDirection="left|right"), the isContinuousSwipe flag will be ignored
- if a specific direction of the swipe is specified and the isContinuousSwipe flag is set, the isFreeDragAfterOpen flag is automatically set to true
- if you use swipe and left and right (app:swipeDirection="left|right"), the isFreeHorizontalDrag flag will work differently. It will set the mode at which the main view will continuously move in both directions
```

## License

```
The MIT License (MIT)

Copyright (c) 2018 Arman Sargsyan

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
