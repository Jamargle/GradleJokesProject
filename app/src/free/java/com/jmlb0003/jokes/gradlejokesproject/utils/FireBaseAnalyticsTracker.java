package com.jmlb0003.jokes.gradlejokesproject.utils;

import android.content.Context;
import android.os.Bundle;

import com.google.firebase.analytics.FirebaseAnalytics;

public final class FireBaseAnalyticsTracker {

    private FirebaseAnalytics firebaseAnalytics;

    public FireBaseAnalyticsTracker(final Context context) {
        firebaseAnalytics = FirebaseAnalytics.getInstance(context);
    }

    public void trackEvent(
            final String id,
            final String name) {

        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, id);
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, name);
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "image");
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
    }

}
