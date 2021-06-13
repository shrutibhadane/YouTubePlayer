package direction.com.you;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {
    //implements YouTubePlayer.OnInitializedListener{

    private YouTubePlayerSupportFragment mYoutubePlayerFragment;

    private YouTubePlayer YPlayer;
    private static final int RECOVERY_DIALOG_REQUEST = 1;
    private VideoActivity myContext;

    public BlankFragment() {
    }


    @Override
    public void onAttach(Activity activity) {

        if (activity instanceof VideoActivity) {
            myContext = (VideoActivity) activity;
        }

        super.onAttach(activity);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_blank, container, false);


        YouTubePlayerSupportFragment youTubePlayerFragment = YouTubePlayerSupportFragment.newInstance();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.add(R.id.fragment_youtube_player, youTubePlayerFragment).commit();


        youTubePlayerFragment.initialize(Constants.API_KEY,
                new YouTubePlayer.OnInitializedListener() {
                    @Override
                    public void onInitializationSuccess(YouTubePlayer.Provider provider,
                                                        YouTubePlayer youTubePlayer, boolean b) {
                        // do any work here to cue video, play video, etc.
                        youTubePlayer.cueVideo("5xVh-7ywKpE");
                    }

                    @Override
                    public void onInitializationFailure(YouTubePlayer.Provider provider,
                                                        YouTubeInitializationResult youTubeInitializationResult) {

                    }
                });

/*
        mYoutubePlayerFragment = new YouTubePlayerSupportFragment();
        mYoutubePlayerFragment.initialize(Constants.API_KEY, this);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_youtube_player, mYoutubePlayerFragment);
        fragmentTransaction.commit();
*/


        return view;
    }

}