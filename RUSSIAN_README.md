# SwipeLayout
[![](https://jitpack.io/v/ArmanSar/SwipeLayout.svg)](https://jitpack.io/#ArmanSar/SwipeLayout) [![license](https://img.shields.io/github/license/mashape/apistatus.svg)](https://github.com/ArmanSar/SwipeLayout/blob/master/LICENSE) [![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-SwipeLayout-green.svg?style=flat)](https://android-arsenal.com/details/1/7215)

SwipeLayout - это проект для платформы android, предоставляющий возможность выполнять свайп для любого макета, в указанном направлении.

### Выберите язык
[English](https://github.com/ArmanSar/SwipeLayout/blob/master/README.md) 

[Русский](https://github.com/ArmanSar/SwipeLayout/blob/master/RUSSIAN_README.md)

## Описание
SwipeLayout - это просто 'Custom ViewGroup', унаследованный от FrameLayout, которая дает возможность просто и легко использовать функцию 'swipe to dismiss', без использования ItemTouchHelper, для любого макета.

## Скачать
Скачайте [APK](https://github.com/ArmanSar/SwipeLayout/releases/download/1.0.9/SwipeLayout_app.apk) данного примера и попробуйте!

## Скриншоты
<img src="/screenshots/left.gif" alt="left.gif" title="left.gif" width="180" height="340" /> <img src="/screenshots/right.gif" alt="right.gif" title="right.gif" width="180" height="340" /> <img src="/screenshots/horizontal.gif" alt="horizontal.gif" title="horizontal.gif" width="180" height="340" />

## Особенности
- Выполнение свайпа влево
- Выполнение свайпа вправо
- Выполнение свайпа и влево и вправо
- Использование любого своего макета
- Четыре режима свайпа, которые можно комбинировать между собой

## Интеграция
**Вариант 1**
Скопируйте файл attrs.xml в папку src/res/values и файл SwipeLayout.java в папку с исходным кодом вашего проекта из [gist](https://gist.github.com/ArmanSar/64359efd499ed38f6996390e79a5eadc) и используйте.

**Вариант 2**

Добавьте в корневой build.gradle следующий репозиторий:
```groovy
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

Добавьте в build.gradle вашего модуля следующую зависимость:
```groovy
dependencies {
    implementation 'com.github.ArmanSar:SwipeLayout:1.0.9'
}
```

## Как использовать ?
Пример использования. Свайп влево
```xml
<mobile.sarproj.com.layout.SwipeLayout
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

</mobile.sarproj.com.swipelayout.SwipeLayout>
```
```
Выше представлен пример макета. Для корректной работы свайпа необходимо в своем макете добавить  <mobile.sarproj.com.swipelayout.SwipeLayout в котором нужно указать следующие параметры:
- app:draggedItem="@id/drag_item", где drag_item - id элемента который должен перетаскиваться
- app:rightItem="@id/right_view", где right_view - id элемента, который останется справа при свайпе (если используется свайп вправо, то необходимо указать app:leftItem)
- app:swipeDirection="left" - направление свайпа
  - app:swipeDirection="left" - свайп влево
  - app:swipeDirection="right" - свайп вправо
  - app:swipeDirection="left|right" - свайп и влево и вправо
```

## Описание параметров
**Обязательные**
```
- app:draggedItem="@id/drag_item", где drag_item - id элемента который должен перетаскиваться
- app:rightItem="@id/right_view", где right_view - id элемента, который останется справа при свайпе влево
- app:leftItem="@id/left_view", где left_view - id элемента, который останется слева при свайпе вправо
- app:swipeDirection="left" - направление свайпа
  - app:swipeDirection="left" - свайп влево
  - app:swipeDirection="right" - свайп вправо
  - app:swipeDirection="left|right" - свайп и влево и вправо
```

**Необязательные**
```
- app:isFreeDragAfterOpen="false|true" - позволяет главной view перемещаться и после его открытия
- app:isFreeHorizontalDrag="false|true" - позволяет перемещать главное view в направлении противоположном свайпу
- app:isContinuousSwipe="false|true" - позволяет выполнить свайп до конца экрана
- app:isTogether="false|true" - вторичная view будет перемещаться вместе с главной view
- app:autoMovingSensitivity="1000" - чувствительность автоматического закрытия главного view
- app:rightDragViewPadding="0dp" - правая ограничительная граница свайпа для главного view
- app:leftDragViewPadding="0dp" - левая ограничительная граница свайпа для главного view
```

**Программное управление**
```
SwipeLayout.close() - отменить свайп, вернуть главное view в исходное состояние
SwipeLayout.openLeft() - выполнить свайп вправо
SwipeLayout.openRight() - выполнить свайп влево
SwipeLayout.openRightCompletely() - выполнить свайп вправо до конца экрана
SwipeLayout.openLeftCompletely() - выполнить свайп влево до конца экрана
SwipeLayout.close(false) - отменить свайп, вернуть главное view в исходное состояние без анимации
SwipeLayout.openLeft(false) - выполнить свайп вправо без анимации
SwipeLayout.openRight(false) - выполнить свайп влево без анимации
SwipeLayout.openRightCompletely(false) - выполнить свайп вправо до конца экрана без анимации
SwipeLayout.openLeftCompletely(false) - выполнить свайп влево до конца экрана без анимации
SwipeLayout.isClosed() - находится ли главное view в исходном состоянии
SwipeLayout.isMoving() - находится ли главное view в режиме перемещения
```
**Callback**
```java
SwipeLayout.setOnActionsListener(new SwipeLayout.SwipeActionsListener() {
    @Override
    public void onOpen(int direction, boolean isContinuous) {
        if (direction == SwipeLayout.RIGHT) {
            // был выполнен свайп вправо
        } else if (direction == SwipeLayout.LEFT) {
            // был выполнен свайп влево
        }
    }

    @Override  
    public void onClose() {  
        // главное view вернулось в начальное состояние
    }
});
```

**Примечание**
```
- флаг isContinuousSwipe работает в двух режимах, с указанием вторичного view (app:leftItem, app:rightItem) и без его указания
- если используется свайп и влево и вправо (app:swipeDirection="left|right"), то флаг isContinuousSwipe будет проигнорирован
- если указано конкретное направление свайпа и установлен флаг isContinuousSwipe, то флаг isFreeDragAfterOpen будет автоматически установлен как true
- если используется свайп и влево и вправо (app:swipeDirection="left|right"), то флаг isFreeHorizontalDrag будет работать иначе. Он будет устанавливать режим, при котором, главное  view будет непрерывно перемещаться в обоих направлениях
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
