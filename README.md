# YaPhotolenta
Приложение "Я.Фотолента" разработано в качестве тестового задания для проекта Яндекс.Мобилизация 2018 и имеет следующую функциональность:
- лента изображений в два столбца с возможностью прокрутки;
- изображения хранятся в публичной папке https://disk.yandex.ru/client/disk/Sochi
- при нажатии на изображении оно открывается в новом окне;
- изображение можно масштабировать жестом или двойным тапом;
- возможность перелистования изображений;
- для работы необходимо подключение к сети. При отсутствии сети будет отображено сообщение.

В разработке приложения использовал следующий стек технологий:
- API Яндекс.Диска - для возвращения списка опубликованных изображений на Диске;
- HttpUrlConnection - для получения данных по сети;
- GSON (https://github.com/google/gson) - библиотека для конвертации JSON в JAVA-объекты;
- Picasso (https://github.com/square/picasso) - библиотека для подгрузки изображений из сети;
- PhotoView (https://github.com/chrisbanes/PhotoView) - библиотека для масштабирования изображения жестом или двойным тапом;
- GridView - компонент для отображения изображений в виде плитки;
- ViewPager - для перелистывания изображений влево-вправо.

<img src="https://github.com/Gluk87/YaPhotolenta/blob/master/screen/Screenshot_20180503-232445.png" width="400"/>
