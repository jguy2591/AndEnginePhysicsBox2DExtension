/*
 * Copyright (C) 2008 aki@akjava.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.akjava.android.box2dtest.ndkbox2d;

import org.anddev.andengine.physics.box2d.Box2DNativeWrapper;

import android.app.Activity;
import android.os.Bundle;

import com.akjava.android.box2dtest.MoveBoxRenderer;
import com.akjava.lib.android.opengl.AbstractGLSurfaceView;
import com.akjava.lib.android.opengl.SimpleGameGLSurfaceView;

public class MoveBoxActivity extends Activity {

	/**
	 * Set to true to enable checking of the OpenGL error code after every
	 * OpenGL call. Set to false for faster code.
	 * 
	 */

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle("ndk move box(use d-pad)");

		mGLView = new SimpleGameGLSurfaceView(this);
		Box2DNativeWrapper controler = new Box2DNativeWrapper();
		setContentView(mGLView);

		MoveBoxRenderer render = new MoveBoxRenderer(this, controler);
		mGLView.setAbstractRender(render);
	}

	@Override
	protected void onPause() {
		super.onPause();
		mGLView.onPause();
	}

	@Override
	protected void onResume() {
		super.onResume();
		mGLView.onResume();

	}

	private AbstractGLSurfaceView mGLView;
}
