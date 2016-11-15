package com.develcode.plugins.volumeControl;

import android.media.AudioManager;

public interface Constants {
	public static final String SET_MEDIA_VOLUME 			= "setMediaVolume";
	        
	public static final String GET_MEDIA_VOLUME 			= "getMediaVolume";
	public static final String GET_NOTIFICATION_VOLUME 		= "getNotificationVolume";
	public static final String GET_RING_VOLUME 				= "getRingVolume";

	public static final String SET_VOLUME_CONTROL_STREAM    = "setVolumeControlStream";

	public static final int STREAM_MEDIA  			    	= AudioManager.STREAM_MUSIC;
	public static final int STREAM_NOTIFICATION   			= AudioManager.STREAM_NOTIFICATION;
	public static final int STREAM_RING   			    	= AudioManager.STREAM_RING;
	public static final int STREAM_VOICE_CALL   			= AudioManager.STREAM_VOICE_CALL;
}