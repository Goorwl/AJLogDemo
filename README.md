# AJLogDemo

[![](https://jitpack.io/v/Goorwl/AJLogDemo.svg)](https://jitpack.io/#Goorwl/AJLogDemo) [![](https://img.shields.io/badge/blog-%E6%A9%99%E5%AD%90-blue.svg)](https://xiaozhuanlan.com/goorwl?rel=goorwl) [![](https://img.shields.io/badge/E--mail-goorwl%40163.com-pink.svg)](https://mailto:goorwl@163.com)

Log util with aspectj to come ture.

# HOW TO USE

## SETTING

In project `build.gradle` file like this:

	
	buildscript {
	    repositories {
	        google()
	        jcenter()
	        maven { url 'https://jitpack.io' }			// this jar where location repo
	    }
	    dependencies {
	        classpath 'com.android.tools.build:gradle:3.5.0'
	        classpath 'com.hujiang.aspectjx:gradle-android-plugin-aspectjx:2.0.4'		// aspectj tool   
	    }
	}
	
	allprojects {
	    repositories {
	        google()
	        jcenter()
	        maven { url 'https://jitpack.io' }			// this jar where location repo
	    }
	}


In module `build.gradle` file like this:
	
	apply plugin: 'com.android.application'
	apply plugin: 'android-aspectjx'			// this line

	dependencies {
		...
		implementation 'com.github.Goorwl:AJLogDemo:lastest-version'
	}

## USE IT

### Log

code:

    @DebugLog
    private int getSum(int a, int b) {
        return a + b;
    }

output:

![output](https://i.imgur.com/PAvGYBF.png)

close:

	MyLog.setEnable(BuildConfig.DEBUG);

### AntiDoubleClick

code:

    findViewById(R.id.btn_test).setOnClickListener(new View.OnClickListener() {
        @Override
        @DoubleClick
        public void onClick(View v) {
            Toast.makeText(MainActivity.this, "ON CLICK...", Toast.LENGTH_SHORT).show();
            Log.e(TAG, "onClick: ON CLICK");
        }
    });

or：    

	@Override
    @DoubleClick
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_test:
                Log.e(TAG, "onClick: x");
                break;
            case R.id.btn_test1:
                Log.e(TAG, "onClick: xx");
                break;
        }
    }



set intervals time:

    MyClick.setIntervalsTime(1000);

Disadvantage:

* NOT FOR LAMADA