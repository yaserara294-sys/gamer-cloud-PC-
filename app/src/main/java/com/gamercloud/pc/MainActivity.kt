
<?xml version="1.0" encoding="utf-8"?>

<manifest xmlns:android="http://schemas.android.com/apk/res/android">

    <!-- INTERNET Y RED -->
    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
    <uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />

    <!-- MANTENER EL DISPOSITIVO ACTIVO DURANTE EL JUEGO -->
    <uses-permission android:name="android.permission.WAKE_LOCK" />

    <!-- VIBRACIÓN PARA CONTROLES -->
    <uses-permission android:name="android.permission.VIBRATE" />

    <!-- COMPATIBILIDAD CON DISPOSITIVOS -->
    <uses-feature
        android:name="android.hardware.touchscreen"
        android:required="false" />

    <uses-feature
        android:name="android.hardware.gamepad"
        android:required="false" />

    <application
        android:allowBackup="false"
        android:label="Gamer Cloud PC"
        android:description="Cloud Gaming Platform"
        android:theme="@android:style/Theme.Material.NoActionBar"
        android:usesCleartextTraffic="false"
        android:supportsRtl="true"
        android:resizeableActivity="true">

        <!-- PANTALLA PRINCIPAL -->
        <activity
            android:name=".MainActivity"
            android:exported="true"
            android:windowSoftInputMode="adjustResize">

            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>

        </activity>

    </application>

</manifest>
