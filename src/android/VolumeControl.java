/*
 * Phonegap VolumeControl Plugin for Android
 * Cordova 2.2.0
 * Author: Manuel Simpson
 * Email: manusimpson[at]gmail[dot]com
 * Date: 12/28/2012
 */

package com.develcode.plugins.volumeControl;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.LOG;
import org.json.JSONArray;
import org.json.JSONException;

import android.content.Context;
import android.media.*;

public class VolumeControl extends CordovaPlugin {

    private static final String TAG = "VolumeControl";
        
	public static final String SET_MEDIA_VOLUME = "setMediaVolume";
        
    public static final String GET_MEDIA_VOLUME = "getMediaVolume";
    public static final String GET_NOTIFICATION_VOLUME = "getNotificationVolume";
    public static final String GET_RING_VOLUME = "getRingVolume";

	private Context context;
	private AudioManager manager;

	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		boolean actionState = true;
		context = cordova.getActivity().getApplicationContext();
		manager = (AudioManager)context.getSystemService(Context.AUDIO_SERVICE);

		if (SET_MEDIA_VOLUME.equals(action)) {
			try {
				//Get the media volume value to set
				int volume = getVolumeToSet(args.getInt(0), AudioManager.STREAM_MUSIC);
				boolean play_sound;

				if(args.length() > 1 && !args.isNull(1)) {
					play_sound = args.getBoolean(1);
				} else {
					play_sound = true;
				}

				//Set the volume
				manager.setStreamVolume(AudioManager.STREAM_MUSIC, volume, (play_sound ? AudioManager.FLAG_PLAY_SOUND : 0));
				callbackContext.success();
			} catch (Exception e) {
				LOG.d(TAG, "Error setting Media volume " + e);
				actionState = false;
			}
		} else if(GET_MEDIA_VOLUME.equals(action)) {
				// Get current media volume
				int currVol = getCurrentMediaVolume();
				String strVol= String.valueOf(currVol);
				callbackContext.success(strVol);
				LOG.d(TAG, "Current Media Volume is " + currVol);
		} else if(GET_NOTIFICATION_VOLUME.equals(action)) {
				// Get current notifiavtion volume
				int currVol = getCurrentNotificationVolume();
				String strVol= String.valueOf(currVol);
				callbackContext.success(strVol);
				LOG.d(TAG, "Current Notification Volume is " + currVol);
		} else if(GET_RING_VOLUME.equals(action)) {
				// Get current ring volume
				int currVol = getCurrentRingVolume();
				String strVol= String.valueOf(currVol);
				callbackContext.success(strVol);
				LOG.d(TAG, "Current Ring Volume is " + currVol);
		} else {
			actionState = false;
		}

		return actionState;
	}

	private int getVolumeToSet(int percent, int stream) {
		int volLevel;
		int maxVolume = manager.getStreamMaxVolume(stream);
		volLevel = Math.round((percent * maxVolume) / 100);

		return volLevel;
	}

	private int getCurrentVolume(int stream) {
		try {
			int maxVolume = manager.getStreamMaxVolume(stream);
			int currSystemVol = manager.getStreamVolume(stream);

			return Math.round((currSystemVol * 100) / maxVolume);
		} catch (Exception e) {
			LOG.d(TAG, "getVolume error: " + e);
			return 1;
		}
	}

	private int getCurrentMediaVolume() {
		return getCurrentVolume(AudioManager.STREAM_MUSIC);
	}
        
	private int getCurrentNotificationVolume() {
		return getCurrentVolume(AudioManager.STREAM_NOTIFICATION);
	}

	private int getCurrentRingVolume() {
		return getCurrentVolume(AudioManager.STREAM_RING);
	}        
}
