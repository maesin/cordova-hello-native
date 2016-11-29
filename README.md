# cordova-hello-native

Cordova でネイティブ連携を行うサンプルプロジェクトです。  
現状は、Android のみの対応になっています。

## 内容
独自に追加したアクティビティを JS から起動して、結果を JS で受信して表示する Android アプリ  
(ネイティブ処理部分を独自に拡張するにあたり、汎用的に利用できる Cordova プラグインの活用例)

### 画面遷移
#### 画面1 (MainActivity)
![画面1](https://raw.githubusercontent.com/maesin/cordova-hello-native/master/screenshot_main.png)

Web で構築された最初の画面です。  
Sub Activity ボタンを押下すると画面2に遷移します。

#### 画面2 (SubActivity)
![画面2](https://raw.githubusercontent.com/maesin/cordova-hello-native/master/screenshot_sub.png)

ネイティブ連携で呼び出した画面です。  
OK か NG ボタン、またはバックキーを押下して画面1に戻ります。

#### OK画面 (MainActivity)
![OK画面](https://raw.githubusercontent.com/maesin/cordova-hello-native/master/screenshot_main_ok.png)

OK ボタンを押下して戻ると OK と表示されます。

#### NG画面 (MainActivity)
![NG画面](https://raw.githubusercontent.com/maesin/cordova-hello-native/master/screenshot_main_ng.png)

NG ボタン、またはバックキーを押下して戻ると NG と表示されます。

## 必要なものを揃える手順
- [ネイティブ連携用プラグイン](https://github.com/maesin/cordova-plugin-native.git)の追加
- ネイティブ連携用プラグインのアクションを通知する処理の追加 (www/js/index.js)
- 独自に追加したアクティビティの結果を受信するメソッドの追加 (www/js/index.js)
- 遷移用のボタンの追加 (www/index.html)
- platforms/android/res/layout/activity_sub.xml の作成
- com.mycompany.hello.SubActivity の作成
- platforms/android/AndroidManifest.xml への activity タグの追加
- com.mycompany.hello.NativeExecutor の作成
- com.mycampany.hello.MainActivity への NativeExecutor を設定する処理の追加

## 起動
```コマンドライン
git clone git@github.com:maesin/cordova-hello-native.git
cd cordova-hello-native
cordova run android
```

この後は、Android Studio などで編集ください。

## エラーなどでアプリが起動できない場合
### cordova platform rm してみる
ファイルが不足している可能性があるため、プラットフォームを追加し直します。

```コマンドライン
cordova platform rm android
cordova platform add android
git checkout .
cordova run android
```

### このプロジェクトを再構築
```コマンドライン
cordova create cordova-hello-native com.mycompany.hello HelloNative
cd cordova-hello-native
cordova platform add android --save
cordova platform update android --save
cordova build
cordova plugin add https://github.com/maesin/cordova-plugin-native.git
cordova plugin ls
...  # 前述の必要なものを準備
cordova run android
```

詳細なコマンドラインツールの使い方は、[公式ドキュメント](https://cordova.apache.org/docs/en/latest/guide/cli/index.html)をご覧ください。