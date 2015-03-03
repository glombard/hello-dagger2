package com.codeblast.hellodagger1;

import android.app.Application;

import dagger.ObjectGraph;

public class MyApplication extends Application {

  private ObjectGraph objectGraph;

  @Override
  public void onCreate() {
    super.onCreate();
    objectGraph = ObjectGraph.create(new RootModule(this));
  }

  public ObjectGraph getObjectGraph() {
    return objectGraph;
  }
}
