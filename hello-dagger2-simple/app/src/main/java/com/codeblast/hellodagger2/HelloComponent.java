package com.codeblast.hellodagger2;

import dagger.Component;

@ActivityScope
@Component(modules = HelloModule.class)
public interface HelloComponent {
  void initialize(HelloActivity helloActivity);
}
